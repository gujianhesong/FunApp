package com.pinery.fun.video.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.pinery.base.util.ViewUtil;
import com.pinery.fun.video.R;
import com.pinery.fun.video.bean.BaseVideoItemBean;
import com.pinery.fun.video.bean.HuoLiveItemBean;
import com.pinery.fun.video.bean.HuoVideoItemBean;
import java.util.List;

public class HuoCityAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
  public static final int ITEM_TYPE_UNKNOWN = 0;
  public static final int ITEM_TYPE_VIDEO = 1;
  public static final int ITEM_TYPE_LIVE = 2;

  List<BaseVideoItemBean> list;
  Context context;
  RecyclerView recyclerView;

  private VideoViewHolderHandler videoViewHolderHandler;
  private LiveViewHolderHandler liveViewHolderHandler;

  public HuoCityAdapter(Context context, List<BaseVideoItemBean> list) {
    this.context = context;
    this.list = list;

    videoViewHolderHandler = new VideoViewHolderHandler();
    liveViewHolderHandler = new LiveViewHolderHandler();
  }

  public void bindRecyclerView(RecyclerView recyclerView) {
    this.recyclerView = recyclerView;
  }

  @Override public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    if (viewType == ITEM_TYPE_VIDEO) {
      final View view =
          LayoutInflater.from(parent.getContext()).inflate(R.layout.item_huo_city_video, parent, false);
      return new CityVideoViewHolder(view);
    } else if (viewType == ITEM_TYPE_LIVE) {
      final View view =
          LayoutInflater.from(parent.getContext()).inflate(R.layout.item_huo_city_live, parent, false);
      return new CityLiveViewHolder(view);
    }
    return null;
  }

  @Override public void onBindViewHolder(RecyclerView.ViewHolder viewHodler, int position) {
    BaseVideoItemBean dataBeanX = list.get(position);
    if (viewHodler != null && dataBeanX != null) {
      if (viewHodler instanceof CityVideoViewHolder && dataBeanX instanceof HuoVideoItemBean) {
        videoViewHolderHandler.bindViewHolder((CityVideoViewHolder) viewHodler,
            (HuoVideoItemBean) dataBeanX);
      } else if (viewHodler instanceof CityLiveViewHolder && dataBeanX instanceof HuoLiveItemBean) {
        liveViewHolderHandler.bindViewHolder((CityLiveViewHolder) viewHodler,
            (HuoLiveItemBean) dataBeanX);
      }
    }
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

  @Override public int getItemCount() {
    return list != null ? list.size() : 0;
  }

  class CityVideoViewHolder extends RecyclerView.ViewHolder {
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

  class CityLiveViewHolder extends RecyclerView.ViewHolder {
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

  interface IViewHolderHandler<VH extends RecyclerView.ViewHolder, T extends BaseVideoItemBean> {
    void setLayoutParams(VH holder, T dataBeanX);

    void fillData(VH viewHodler, T dataBeanX);

    void loadCoverImage(VH viewHodler, T dataBeanX);

    void loadAvatarImage(VH viewHodler, T dataBeanX);
  }

  abstract class BaseViewHolderHandler<VH extends RecyclerView.ViewHolder, T extends BaseVideoItemBean>
      implements IViewHolderHandler<VH, T> {
    void bindViewHolder(VH viewHodler, T dataBeanX) {
      setLayoutParams(viewHodler, dataBeanX);
      fillData(viewHodler, dataBeanX);
      loadCoverImage(viewHodler, dataBeanX);
      loadAvatarImage(viewHodler, dataBeanX);
    }
  }

  class VideoViewHolderHandler
      extends BaseViewHolderHandler<CityVideoViewHolder, HuoVideoItemBean> {

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
