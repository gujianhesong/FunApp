package com.pinery.fun.video.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.pinery.base.util.LogUtil;
import com.pinery.base.util.ViewUtil;
import com.pinery.fun.video.R;
import com.pinery.fun.video.bean.HuoVideoBean;
import java.util.List;

public class HuoVideoAdapter extends RecyclerView.Adapter<HuoVideoAdapter.ViewHolder> {
  List<HuoVideoBean.DataBeanX> list;
  Context context;

  public HuoVideoAdapter(Context context, List<HuoVideoBean.DataBeanX> list) {
    this.context = context;
    this.list = list;
  }

  @Override public HuoVideoAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    final View view =
        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_huo_video, parent, false);
    return new HuoVideoAdapter.ViewHolder(view);
  }

  @Override public void onBindViewHolder(HuoVideoAdapter.ViewHolder viewHodler, int position) {
    loadCoverImage(viewHodler.ivImage, position);
  }

  private void loadCoverImage(ImageView imageView, int position) {
    String url = "";

    try {
      HuoVideoBean.DataBeanX.DataBean.VideoBean.CoverBean coverBean = list.get(position).getData().getVideo().getCover();
      if (TextUtils.isEmpty(url)) {
        url = coverBean != null ? coverBean.getUrl_list().get(0) : url;
      }
    }catch (Exception ex){
      ex.printStackTrace();
    }

    Glide.with(context).load(url).into(imageView);
  }

  private void loadAvatarImage(ImageView imageView, int position) {
    String url = "";

    HuoVideoBean.DataBeanX.DataBean.AuthorBean.AvatarJpgBean avatarJpgBean =
        list.get(position).getData().getAuthor().getAvatar_jpg();
    HuoVideoBean.DataBeanX.DataBean.AuthorBean.AvatarLargeBean avatarLargeBean =
        list.get(position).getData().getAuthor().getAvatar_large();
    HuoVideoBean.DataBeanX.DataBean.AuthorBean.AvatarThumbBean avatarThumbBean =
        list.get(position).getData().getAuthor().getAvatar_thumb();
    if (TextUtils.isEmpty(url)) {
      url = avatarJpgBean != null ? avatarJpgBean.getUrl_list().get(0) : url;
    }
    if (TextUtils.isEmpty(url)) {
      url = avatarLargeBean != null ? avatarLargeBean.getUrl_list().get(0) : url;
    }
    if (TextUtils.isEmpty(url)) {
      url = avatarThumbBean != null ? avatarThumbBean.getUrl_list().get(0) : url;
    }

    Glide.with(context).load(url).into(imageView);
  }

  @Override public int getItemCount() {
    return list != null ? list.size() : 0;
  }

  class ViewHolder extends RecyclerView.ViewHolder {
    ImageView ivImage;

    ViewHolder(View itemView) {
      super(itemView);
      ivImage = ViewUtil.findViewById(itemView, R.id.iv_image);
    }
  }
}
