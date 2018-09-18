package com.pinery.fun.video.ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.bumptech.glide.Glide;
import com.pinery.base.common.CommonViewRepository;
import com.pinery.base.util.ViewUtil;
import com.pinery.fun.video.R;
import com.pinery.fun.video.bean.VideoPlayBean;
import com.pinery.fun.video.common.Constants;
import com.pinery.fun.video.ui.viewproxy.CommentsListViewProxy;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;

/**
 * Created by gujian on 2018-08-12.
 */
@Route(path = Constants.PATH_VIDEO_PLAY) public class VideoPlayActivity extends BaseVideoPlayActivity implements
    View.OnClickListener{
  private VideoPlayBean videoPlayBean;

  private RelativeLayout layoutComments;
  private CommentsListViewProxy commentsListViewProxy;

  @Override protected void initInjector() {

  }

  @Override protected int getLayoutResId() {
    return R.layout.activity_video_play;
  }

  @Override protected void initOtherViews() {
    Object obj = getIntent().getSerializableExtra(Constants.KEY_VIDEO_PLAY_BEAN);
    if (obj instanceof VideoPlayBean) {
      videoPlayBean = (VideoPlayBean) obj;
    }

    if (videoPlayBean == null) {
      return;
    }

    TextView tvName = ViewUtil.findViewById(this, R.id.tv_name);
    ImageView ivAvatar = ViewUtil.findViewById(this, R.id.iv_avatar);
    ivAvatar.setOnClickListener(this);

    ImageView ivCommentsCount = ViewUtil.findViewById(this, R.id.iv_comments_count);
    ImageView ivLoveCount = ViewUtil.findViewById(this, R.id.iv_love_count);
    ImageView ivShareCount = ViewUtil.findViewById(this, R.id.iv_share_count);
    TextView tvCommentsCount = ViewUtil.findViewById(this, R.id.tv_comments_count);
    TextView tvLoveCount = ViewUtil.findViewById(this, R.id.tv_love_count);
    TextView tvShareCount = ViewUtil.findViewById(this, R.id.tv_share_count);
    ivCommentsCount.setOnClickListener(this);
    ivLoveCount.setOnClickListener(this);
    ivShareCount.setOnClickListener(this);
    tvCommentsCount.setOnClickListener(this);
    tvLoveCount.setOnClickListener(this);
    tvShareCount.setOnClickListener(this);

    tvCommentsCount.setText(String.valueOf(videoPlayBean.getCommentCount()));
    tvLoveCount.setText(String.valueOf(videoPlayBean.getLoveCount()));
    tvShareCount.setText(String.valueOf(videoPlayBean.getShareCount()));

    tvName.setText(videoPlayBean.getAuthorName());
    Glide.with(this).load(videoPlayBean.getAuthorAvatar()).into(ivAvatar);
  }

  @Override protected OnInitVideoListener provideVideoListener() {
    return new OnInitVideoListener() {
      @Override public String getVideoUrl() {
        return videoPlayBean != null ? videoPlayBean.getUrl() : "";
      }

      @Override public String getVideoCoverUrl() {
        return videoPlayBean != null ? videoPlayBean.getCoverUrl() : "";
      }
    };
  }

  @Override protected StandardGSYVideoPlayer provideVideoPlayer() {
    return ViewUtil.findViewById(this, R.id.detail_player);
  }

  private void initCommentsView() {
    if(commentsListViewProxy == null){
      layoutComments = ViewUtil.findViewById(this, R.id.layout_comments);
      commentsListViewProxy = CommentsListViewProxy.newInstance(this, videoPlayBean.getId());
    }

    commentsListViewProxy.showInContainer(layoutComments);
  }

  @Override protected void initData() {
    playVideo();
  }

  @Override protected CommonViewRepository provideCommonViewRepository() {
    return null;
  }

  @Override public void onClick(View v) {
    switch (v.getId()){
      case R.id.iv_comments_count:
      case R.id.tv_comments_count:

        initCommentsView();

        break;
      case R.id.iv_love_count:
      case R.id.tv_love_count:
        break;
      case R.id.iv_share_count:
      case R.id.tv_share_count:
        break;
      case R.id.iv_avatar:

        ARouter.getInstance().build(Constants.PATH_USER_CENTER)
            .withString("user_id", videoPlayBean.getUserId())
            .navigation();

        break;
    }
  }

  @Override public void onBackPressed() {
    if(commentsListViewProxy != null && commentsListViewProxy.onBackPressed()){
      return;
    }

    super.onBackPressed();
  }
}
