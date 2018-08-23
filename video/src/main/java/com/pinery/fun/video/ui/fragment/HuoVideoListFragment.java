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
import com.pinery.fun.video.bean.HuoVideoBean;
import com.pinery.fun.video.bean.HuoVideoItemBean;
import com.pinery.fun.video.common.Constants;
import com.pinery.fun.video.dagger.DaggerHuoVideoFragmentComponent;
import com.pinery.fun.video.mvp.HuoVideoContract;
import com.pinery.fun.video.mvp.HuoVideoPresenter;
import com.pinery.fun.video.ui.adapter.HuoVideoAdapter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gujian on 2018-08-12.
 */

public class HuoVideoListFragment extends BaseListFragment<HuoVideoPresenter>
    implements HuoVideoContract.View {

  private List<HuoVideoItemBean> mDatas = new ArrayList<>();
  private int mPage;
  private boolean mFirstRefresh = true;

  public static HuoVideoListFragment newInstance() {
    return new HuoVideoListFragment();
  }

  @Override protected void initInjector() {
    DaggerHuoVideoFragmentComponent.create().inject(this);
  }

  @Override protected void initData() {
    setOnItemClickListener(new OnItemClickListener() {
      @Override public void onItemClick(View view, int position) {
        //打开视频
        showToast("打开视频");

        HuoVideoItemBean dataBeanX = mDatas.get(position);

        String url = dataBeanX.getData().getVideo().getUrl_list().get(0);

        String coverUrl = "";
        try {
          HuoVideoItemBean.DataBean.VideoBean.CoverBean coverBean =
              dataBeanX.getData().getVideo().getCover();
          if (TextUtils.isEmpty(coverUrl)) {
            coverUrl = coverBean != null ? coverBean.getUrl_list().get(0) : coverUrl;
          }
        } catch (Exception ex) {
          ex.printStackTrace();
        }

        String userName = dataBeanX.getData().getAuthor().getNickname();

        String avatar = "";
        try {
          HuoVideoItemBean.DataBean.AuthorBean authorBean = dataBeanX.getData().getAuthor();
          if (authorBean != null) {
            if (TextUtils.isEmpty(avatar)) {
              avatar = authorBean.getAvatar_jpg() != null ? authorBean.getAvatar_jpg()
                  .getUrl_list()
                  .get(0) : avatar;
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

        ARouter.getInstance()
            .build("/video/play")
            .withString(Constants.KEY_URL, url)
            .withString(Constants.KEY_COVER_URL, coverUrl)
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
    if (mDatas.isEmpty()) {
      mRecyclerView.forceToRefresh();
    } else {
    }
  }

  @Override protected RecyclerView.Adapter generateAdapter() {
    //mDatas = new ArrayList<>();
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
    LogUtil.printStack("add page:" + mPage);
    mPage++;

    List<HuoVideoItemBean> list = huoVideoBean.getData();
    if (list != null) {
      mDatas.addAll(list);
    }

    notifyCompleteRefresh(list != null ? list.size() : 0);
  }

  @Override public void error(Throwable throwable) {
    showToast(throwable.getMessage());
  }
}