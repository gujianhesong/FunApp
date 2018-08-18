package com.pinery.fun.video.ui.activity;

import android.graphics.drawable.ColorDrawable;
import android.support.v4.widget.NestedScrollView;
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
import com.pinery.fun.video.common.Constants;
import com.shuyu.gsyvideoplayer.GSYVideoADManager;
import com.shuyu.gsyvideoplayer.GSYVideoManager;
import com.shuyu.gsyvideoplayer.builder.GSYVideoOptionBuilder;
import com.shuyu.gsyvideoplayer.listener.GSYSampleCallBack;
import com.shuyu.gsyvideoplayer.listener.LockClickListener;
import com.shuyu.gsyvideoplayer.utils.OrientationUtils;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;
import com.shuyu.gsyvideoplayer.video.base.GSYVideoPlayer;

/**
 * Created by gujian on 2018-08-12.
 */
@Route(path = "/video/play") public class VideoPlayActivity extends BaseActivity {
  private NestedScrollView postDetailNestedScroll;
  private StandardGSYVideoPlayer videoPlayer;

  private boolean isPlay;
  private boolean isPause;
  private String videoUrl;
  private String coverUrl;

  private OrientationUtils orientationUtils;

  private GSYVideoOptionBuilder gsyVideoOptionBuilder;

  @Override protected void onPause() {
    getCurPlay().onVideoPause();
    super.onPause();
    GSYVideoManager.onPause();
    GSYVideoADManager.onPause();
    isPause = true;
  }

  @Override protected void onResume() {
    getCurPlay().onVideoResume();
    super.onResume();
    GSYVideoManager.onResume();
    GSYVideoADManager.onResume();
    isPause = false;
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    if (isPlay) {
      getCurPlay().release();
    }
    videoPlayer.setVideoAllCallBack(null);
    GSYVideoManager.releaseAllVideos();
    GSYVideoADManager.releaseAllVideos();
    if (orientationUtils != null) orientationUtils.releaseListener();
  }

  @Override protected void initInjector() {

  }

  @Override protected int getLayoutResId() {
    return R.layout.activity_video_play;
  }

  @Override protected void initViews() {
    videoUrl = getIntent().getStringExtra(Constants.KEY_URL);
    coverUrl = getIntent().getStringExtra(Constants.KEY_COVER_URL);
    String name = getIntent().getStringExtra(Constants.KEY_USER_NAME);
    String avatar = getIntent().getStringExtra(Constants.KEY_USER_AVATAR);

    TextView tvName = ViewUtil.findViewById(this, R.id.tv_name);
    ImageView ivAvatar = ViewUtil.findViewById(this, R.id.iv_avatar);
    tvName.setText(name);
    Glide.with(this).load(avatar).into(ivAvatar);

    initPlayerView();
  }

  private void initPlayerView() {
    videoPlayer = ViewUtil.findViewById(this, R.id.detail_player);

    //设置封面
    ImageView imageView = new ImageView(this);
    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    imageView.setImageDrawable(new ColorDrawable(0x77ffff00));
    if(!TextUtils.isEmpty(coverUrl)){
      //Glide.with(this).load(coverUrl).into(imageView);
    }

    //外部辅助的旋转，帮助全屏
    orientationUtils = new OrientationUtils(this, videoPlayer);
    //初始化不打开外部的旋转
    orientationUtils.setEnable(false);

    gsyVideoOptionBuilder = new GSYVideoOptionBuilder()
        .setIsTouchWiget(false)
        .setRotateViewAuto(false)
        .setIsTouchWigetFull(false)
        .setLockLand(false)
        .setLooping(true)
        .setNeedLockFull(true)
        .setSeekRatio(1)
        .setUrl(videoUrl)
        .setCacheWithPlay(true)
        .setHideKey(true)
        //.setVideoTitle("测试视频")
        //.isRealTimeStream(true)
        .setVideoAllCallBack(new GSYSampleCallBack() {
          @Override public void onPrepared(String url, Object... objects) {
            super.onPrepared(url, objects);
            //开始播放了才能旋转和全屏
            orientationUtils.setEnable(true);
            isPlay = true;
          }

          @Override public void onQuitFullscreen(String url, Object... objects) {
            super.onQuitFullscreen(url, objects);
            if (orientationUtils != null) {
              orientationUtils.backToProtVideo();
            }
          }
        });
    gsyVideoOptionBuilder.build(videoPlayer);

    videoPlayer.setThumbImageView(imageView);
    videoPlayer.setThumbPlay(true);

    videoPlayer.getFullscreenButton().setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        //直接横屏
        orientationUtils.resolveByClick();

        //第一个true是否需要隐藏actionbar，第二个true是否需要隐藏statusbar
        videoPlayer.startWindowFullscreen(VideoPlayActivity.this, true, true);
      }
    });

    videoPlayer.setLockClickListener(new LockClickListener() {
      @Override public void onClick(View view, boolean lock) {
        if (orientationUtils != null) {
          //配合下方的onConfigurationChanged
          orientationUtils.setEnable(!lock);
        }
      }
    });

    //设置返回按键功能
    videoPlayer.getBackButton().setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        onBackPressed();
      }
    });
  }

  @Override protected void initData() {
    playVideo();
  }

  @Override protected CommonViewRepository provideCommonViewRepository() {
    return null;
  }

  private GSYVideoPlayer getCurPlay() {
    if (videoPlayer.getFullWindowPlayer() != null) {
      return videoPlayer.getFullWindowPlayer();
    }
    return videoPlayer;
  }

  private void playVideo() {
    //videoPlayer.release();
    //gsyVideoOptionBuilder.setUrl(videoUrl)
    //    .setCacheWithPlay(true)
    //    .setVideoTitle("测试视频")
    //    .build(videoPlayer);
    //gsyVideoOptionBuilder.build(videoPlayer);
    videoPlayer.post(new Runnable() {
      @Override public void run() {
        videoPlayer.startPlayLogic();
      }
    });
  }

}
