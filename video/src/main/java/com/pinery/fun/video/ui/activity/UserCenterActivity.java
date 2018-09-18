package com.pinery.fun.video.ui.activity;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
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
import org.json.JSONObject;

/**
 * Created by gujian on 2018/9/2.
 */
@Route(path = Constants.PATH_USER_CENTER)
public class UserCenterActivity extends BaseActivity<HuoUserCenterPresenter> implements
    HuoUserCenterContract.View {

  private Toolbar toolbar;

  private TextView tvToolbarTitle;
  private ImageView ivAvatar;
  private TextView tvFollowerCount, tvFollowingCount, tvFanTicketCount;
  private TextView tvGender, tvYear, tvConsume;
  private TextView tvSignature;

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
  }

  @Override protected void initData() {
    String userId = getIntent().getStringExtra("user_id");

    mPresenter.refreshData(userId);
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
      tvSignature.setText(bean.getData().getSignature());
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
