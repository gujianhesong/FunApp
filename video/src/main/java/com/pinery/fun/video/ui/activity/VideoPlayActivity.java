package com.pinery.fun.video.ui.activity;

import android.support.v4.widget.NestedScrollView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.pinery.base.activity.BaseActivity;
import com.pinery.base.common.CommonViewRepository;
import com.pinery.base.util.ViewUtil;
import com.pinery.fun.video.R;
import com.pinery.fun.video.widget.LandLayoutVideo;
import com.shuyu.gsyvideoplayer.builder.GSYVideoOptionBuilder;
import com.shuyu.gsyvideoplayer.listener.GSYSampleCallBack;
import com.shuyu.gsyvideoplayer.listener.LockClickListener;
import com.shuyu.gsyvideoplayer.utils.OrientationUtils;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;
import com.shuyu.gsyvideoplayer.video.base.GSYVideoPlayer;

/**
 * Created by gujian on 2018-08-12.
 */
@Route(path = "/video/play")
public class VideoPlayActivity extends BaseActivity {
  private NestedScrollView postDetailNestedScroll;
  private StandardGSYVideoPlayer detailPlayer;

  private boolean isPlay;
  private boolean isPause;
  private boolean cache;
  private String url;

  private OrientationUtils orientationUtils;

  private GSYVideoOptionBuilder gsyVideoOptionBuilder;

  @Override
  protected void onPause() {
    getCurPlay().onVideoPause();
    super.onPause();
    isPause = true;
  }

  @Override
  protected void onResume() {
    getCurPlay().onVideoResume();
    super.onResume();
    isPause = false;
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    if (isPlay) {
      getCurPlay().release();
    }
    //GSYPreViewManager.instance().releaseMediaPlayer();
    if (orientationUtils != null)
      orientationUtils.releaseListener();
  }

  @Override protected void initInjector() {

  }

  @Override protected int getLayoutResId() {
    return R.layout.activity_video_play;
  }

  @Override protected void initViews() {
    postDetailNestedScroll = ViewUtil.findViewById(this, R.id.post_detail_nested_scroll);
    detailPlayer = ViewUtil.findViewById(this, R.id.detail_player);

    url = "rtsp://184.72.239.149/vod/mp4://BigBuckBunny_175k.mov";

    url = getIntent().getStringExtra("video_url");

    //增加封面
    ImageView imageView = new ImageView(this);
    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    //imageView.setImageResource(R.mipmap.defaultimg);

    resolveNormalVideoUI();

    //外部辅助的旋转，帮助全屏
    orientationUtils = new OrientationUtils(this, detailPlayer);
    //初始化不打开外部的旋转
    orientationUtils.setEnable(false);

    gsyVideoOptionBuilder = new GSYVideoOptionBuilder()
        .setThumbImageView(imageView)
        .setIsTouchWiget(false)
        .setRotateViewAuto(false)
        .setIsTouchWigetFull(false)
        .setLockLand(false)
        .setNeedLockFull(true)
        .setSeekRatio(1)
        .setUrl(url)
        .setCacheWithPlay(cache)
        .setVideoTitle("测试视频")
        //.isRealTimeStream(true)
        .setVideoAllCallBack(new GSYSampleCallBack() {
          @Override
          public void onPrepared(String url, Object... objects) {
            super.onPrepared(url, objects);
            //开始播放了才能旋转和全屏
            orientationUtils.setEnable(true);
            isPlay = true;
          }

          @Override
          public void onQuitFullscreen(String url, Object... objects) {
            super.onQuitFullscreen(url, objects);
            if (orientationUtils != null) {
              orientationUtils.backToProtVideo();
            }
          }
        });
    gsyVideoOptionBuilder.build(detailPlayer);

    detailPlayer.getFullscreenButton().setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        //直接横屏
        orientationUtils.resolveByClick();

        //第一个true是否需要隐藏actionbar，第二个true是否需要隐藏statusbar
        detailPlayer.startWindowFullscreen(VideoPlayActivity.this, true, true);
      }
    });

    detailPlayer.setLockClickListener(new LockClickListener() {
      @Override
      public void onClick(View view, boolean lock) {
        if (orientationUtils != null) {
          //配合下方的onConfigurationChanged
          orientationUtils.setEnable(!lock);
        }
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
    if (detailPlayer.getFullWindowPlayer() != null) {
      return detailPlayer.getFullWindowPlayer();
    }
    return detailPlayer;
  }

  private void playVideo() {
    detailPlayer.release();
    gsyVideoOptionBuilder.setUrl(url)
        .setCacheWithPlay(cache)
        .setVideoTitle("测试视频")
        .build(detailPlayer);
    gsyVideoOptionBuilder.build(detailPlayer);
    detailPlayer.postDelayed(new Runnable() {
      @Override
      public void run() {
        detailPlayer.startPlayLogic();
      }
    }, 1000);
  }

  private void resolveNormalVideoUI() {
    //增加title
    //detailPlayer.getTitleTextView().setVisibility(View.GONE);
    //detailPlayer.getBackButton().setVisibility(View.GONE);
  }

}
