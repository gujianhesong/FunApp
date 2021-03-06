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
import com.pinery.fun.video.bean.HuoAdItemBean;
import com.pinery.fun.video.bean.HuoVideoItemBean;
import com.pinery.fun.video.bean.VideoPlayBean;
import com.pinery.fun.video.common.Constants;
import com.pinery.fun.video.util.NumberUtil;
import com.pinery.fun.video.util.WebUtil;
import java.util.ArrayList;
import java.util.List;

public class HuoVideoAdapter extends HuoBaseVideoAdapter {
  private static final int ITEM_TYPE_UNKNOWN = 0;
  private static final int ITEM_TYPE_VIDEO = 1;
  private static final int ITEM_TYPE_AD = 2;

  public HuoVideoAdapter(Context context, List<BaseVideoItemBean> list) {
    super(context, list);
  }

  @Override
  public BaseVideoAdapter.BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    if (viewType == ITEM_TYPE_VIDEO) {
      final View view =
          LayoutInflater.from(parent.getContext()).inflate(R.layout.item_huo_video, parent, false);
      return new VideoViewHolder(view);
    } else if (viewType == ITEM_TYPE_AD) {
      final View view =
          LayoutInflater.from(parent.getContext()).inflate(R.layout.item_huo_ad, parent, false);
      return new AdViewHolder(view);
    }
    return null;
  }

  @Override public int getItemViewType(int position) {
    BaseVideoItemBean itemBean = list.get(position);
    if (itemBean instanceof HuoVideoItemBean) {
      return ITEM_TYPE_VIDEO;
    } else if (itemBean instanceof HuoAdItemBean) {
      return ITEM_TYPE_AD;
    }
    return ITEM_TYPE_UNKNOWN;
  }

  @Override protected List<BaseViewHolderHandler> provideViewHolderHandler() {
    List<BaseViewHolderHandler> list = new ArrayList<>();
    list.add(new VideoViewHolderHandler());
    list.add(new AdViewHolderHandler());
    return list;
  }

  @Override public void onItemClick(View view, int position) {
    BaseVideoItemBean itemBean = list.get(position);

    if (itemBean instanceof HuoVideoItemBean) {
      HuoVideoItemBean videoBean = (HuoVideoItemBean) itemBean;
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

    else if (itemBean instanceof HuoAdItemBean) {
      HuoAdItemBean adBean = (HuoAdItemBean) itemBean;
      WebUtil.openUrl(context, adBean.getData().getWeb_url());
    }
  }

  @Override public void onItemLongClick(View view, int position) {

  }

  class VideoViewHolderHandler extends BaseViewHolderHandler<VideoViewHolder, HuoVideoItemBean> implements View.OnClickListener{

    @Override
    protected boolean shouldHandle(BaseViewHolder viewHodler, BaseVideoItemBean dataBeanX) {
      if(viewHodler instanceof VideoViewHolder && dataBeanX instanceof HuoVideoItemBean){
        return true;
      }
      return false;
    }

    @Override public void setLayoutParams(VideoViewHolder holder, HuoVideoItemBean dataBeanX) {
      try {
        int parentWidth = recyclerView.getMeasuredWidth();
        int videoWidth = dataBeanX.getData().getVideo().getWidth();
        int videoHeight = dataBeanX.getData().getVideo().getHeight();

        int height = (int) (videoHeight * 1f / videoWidth * (parentWidth / 2));

        ViewGroup.LayoutParams params = holder.itemView.getLayoutParams();
        params.height = height;
        holder.itemView.setLayoutParams(params);
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }

    @Override public void fillData(VideoViewHolder viewHodler, HuoVideoItemBean dataBeanX) {
      try {
        viewHodler.tvTitle.setText(dataBeanX.getData().getTitle());
      } catch (Exception ex) {
      }

      try {
        viewHodler.tvFocusCount.setText(
            "♡" + NumberUtil.getFormatNumber(dataBeanX.getData().getStats().getDigg_count()));
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }

    @Override public void loadCoverImage(VideoViewHolder viewHodler, HuoVideoItemBean dataBeanX) {
      String url = "";
      try {
          url = dataBeanX.getData().getVideo().getCover().getUrl_list().get(0);
      } catch (Exception ex) {
        ex.printStackTrace();
      }

      Glide.with(context).load(url).into(viewHodler.ivImage);
    }

    @Override public void loadAvatarImage(VideoViewHolder viewHodler, HuoVideoItemBean dataBeanX) {
      String avatar = "";
      try {
        avatar = dataBeanX.getData().getAuthor().getAvatar_thumb().getUrl_list().get(0);
      } catch (Exception ex) {
      }

      Glide.with(context).load(avatar).error(R.drawable.a0b).into(viewHodler.ivAvatar);
      viewHodler.ivAvatar.setOnClickListener(this);
      viewHodler.ivAvatar.setTag(viewHodler.ivAvatar.getId(), dataBeanX.getData().getAuthor().getId_str());
    }

    @Override
    public void onClick(View view) {
      String userId = (String) view.getTag(view.getId());
      ARouter.getInstance().build(Constants.PATH_USER_CENTER)
              .withString("user_id", userId)
              .navigation();
    }
  }

  class AdViewHolderHandler extends BaseViewHolderHandler<AdViewHolder, HuoAdItemBean> {

    @Override
    protected boolean shouldHandle(BaseViewHolder viewHodler, BaseVideoItemBean dataBeanX) {
      if(viewHodler instanceof AdViewHolder && dataBeanX instanceof HuoAdItemBean){
        return true;
      }
      return false;
    }

    @Override public void setLayoutParams(AdViewHolder holder, HuoAdItemBean dataBeanX) {
      try {
        int parentWidth = recyclerView.getMeasuredWidth();
        int videoWidth = dataBeanX.getData().getCell_width();
        int videoHeight = dataBeanX.getData().getCell_height();

        int height = (int) (videoHeight * 1f / videoWidth * (parentWidth / 2));

        ViewGroup.LayoutParams params = holder.itemView.getLayoutParams();
        params.height = height;
        holder.itemView.setLayoutParams(params);
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }

    @Override public void fillData(AdViewHolder viewHodler, HuoAdItemBean dataBeanX) {
      try {
        viewHodler.tvTitle.setText(dataBeanX.getData().getText());
      } catch (Exception ex) {
      }

      try {
        viewHodler.tvLabel.setText(dataBeanX.getData().getLabel());
      } catch (Exception ex) {
      }

      try {
        viewHodler.tvBtnText.setText(dataBeanX.getData().getButton_text());
      } catch (Exception ex) {
      }
    }

    @Override public void loadCoverImage(AdViewHolder viewHodler, HuoAdItemBean dataBeanX) {
      String url = "";
      try {
        url = dataBeanX.getData().getImage_list().get(0).getUrl_list().get(0);
      } catch (Exception ex) {
        ex.printStackTrace();
      }

      Glide.with(context).load(url).into(viewHodler.ivImage);
    }

    @Override public void loadAvatarImage(AdViewHolder viewHodler, HuoAdItemBean dataBeanX) {
      String avatar = "";
      try {
        avatar = dataBeanX.getData().getAuthor().getAvatar().getUrl_list().get(0);
      } catch (Exception ex) {
        ex.printStackTrace();
      }

      Glide.with(context).load(avatar).error(R.drawable.a0b).into(viewHodler.ivAvatar);
    }
  }

  class VideoViewHolder extends BaseVideoAdapter.BaseViewHolder {
    ImageView ivImage;
    TextView tvTitle;
    ImageView ivAvatar;
    TextView tvFocusCount;

    VideoViewHolder(View itemView) {
      super(itemView);
      ivImage = ViewUtil.findViewById(itemView, R.id.iv_image);
      tvTitle = ViewUtil.findViewById(itemView, R.id.tv_title);
      ivAvatar = ViewUtil.findViewById(itemView, R.id.iv_avatar);
      tvFocusCount = ViewUtil.findViewById(itemView, R.id.tv_focus_count);
    }
  }

  class AdViewHolder extends BaseVideoAdapter.BaseViewHolder {
    ImageView ivImage;
    TextView tvTitle;
    ImageView ivAvatar;
    TextView tvLabel;
    TextView tvBtnText;

    AdViewHolder(View itemView) {
      super(itemView);
      ivImage = ViewUtil.findViewById(itemView, R.id.iv_image);
      tvTitle = ViewUtil.findViewById(itemView, R.id.tv_title);
      ivAvatar = ViewUtil.findViewById(itemView, R.id.iv_avatar);
      tvLabel = ViewUtil.findViewById(itemView, R.id.tv_ad_label);
      tvBtnText = ViewUtil.findViewById(itemView, R.id.tv_ad_btn_text);
    }
  }
}
