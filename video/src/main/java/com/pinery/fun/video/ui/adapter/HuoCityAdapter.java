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
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.pinery.base.util.ViewUtil;
import com.pinery.fun.video.R;
import com.pinery.fun.video.bean.BaseVideoItemBean;
import com.pinery.fun.video.bean.HuoLiveItemBean;
import com.pinery.fun.video.bean.HuoVideoItemBean;
import com.pinery.fun.video.common.Constants;
import java.util.ArrayList;
import java.util.List;

public class HuoCityAdapter extends HuoBaseVideoAdapter {
  private static final int ITEM_TYPE_UNKNOWN = 0;
  private static final int ITEM_TYPE_VIDEO = 1;
  private static final int ITEM_TYPE_LIVE = 2;

  public HuoCityAdapter(Context context, List<BaseVideoItemBean> list) {
    super(context, list);
  }

  @Override
  public BaseVideoAdapter.BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    if (viewType == ITEM_TYPE_VIDEO) {
      final View view = LayoutInflater.from(parent.getContext())
          .inflate(R.layout.item_huo_city_video, parent, false);
      return new CityVideoViewHolder(view);
    } else if (viewType == ITEM_TYPE_LIVE) {
      final View view = LayoutInflater.from(parent.getContext())
          .inflate(R.layout.item_huo_city_live, parent, false);
      return new CityLiveViewHolder(view);
    }
    return null;
  }

  @Override public int getItemViewType(int position) {
    BaseVideoItemBean baseVideoItemBean = list.get(position);
    if (baseVideoItemBean instanceof HuoVideoItemBean) {
      return ITEM_TYPE_VIDEO;
    } else if (baseVideoItemBean instanceof HuoLiveItemBean) {
      return ITEM_TYPE_LIVE;
    }
    return ITEM_TYPE_UNKNOWN;
  }

  @Override protected List<BaseViewHolderHandler> provideViewHolderHandler() {
    List<BaseViewHolderHandler> list = new ArrayList<>();
    list.add(new VideoViewHolderHandler());
    list.add(new LiveViewHolderHandler());
    return list;
  }

  @Override public void onItemClick(View view, int position) {
    String url = "", coverUrl = "", userName = "", avatar = "";

    BaseVideoItemBean itemBean = list.get(position);

    if (itemBean instanceof HuoVideoItemBean) {
      HuoVideoItemBean videoItemBean = (HuoVideoItemBean) itemBean;

      url = videoItemBean.getData().getVideo().getUrl_list().get(0);

      try {
        HuoVideoItemBean.DataBean.VideoBean.CoverBean coverBean =
            videoItemBean.getData().getVideo().getCover();
        if (TextUtils.isEmpty(coverUrl)) {
          coverUrl = coverBean != null ? coverBean.getUrl_list().get(0) : coverUrl;
        }
      } catch (Exception ex) {
        ex.printStackTrace();
      }

      userName = videoItemBean.getData().getAuthor().getNickname();

      avatar = "";
      try {
        HuoVideoItemBean.DataBean.AuthorBean authorBean = videoItemBean.getData().getAuthor();
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
    } else if (itemBean instanceof HuoLiveItemBean) {
      HuoLiveItemBean liveItemBean = (HuoLiveItemBean) itemBean;

      url = liveItemBean.getData().getStream_url().getRtmp_pull_url();
      userName = liveItemBean.getData().getOwner().getNickname();
      HuoLiveItemBean.DataBean.OwnerBean.AvatarJpgBean avatarJpgBean =
          liveItemBean.getData().getOwner().getAvatar_jpg();
      HuoLiveItemBean.DataBean.OwnerBean.AvatarLargeBean avatarLargeBean =
          liveItemBean.getData().getOwner().getAvatar_large();
      HuoLiveItemBean.DataBean.OwnerBean.AvatarThumbBean avatarThumbBean =
          liveItemBean.getData().getOwner().getAvatar_thumb();
      if (TextUtils.isEmpty(avatar)) {
        avatar = avatarJpgBean != null ? avatarJpgBean.getUrl_list().get(0) : avatar;
      }
      if (TextUtils.isEmpty(avatar)) {
        avatar = avatarLargeBean != null ? avatarLargeBean.getUrl_list().get(0) : avatar;
      }
      if (TextUtils.isEmpty(avatar)) {
        avatar = avatarThumbBean != null ? avatarThumbBean.getUrl_list().get(0) : avatar;
      }
    }

    ARouter.getInstance()
        .build("/video/play")
        .withString(Constants.KEY_URL, url)
        .withString(Constants.KEY_COVER_URL, coverUrl)
        .withString(Constants.KEY_USER_NAME, userName)
        .withString(Constants.KEY_USER_AVATAR, avatar)
        .navigation();
  }

  @Override public void onItemLongClick(View view, int position) {

  }

  class CityVideoViewHolder extends BaseVideoAdapter.BaseViewHolder {
    ImageView ivImage;
    TextView tvTitle;
    ImageView ivAvatar;
    TextView tvDistance;

    CityVideoViewHolder(View itemView) {
      super(itemView);
      ivImage = ViewUtil.findViewById(itemView, R.id.iv_image);
      tvTitle = ViewUtil.findViewById(itemView, R.id.tv_title);
      ivAvatar = ViewUtil.findViewById(itemView, R.id.iv_avatar);
      tvDistance = ViewUtil.findViewById(itemView, R.id.tv_distance);
    }
  }

  class CityLiveViewHolder extends BaseVideoAdapter.BaseViewHolder {
    ImageView ivImage;
    TextView tvLocation;
    TextView tvName;
    TextView tvCount;
    TextView tvDistance;

    CityLiveViewHolder(View itemView) {
      super(itemView);
      ivImage = ViewUtil.findViewById(itemView, R.id.iv_image);
      tvLocation = ViewUtil.findViewById(itemView, R.id.tv_location);
      tvName = ViewUtil.findViewById(itemView, R.id.tv_name);
      tvCount = ViewUtil.findViewById(itemView, R.id.tv_count);
      tvDistance = ViewUtil.findViewById(itemView, R.id.tv_distance);
    }
  }

  class VideoViewHolderHandler
      extends BaseViewHolderHandler<CityVideoViewHolder, HuoVideoItemBean> {

    @Override
    protected boolean shouldHandle(BaseViewHolder viewHodler, BaseVideoItemBean dataBeanX) {
      if(viewHodler instanceof CityVideoViewHolder && dataBeanX instanceof HuoVideoItemBean){
        return true;
      }
      return false;
    }

    @Override public void setLayoutParams(CityVideoViewHolder holder, HuoVideoItemBean dataBeanX) {
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

    @Override public void fillData(CityVideoViewHolder viewHodler, HuoVideoItemBean dataBeanX) {
      try {
        viewHodler.tvTitle.setText(dataBeanX.getData().getTitle());
      } catch (Exception ex) {
      }

      try {
        viewHodler.tvDistance.setText(dataBeanX.getData().get_distance());
      } catch (Exception ex) {
      }
    }

    @Override
    public void loadCoverImage(CityVideoViewHolder viewHodler, HuoVideoItemBean dataBeanX) {
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

    @Override
    public void loadAvatarImage(CityVideoViewHolder viewHodler, HuoVideoItemBean dataBeanX) {
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

  class LiveViewHolderHandler extends BaseViewHolderHandler<CityLiveViewHolder, HuoLiveItemBean> {

    @Override
    protected boolean shouldHandle(BaseViewHolder viewHodler, BaseVideoItemBean dataBeanX) {
      if(viewHodler instanceof CityLiveViewHolder && dataBeanX instanceof HuoLiveItemBean){
        return true;
      }
      return false;
    }

    @Override public void setLayoutParams(CityLiveViewHolder holder, HuoLiveItemBean dataBeanX) {

    }

    @Override public void fillData(CityLiveViewHolder viewHodler, HuoLiveItemBean dataBeanX) {
      try {
        viewHodler.tvLocation.setText(dataBeanX.getData().getOwner().getCity());
      } catch (Exception ex) {
      }

      try {
        viewHodler.tvName.setText(dataBeanX.getData().getOwner().getNickname());
      } catch (Exception ex) {
      }

      try {
        viewHodler.tvCount.setText(String.format("%d人", dataBeanX.getData().getUser_count()));
      } catch (Exception ex) {
      }

      try {
        viewHodler.tvDistance.setText(dataBeanX.getData().get_distance());
      } catch (Exception ex) {
      }
    }

    @Override public void loadCoverImage(CityLiveViewHolder viewHodler, HuoLiveItemBean dataBeanX) {

    }

    @Override public void loadAvatarImage(final CityLiveViewHolder viewHodler,
        final HuoLiveItemBean dataBeanX) {
      String url = "";

      HuoLiveItemBean.DataBean.OwnerBean.AvatarJpgBean avatarJpgBean =
          dataBeanX.getData().getOwner().getAvatar_jpg();
      HuoLiveItemBean.DataBean.OwnerBean.AvatarLargeBean avatarLargeBean =
          dataBeanX.getData().getOwner().getAvatar_large();
      HuoLiveItemBean.DataBean.OwnerBean.AvatarThumbBean avatarThumbBean =
          dataBeanX.getData().getOwner().getAvatar_thumb();
      if (TextUtils.isEmpty(url)) {
        url = avatarJpgBean != null ? avatarJpgBean.getUrl_list().get(0) : url;
      }
      if (TextUtils.isEmpty(url)) {
        url = avatarLargeBean != null ? avatarLargeBean.getUrl_list().get(0) : url;
      }
      if (TextUtils.isEmpty(url)) {
        url = avatarThumbBean != null ? avatarThumbBean.getUrl_list().get(0) : url;
      }

      Glide.with(context).load(url).into(new SimpleTarget<GlideDrawable>() {
        @Override public void onResourceReady(GlideDrawable resource,
            GlideAnimation<? super GlideDrawable> glideAnimation) {

          viewHodler.ivImage.setImageDrawable(resource);

          setLayoutParams(viewHodler, dataBeanX);
        }
      });
    }
  }
}
