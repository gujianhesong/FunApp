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
import com.pinery.fun.video.bean.BaseVideoItemBean;
import com.pinery.fun.video.bean.HuoCityBean;
import com.pinery.fun.video.bean.HuoLiveItemBean;
import com.pinery.fun.video.bean.HuoVideoItemBean;
import com.pinery.fun.video.common.Constants;
import com.pinery.fun.video.dagger.DaggerHuoCityFragmentComponent;
import com.pinery.fun.video.mvp.HuoCityContract;
import com.pinery.fun.video.mvp.HuoCityPresenter;
import com.pinery.fun.video.ui.adapter.HuoCityAdapter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gujian on 2018-08-12.
 */

public class HuoCityListFragment extends BaseListFragment<HuoCityPresenter>
    implements HuoCityContract.View {

  private List<BaseVideoItemBean> mDatas = new ArrayList<>();
  private int mPage;
  private boolean mFirstRefresh = true;

  public static HuoCityListFragment newInstance() {
    return new HuoCityListFragment();
  }

  @Override protected void initInjector() {
    DaggerHuoCityFragmentComponent.create().inject(this);
  }

  @Override protected void initData() {
    setOnItemClickListener(new OnItemClickListener() {
      @Override public void onItemClick(View view, int position) {
        //打开视频
        showToast("打开视频");

        handleOnClickItem(mDatas.get(position));
      }
    });
    setOnItemLongClickListener(new OnItemLongClickListener() {
      @Override public void onItemLongClick(View view, int position) {

      }
    });
  }

  @Override protected void onLazyLoad() {
    if (mDatas.isEmpty()) {
      mRecyclerView.forceToRefresh();
    } else {
    }
  }

  @Override protected RecyclerView.Adapter generateAdapter() {
    //mDatas = new ArrayList<>();
    HuoCityAdapter adapter = new HuoCityAdapter(mContext, mDatas);
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

  @Override public void updateList(boolean isRefresh, HuoCityBean bean) {
    if (isRefresh) {
      mDatas.clear();
      mPage = 0;
    }
    LogUtil.printStack("add page:" + mPage);
    mPage++;

    List<BaseVideoItemBean> list = bean.getData();
    if (list != null) {
      mDatas.addAll(list);
    }

    notifyCompleteRefresh(list != null ? list.size() : 0);
  }

  @Override public void error(Throwable throwable) {
    showToast(throwable.getMessage());
  }

  private void handleOnClickItem(BaseVideoItemBean dataBeanX) {
    String url = "", coverUrl = "", userName = "", avatar = "";

    if (dataBeanX instanceof HuoVideoItemBean) {
      HuoVideoItemBean videoItemBean = (HuoVideoItemBean) dataBeanX;

      url = videoItemBean.getData().getVideo().getUrl_list().get(0);

      try {
        HuoVideoItemBean.DataBean.VideoBean.CoverBean coverBean =
            videoItemBean.getData().getVideo().getCover();
        if (TextUtils.isEmpty(coverUrl)) {
          coverUrl = coverBean != null ? coverBean.getUrl_list().get(0) : coverUrl;
        }
      } catch (Exception ex) {
        ex.printStackTrace();
      }

      userName = videoItemBean.getData().getAuthor().getNickname();

      avatar = "";
      try {
        HuoVideoItemBean.DataBean.AuthorBean authorBean = videoItemBean.getData().getAuthor();
        if (authorBean != null) {
          if (TextUtils.isEmpty(avatar)) {
            avatar =
                authorBean.getAvatar_jpg() != null ? authorBean.getAvatar_jpg().getUrl_list().get(0)
                    : avatar;
          }
          if (TextUtils.isEmpty(avatar)) {
            avatar = authorBean.getAvatar_large() != null ? authorBean.getAvatar_large()
                .getUrl_list()
                .get(0) : avatar;
          }
          if (TextUtils.isEmpty(avatar)) {
            avatar = authorBean.getAvatar_thumb() != null ? authorBean.getAvatar_thumb()
                .getUrl_list()
                .get(0) : avatar;
          }
        }
      } catch (Exception ex) {
      }
    } else if (dataBeanX instanceof HuoLiveItemBean) {
      HuoLiveItemBean liveItemBean = (HuoLiveItemBean) dataBeanX;
      url = liveItemBean.getData().getStream_url().getRtmp_pull_url();
      userName = liveItemBean.getData().getOwner().getNickname();
      HuoLiveItemBean.DataBean.OwnerBean.AvatarJpgBean avatarJpgBean =
          liveItemBean.getData().getOwner().getAvatar_jpg();
      HuoLiveItemBean.DataBean.OwnerBean.AvatarLargeBean avatarLargeBean =
          liveItemBean.getData().getOwner().getAvatar_large();
      HuoLiveItemBean.DataBean.OwnerBean.AvatarThumbBean avatarThumbBean =
          liveItemBean.getData().getOwner().getAvatar_thumb();
      if (TextUtils.isEmpty(avatar)) {
        avatar = avatarJpgBean != null ? avatarJpgBean.getUrl_list().get(0) : avatar;
      }
      if (TextUtils.isEmpty(avatar)) {
        avatar = avatarLargeBean != null ? avatarLargeBean.getUrl_list().get(0) : avatar;
      }
      if (TextUtils.isEmpty(avatar)) {
        avatar = avatarThumbBean != null ? avatarThumbBean.getUrl_list().get(0) : avatar;
      }
    }

    ARouter.getInstance()
        .build("/video/play")
        .withString(Constants.KEY_URL, url)
        .withString(Constants.KEY_COVER_URL, coverUrl)
        .withString(Constants.KEY_USER_NAME, userName)
        .withString(Constants.KEY_USER_AVATAR, avatar)
        .navigation();
  }
}