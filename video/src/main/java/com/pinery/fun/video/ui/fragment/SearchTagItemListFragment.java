package com.pinery.fun.video.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.pinery.base.adapter.BaseAdapter;
import com.pinery.base.fragment.BaseListFragment;
import com.pinery.base.util.NetWorkUtil;
import com.pinery.base.widget.RecycleViewDivider;
import com.pinery.fun.video.R;
import com.pinery.fun.video.bean.SearchTagItemsBean;
import com.pinery.fun.video.dagger.DaggerSearchTagItemListComponent;
import com.pinery.fun.video.mvp.SearchContract;
import com.pinery.fun.video.mvp.SearchTagItemsPresenter;
import com.pinery.fun.video.ui.adapter.SearchTagItemsAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gujian on 2019-03-21.
 */

public class SearchTagItemListFragment extends BaseListFragment<SearchTagItemsPresenter>
    implements SearchContract.TagItemsView {

  private List<SearchTagItemsBean.DataBean> mDatas = new ArrayList<>();
  private int mPage;
  private int mTagId;

  public static SearchTagItemListFragment newInstance(int tagId) {
    SearchTagItemListFragment fragment = new SearchTagItemListFragment();
    Bundle bundle = new Bundle();
    bundle.putInt("tagId", tagId);
    fragment.setArguments(bundle);
    return fragment;
  }

  @Override protected void initInjector() {
    DaggerSearchTagItemListComponent.create().inject(this);
  }

  @Override protected void initData() {
    mTagId = getArguments().getInt("tagId");
  }

  @Override protected void onLazyLoad() {
    if (mDatas.isEmpty()) {
      mRecyclerView.forceToRefresh();
    } else {
    }
  }

  @Override protected BaseAdapter<SearchTagItemsAdapter.SearchTagViewHolder> generateAdapter() {
    //mDatas = new ArrayList<>();
    SearchTagItemsAdapter adapter = new SearchTagItemsAdapter(mContext, mDatas);
//    adapter.bindRecyclerView(mRecyclerView);
    return adapter;
  }

  @Override protected void setLayoutManager(LRecyclerView recyclerView) {
    recyclerView.setLayoutManager(
        new LinearLayoutManager(getContext()));
    recyclerView.addItemDecoration(new RecycleViewDivider(mContext));
  }

  @Override public void onRefresh() {
    if (!NetWorkUtil.isNetWorkAvailable(mContext)) {
      showErrorMessage(true, mContext.getString(R.string.tip_network_error));
      return;
    }

    mPresenter.requestTagItems(mTagId);
  }

  @Override public void onLoadMore() {
    if (!NetWorkUtil.isNetWorkAvailable(mContext)) {
      showErrorMessage(false, mContext.getString(R.string.tip_network_error));
      return;
    }

    mPresenter.loadMoreData(mTagId, mPage);
  }

  @Override
  public void updateTagItems(SearchTagItemsBean bean, boolean isRefresh) {
    if (isRefresh) {
      mDatas.clear();
      mPage = 0;
    }
    mPage++;

    List<SearchTagItemsBean.DataBean> list = bean.getData();
    if (list != null) {
      mDatas.addAll(list);
    }

    notifyCompleteRefresh(list != null ? list.size() : 0);
  }

  @Override public void error(Throwable throwable) {
    showToast(throwable.getMessage());
  }
}