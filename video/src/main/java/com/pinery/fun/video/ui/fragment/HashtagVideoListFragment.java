package com.pinery.fun.video.ui.fragment;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.pinery.base.adapter.BaseAdapter;
import com.pinery.base.fragment.BaseListFragment;
import com.pinery.base.util.NetWorkUtil;
import com.pinery.base.util.ScreenUtil;
import com.pinery.fun.video.R;
import com.pinery.fun.video.bean.HashTagItemsBean;
import com.pinery.fun.video.dagger.DaggerHashTagVideoListComponent;
import com.pinery.fun.video.mvp.HashTagContract;
import com.pinery.fun.video.mvp.HashTagItemsPresenter;
import com.pinery.fun.video.ui.adapter.HashTagVideoListAdapter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gujian on 2018-08-12.
 */

public class HashtagVideoListFragment extends BaseListFragment<HashTagItemsPresenter>
    implements HashTagContract.HashTagItemsView {

  private List<HashTagItemsBean.DataBeanX> mDatas = new ArrayList<>();
  private String mHashTag;
  private int mPage;

  public static HashtagVideoListFragment newInstance(String hashtag) {
    HashtagVideoListFragment fragment = new HashtagVideoListFragment();
    Bundle bundle = new Bundle();
    bundle.putString("hashtag", hashtag);
    fragment.setArguments(bundle);
    return fragment;
  }

  @Override protected void initInjector() {
    DaggerHashTagVideoListComponent.create().inject(this);
  }

  @Override protected void initData() {
    mHashTag = getArguments().getString("hashtag");

    onLazyLoad();
  }

  @Override protected void onLazyLoad() {
    if (mDatas.isEmpty()) {
      mRecyclerView.forceToRefresh();
    } else {
    }
  }

  @Override protected BaseAdapter<HashTagVideoListAdapter.ViewHolder> generateAdapter() {
    //mDatas = new ArrayList<>();
    HashTagVideoListAdapter adapter = new HashTagVideoListAdapter(mContext, mDatas);
    return adapter;
  }

  @Override protected void setLayoutManager(LRecyclerView recyclerView) {
    recyclerView.setLayoutManager(
        new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
    recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
      @Override public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
          RecyclerView.State state) {
        int width = ScreenUtil.dp2px(mContext, 1);
        outRect.set(width, width, width, width);
      }
    });
  }

  @Override public void onRefresh() {
    if (!NetWorkUtil.isNetWorkAvailable(mContext)) {
      showErrorMessage(true, mContext.getString(R.string.tip_network_error));
      return;
    }

    mPresenter.refreshData(mHashTag);
  }

  @Override public void onLoadMore() {
    if (!NetWorkUtil.isNetWorkAvailable(mContext)) {
      showErrorMessage(false, mContext.getString(R.string.tip_network_error));
      return;
    }

    mPresenter.loadMoreData(mHashTag, mPage);
  }

  @Override public void updateHashTagList(HashTagItemsBean bean, boolean refresh) {
    if (refresh) {
      mDatas.clear();
      mPage = 0;
    }
    mPage++;

    //List<HashTagItemsBean.DataBeanX> list = bean.getData();
    //if (list != null) {
    //  mDatas.addAll(list);
    //}
    //
    //notifyCompleteRefresh(list != null ? list.size() : 0);
  }

  @Override public void error(Throwable throwable) {
    showToast(throwable.getMessage());
  }
}