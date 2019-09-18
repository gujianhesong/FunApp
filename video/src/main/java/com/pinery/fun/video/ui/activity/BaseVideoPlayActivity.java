package com.pinery.fun.video.ui.activity;

import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.pinery.base.activity.BaseActivity;
import com.pinery.base.util.GlideUtil;
import com.pinery.fun.video.R;
import com.shuyu.gsyvideoplayer.GSYVideoADManager;
import com.shuyu.gsyvideoplayer.GSYVideoManager;
import com.shuyu.gsyvideoplayer.builder.GSYVideoOptionBuilder;
import com.shuyu.gsyvideoplayer.listener.GSYSampleCallBack;
import com.shuyu.gsyvideoplayer.listener.LockClickListener;
import com.shuyu.gsyvideoplayer.utils.OrientationUtils;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;
import com.shuyu.gsyvideoplayer.video.base.GSYVideoPlayer;

/**
 * 视频播放页面，专门负责视频播放逻辑
 */
public abstract class BaseVideoPlayActivity extends BaseActivity {

  interface OnInitVideoListener {
    String getVideoUrl();

    String getVideoCoverUrl();
  }

  private OnInitVideoListener mOnInitVideoListener;
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

  @Deprecated
  @Override protected void initViews() {
    initOtherViews();

    mOnInitVideoListener = provideVideoListener();
    if (mOnInitVideoListener != null) {
      videoUrl = mOnInitVideoListener.getVideoUrl();
      coverUrl = mOnInitVideoListener.getVideoCoverUrl();
    }

    initPlayerView();
  }

  private void initPlayerView() {
    if (mOnInitVideoListener == null) {
      return;
    }

    videoPlayer = provideVideoPlayer();
    if (videoPlayer == null) {
      return;
    }

    //外部辅助的旋转，帮助全屏
    orientationUtils = new OrientationUtils(this, videoPlayer);
    //初始化不打开外部的旋转
    orientationUtils.setEnable(false);

    gsyVideoOptionBuilder = new GSYVideoOptionBuilder().setIsTouchWiget(false)
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

    //设置封面
    final ImageView imageView = new ImageView(this);
    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    //imageView.setImageDrawable(new B);
    //if (!TextUtils.isEmpty(coverUrl)) {
    //  GlideUtil.loadImage(imageView, coverUrl);
    //}
    videoPlayer.setThumbImageView(imageView);
    videoPlayer.setThumbPlay(true);

    videoPlayer.getFullscreenButton().setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        //直接横屏
        orientationUtils.resolveByClick();

        //第一个true是否需要隐藏actionbar，第二个true是否需要隐藏statusbar
        videoPlayer.startWindowFullscreen(BaseVideoPlayActivity.this, true, true);
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
      @Override public void onClick(View v) {
        onBackPressed();
      }
    });
  }

  private GSYVideoPlayer getCurPlay() {
    if (videoPlayer.getFullWindowPlayer() != null) {
      return videoPlayer.getFullWindowPlayer();
    }
    return videoPlayer;
  }

  protected void playVideo() {
    videoPlayer.post(new Runnable() {
      @Override public void run() {
        videoPlayer.startPlayLogic();
      }
    });
  }

  protected abstract OnInitVideoListener provideVideoListener();

  protected abstract StandardGSYVideoPlayer provideVideoPlayer();

  protected abstract void initOtherViews();
}
