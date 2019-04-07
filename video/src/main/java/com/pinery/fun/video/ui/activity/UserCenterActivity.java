package com.pinery.fun.video.ui.activity;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.bumptech.glide.Glide;
import com.github.jdsjlzx.interfaces.OnItemClickListener;
import com.github.jdsjlzx.interfaces.OnItemLongClickListener;
import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.pinery.base.activity.BaseActivity;
import com.pinery.base.adapter.BaseAdapter;
import com.pinery.base.common.CommonViewRepository;
import com.pinery.base.util.NetWorkUtil;
import com.pinery.base.util.ScreenUtil;
import com.pinery.base.util.ViewUtil;
import com.pinery.fun.video.R;
import com.pinery.fun.video.bean.BaseVideoItemBean;
import com.pinery.fun.video.bean.HuoUserCenterBean;
import com.pinery.fun.video.bean.HuoUserVideoItemBean;
import com.pinery.fun.video.bean.HuoUserVideoListBean;
import com.pinery.fun.video.common.Constants;
import com.pinery.fun.video.dagger.DaggerHuoUserCenterActivityComponent;
import com.pinery.fun.video.mvp.HuoUserCenterContract;
import com.pinery.fun.video.mvp.HuoUserCenterPresenter;
import com.pinery.fun.video.ui.adapter.BaseVideoAdapter;
import com.pinery.fun.video.ui.adapter.HuoUserVideoAdapter;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gujian on 2018/9/2.
 */
@Route(path = Constants.PATH_USER_CENTER)
public class UserCenterActivity extends BaseActivity<HuoUserCenterPresenter> implements
    HuoUserCenterContract.View, OnLoadMoreListener {

  private Toolbar toolbar;

  private TextView tvToolbarTitle;
  private ImageView ivAvatar;
  private TextView tvFollowerCount, tvFollowingCount, tvFanTicketCount;
  private TextView tvGender, tvYear, tvConsume;
  private TextView tvSignature;

  protected LRecyclerView mRecyclerView;

  protected BaseAdapter mAdapter;
  private LRecyclerViewAdapter mLRecyclerViewAdapter;

  private List<BaseVideoItemBean> mDatas = new ArrayList<>();
  private int mPage;
  private boolean mFirstRefresh = true;

  private String userId;

  @Override protected void initInjector() {
    DaggerHuoUserCenterActivityComponent.builder().build().inject(this);
  }

  @Override protected int getLayoutResId() {
    return R.layout.activity_user_center;
  }

  @Override protected void initViews() {
    initToolbar();

    ivAvatar = ViewUtil.findViewById(this, R.id.iv_avatar);
    tvFollowerCount = ViewUtil.findViewById(this, R.id.tv_follower_count);
    tvFollowingCount = ViewUtil.findViewById(this, R.id.tv_following_count);
    tvFanTicketCount = ViewUtil.findViewById(this, R.id.tv_fan_ticket_count);
    tvGender = ViewUtil.findViewById(this, R.id.tv_user_gender);
    tvYear = ViewUtil.findViewById(this, R.id.tv_user_year);
    tvConsume = ViewUtil.findViewById(this, R.id.tv_user_consume);
    tvSignature = ViewUtil.findViewById(this, R.id.tv_user_signature);

    mRecyclerView = ViewUtil.findViewById(this, R.id.swipe_target);
    mRecyclerView.setHasFixedSize(true);

    setLayoutManager(mRecyclerView);

    mAdapter = generateAdapter();
    mLRecyclerViewAdapter = new LRecyclerViewAdapter(mAdapter);
    mRecyclerView.setAdapter(mLRecyclerViewAdapter);
    mRecyclerView.setOnLoadMoreListener(this);
    //mRecyclerView.addOnScrollListener(new ImageAutoLoadScrollListener());
    mLRecyclerViewAdapter.setOnItemClickListener(new OnItemClickListener() {
      @Override public void onItemClick(View view, int position) {
        if (mAdapter != null) {
          mAdapter.onItemClick(view, position);
        }
      }
    });
    mLRecyclerViewAdapter.setOnItemLongClickListener(new OnItemLongClickListener() {
      @Override public void onItemLongClick(View view, int position) {
        if (mAdapter != null) {
          mAdapter.onItemLongClick(view, position);
        }
      }
    });

  }

  @Override protected void initData() {
    userId = getIntent().getStringExtra("user_id");

    mPresenter.requestUserInfo(userId);
    mPresenter.refreshVideoList(userId, true);
  }


  @Override public void onLoadMore() {
    if (!NetWorkUtil.isNetWorkAvailable(this)) {
      showErrorMessage(getString(R.string.tip_network_error));
      return;
    }

    mPresenter.loadMoreVideoList(userId, mPage);
  }

  protected void setLayoutManager(LRecyclerView recyclerView) {
    recyclerView.setLayoutManager(
            new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
    recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
      @Override public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                                           RecyclerView.State state) {
        int width = ScreenUtil.dp2px(getApplicationContext(), 1);
        outRect.set(width, width, width, width);
      }
    });
  }

  protected BaseAdapter<BaseVideoAdapter.BaseViewHolder> generateAdapter() {
    HuoUserVideoAdapter adapter = new HuoUserVideoAdapter(this, mDatas);
    adapter.bindRecyclerView(mRecyclerView);
    return adapter;
  }

  @Override protected CommonViewRepository provideCommonViewRepository() {
    return null;
  }

  private void initToolbar() {
    toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    toolbar.setNavigationIcon(R.drawable.wk);
    toolbar.setNavigationOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        finish();
      }
    });

    tvToolbarTitle = ViewUtil.findViewById(this, R.id.toolbar_title);
  }

  @Override public void update(HuoUserCenterBean bean) {
    if (bean == null) {
      return;
    }

    loadAvatarImage(ivAvatar, bean);

    tvToolbarTitle.setText(bean.getData().getNickname());
    tvFollowerCount.setText(String.valueOf(bean.getData().getStats().getFollower_count()));
    tvFollowingCount.setText(String.valueOf(bean.getData().getStats().getFollowing_count()));
    tvFanTicketCount.setText(String.valueOf(bean.getData().getFan_ticket_count()));
    tvGender.setText(bean.getData().getGender() == 1 ? "男" : "女");
    tvYear.setText(bean.getData().getBirthday_description());

    try {
      int consume = 0;
      String balance = bean.getData().getBalance();
      if (!TextUtils.isEmpty(balance)) {
        consume = new JSONObject(balance).getInt("consume");
      }
      tvConsume.setText("送出" + consume);
    } catch (Exception ex) {
    }

    try {
      String signature = bean.getData().getSignature();
      if (TextUtils.isEmpty(signature)){
        tvSignature.setVisibility(View.GONE);
      }else{
        tvSignature.setVisibility(View.VISIBLE);
        tvSignature.setText(signature);
      }
    } catch (Exception ex) {
    }
  }

  @Override
  public void updateList(boolean isRefresh, HuoUserVideoListBean bean) {
    if (isRefresh) {
      mDatas.clear();
      mPage = 0;
    }
    mPage++;

    List<HuoUserVideoItemBean> list = bean.getData();
    if (list != null) {
      mDatas.addAll(list);
    }

    notifyCompleteRefresh(list != null ? list.size() : 0);
  }

  public void notifyCompleteRefresh(int refreshCount) {
    mRecyclerView.refreshComplete(refreshCount);
    mLRecyclerViewAdapter.notifyDataSetChanged();
//    mLRecyclerViewAdapter.notifyItemRangeInserted(mAdapter.getItemCount() - refreshCount,
//            refreshCount);
  }

  private void loadAvatarImage(ImageView ivAvatar, HuoUserCenterBean bean) {
    String avatar = "";
    try {
      HuoUserCenterBean.DataBean authorBean = bean.getData();
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

    Glide.with(this).load(avatar).error(R.drawable.a0b).into(ivAvatar);
  }

  @Override public void error(Throwable throwable) {

  }
}
