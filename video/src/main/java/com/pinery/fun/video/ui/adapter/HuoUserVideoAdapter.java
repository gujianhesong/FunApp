package com.pinery.fun.video.ui.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.bumptech.glide.Glide;
import com.pinery.base.util.ViewUtil;
import com.pinery.fun.video.R;
import com.pinery.fun.video.bean.BaseVideoItemBean;
import com.pinery.fun.video.bean.HuoUserVideoItemBean;
import com.pinery.fun.video.bean.VideoPlayBean;
import com.pinery.fun.video.common.Constants;
import com.pinery.fun.video.util.NumberUtil;

import java.util.ArrayList;
import java.util.List;

public class HuoUserVideoAdapter extends HuoBaseVideoAdapter {

  public HuoUserVideoAdapter(Context context, List<BaseVideoItemBean> list) {
    super(context, list);
  }

  @Override
  public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      final View view =
          LayoutInflater.from(parent.getContext()).inflate(R.layout.item_huo_user_video, parent, false);
      return new VideoViewHolder(view);
  }

  @Override protected List<BaseViewHolderHandler> provideViewHolderHandler() {
    List<BaseViewHolderHandler> list = new ArrayList<>();
    list.add(new UserVideoViewHolderHandler());
    return list;
  }

  @Override public void onItemClick(View view, int position) {
    BaseVideoItemBean itemBean = list.get(position);

    if (itemBean instanceof HuoUserVideoItemBean) {
      HuoUserVideoItemBean videoBean = (HuoUserVideoItemBean) itemBean;
      String id = videoBean.getData().getId_str();
      String url = videoBean.getData().getVideo().getUrl_list().get(0);

      String coverUrl = "";
      try {
        coverUrl = videoBean.getData().getVideo().getCover().getUrl_list().get(0);
      } catch (Exception ex) {
        ex.printStackTrace();
      }

      String userName = videoBean.getData().getAuthor().getNickname();

      String avatar = "";
      try {
        avatar = videoBean.getData().getAuthor().getAvatar_thumb().getUrl_list().get(0);
      } catch (Exception ex) {
      }

      VideoPlayBean bean = new VideoPlayBean();
      bean.setId(id);
      bean.setUrl(url);
      bean.setCoverUrl(coverUrl);
      bean.setAuthorName(userName);
      bean.setAuthorAvatar(avatar);
      bean.setCommentCount(videoBean.getData().getStats().getComment_count());
      bean.setLoveCount(videoBean.getData().getStats().getDigg_count());
      bean.setShareCount(videoBean.getData().getStats().getShare_count());
      bean.setUserId(videoBean.getData().getAuthor().getId_str());

      ARouter.getInstance()
          .build(Constants.PATH_VIDEO_PLAY)
          .withSerializable(Constants.KEY_VIDEO_PLAY_BEAN, bean)
          .navigation();
    }

  }

  @Override public void onItemLongClick(View view, int position) {

  }

  class UserVideoViewHolderHandler extends BaseViewHolderHandler<VideoViewHolder, HuoUserVideoItemBean> {

    @Override
    protected boolean shouldHandle(BaseViewHolder viewHodler, BaseVideoItemBean dataBeanX) {
      if(dataBeanX instanceof HuoUserVideoItemBean){
        return true;
      }
      return false;
    }

    @Override public void setLayoutParams(VideoViewHolder holder, HuoUserVideoItemBean dataBeanX) {
      try {
        int parentWidth = recyclerView.getMeasuredWidth();
        int videoWidth = dataBeanX.getData().getVideo().getWidth();
        int videoHeight = dataBeanX.getData().getVideo().getHeight();

        int height = (int) (videoHeight * 1f / videoWidth * (parentWidth / 3));

        ViewGroup.LayoutParams params = holder.itemView.getLayoutParams();
        params.height = height;
        holder.itemView.setLayoutParams(params);
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }

    @Override public void fillData(VideoViewHolder viewHodler, HuoUserVideoItemBean dataBeanX) {
      try {
        viewHodler.tvFocusCount.setText(
            "♡" + NumberUtil.getFormatNumber(dataBeanX.getData().getStats().getDigg_count()));
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }

    @Override public void loadCoverImage(VideoViewHolder viewHodler, HuoUserVideoItemBean dataBeanX) {
      String url = "";
      try {
        url = dataBeanX.getData().getVideo().getCover().getUrl_list().get(0) ;
      } catch (Exception ex) {
        ex.printStackTrace();
      }

      Glide.with(context).load(url).into(viewHodler.ivImage);
    }

    @Override public void loadAvatarImage(VideoViewHolder viewHodler, HuoUserVideoItemBean dataBeanX) {
    }
  }

  class VideoViewHolder extends BaseViewHolder {
    ImageView ivImage;
    TextView tvFocusCount;

    VideoViewHolder(View itemView) {
      super(itemView);
      ivImage = ViewUtil.findViewById(itemView, R.id.iv_image);
      tvFocusCount = ViewUtil.findViewById(itemView, R.id.tv_focus_count);
    }
  }

}
