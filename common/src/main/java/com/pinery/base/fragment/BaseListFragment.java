package com.pinery.base.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.bumptech.glide.Glide;
import com.github.jdsjlzx.interfaces.OnItemClickListener;
import com.github.jdsjlzx.interfaces.OnItemLongClickListener;
import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.interfaces.OnNetWorkErrorListener;
import com.github.jdsjlzx.interfaces.OnRefreshListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.pinery.base.adapter.BaseAdapter;
import com.pinery.base.mvp.IPresenter;
import com.pinery.base.util.LogUtil;
import com.pinery.base.util.ViewUtil;
import com.pinery.base.widget.RecycleViewDivider;
import com.pinery.fun.commonlib.R;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;

/**
 * 列表页面Fragment
 * Created by gujian on 2018-08-12.
 */

public abstract class BaseListFragment<T extends IPresenter> extends BaseLazyFragment<T>
    implements OnRefreshListener, OnLoadMoreListener {

  protected LRecyclerView mRecyclerView;

  protected BaseAdapter mAdapter;

  protected Context mContext;

  private boolean isRefreshing;

  @Override protected int getLayoutId() {
    return R.layout.fragment_base_list;
  }

  @Override protected void initViews(View view, Bundle savedInstanceState) {
    mContext = view.getContext();

    mRecyclerView = ViewUtil.findViewById(view, R.id.swipe_target);
    mRecyclerView.setHasFixedSize(true);

    setLayoutManager(mRecyclerView);

    mAdapter = generateAdapter();
    mRecyclerView.setAdapter(new LRecyclerViewAdapter(mAdapter));
    mRecyclerView.setOnRefreshListener(this);
    mRecyclerView.setOnLoadMoreListener(this);
    mRecyclerView.addOnScrollListener(new ImageAutoLoadScrollListener());
    setOnItemClickListener(new OnItemClickListener() {
      @Override public void onItemClick(View view, int position) {
        if (mAdapter != null) {
          mAdapter.onItemClick(view, position);
        }
      }
    });
    setOnItemLongClickListener(new OnItemLongClickListener() {
      @Override public void onItemLongClick(View view, int position) {
        if (mAdapter != null) {
          mAdapter.onItemLongClick(view, position);
        }
      }
    });
  }

  /**
   * 开始刷新
   */
  protected void startRefresh(){
    boolean isRefreshing = isRefreshing();

    //取消任务
    mPresenter.dispose();
    //设置刷新完成.
    notifyCompleteRefresh(0);
    //移到顶部
    mRecyclerView.scrollToPosition(0);

    int delayTime = 100;
    if(isRefreshing){
      delayTime = 1000;
    }

    LogUtil.i("delayTime : " + delayTime);

    //下拉刷新
    Flowable.just("")
        .subscribeOn(Schedulers.io())
        .delay(delayTime, TimeUnit.MILLISECONDS)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Consumer<String>() {
          @Override public void accept(@NonNull String s) throws Exception {
            mRecyclerView.forceToRefresh();
          }
        });

  }

  public boolean isRefreshing(){
    return isRefreshing;
  }

  public void setRefreshing(boolean isRefreshing){
    this.isRefreshing = isRefreshing;
  }

  protected void notifyCompleteRefresh(int refreshCount) {
    isRefreshing = false;
    mRecyclerView.refreshComplete(refreshCount);
    if (refreshCount > 0) {
      int start = mAdapter.getItemCount() - refreshCount;
      if(start > 0){
        mAdapter.notifyItemRangeInserted(start, refreshCount);
      }else{
        mAdapter.notifyDataSetChanged();
      }
    }
  }

  public void showErrorMessage(boolean isRefresh, String message) {
    if (mContext instanceof Activity) {
      super.showErrorMessage(message);
    }

    if (isRefresh) {
      mRecyclerView.refreshComplete(0);
    } else {
      mRecyclerView.refreshComplete(0);
      mRecyclerView.setOnNetWorkErrorListener(new OnNetWorkErrorListener() {
        @Override public void reload() {
          onLoadMore();
        }
      });
    }
  }

  protected void setLayoutManager(LRecyclerView recyclerView) {
    LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
    recyclerView.setLayoutManager(layoutManager);

    mRecyclerView.addItemDecoration(new RecycleViewDivider(mContext));
  }

  public void setOnItemClickListener(OnItemClickListener listener) {
    if (mRecyclerView.getAdapter() != null) {
      ((LRecyclerViewAdapter) mRecyclerView.getAdapter()).setOnItemClickListener(listener);
    }
  }

  public void setOnItemLongClickListener(OnItemLongClickListener listener) {
    if (mRecyclerView.getAdapter() != null) {
      ((LRecyclerViewAdapter) mRecyclerView.getAdapter()).setOnItemLongClickListener(listener);
    }
  }

  protected abstract BaseAdapter generateAdapter();

  public abstract void onLoadMore();

  public abstract void onRefresh();

  //监听滚动来对图片加载进行判断处理
  private class ImageAutoLoadScrollListener extends RecyclerView.OnScrollListener {

    @Override public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
      super.onScrolled(recyclerView, dx, dy);
    }

    @Override public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
      super.onScrollStateChanged(recyclerView, newState);
      switch (newState) {
        case RecyclerView.SCROLL_STATE_IDLE: // The RecyclerView is not currently scrolling.
          //当屏幕停止滚动，加载图片
          try {
            if (getContext() != null) Glide.with(getContext()).resumeRequests();
          } catch (Exception e) {
            e.printStackTrace();
          }
          break;
        case RecyclerView.SCROLL_STATE_DRAGGING: // The RecyclerView is currently being dragged by outside input such as user touch input.
          //当屏幕滚动且用户使用的触碰或手指还在屏幕上，停止加载图片
          //try {
          //  if (getContext() != null) Glide.with(getContext()).pauseRequests();
          //} catch (Exception e) {
          //  e.printStackTrace();
          //}
          break;
        case RecyclerView.SCROLL_STATE_SETTLING: // The RecyclerView is currently animating to a final position while not under outside control.
          //由于用户的操作，屏幕产生惯性滑动，停止加载图片
          try {
            if (getContext() != null) Glide.with(getContext()).pauseRequests();
          } catch (Exception e) {
            e.printStackTrace();
          }
          break;
      }
    }
  }
}
