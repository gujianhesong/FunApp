package com.pinery.fun.video.ui.activity;

import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.bumptech.glide.Glide;
import com.pinery.base.activity.BaseActivity;
import com.pinery.base.common.CommonViewRepository;
import com.pinery.base.util.ViewUtil;
import com.pinery.fun.video.R;
import com.pinery.fun.video.bean.HuoUserCenterBean;
import com.pinery.fun.video.common.Constants;
import com.pinery.fun.video.dagger.DaggerHuoUserCenterActivityComponent;
import com.pinery.fun.video.mvp.HuoUserCenterContract;
import com.pinery.fun.video.mvp.HuoUserCenterPresenter;
import com.pinery.fun.video.ui.viewproxy.HuoUserVideoListViewProxy;
import org.json.JSONObject;

/**
 * Created by gujian on 2018/9/2.
 */
@Route(path = Constants.PATH_USER_CENTER)
public class UserCenterActivity extends BaseActivity<HuoUserCenterPresenter> implements
    HuoUserCenterContract.UserCenterView{

  private Toolbar toolbar;

  private TextView tvToolbarTitle;
  private ImageView ivAvatar;
  private TextView tvFollowerCount, tvFollowingCount, tvFanTicketCount;
  private TextView tvGender, tvYear, tvCity;
  private TextView tvSignature;

  protected RelativeLayout rlVideoList;
  private HuoUserVideoListViewProxy mVideoProxy;

  private String userId;

  @Override protected void initInjector() {
    DaggerHuoUserCenterActivityComponent.builder().build().inject(this);
  }

  @Override protected int getLayoutResId() {
    return R.layout.activity_user_center;
  }

  @Override protected void onDestroy() {
    super.onDestroy();

    if(mVideoProxy != null){
      mVideoProxy.onDestroyView();
    }
  }

  @Override protected void initViews() {
    initToolbar();

    ivAvatar = ViewUtil.findViewById(this, R.id.iv_avatar);
    tvFollowerCount = ViewUtil.findViewById(this, R.id.tv_follower_count);
    tvFollowingCount = ViewUtil.findViewById(this, R.id.tv_following_count);
    tvFanTicketCount = ViewUtil.findViewById(this, R.id.tv_fan_ticket_count);
    tvGender = ViewUtil.findViewById(this, R.id.tv_user_gender);
    tvYear = ViewUtil.findViewById(this, R.id.tv_user_year);
    tvCity = ViewUtil.findViewById(this, R.id.tv_user_city);
    tvSignature = ViewUtil.findViewById(this, R.id.tv_user_signature);
    rlVideoList = ViewUtil.findViewById(this, R.id.rl_video_list);
  }

  @Override protected void initData() {
    userId = getIntent().getStringExtra("user_id");

    mPresenter.requestUserInfo(userId);

    mVideoProxy = HuoUserVideoListViewProxy.newInstance(this, userId);
    rlVideoList.addView(mVideoProxy.getView(), new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
        ViewGroup.LayoutParams.MATCH_PARENT));
    mVideoProxy.onCreateView();

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
    tvFollowerCount.setText(String.valueOf(bean.getData().getTotal_fans_count()));
    tvFollowingCount.setText(String.valueOf(bean.getData().getStats().getFollowing_count()));
    tvFanTicketCount.setText(String.valueOf(bean.getData().getFan_ticket_count()));
    tvGender.setText(bean.getData().getGender() == 1 ? "男" : "女");
    tvYear.setText(bean.getData().getBirthday_description());

    tvCity.setText(bean.getData().getCity());

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
