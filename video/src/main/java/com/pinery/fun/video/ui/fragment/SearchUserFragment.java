package com.pinery.fun.video.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import com.github.jdsjlzx.ItemDecoration.DividerDecoration;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.pinery.base.fragment.BaseListFragment;
import com.pinery.base.util.NetWorkUtil;
import com.pinery.fun.video.R;
import com.pinery.fun.video.bean.SearchBean;
import com.pinery.fun.video.bean.item.SearchUserItemsBean;
import com.pinery.fun.video.callback.OnSearchCallback;
import com.pinery.fun.video.dagger.DaggerSearchUserFragmentComponent;
import com.pinery.fun.video.mvp.SearchContract;
import com.pinery.fun.video.mvp.SearchPresenter;
import com.pinery.fun.video.ui.adapter.SearchUserAdapter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gujian on 2018-08-12.
 */

public class SearchUserFragment extends BaseListFragment<SearchPresenter>
    implements SearchContract.View, OnSearchCallback {

  private List<SearchUserItemsBean.UsersBean> mDatas = new ArrayList<>();
  private int mPage;
  private String keyword;
  private int searchType = SearchPresenter.SEARCH_TYPE_USER;

  public static SearchUserFragment newInstance() {
    return new SearchUserFragment();
  }

  @Override protected void initInjector() {
    DaggerSearchUserFragmentComponent.create().inject(this);
  }

  @Override protected void initData() {
  }

  @Override protected void onLazyLoad() {
    mRecyclerView.refresh();
  }

  @Override protected SearchUserAdapter generateAdapter() {
    SearchUserAdapter adapter = new SearchUserAdapter(mContext, mDatas);
    return adapter;
  }

  @Override protected void setLayoutManager(LRecyclerView recyclerView) {
    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    recyclerView.addItemDecoration(new DividerDecoration.Builder(getContext())
        .setHeight(1f)
        .setColorResource(R.color.divide_line)
        .build());
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

    List<SearchUserItemsBean.UsersBean> list = bean.getData().get(0).getUser_result().getUsers();
    if (list != null) {
      mDatas.addAll(list);
    }

    notifyCompleteRefresh(list != null ? list.size() : 0);
  }

  @Override public void error(Throwable throwable) {
    showToast(throwable.getMessage());
  }
}