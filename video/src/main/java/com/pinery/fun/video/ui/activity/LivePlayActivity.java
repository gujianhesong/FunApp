package com.pinery.fun.video.ui.activity;

import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.bumptech.glide.Glide;
import com.pinery.base.common.CommonViewRepository;
import com.pinery.base.util.ViewUtil;
import com.pinery.fun.video.R;
import com.pinery.fun.video.bean.LivePlayBean;
import com.pinery.fun.video.common.Constants;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;

/**
 * Created by gujian on 2018-08-12.
 */
@Route(path = Constants.PATH_LIVE_PLAY) public class LivePlayActivity extends BaseVideoPlayActivity {
  private LivePlayBean livePlayBean;

  private RelativeLayout layoutComments;

  @Override protected void initInjector() {

  }

  @Override protected int getLayoutResId() {
    return R.layout.activity_live_play;
  }

  @Override protected void initOtherViews() {
    Object obj = getIntent().getSerializableExtra(Constants.KEY_LIVE_PLAY_BEAN);
    if (obj instanceof LivePlayBean) {
      livePlayBean = (LivePlayBean) obj;
    }

    if (livePlayBean == null) {
      return;
    }

    TextView tvName = ViewUtil.findViewById(this, R.id.tv_name);
    ImageView ivAvatar = ViewUtil.findViewById(this, R.id.iv_avatar);

    tvName.setText(livePlayBean.getAuthorName());
    Glide.with(this).load(livePlayBean.getAuthorAvatar()).into(ivAvatar);
  }

  @Override protected OnInitVideoListener provideVideoListener() {
    return new OnInitVideoListener() {
      @Override public String getVideoUrl() {
        return livePlayBean != null ? livePlayBean.getUrl() : "";
      }

      @Override public String getVideoCoverUrl() {
        return "";
      }
    };
  }

  @Override protected StandardGSYVideoPlayer provideVideoPlayer() {
    return ViewUtil.findViewById(this, R.id.detail_player);
  }

  @Override protected void initData() {
    playVideo();
  }

  @Override protected CommonViewRepository provideCommonViewRepository() {
    return null;
  }
}
