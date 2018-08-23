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
import com.pinery.fun.video.bean.HuoLiveItemBean;
import java.util.List;

public class HuoLiveAdapter extends RecyclerView.Adapter<HuoLiveAdapter.ViewHolder> {
  List<HuoLiveItemBean> list;
  Context context;
  RecyclerView recyclerView;

  public HuoLiveAdapter(Context context, List<HuoLiveItemBean> list) {
    this.context = context;
    this.list = list;
  }

  public void bindRecyclerView(RecyclerView recyclerView) {
    this.recyclerView = recyclerView;
  }

  @Override public HuoLiveAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    final View view =
        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_huo_live, parent, false);
    return new HuoLiveAdapter.ViewHolder(view);
  }

  @Override public void onBindViewHolder(HuoLiveAdapter.ViewHolder viewHodler, int position) {
    HuoLiveItemBean dataBeanX = list.get(position);
    if (dataBeanX != null) {
      //setLayoutParams(viewHodler, dataBeanX);

      fillData(viewHodler, dataBeanX);

      loadAvatarImage(viewHodler, dataBeanX);
    }
  }

  private void fillData(HuoLiveAdapter.ViewHolder viewHodler, HuoLiveItemBean dataBeanX) {
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

  private void loadAvatarImage(final HuoLiveAdapter.ViewHolder viewHodler,
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

  private void setLayoutParams(HuoLiveAdapter.ViewHolder holder, HuoLiveItemBean dataBeanX) {
    try {
      int parentWidth = recyclerView.getMeasuredWidth();
      int videoWidth = holder.ivImage.getDrawable().getIntrinsicWidth();
      int videoHeight = holder.ivImage.getDrawable().getIntrinsicHeight();

      int height = (int) (videoHeight * 1f / videoWidth * (parentWidth / 2));

      ViewGroup.LayoutParams params = holder.ivImage.getLayoutParams();
      params.height = height;
      holder.ivImage.setLayoutParams(params);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  @Override public int getItemCount() {
    return list != null ? list.size() : 0;
  }

  class ViewHolder extends RecyclerView.ViewHolder {
    ImageView ivImage;
    TextView tvLocation;
    TextView tvName;
    TextView tvCount;

    ViewHolder(View itemView) {
      super(itemView);
      ivImage = ViewUtil.findViewById(itemView, R.id.iv_image);
      tvLocation = ViewUtil.findViewById(itemView, R.id.tv_location);
      tvName = ViewUtil.findViewById(itemView, R.id.tv_name);
      tvCount = ViewUtil.findViewById(itemView, R.id.tv_count);
    }
  }
}
