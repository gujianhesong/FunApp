package com.pinery.fun.video.ui.fragment;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.view.View;
import com.alibaba.android.arouter.launcher.ARouter;
import com.github.jdsjlzx.interfaces.OnItemClickListener;
import com.github.jdsjlzx.interfaces.OnItemLongClickListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.pinery.base.util.LogUtil;
import com.pinery.base.util.NetWorkUtil;
import com.pinery.base.util.ScreenUtil;
import com.pinery.fun.video.R;
import com.pinery.fun.video.bean.HuoLiveBean;
import com.pinery.fun.video.bean.HuoVideoBean;
import com.pinery.fun.video.common.Constants;
import com.pinery.fun.video.dagger.DaggerHuoLiveFragmentComponent;
import com.pinery.fun.video.mvp.HuoLiveContract;
import com.pinery.fun.video.mvp.HuoLivePresenter;
import com.pinery.fun.video.ui.adapter.HuoLiveAdapter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gujian on 2018-08-12.
 */

public class HuoLiveListFragment extends BaseListFragment<HuoLivePresenter>
    implements HuoLiveContract.View {

  private List<HuoLiveBean.DataBeanX> mDatas;
  private int mPage;
  private boolean mFirstRefresh = true;

  public static HuoLiveListFragment newInstance() {
    return new HuoLiveListFragment();
  }

  @Override protected void initInjector() {
    DaggerHuoLiveFragmentComponent.create().inject(this);
  }

  @Override protected void initData() {
    setOnItemClickListener(new OnItemClickListener() {
      @Override public void onItemClick(View view, int position) {
        //打开视频
        showToast("打开视频");

        HuoLiveBean.DataBeanX dataBeanX = mDatas.get(position);
        String url = dataBeanX.getData().getStream_url().getRtmp_pull_url();
        String userName = dataBeanX.getData().getOwner().getNickname();
        String avatar = "";
        HuoLiveBean.DataBeanX.DataBean.OwnerBean.AvatarJpgBean avatarJpgBean =
            dataBeanX.getData().getOwner().getAvatar_jpg();
        HuoLiveBean.DataBeanX.DataBean.OwnerBean.AvatarLargeBean avatarLargeBean =
            dataBeanX.getData().getOwner().getAvatar_large();
        HuoLiveBean.DataBeanX.DataBean.OwnerBean.AvatarThumbBean avatarThumbBean =
            dataBeanX.getData().getOwner().getAvatar_thumb();
        if (TextUtils.isEmpty(avatar)) {
          avatar = avatarJpgBean != null ? avatarJpgBean.getUrl_list().get(0) : avatar;
        }
        if (TextUtils.isEmpty(avatar)) {
          avatar = avatarLargeBean != null ? avatarLargeBean.getUrl_list().get(0) : avatar;
        }
        if (TextUtils.isEmpty(avatar)) {
          avatar = avatarThumbBean != null ? avatarThumbBean.getUrl_list().get(0) : avatar;
        }

        ARouter.getInstance().build("/video/play")
            .withString(Constants.KEY_URL, url)
            .withString(Constants.KEY_USER_NAME, userName)
            .withString(Constants.KEY_USER_AVATAR, avatar)
            .navigation();

      }
    });
    setOnItemLongClickListener(new OnItemLongClickListener() {
      @Override public void onItemLongClick(View view, int position) {

      }
    });

  }

  @Override protected void onLazyLoad() {
    if(mDatas.isEmpty()){
      mRecyclerView.forceToRefresh();
    }else{
    }
  }

  @Override protected RecyclerView.Adapter generateAdapter() {
    mDatas = new ArrayList<>();
    HuoLiveAdapter adapter = new HuoLiveAdapter(mContext, mDatas);
    adapter.bindRecyclerView(mRecyclerView);
    return adapter;
  }

  @Override protected void setLayoutManager(LRecyclerView recyclerView){
    recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
    recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
      @Override
      public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
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

    if(mFirstRefresh){
      mPresenter.refreshData(true);
      mFirstRefresh = false;
    }else{
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

  @Override public void updateList(boolean isRefresh, HuoLiveBean huoLivebean) {
    if(isRefresh){
      mDatas.clear();
      mPage = 0;
    }
    LogUtil.printStack("add page:"+mPage);
    mPage++;

    List<HuoLiveBean.DataBeanX> list = huoLivebean.getData();
    if(list != null){
      mDatas.addAll(list);
    }

    notifyCompleteRefresh(list != null ? list.size() : 0);
  }

  @Override public void error(Throwable throwable) {
    showToast(throwable.getMessage());
  }
}