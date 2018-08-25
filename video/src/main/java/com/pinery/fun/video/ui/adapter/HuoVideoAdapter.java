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
      String url = videoBean.getData().getVideo().getUrl_list().get(0);

      String coverUrl = "";
      try {
        HuoVideoItemBean.DataBean.VideoBean.CoverBean coverBean =
            videoBean.getData().getVideo().getCover();
        if (TextUtils.isEmpty(coverUrl)) {
          coverUrl = coverBean != null ? coverBean.getUrl_list().get(0) : coverUrl;
        }
      } catch (Exception ex) {
        ex.printStackTrace();
      }

      String userName = videoBean.getData().getAuthor().getNickname();

      String avatar = "";
      try {
        HuoVideoItemBean.DataBean.AuthorBean authorBean = videoBean.getData().getAuthor();
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

      ARouter.getInstance()
          .build("/video/play")
          .withString(Constants.KEY_URL, url)
          .withString(Constants.KEY_COVER_URL, coverUrl)
          .withString(Constants.KEY_USER_NAME, userName)
          .withString(Constants.KEY_USER_AVATAR, avatar)
          .navigation();
    }

    else if (itemBean instanceof HuoAdItemBean) {
      HuoAdItemBean adBean = (HuoAdItemBean) itemBean;
      WebUtil.openUrl(context, adBean.getData().getWeb_url());
    }
  }

  @Override public void onItemLongClick(View view, int position) {

  }

  class VideoViewHolderHandler extends BaseViewHolderHandler<VideoViewHolder, HuoVideoItemBean> {

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
        HuoVideoItemBean.DataBean.VideoBean.CoverBean coverBean =
            dataBeanX.getData().getVideo().getCover();
        if (TextUtils.isEmpty(url)) {
          url = coverBean != null ? coverBean.getUrl_list().get(0) : url;
        }
      } catch (Exception ex) {
        ex.printStackTrace();
      }

      Glide.with(context).load(url).into(viewHodler.ivImage);
    }

    @Override public void loadAvatarImage(VideoViewHolder viewHodler, HuoVideoItemBean dataBeanX) {
      String avatar = "";
      try {
        HuoVideoItemBean.DataBean.AuthorBean authorBean = dataBeanX.getData().getAuthor();
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

      Glide.with(context).load(avatar).into(viewHodler.ivAvatar);
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
        HuoAdItemBean.DataBean.ImageListBean coverBean = dataBeanX.getData().getImage_list().get(0);
        if (TextUtils.isEmpty(url)) {
          url = coverBean != null ? coverBean.getUrl_list().get(0) : url;
        }
      } catch (Exception ex) {
        ex.printStackTrace();
      }

      Glide.with(context).load(url).into(viewHodler.ivImage);
    }

    @Override public void loadAvatarImage(AdViewHolder viewHodler, HuoAdItemBean dataBeanX) {
      String avatar = "";
      try {
        HuoAdItemBean.DataBean.AuthorBean.AvatarBean authorBean =
            dataBeanX.getData().getAuthor().getAvatar();
        if (TextUtils.isEmpty(avatar)) {
          avatar = authorBean.getUri();
        }
        if (TextUtils.isEmpty(avatar)) {
          avatar = authorBean.getUrl_list() != null ? authorBean.getUrl_list().get(0) : avatar;
        }
      } catch (Exception ex) {
        ex.printStackTrace();
      }

      Glide.with(context).load(avatar).into(viewHodler.ivAvatar);
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
