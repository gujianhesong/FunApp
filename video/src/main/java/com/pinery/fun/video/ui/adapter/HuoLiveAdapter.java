package com.pinery.fun.video.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
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
import com.pinery.fun.video.bean.HuoAdItemBean;
import com.pinery.fun.video.bean.HuoLiveItemBean;
import com.pinery.fun.video.bean.LivePlayBean;
import com.pinery.fun.video.common.Constants;
import java.util.ArrayList;
import java.util.List;

public class HuoLiveAdapter extends HuoBaseVideoAdapter {
  private static final int ITEM_TYPE_UNKNOWN = 0;
  private static final int ITEM_TYPE_LIVE = 1;

  public HuoLiveAdapter(Context context, List<BaseVideoItemBean> list) {
    super(context, list);
  }

  public void bindRecyclerView(RecyclerView recyclerView) {
    this.recyclerView = recyclerView;
  }

  @Override
  public BaseVideoAdapter.BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    if (viewType == ITEM_TYPE_LIVE) {
      final View view =
          LayoutInflater.from(parent.getContext()).inflate(R.layout.item_huo_live, parent, false);
      return new LiveViewHolder(view);
    }
    return null;
  }

  @Override public int getItemViewType(int position) {
    BaseVideoItemBean itemBean = list.get(position);
    if (itemBean instanceof HuoLiveItemBean) {
      return ITEM_TYPE_LIVE;
    }
    return ITEM_TYPE_UNKNOWN;
  }

  @Override protected List<BaseViewHolderHandler> provideViewHolderHandler() {
    List<BaseViewHolderHandler> list = new ArrayList<>();
    list.add(new LiveViewHolderHandler());
    return list;
  }

  @Override public void onItemClick(View view, int position) {
    BaseVideoItemBean itemBean = list.get(position);

    if (itemBean instanceof HuoLiveItemBean) {
      HuoLiveItemBean liveItemBean = (HuoLiveItemBean) itemBean;
      String url = liveItemBean.getData().getStream_url().getRtmp_pull_url();
      String userName = liveItemBean.getData().getOwner().getNickname();
      String avatar = "";
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

      LivePlayBean bean = new LivePlayBean();
      bean.setUrl(url);
      bean.setAuthorName(userName);
      bean.setAuthorAvatar(avatar);

      ARouter.getInstance()
          .build(Constants.PATH_LIVE_PLAY)
          .withSerializable(Constants.KEY_LIVE_PLAY_BEAN, bean)
          .navigation();
    }
  }

  @Override public void onItemLongClick(View view, int position) {

  }

  class LiveViewHolderHandler extends BaseViewHolderHandler<LiveViewHolder, HuoLiveItemBean> {

    @Override
    protected boolean shouldHandle(BaseViewHolder viewHodler, BaseVideoItemBean dataBeanX) {
      if(viewHodler instanceof LiveViewHolder && dataBeanX instanceof HuoLiveItemBean){
        return true;
      }
      return false;
    }

    @Override public void setLayoutParams(LiveViewHolder holder, HuoLiveItemBean dataBeanX) {
      /*try {
        int parentWidth = recyclerView.getMeasuredWidth();
        int videoWidth = holder.ivAvatar.getDrawable().getIntrinsicWidth();
        int videoHeight = holder.ivAvatar.getDrawable().getIntrinsicHeight();

        int height = (int) (videoHeight * 1f / videoWidth * (parentWidth / 2));

        ViewGroup.LayoutParams params = holder.ivAvatar.getLayoutParams();
        params.height = height;
        holder.ivAvatar.setLayoutParams(params);
      } catch (Exception ex) {
        ex.printStackTrace();
      }*/
    }

    @Override public void fillData(LiveViewHolder viewHodler, HuoLiveItemBean dataBeanX) {
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
    }

    @Override
    public void loadCoverImage(final LiveViewHolder viewHodler, final HuoLiveItemBean dataBeanX) {
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

      Glide.with(context).load(url).error(R.drawable.a0b).into(new SimpleTarget<GlideDrawable>() {
        @Override public void onResourceReady(GlideDrawable resource,
            GlideAnimation<? super GlideDrawable> glideAnimation) {

          viewHodler.ivImage.setImageDrawable(resource);

          setLayoutParams(viewHodler, dataBeanX);
        }
      });
    }

    @Override public void loadAvatarImage(LiveViewHolder viewHodler, HuoLiveItemBean dataBeanX) {

    }
  }

  class LiveViewHolder extends BaseVideoAdapter.BaseViewHolder {
    ImageView ivImage;
    TextView tvLocation;
    TextView tvName;
    TextView tvCount;

    LiveViewHolder(View itemView) {
      super(itemView);
      ivImage = ViewUtil.findViewById(itemView, R.id.iv_image);
      tvLocation = ViewUtil.findViewById(itemView, R.id.tv_location);
      tvName = ViewUtil.findViewById(itemView, R.id.tv_name);
      tvCount = ViewUtil.findViewById(itemView, R.id.tv_count);
    }
  }
}
