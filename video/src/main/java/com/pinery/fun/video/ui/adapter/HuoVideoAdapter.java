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
import com.pinery.base.util.ViewUtil;
import com.pinery.fun.video.R;
import com.pinery.fun.video.bean.HuoVideoItemBean;
import java.util.List;

public class HuoVideoAdapter extends RecyclerView.Adapter<HuoVideoAdapter.ViewHolder> {
  List<HuoVideoItemBean> list;
  Context context;
  RecyclerView recyclerView;

  public HuoVideoAdapter(Context context, List<HuoVideoItemBean> list) {
    this.context = context;
    this.list = list;
  }

  public void bindRecyclerView(RecyclerView recyclerView) {
    this.recyclerView = recyclerView;
  }

  @Override public HuoVideoAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    final View view =
        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_huo_video, parent, false);
    return new HuoVideoAdapter.ViewHolder(view);
  }

  @Override public void onBindViewHolder(HuoVideoAdapter.ViewHolder viewHodler, int position) {
    HuoVideoItemBean dataBeanX = list.get(position);
    if (dataBeanX != null) {
      setLayoutParams(viewHodler, dataBeanX);
      fillData(viewHodler, dataBeanX);
      loadCoverImage(viewHodler, dataBeanX);
      loadAvatarImage(viewHodler, dataBeanX);
    }
  }

  private void fillData(HuoVideoAdapter.ViewHolder viewHodler, HuoVideoItemBean dataBeanX) {
    try {
      viewHodler.tvTitle.setText(dataBeanX.getData().getTitle());
    } catch (Exception ex) {
    }
  }

  private void loadCoverImage(final HuoVideoAdapter.ViewHolder viewHodler,
      final HuoVideoItemBean dataBeanX) {
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

  private void loadAvatarImage(HuoVideoAdapter.ViewHolder viewHodler, HuoVideoItemBean dataBeanX) {
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

  private void setLayoutParams(HuoVideoAdapter.ViewHolder holder, HuoVideoItemBean dataBeanX) {
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

  @Override public int getItemCount() {
    return list != null ? list.size() : 0;
  }

  class ViewHolder extends RecyclerView.ViewHolder {
    ImageView ivImage;
    TextView tvTitle;
    ImageView ivAvatar;

    ViewHolder(View itemView) {
      super(itemView);
      ivImage = ViewUtil.findViewById(itemView, R.id.iv_image);
      tvTitle = ViewUtil.findViewById(itemView, R.id.tv_title);
      ivAvatar = ViewUtil.findViewById(itemView, R.id.iv_avatar);
    }
  }
}
