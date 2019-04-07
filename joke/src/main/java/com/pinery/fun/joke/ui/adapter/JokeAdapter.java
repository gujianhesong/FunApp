package com.pinery.fun.joke.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.pinery.base.adapter.BaseAdapter;
import com.pinery.base.util.ScreenUtil;
import com.pinery.base.util.ViewUtil;
import com.pinery.fun.joke.R;
import com.pinery.fun.joke.bean.JokeDatasBean;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;
import java.util.List;

public class JokeAdapter extends BaseAdapter<JokeAdapter.ViewHolder>
    implements View.OnClickListener, com.github.jdsjlzx.interfaces.OnItemClickListener,
    com.github.jdsjlzx.interfaces.OnItemLongClickListener {
  private static final int ITEM_TYPE_TEXT = 0;
  private static final int ITEM_TYPE_IMAGE = 1;
  private static final int ITEM_TYPE_VIDEO = 2;

  private Context context;
  private List<JokeDatasBean.DataBean> list;
  private View.OnClickListener mOnClickListener;

  public JokeAdapter(Context context, List<JokeDatasBean.DataBean> list) {
    this.context = context;
    this.list = list;

  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent,
      int viewType) {
    switch (viewType) {
      case ITEM_TYPE_TEXT:
        View view =
            LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_joke_text, parent, false);
        return new TextViewHolder(view);
      case ITEM_TYPE_IMAGE:
        view =
            LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_joke_image, parent, false);
        return new ImageViewHolder(view);
      case ITEM_TYPE_VIDEO:
        view =
            LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_joke_video, parent, false);
        return new VideoViewHolder(view);
      default:
        view =
            LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_joke_text, parent, false);
        return new TextViewHolder(view);
    }
  }

  @Override public int getItemViewType(int position) {
    JokeDatasBean.DataBean itemBean = list.get(position);
    int type = ITEM_TYPE_TEXT;
    switch (itemBean.getType()) {
      case "text":
        type = ITEM_TYPE_TEXT;
        break;
      case "image":
        type = ITEM_TYPE_IMAGE;
        break;
      case "video":
        type = ITEM_TYPE_VIDEO;
        break;
    }
    return type;
  }

  @Override public void onBindViewHolder(ViewHolder holder, int position) {
    holder.itemView.setOnClickListener(this);

    JokeDatasBean.DataBean bean = list.get(position);
    holder.setData(bean);
  }

  @Override
  public int getItemCount() {
    return list != null ? list.size() : 0;
  }

  @Override
  public void onClick(View view) {

  }

  @Override public void onItemClick(View view, int position) {
    //Object tag = view.getTag(view.getId());
    //if (tag instanceof String) {
    //  String hashtag = (String) tag;
    //  ARouter.getInstance()
    //      .build(Constants.PATH_HASH_TAG)
    //      .withString("hashtag", hashtag)
    //      .navigation();
    //}
  }

  @Override public void onItemLongClick(View view, int position) {

  }

  public static abstract class ViewHolder extends RecyclerView.ViewHolder {
    ViewHolder(View itemView) {
      super(itemView);
    }

    public abstract void setData(JokeDatasBean.DataBean bean);
  }

  public static class TextViewHolder extends ViewHolder {
    TextView tvNickname;
    TextView tvTitle;
    TextView tvTime;
    ImageView ivAvatar;
    TextView tvOperationUp;
    TextView tvOperationDown;
    TextView tvOperationShare;
    TextView tvOperationComment;

    TextViewHolder(View itemView) {
      super(itemView);
      tvNickname = ViewUtil.findViewById(itemView, R.id.tv_nickname);
      tvTitle = ViewUtil.findViewById(itemView, R.id.tv_title);
      tvTime = ViewUtil.findViewById(itemView, R.id.tv_time);
      ivAvatar = ViewUtil.findViewById(itemView, R.id.iv_avatar);
      tvOperationUp = ViewUtil.findViewById(itemView, R.id.tv_opration_up);
      tvOperationDown = ViewUtil.findViewById(itemView, R.id.tv_opration_down);
      tvOperationShare = ViewUtil.findViewById(itemView, R.id.tv_opration_share);
      tvOperationComment = ViewUtil.findViewById(itemView, R.id.tv_opration_comment);
    }

    @Override public void setData(JokeDatasBean.DataBean bean) {
      if (bean != null) {
        Context context = itemView.getContext();
        tvNickname.setText(bean.getUser_name());

        String headUrl = bean.getUser_head();
        if(headUrl != null){
          headUrl = headUrl.replace("medium", "thumb");
        }
        Glide.with(context).load(headUrl).into(ivAvatar);

        tvTime.setText(bean.getCreate_time());
        tvTitle.setText(bean.getText());

        tvOperationUp.setText(String.valueOf(bean.getUp()));
        tvOperationDown.setText(String.valueOf(bean.getDown()));
        tvOperationShare.setText(String.valueOf(bean.getForward()));
        tvOperationComment.setText(String.valueOf(bean.getComment()));
      }
    }
  }

  public static class ImageViewHolder extends ViewHolder {
    TextView tvNickname;
    TextView tvTitle;
    TextView tvTime;
    ImageView ivAvatar;
    ImageView ivImage;
    TextView tvOperationUp;
    TextView tvOperationDown;
    TextView tvOperationShare;
    TextView tvOperationComment;

    ImageViewHolder(View itemView) {
      super(itemView);
      tvNickname = ViewUtil.findViewById(itemView, R.id.tv_nickname);
      tvTitle = ViewUtil.findViewById(itemView, R.id.tv_title);
      tvTime = ViewUtil.findViewById(itemView, R.id.tv_time);
      ivAvatar = ViewUtil.findViewById(itemView, R.id.iv_avatar);
      ivImage = ViewUtil.findViewById(itemView, R.id.iv_image);
      tvOperationUp = ViewUtil.findViewById(itemView, R.id.tv_opration_up);
      tvOperationDown = ViewUtil.findViewById(itemView, R.id.tv_opration_down);
      tvOperationShare = ViewUtil.findViewById(itemView, R.id.tv_opration_share);
      tvOperationComment = ViewUtil.findViewById(itemView, R.id.tv_opration_comment);
    }

    @Override public void setData(JokeDatasBean.DataBean bean) {
      if (bean != null) {
        Context context = itemView.getContext();
        tvNickname.setText(bean.getUser_name());
        Glide.with(context).load(bean.getUser_head()).into(ivAvatar);
        tvTime.setText(bean.getCreate_time());
        tvTitle.setText(bean.getText());

        float ratio = 5f;

        if (bean.getHeight() * 1.0 / bean.getWidth() > ratio){
          Glide.with(context).load(bean.getThumb_url()).into(ivImage);
        }else{
          Glide.with(context).load(bean.getObj_url()).into(ivImage);
        }

        tvOperationUp.setText(String.valueOf(bean.getUp()));
        tvOperationDown.setText(String.valueOf(bean.getDown()));
        tvOperationShare.setText(String.valueOf(bean.getForward()));
        tvOperationComment.setText(String.valueOf(bean.getComment()));

        //设置布局
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) ivImage.getLayoutParams();
        if (bean.getHeight() < bean.getWidth() * ratio) {
          ivImage.setScaleType(ImageView.ScaleType.FIT_XY);
          params.width = LinearLayout.LayoutParams.MATCH_PARENT;
          params.height =
              (int) (bean.getHeight() * 1.0 / bean.getWidth() * (ScreenUtil.getWindowSize(context).x
                  - ScreenUtil.dp2px(context, 8) * 2));
        } else {
          ivImage.setScaleType(ImageView.ScaleType.FIT_CENTER);
          params.width = LinearLayout.LayoutParams.MATCH_PARENT;
          params.height =  LinearLayout.LayoutParams.WRAP_CONTENT;
        }
      }
    }
  }

  public static class VideoViewHolder extends ViewHolder {
    TextView tvNickname;
    TextView tvTitle;
    TextView tvTime;
    ImageView ivAvatar;
    ImageView ivImage;
    TextView tvOperationUp;
    TextView tvOperationDown;
    TextView tvOperationShare;
    TextView tvOperationComment;
    JCVideoPlayerStandard jcVideoPlayerStandard;

    VideoViewHolder(View itemView) {
      super(itemView);
      tvNickname = ViewUtil.findViewById(itemView, R.id.tv_nickname);
      tvTitle = ViewUtil.findViewById(itemView, R.id.tv_title);
      tvTime = ViewUtil.findViewById(itemView, R.id.tv_time);
      ivAvatar = ViewUtil.findViewById(itemView, R.id.iv_avatar);
      ivImage = ViewUtil.findViewById(itemView, R.id.iv_image);
      tvOperationUp = ViewUtil.findViewById(itemView, R.id.tv_opration_up);
      tvOperationDown = ViewUtil.findViewById(itemView, R.id.tv_opration_down);
      tvOperationShare = ViewUtil.findViewById(itemView, R.id.tv_opration_share);
      tvOperationComment = ViewUtil.findViewById(itemView, R.id.tv_opration_comment);

      jcVideoPlayerStandard = ViewUtil.findViewById(itemView, R.id.videoplayer);
    }

    @Override public void setData(JokeDatasBean.DataBean bean) {
      if (bean != null) {
        Context context = itemView.getContext();
        tvNickname.setText(bean.getUser_name());
        Glide.with(context).load(bean.getUser_head()).into(ivAvatar);
        tvTime.setText(bean.getCreate_time());
        tvTitle.setText(bean.getText());

        jcVideoPlayerStandard.setUp(bean.getObj_url()
            , JCVideoPlayerStandard.SCREEN_LAYOUT_LIST, "");
        Glide.with(context).load(bean.getThumb_url()).into(jcVideoPlayerStandard.thumbImageView);

        tvOperationUp.setText(String.valueOf(bean.getUp()));
        tvOperationDown.setText(String.valueOf(bean.getDown()));
        tvOperationShare.setText(String.valueOf(bean.getForward()));
        tvOperationComment.setText(String.valueOf(bean.getComment()));

        //设置布局
        LinearLayout.LayoutParams params =
            (LinearLayout.LayoutParams) jcVideoPlayerStandard.getLayoutParams();
        if (bean.getHeight() < bean.getWidth() * 1.7) {
          params.width = LinearLayout.LayoutParams.MATCH_PARENT;
          params.height =
              (int) (bean.getHeight() * 1.0 / bean.getWidth() * (ScreenUtil.getWindowSize(context).x
                  - ScreenUtil.dp2px(context, 8) * 2));
        } else {
          params.height = (int) (ScreenUtil.getWindowSize(itemView.getContext()).y * 0.7);
          params.width = (int) (params.height * 1.0 / bean.getHeight() * bean.getWidth());
        }
      }
    }
  }
}
