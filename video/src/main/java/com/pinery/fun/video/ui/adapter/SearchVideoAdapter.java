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
import com.pinery.fun.video.bean.VideoPlayBean;
import com.pinery.fun.video.bean.item.SearchVideoItemsBean;
import com.pinery.fun.video.common.Constants;
import com.pinery.fun.video.util.NumberUtil;
import java.util.List;

public class SearchVideoAdapter extends BaseAdapter<SearchVideoAdapter.ViewHolder>
    implements View.OnClickListener {
  private Context context;
  private List<SearchVideoItemsBean.ItemsBean> list;
  private RecyclerView recyclerView;

  public SearchVideoAdapter(Context context,
      List<SearchVideoItemsBean.ItemsBean> list) {
    this.context = context;
    this.list = list;
  }

  public void bindRecyclerView(RecyclerView recyclerView) {
    this.recyclerView = recyclerView;
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    final View view =
        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_huo_video, parent, false);
    return new ViewHolder(view);
  }

  @Override public void onBindViewHolder(ViewHolder holder, int position) {
    SearchVideoItemsBean.ItemsBean bean = list.get(position);

    setLayoutParams(holder, bean);
    fillData(holder, bean);
    loadCoverImage(holder, bean);
    loadAvatarImage(holder, bean);
  }

  @Override public int getItemCount() {
    return list != null ? list.size() : 0;
  }

  private void setLayoutParams(ViewHolder holder,
      SearchVideoItemsBean.ItemsBean dataBeanX) {
    try {
      int parentWidth = recyclerView.getMeasuredWidth();
      int videoWidth = dataBeanX.getItem().getVideo().getWidth();
      int videoHeight = dataBeanX.getItem().getVideo().getHeight();

      int height = (int) (videoHeight * 1f / videoWidth * (parentWidth / 2));

      ViewGroup.LayoutParams params = holder.itemView.getLayoutParams();
      params.height = height;
      holder.itemView.setLayoutParams(params);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  private void fillData(ViewHolder viewHodler,
      SearchVideoItemsBean.ItemsBean dataBeanX) {
    try {
      viewHodler.tvTitle.setText(dataBeanX.getItem().getTitle());
    } catch (Exception ex) {
    }

    try {
      viewHodler.tvFocusCount.setText(
          "♡" + NumberUtil.getFormatNumber(dataBeanX.getItem().getStats().getDigg_count()));
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  private void loadCoverImage(ViewHolder viewHodler,
      SearchVideoItemsBean.ItemsBean dataBeanX) {
    String url = "";
    try {
      url = dataBeanX.getItem().getVideo().getCover().getUrl_list().get(0);
    } catch (Exception ex) {
      ex.printStackTrace();
    }

    Glide.with(context).load(url).into(viewHodler.ivImage);
  }

  private void loadAvatarImage(ViewHolder viewHodler,
      SearchVideoItemsBean.ItemsBean dataBeanX) {
    String avatar = "";
    try {
      avatar = dataBeanX.getItem().getAuthor().getAvatar_thumb().getUrl_list().get(0);
    } catch (Exception ex) {
    }

    Glide.with(context).load(avatar).error(R.drawable.a0b).into(viewHodler.ivAvatar);
    viewHodler.ivAvatar.setOnClickListener(this);
    viewHodler.ivAvatar.setTag(viewHodler.ivAvatar.getId(),
        dataBeanX.getItem().getAuthor().getId_str());
  }

  @Override
  public void onClick(View view) {
    String userId = (String) view.getTag(view.getId());
    ARouter.getInstance().build(Constants.PATH_USER_CENTER)
        .withString("user_id", userId)
        .navigation();
  }

  @Override public void onItemClick(View view, int position) {
    SearchVideoItemsBean.ItemsBean videoBean = list.get(position);
    String id = videoBean.getItem().getId_str();
    String url = videoBean.getItem().getVideo().getUrl_list().get(0);

    String coverUrl = "";
    try {
      coverUrl = videoBean.getItem().getVideo().getCover().getUrl_list().get(0);
    } catch (Exception ex) {
      ex.printStackTrace();
    }

    String userName = videoBean.getItem().getAuthor().getNickname();

    String avatar = "";
    try {
      avatar = videoBean.getItem().getAuthor().getAvatar_thumb().getUrl_list().get(0);
    } catch (Exception ex) {
    }

    VideoPlayBean bean = new VideoPlayBean();
    bean.setId(id);
    bean.setUrl(url);
    bean.setCoverUrl(coverUrl);
    bean.setAuthorName(userName);
    bean.setAuthorAvatar(avatar);
    bean.setCommentCount(videoBean.getItem().getStats().getComment_count());
    bean.setLoveCount(videoBean.getItem().getStats().getDigg_count());
    bean.setShareCount(videoBean.getItem().getStats().getShare_count());
    bean.setUserId(videoBean.getItem().getAuthor().getId_str());

    ARouter.getInstance()
        .build(Constants.PATH_VIDEO_PLAY)
        .withSerializable(Constants.KEY_VIDEO_PLAY_BEAN, bean)
        .navigation();
  }

  @Override public void onItemLongClick(View view, int position) {

  }

  public static class ViewHolder extends RecyclerView.ViewHolder {
    ImageView ivImage;
    TextView tvTitle;
    ImageView ivAvatar;
    TextView tvFocusCount;

    ViewHolder(View itemView) {
      super(itemView);
      ivImage = ViewUtil.findViewById(itemView, R.id.iv_image);
      tvTitle = ViewUtil.findViewById(itemView, R.id.tv_title);
      ivAvatar = ViewUtil.findViewById(itemView, R.id.iv_avatar);
      tvFocusCount = ViewUtil.findViewById(itemView, R.id.tv_focus_count);
    }
  }
}
