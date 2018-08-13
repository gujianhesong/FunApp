package com.pinery.fun.video.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;

/**
 * Created by gujian on 2018-08-12.
 */

public class LandLayoutVideo extends StandardGSYVideoPlayer {

  /**
   * 1.5.0开始加入，如果需要不同布局区分功能，需要重载
   */
  public LandLayoutVideo(Context context, Boolean fullFlag) {
    super(context, fullFlag);
  }

  public LandLayoutVideo(Context context) {
    super(context);
  }

  public LandLayoutVideo(Context context, AttributeSet attrs) {
    super(context, attrs);
  }


  ////这个必须配置最上面的构造才能生效
  //@Override
  //public int getLayoutId() {
  //  if (mIfCurrentIsFullscreen) {
  //    return R.layout.sample_video_land;
  //  }
  //  return R.layout.sample_video_normal;
  //}
  //
  //@Override
  //protected void updateStartImage() {
  //  if (mIfCurrentIsFullscreen) {
  //    if(mStartButton instanceof  ImageView) {
  //      ImageView imageView = (ImageView) mStartButton;
  //      if (mCurrentState == CURRENT_STATE_PLAYING) {
  //        imageView.setImageResource(R.drawable.video_click_pause_selector);
  //      } else if (mCurrentState == CURRENT_STATE_ERROR) {
  //        imageView.setImageResource(R.drawable.video_click_play_selector);
  //      } else {
  //        imageView.setImageResource(R.drawable.video_click_play_selector);
  //      }
  //    }
  //  } else {
  //    super.updateStartImage();
  //  }
  //}
  //
  //@Override
  //public int getEnlargeImageRes() {
  //  return R.drawable.custom_enlarge;
  //}
  //
  //@Override
  //public int getShrinkImageRes() {
  //  return R.drawable.custom_shrink;
  //}


}
