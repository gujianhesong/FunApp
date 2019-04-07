package com.pinery.fun.joke.ui.fragment;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.bumptech.glide.Glide;
import com.github.jdsjlzx.ItemDecoration.DividerDecoration;
import com.github.jdsjlzx.interfaces.OnNetWorkErrorListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.pinery.base.adapter.BaseAdapter;
import com.pinery.base.fragment.BaseListFragment;
import com.pinery.base.util.LogUtil;
import com.pinery.base.util.NetWorkUtil;
import com.pinery.base.util.ScreenUtil;
import com.pinery.base.util.ViewUtil;
import com.pinery.base.widget.LRecycleViewDivider;
import com.pinery.fun.joke.R;
import com.pinery.fun.joke.bean.JokeDatasBean;
import com.pinery.fun.joke.callback.IRecyclerViewPool;
import com.pinery.fun.joke.dagger.DaggerJokeFragmentComponent;
import com.pinery.fun.joke.mvp.JokeContract;
import com.pinery.fun.joke.mvp.JokePresenter;
import com.pinery.fun.joke.ui.adapter.JokeAdapter;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by gujian on 2018-08-12.
 */

public class JokeListFragment extends BaseListFragment<JokePresenter>
    implements JokeContract.View, IRecyclerViewPool {

  private List<JokeDatasBean.DataBean> mDatas = new ArrayList<>();
  private String mType;
  private long mTimestamp;
  private RecyclerView.RecycledViewPool mPool;

  public static JokeListFragment newInstance(String type) {
    JokeListFragment fragment = new JokeListFragment();
    Bundle bundle = new Bundle();
    bundle.putString("type", type);
    fragment.setArguments(bundle);
    return fragment;
  }

  @Override
  public void onPause() {
    super.onPause();
    if("video".equals(mType)){
      JCVideoPlayer.releaseAllVideos();
    }
  }

  @Override protected int getLayoutId() {
    return R.layout.fragment_joke_list;
  }

  @Override protected void initInjector() {
    DaggerJokeFragmentComponent.create().inject(this);
  }

  @Override protected void initViews(View view, Bundle savedInstanceState) {
    super.initViews(view, savedInstanceState);

    FloatingActionButton floatingActionButton = ViewUtil.findViewById(view, R.id.float_action_btn);
    floatingActionButton.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        //开始刷新
        startRefresh();
      }
    });

    if(mRecyclerView != null && mRecyclerView.getRecycledViewPool() != mPool && mPool != null){
      if(mRecyclerView.getLayoutManager() != null && mRecyclerView.getLayoutManager() instanceof LinearLayoutManager){
        ((LinearLayoutManager)mRecyclerView.getLayoutManager()).setRecycleChildrenOnDetach(true);
      }
      mRecyclerView.setRecycledViewPool(mPool);
      LogUtil.i("mRecyclerView:" + mRecyclerView + ", " + mType);
    }

    //mRecyclerView.addOnScrollListener(new RecyclerScrollListener());
  }

  @Override protected void initData() {
    mType = getArguments().getString("type");
  }

  @Override protected void onLazyLoad() {
    if (mDatas.isEmpty()) {
      //开始刷新
      startRefresh();
    } else {
    }
  }

  @Override protected JokeAdapter generateAdapter() {
    JokeAdapter adapter = new JokeAdapter(mContext, mDatas);
    return adapter;
  }

  @Override protected void setLayoutManager(LRecyclerView recyclerView) {
    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    recyclerView.addItemDecoration(new DividerDecoration.Builder(getContext())
        .setHeight(R.dimen.dp_6)
        .setColorResource(R.color.divide_line)
        .build());
  }

  @Override public void onRefresh() {
    if (!NetWorkUtil.isNetWorkAvailable(mContext)) {
      showErrorMessage(true, mContext.getString(R.string.tip_network_error));
      return;
    }

    mTimestamp = 0;
    setRefreshing(true);

    mPresenter.requestData(mType, mTimestamp, true);
  }

  @Override public void onLoadMore() {
    if (!NetWorkUtil.isNetWorkAvailable(mContext)) {
      showErrorMessage(false, mContext.getString(R.string.tip_network_error));
      return;
    }

    mPresenter.requestData(mType, mTimestamp, false);
  }

  @Override public void updateList(boolean isRefresh, JokeDatasBean data) {
    if (isRefresh) {
      LogUtil.i("updateList:" + isRefresh + ", " + data);
      mDatas.clear();
    }

    mTimestamp = data.getTimestamp();

    List<JokeDatasBean.DataBean> list = data.getData();
    if (list != null) {
      mDatas.addAll(list);
    }

    notifyCompleteRefresh(list != null ? list.size() : 0);
  }

  @Override public void onFailure(boolean isCancel, Throwable throwable) {
    notifyCompleteRefresh(0);

    if(!isCancel){
      showToast(throwable.getMessage());
      mRecyclerView.setOnNetWorkErrorListener(new OnNetWorkErrorListener() {
        @Override
        public void reload() {
          onLoadMore();
        }
      });
    }

  }

  @Override public void onDestroyView() {
    super.onDestroyView();

    LogUtil.i("onDestroyView:" + mType);
    if (mRecyclerView != null){
      mRecyclerView.refreshComplete(0);
    }
  }

  @Override public void setRecyclerViewPool(RecyclerView.RecycledViewPool pool) {
    mPool = pool;
  }

  @Override public RecyclerView.RecycledViewPool getRecyclerViewPool() {
    if(mRecyclerView != null){
      return mRecyclerView.getRecycledViewPool();
    }
    return null;
  }

  private class RecyclerScrollListener extends RecyclerView.OnScrollListener {

    @Override public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
      super.onScrolled(recyclerView, dx, dy);

      LinearLayoutManager linearLayoutManager =
          (LinearLayoutManager) recyclerView.getLayoutManager();

      int firstItem = linearLayoutManager.findFirstVisibleItemPosition();
      int lastItem = linearLayoutManager.findLastVisibleItemPosition();

    }

    @Override public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
      super.onScrollStateChanged(recyclerView, newState);
    }
  }

}