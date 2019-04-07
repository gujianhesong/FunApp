package com.pinery.fun.video.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.android.arouter.launcher.ARouter;
import com.bumptech.glide.Glide;
import com.pinery.base.adapter.BaseAdapter;
import com.pinery.base.util.ViewUtil;
import com.pinery.fun.video.R;
import com.pinery.fun.video.bean.HashTagItemsBean;
import com.pinery.fun.video.common.Constants;
import java.util.List;

public class HashTagVideoListAdapter extends
    BaseAdapter<HashTagVideoListAdapter.ViewHolder>
    implements View.OnClickListener, com.github.jdsjlzx.interfaces.OnItemClickListener,
    com.github.jdsjlzx.interfaces.OnItemLongClickListener {
  private Context context;
  private List<HashTagItemsBean.DataBeanX> list;
  private View.OnClickListener mOnClickListener;

  public HashTagVideoListAdapter(Context context, List<HashTagItemsBean.DataBeanX> list) {
    this.context = context;
    this.list = list;
  }

  @Override
  public HashTagVideoListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
      int viewType) {
    final View view =
        LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_hashtag_video, parent, false);
    return new HashTagVideoListAdapter.ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(HashTagVideoListAdapter.ViewHolder holder, int position) {
    holder.itemView.setOnClickListener(this);

    HashTagItemsBean.DataBeanX bean = list.get(position);
    if (bean != null) {
      holder.tvTitle.setText(bean.getData().getTitle());
      holder.tvUserNickname.setText(bean.getData().getAuthor().getNickname());
      Glide.with(context)
          .load(bean.getData().getVideo().getCover().getUrl_list().get(0))
          .into(holder.ivImage);
      Glide.with(context)
          .load(bean.getData().getAuthor().getAvatar_jpg().getUrl_list().get(0))
          .into(holder.ivAvatar);
    }
  }

  @Override
  public int getItemCount() {
    return list != null ? list.size() : 0;
  }

  @Override
  public void onClick(View view) {
    Object tag = view.getTag(view.getId());
    if (tag instanceof String) {
      String userId = (String) tag;
      ARouter.getInstance()
          .build(Constants.PATH_USER_CENTER)
          .withString("user_id", userId)
          .navigation();
    }
  }

  @Override public void onItemClick(View view, int position) {

  }

  @Override public void onItemLongClick(View view, int position) {

  }

  public static class ViewHolder extends RecyclerView.ViewHolder {
    ImageView ivImage;
    ImageView ivAvatar;
    TextView tvTitle;
    TextView tvUserNickname;

    ViewHolder(View itemView) {
      super(itemView);
      ivImage = ViewUtil.findViewById(itemView, R.id.iv_image);
      ivAvatar = ViewUtil.findViewById(itemView, R.id.iv_avatar);
      tvTitle = ViewUtil.findViewById(itemView, R.id.tv_title);
      tvUserNickname = ViewUtil.findViewById(itemView, R.id.tv_user_nickname);
    }
  }
}
