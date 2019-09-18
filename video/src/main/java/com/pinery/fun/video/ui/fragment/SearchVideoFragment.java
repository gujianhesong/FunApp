package com.pinery.fun.video.ui.fragment;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.view.View;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.pinery.base.fragment.BaseListFragment;
import com.pinery.base.util.NetWorkUtil;
import com.pinery.base.util.ScreenUtil;
import com.pinery.fun.video.R;
import com.pinery.fun.video.bean.SearchBean;
import com.pinery.fun.video.bean.item.SearchVideoItemsBean;
import com.pinery.fun.video.callback.OnSearchCallback;
import com.pinery.fun.video.dagger.DaggerSearchVideoFragmentComponent;
import com.pinery.fun.video.mvp.SearchContract;
import com.pinery.fun.video.mvp.SearchPresenter;
import com.pinery.fun.video.ui.adapter.SearchVideoAdapter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gujian on 2018-08-12.
 */

public class SearchVideoFragment extends BaseListFragment<SearchPresenter>
    implements SearchContract.View, OnSearchCallback {

  private List<SearchVideoItemsBean.ItemsBean> mDatas = new ArrayList<>();
  private int mPage;
  private String keyword;
  private int searchType = SearchPresenter.SEARCH_TYPE_VIDEO;

  public static SearchVideoFragment newInstance() {
    return new SearchVideoFragment();
  }

  @Override protected void initInjector() {
    DaggerSearchVideoFragmentComponent.create().inject(this);
  }

  @Override protected void initData() {
  }

  @Override protected void onLazyLoad() {
    mRecyclerView.refresh();
  }

  @Override protected SearchVideoAdapter generateAdapter() {
    SearchVideoAdapter adapter = new SearchVideoAdapter(mContext, mDatas);
    adapter.bindRecyclerView(mRecyclerView);
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

  @Override public void onSearch(String keyword) {
    this.keyword = keyword;

    if (isVisible) {
      mRecyclerView.refresh();
    }
  }

  @Override public void onRefresh() {
    if (!TextUtils.isEmpty(keyword)) {
      if (!NetWorkUtil.isNetWorkAvailable(mContext)) {
        showErrorMessage(true, mContext.getString(R.string.tip_network_error));
        return;
      }

      mPresenter.refreshData(keyword, searchType);
    } else {
      notifyCompleteRefresh(0);
    }
  }

  @Override public void onLoadMore() {
    if (!NetWorkUtil.isNetWorkAvailable(mContext)) {
      showErrorMessage(false, mContext.getString(R.string.tip_network_error));
      return;
    }

    mPresenter.loadMoreData(keyword, searchType, mPage);
  }

  @Override public void updateList(String keyword, boolean isRefresh, SearchBean bean) {
    if (isRefresh) {
      mDatas.clear();
      mPage = 0;
    }
    mPage++;

    List<SearchVideoItemsBean.ItemsBean> list = bean.getData().get(0).getItem_result().getItems();
    if (list != null) {
      mDatas.addAll(list);
    }

    notifyCompleteRefresh(list != null ? list.size() : 0);
  }

  @Override public void error(Throwable throwable) {
    showToast(throwable.getMessage());
  }
}