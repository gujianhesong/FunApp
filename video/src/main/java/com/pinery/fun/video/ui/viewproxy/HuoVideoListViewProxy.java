package com.pinery.fun.video.ui.viewproxy;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.pinery.base.adapter.BaseAdapter;
import com.pinery.base.util.LogUtil;
import com.pinery.base.util.NetWorkUtil;
import com.pinery.base.util.ScreenUtil;
import com.pinery.base.viewproxy.BaseListViewProxy;
import com.pinery.fun.video.R;
import com.pinery.fun.video.bean.BaseVideoItemBean;
import com.pinery.fun.video.bean.HuoVideoBean;
import com.pinery.fun.video.dagger.DaggerHuoVideoViewProxyComponent;
import com.pinery.fun.video.mvp.HuoVideoContract;
import com.pinery.fun.video.mvp.HuoVideoPresenter;
import com.pinery.fun.video.ui.adapter.BaseVideoAdapter;
import com.pinery.fun.video.ui.adapter.HuoVideoAdapter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gujian on 2018-08-25.
 */

public class HuoVideoListViewProxy extends BaseListViewProxy<HuoVideoPresenter>
    implements HuoVideoContract.View {

  private List<BaseVideoItemBean> mDatas = new ArrayList<>();
  private int mPage;
  private boolean mFirstRefresh = true;

  public static HuoVideoListViewProxy newInstance(Context context) {
    return new HuoVideoListViewProxy(context);
  }

  public HuoVideoListViewProxy(Context context){
    super(context);
  }

  @Override protected void initInjector() {
    DaggerHuoVideoViewProxyComponent.create().inject(this);
  }

  @Override protected void initData() {
    if (mDatas.isEmpty()) {
      mRecyclerView.forceToRefresh();
    } else {
    }
  }

  @Override protected BaseAdapter<BaseVideoAdapter.BaseViewHolder> generateAdapter() {
    HuoVideoAdapter adapter = new HuoVideoAdapter(mContext, mDatas);
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

  @Override public void onRefresh() {
    if (!NetWorkUtil.isNetWorkAvailable(mContext)) {
      showErrorMessage(true, mContext.getString(R.string.tip_network_error));
      return;
    }

    if (mFirstRefresh) {
      mPresenter.refreshData(true);
      mFirstRefresh = false;
    } else {
      mPresenter.refreshData(false);
    }
  }

  @Override public void onLoadMore() {
    if (!NetWorkUtil.isNetWorkAvailable(mContext)) {
      showErrorMessage(false, mContext.getString(R.string.tip_network_error));
      return;
    }

    mPresenter.loadMoreData(mPage);
  }

  @Override public void updateList(boolean isRefresh, HuoVideoBean huoVideoBean) {
    if (isRefresh) {
      mDatas.clear();
      mPage = 0;
    }
    mPage++;

    List<BaseVideoItemBean> list = huoVideoBean.getData();
    if (list != null) {
      mDatas.addAll(list);
    }

    notifyCompleteRefresh(list != null ? list.size() : 0);
  }

  @Override public void error(Throwable throwable) {
    showToast(throwable.getMessage());
  }
}