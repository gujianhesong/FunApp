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
import com.pinery.fun.video.bean.SearchBean;
import com.pinery.fun.video.bean.item.SearchUserItemsBean;
import com.pinery.fun.video.bean.item.SearchUserItemsBean.UsersBean.UserBean;
import com.pinery.fun.video.common.Constants;
import java.util.List;

public class SearchUserAdapter extends BaseAdapter<SearchUserAdapter.ViewHolder> {
  private Context context;
  private List<SearchUserItemsBean.UsersBean> list;

  public SearchUserAdapter(Context context,
      List<SearchUserItemsBean.UsersBean> list) {
    this.context = context;
    this.list = list;
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    final View view =
        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_search_user, parent, false);
    return new ViewHolder(view);
  }

  @Override public void onBindViewHolder(ViewHolder holder, int position) {
    SearchUserItemsBean.UsersBean bean = list.get(position);

    String avatar = "";
    try {
      avatar = bean.getUser().getAvatar_thumb().getUrl_list().get(0);
    } catch (Exception ex) {
    }

    Glide.with(context).load(avatar).error(R.drawable.a0b).into(holder.ivAvatar);
    holder.tvTitle.setText(bean.getUser().getNickname());
    holder.tvFansCount.setText("粉丝数："+bean.getUser().getTotal_fans_count());
    holder.tvDesc.setText(bean.getUser().getSignature());
  }

  @Override public int getItemCount() {
    return list != null ? list.size() : 0;
  }

  @Override public void onItemClick(View view, int position) {
    SearchUserItemsBean.UsersBean usersBean = list.get(position);
    String userId = usersBean.getUser().getId_str();
    ARouter.getInstance().build(Constants.PATH_USER_CENTER)
        .withString("user_id", userId)
        .navigation();
  }

  @Override public void onItemLongClick(View view, int position) {

  }

  public static class ViewHolder extends RecyclerView.ViewHolder {
    ImageView ivAvatar;
    TextView tvTitle;
    TextView tvFansCount;
    TextView tvDesc;

    ViewHolder(View itemView) {
      super(itemView);
      ivAvatar = ViewUtil.findViewById(itemView, R.id.iv_avatar);
      tvTitle = ViewUtil.findViewById(itemView, R.id.tv_title);
      tvFansCount = ViewUtil.findViewById(itemView, R.id.tv_fans_count);
      tvDesc = ViewUtil.findViewById(itemView, R.id.tv_desc);
    }
  }
}
