package com.pinery.fun.video.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.pinery.base.adapter.BaseAdapter;
import com.pinery.base.util.ViewUtil;
import com.pinery.fun.video.R;
import com.pinery.fun.video.bean.item.SearchSongItemsBean;
import java.util.List;

public class SearchSongAdapter extends BaseAdapter<SearchSongAdapter.ViewHolder> {
  private Context context;
  private List<SearchSongItemsBean.SongsBean> list;

  public SearchSongAdapter(Context context,
      List<SearchSongItemsBean.SongsBean> list) {
    this.context = context;
    this.list = list;
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    final View view =
        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_search_song, parent, false);
    return new ViewHolder(view);
  }

  @Override public void onBindViewHolder(ViewHolder holder, int position) {
    SearchSongItemsBean.SongsBean bean = list.get(position);

    String avatar = "";
    try {
      avatar = bean.getSong().getCover_thumb().getUrl_list().get(0);
    } catch (Exception ex) {
    }

    Glide.with(context).load(avatar).error(R.drawable.a0b).into(holder.ivAvatar);
    holder.tvTitle.setText(bean.getSong().getTitle());
    holder.tvAuthor.setText(bean.getSong().getAuthor());
    holder.tvCount.setText("" + bean.getSong().getVideo_cnt());
  }

  @Override public int getItemCount() {
    return list != null ? list.size() : 0;
  }

  @Override public void onItemClick(View view, int position) {
    //SearchSongItemsBean.SongsBean bean = list.get(position);
    //String userId = bean.getUser().getId_str();
    //ARouter.getInstance().build(Constants.PATH_USER_CENTER)
    //    .withString("user_id", userId)
    //    .navigation();
  }

  @Override public void onItemLongClick(View view, int position) {

  }

  public static class ViewHolder extends RecyclerView.ViewHolder {
    ImageView ivAvatar;
    TextView tvTitle;
    TextView tvAuthor;
    TextView tvCount;

    ViewHolder(View itemView) {
      super(itemView);
      ivAvatar = ViewUtil.findViewById(itemView, R.id.iv_avatar);
      tvTitle = ViewUtil.findViewById(itemView, R.id.tv_title);
      tvAuthor = ViewUtil.findViewById(itemView, R.id.tv_author);
      tvCount = ViewUtil.findViewById(itemView, R.id.tv_count);
    }
  }
}
