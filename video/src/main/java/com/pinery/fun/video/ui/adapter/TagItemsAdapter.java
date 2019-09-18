package com.pinery.fun.video.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.bumptech.glide.Glide;
import com.pinery.base.adapter.BaseAdapter;
import com.pinery.base.util.GlideUtil;
import com.pinery.base.util.ScreenUtil;
import com.pinery.base.util.ViewUtil;
import com.pinery.base.widget.RecycleViewDivider;
import com.pinery.fun.video.R;
import com.pinery.fun.video.bean.TagItemsBean;
import com.pinery.fun.video.bean.VideoPlayBean;
import com.pinery.fun.video.bean.item.TagItemBean;
import com.pinery.fun.video.common.Constants;

import java.util.List;

public class TagItemsAdapter extends
    BaseAdapter<TagItemsAdapter.SearchTagViewHolder>
    implements View.OnClickListener, com.github.jdsjlzx.interfaces.OnItemClickListener,
    com.github.jdsjlzx.interfaces.OnItemLongClickListener {
  private Context context;
  private List<TagItemsBean.DataBean> list;
  private View.OnClickListener mOnClickListener;

  public TagItemsAdapter(Context context, List<TagItemsBean.DataBean> list) {
    this.context = context;
    this.list = list;
  }

  @Override
  public TagItemsAdapter.SearchTagViewHolder onCreateViewHolder(ViewGroup parent,
      int viewType) {
    final View view =
        LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_tag_items, parent, false);
    return new TagItemsAdapter.SearchTagViewHolder(view);
  }

  @Override
  public void onBindViewHolder(SearchTagViewHolder holder, int position) {
    holder.itemView.setOnClickListener(this);

    TagItemsBean.DataBean item = list.get(position);
    if (item.getType() == 1) {
      //热门话题
      TagItemsBean.DataBean.ContentBean bean = list.get(position).getContent();
      holder.tvTitle.setText(bean.getHashtag().getTitle());
      holder.itemView.setTag(holder.itemView.getId(),
          String.valueOf(bean.getHashtag().getId()));
      holder.tvEntranceDesc.setText(String.format("%d视频", bean.getHashtag().getVideo_cnt()));
      holder.tvDesc.setText(bean.getDescription());

      holder.ivAvatar.setImageResource(R.drawable.a90);

      //设置横向子列表
      Context context = holder.rvChild.getContext();
      holder.rvChild.setLayoutManager(new LinearLayoutManager(context,
          LinearLayoutManager.HORIZONTAL, false));
      holder.rvChild.addItemDecoration(
          new RecycleViewDivider(context, LinearLayoutManager.VERTICAL,
              ScreenUtil.dp2px(context, 8), Color.TRANSPARENT));
      ChildRecyclerAdapter adapterChild =
          new ChildRecyclerAdapter(context, bean.getItems());
      holder.rvChild.setAdapter(adapterChild);
    } else if (item.getType() == 2) {
      //用户推荐

      TagItemsBean.DataBean.ContentBean bean = list.get(position).getContent();
      holder.tvTitle.setText(bean.getUser().getNickname());
      holder.itemView.setTag(holder.itemView.getId(), String.valueOf(bean.getUser().getId()));
      holder.tvEntranceDesc.setText("");
      holder.tvDesc.setText(bean.getDescription());

      GlideUtil.loadImage(holder.ivAvatar, bean.getUser().getAvatar_thumb().getUrl_list().get(0), R.drawable.a0b);

      //设置横向子列表
      Context context = holder.rvChild.getContext();
      holder.rvChild.setLayoutManager(new LinearLayoutManager(context,
          LinearLayoutManager.HORIZONTAL, false));
      holder.rvChild.addItemDecoration(
          new RecycleViewDivider(context, LinearLayoutManager.VERTICAL,
              ScreenUtil.dp2px(context, 8), Color.TRANSPARENT));
      ChildRecyclerAdapter adapterChild =
          new ChildRecyclerAdapter(context, bean.getItems());
      holder.rvChild.setAdapter(adapterChild);
    }
  }

  @Override
  public int getItemCount() {
    return list != null ? list.size() : 0;
  }

  @Override
  public void onClick(View view) {

  }

  @Override public void onItemClick(View view, int position) {
    TagItemsBean.DataBean item = list.get(position);
    if (item.getType() == 1) {
      Object tag = view.getTag(view.getId());
      if (tag instanceof String) {
        String hashtag = (String) tag;
        ARouter.getInstance()
            .build(Constants.PATH_HASH_TAG)
            .withString("hashtag", hashtag)
            .navigation();
      }
    }else if (item.getType() == 2) {
      String userId = item.getContent().getUser().getId_str();
      ARouter.getInstance().build(Constants.PATH_USER_CENTER)
          .withString("user_id", userId)
          .navigation();
    }

  }

  @Override public void onItemLongClick(View view, int position) {

  }

  public static class SearchTagViewHolder extends RecyclerView.ViewHolder {
    ImageView ivAvatar;
    TextView tvTitle;
    TextView tvDesc;
    TextView tvEntranceDesc;
    RecyclerView rvChild;

    SearchTagViewHolder(View itemView) {
      super(itemView);
      ivAvatar = ViewUtil.findViewById(itemView, R.id.iv_avatar);
      tvTitle = ViewUtil.findViewById(itemView, R.id.tv_title);
      tvDesc = ViewUtil.findViewById(itemView, R.id.tv_desc);
      tvEntranceDesc = ViewUtil.findViewById(itemView, R.id.tv_entrance_desc);
      rvChild = ViewUtil.findViewById(itemView, R.id.rv_child);
    }
  }

  public static class ChildRecyclerAdapter extends RecyclerView.Adapter<ChildViewHolder> implements
      View.OnClickListener{

    private Context context;
    private List<TagItemBean> datas;

    public ChildRecyclerAdapter(Context context,
        List<TagItemBean> datas) {
      this.context = context;
      this.datas = datas;
    }

    @Override
    public ChildViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      return new ChildViewHolder(LayoutInflater.from(context)
          .inflate(R.layout.item_tag_child_view, parent, false));
    }

    @Override
    public void onBindViewHolder(ChildViewHolder holder, int position) {
      TagItemBean bean = datas.get(position);
      Glide.with(context).load(bean.getVideo().getCover_medium().getUrl_list().get(0)).into(holder.ivImage);

      holder.ivImage.setOnClickListener(this);
      holder.ivImage.setTag(holder.ivImage.getId(), bean);
    }

    @Override
    public int getItemCount() {
      return datas.size();
    }

    @Override public void onClick(View view) {
      Object obj = view.getTag(view.getId());
      if (obj instanceof TagItemBean){
        TagItemBean itemsBean =
            (TagItemBean) obj;

        TagItemBean.VideoBean videoBean = itemsBean.getVideo();

        VideoPlayBean bean = new VideoPlayBean();
        bean.setId(videoBean.getVideo_id());
        bean.setUrl(videoBean.getUrl_list().get(0));
        bean.setCoverUrl(videoBean.getCover().getUrl_list().get(0));
        bean.setAuthorName(itemsBean.getAuthor().getNickname());
        bean.setAuthorAvatar(itemsBean.getAuthor().getAvatar_medium().getUrl_list().get(0));
        //bean.setCommentCount(itemsBean.get);
        //bean.setLoveCount(videoBean.getData().getStats().getDigg_count());
        //bean.setShareCount(videoBean.getData().getStats().getShare_count());
        bean.setUserId(itemsBean.getAuthor().getId_str());

        ARouter.getInstance()
            .build(Constants.PATH_VIDEO_PLAY)
            .withSerializable(Constants.KEY_VIDEO_PLAY_BEAN, bean)
            .navigation();
      }
    }
  }

  public static class ChildViewHolder extends RecyclerView.ViewHolder {
    ImageView ivImage;

    ChildViewHolder(View itemView) {
      super(itemView);
      ivImage = ViewUtil.findViewById(itemView, R.id.iv_image);
    }
  }
}
