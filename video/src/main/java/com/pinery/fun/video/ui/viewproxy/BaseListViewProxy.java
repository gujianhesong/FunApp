package com.pinery.fun.video.ui.viewproxy;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import com.github.jdsjlzx.interfaces.OnItemClickListener;
import com.github.jdsjlzx.interfaces.OnItemLongClickListener;
import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.interfaces.OnNetWorkErrorListener;
import com.github.jdsjlzx.interfaces.OnRefreshListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.pinery.base.adapter.BaseAdapter;
import com.pinery.base.mvp.IPresenter;
import com.pinery.base.util.ViewUtil;
import com.pinery.fun.video.R;

/**
 * Created by gujian on 2018-08-25.
 */

public abstract class BaseListViewProxy<T extends IPresenter> extends BaseViewProxy<T>
    implements OnRefreshListener, OnLoadMoreListener {

  protected LRecyclerView mRecyclerView;

  protected BaseAdapter mAdapter;
  private LRecyclerViewAdapter mLRecyclerViewAdapter;

  public BaseListViewProxy(Context context) {
    super(context);
  }

  @Override public int getLayoutId() {
    return R.layout.fragment_base_list;
  }

  @Override protected void initView(View view) {
    mRecyclerView = ViewUtil.findViewById(view, R.id.swipe_target);
    mRecyclerView.setHasFixedSize(true);

    setLayoutManager(mRecyclerView);

    mAdapter = generateAdapter();
    mLRecyclerViewAdapter = new LRecyclerViewAdapter(mAdapter);
    mRecyclerView.setAdapter(mLRecyclerViewAdapter);
    mRecyclerView.setOnRefreshListener(this);
    mRecyclerView.setOnLoadMoreListener(this);
    //mRecyclerView.addOnScrollListener(new ImageAutoLoadScrollListener());
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

  public void notifyCompleteRefresh(int refreshCount) {
    mRecyclerView.refreshComplete(refreshCount);
    if (mAdapter.getItemCount() == refreshCount) {
      mLRecyclerViewAdapter.notifyDataSetChanged();
    } else {
      mLRecyclerViewAdapter.notifyItemRangeInserted(mAdapter.getItemCount() - refreshCount,
          refreshCount);
    }
  }

  public void showErrorMessage(boolean isRefresh, String message) {
    //if (mContext instanceof Activity) {
    //  super.showErrorMessage(message);
    //}

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

    //mRecyclerView.addItemDecoration(new RecycleViewDivider(mContext));
  }

  public void setOnItemClickListener(OnItemClickListener listener) {
    if (mLRecyclerViewAdapter != null) {
      mLRecyclerViewAdapter.setOnItemClickListener(listener);
    }
  }

  public void setOnItemLongClickListener(OnItemLongClickListener listener) {
    if (mLRecyclerViewAdapter != null) {
      mLRecyclerViewAdapter.setOnItemLongClickListener(listener);
    }
  }

  protected abstract BaseAdapter generateAdapter();
}
