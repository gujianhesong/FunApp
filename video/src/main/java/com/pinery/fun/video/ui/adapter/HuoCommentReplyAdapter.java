package com.pinery.fun.video.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.pinery.base.util.ViewUtil;
import com.pinery.fun.video.R;
import com.pinery.fun.video.bean.CommentReplyItemBean;
import com.pinery.fun.video.bean.CommentReplyListBean;
import com.pinery.fun.video.util.NumberUtil;
import com.pinery.fun.video.util.TimeUtil;
import java.util.List;

public class HuoCommentReplyAdapter extends BaseAdapter<RecyclerView.ViewHolder> {
  private static final int ITEM_POSITION_COMMENT = 0;
  private static final int ITEM_POSITION_COMMENT_REPLY_COUNT = 1;

  private static final int ITEM_TYPE_COMMENT = 0;
  private static final int ITEM_TYPE_COMMENT_REPLY_COUNT = 1;
  private static final int ITEM_TYPE_COMMENT_REPLY = 2;

  private Context context;
  private List<CommentReplyListBean> list;

  CommentHandler commentHandler;
  CommentReplyCountHandler commentReplyCountHandler;
  CommentReplyHandler commentReplyHandler;

  public HuoCommentReplyAdapter(Context context, List<CommentReplyListBean> list) {
    this.context = context;
    this.list = list;

    commentHandler = new CommentHandler();
    commentReplyCountHandler = new CommentReplyCountHandler();
    commentReplyHandler = new CommentReplyHandler();
  }

  @Override public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    switch (viewType) {
      case ITEM_TYPE_COMMENT:

        View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_huo_comment, parent, false);
        return new CommentViewHolder(view);

      case ITEM_TYPE_COMMENT_REPLY_COUNT:

        view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_huo_comment_reply_count, parent, false);
        return new CommentReplyCountViewHolder(view);

      case ITEM_TYPE_COMMENT_REPLY:
      default:

        view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_huo_comment_reply, parent, false);
        return new CommentReplyViewHolder(view);
    }
  }

  @Override public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    if (position == ITEM_POSITION_COMMENT) {
      if (holder instanceof CommentViewHolder) {
        CommentReplyListBean bean = list.get(0);

        commentHandler.fillData((CommentViewHolder) holder, bean.getData().getOrigin_comment());
        commentHandler.loadAvatarImage((CommentViewHolder) holder,
            bean.getData().getOrigin_comment());
      }
    } else if (position == ITEM_POSITION_COMMENT_REPLY_COUNT) {
      if (holder instanceof CommentReplyCountViewHolder) {
        CommentReplyListBean bean = list.get(0);
        commentReplyCountHandler.fillData((CommentReplyCountViewHolder) holder, bean.getExtra());
      }
    } else {
      if (holder instanceof CommentReplyViewHolder) {
        CommentReplyListBean bean = list.get((position - 2) / 20);

        commentReplyHandler.fillData((CommentReplyViewHolder) holder,
            bean.getData().getComments().get((position - 2) % 20));
        commentReplyHandler.loadAvatarImage((CommentReplyViewHolder) holder,
            bean.getData().getComments().get((position - 2) % 20));
      }
    }
  }

  @Override public int getItemViewType(int position) {
    if (position == ITEM_POSITION_COMMENT) {
      return ITEM_TYPE_COMMENT;
    } else if (position == ITEM_POSITION_COMMENT_REPLY_COUNT) {
      return ITEM_TYPE_COMMENT_REPLY_COUNT;
    } else {
      return ITEM_TYPE_COMMENT_REPLY;
    }
  }

  @Override public int getItemCount() {
    int count = 0;
    if (list != null) {
      for (CommentReplyListBean bean : list) {
        count += bean.getData().getComments().size();
      }
    }
    return count == 0 ? 0 : count + 2;
  }

  @Override public void onItemClick(View view, int position) {

  }

  @Override public void onItemLongClick(View view, int position) {

  }

  private class CommentHandler {
    private void fillData(CommentViewHolder viewHodler,
        CommentReplyListBean.DataBean.OriginCommentBean bean) {
      try {
        viewHodler.tvNickname.setText(bean.getUser().getNickname());
      } catch (Exception ex) {
      }

      try {
        viewHodler.tvComment.setText(bean.getText());
      } catch (Exception ex) {
      }

      viewHodler.tvFeedbackCount.setVisibility(View.GONE);

      try {
        viewHodler.tvCreateTime.setText(TimeUtil.getCommentTime(bean.getCreate_time()));
      } catch (Exception ex) {
      }

      try {
        if (bean.getAuthor_digg() == 1) {
          viewHodler.tvAuthorDigg.setVisibility(View.VISIBLE);
        } else {
          viewHodler.tvAuthorDigg.setVisibility(View.GONE);
        }
      } catch (Exception ex) {
      }

      try {
        viewHodler.tvDiggCount.setText(NumberUtil.getFormatNumber(bean.getDigg_count()));
      } catch (Exception ex) {
        ex.printStackTrace();
      }

      viewHodler.divideLine.setVisibility(View.GONE);
      viewHodler.itemView.setBackgroundColor(Color.WHITE);
    }

    private void loadAvatarImage(CommentViewHolder viewHodler,
        CommentReplyListBean.DataBean.OriginCommentBean bean) {
      String avatar = "";
      try {
        CommentReplyListBean.DataBean.OriginCommentBean.UserBean authorBean = bean.getUser();
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

      Glide.with(context).load(avatar).error(R.drawable.a0b).into(viewHodler.ivAvatar);
    }
  }

  private class CommentReplyCountHandler {
    private void fillData(CommentReplyCountViewHolder viewHodler,
        CommentReplyListBean.ExtraBean bean) {
      try {
        viewHodler.tvCommentReplyCount.setText(String.format("全部回复（%d）", bean.getTotal()));
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }
  }

  private class CommentReplyHandler {
    private void fillData(CommentReplyViewHolder viewHolder, CommentReplyItemBean bean) {
      try {
        viewHolder.tvNickname.setText(bean.getUser().getNickname());
      } catch (Exception ex) {
      }

      try {
        viewHolder.tvComment.setText(bean.getText());
      } catch (Exception ex) {
      }

      try {
        viewHolder.tvCreateTime.setText(TimeUtil.getCommentTime(bean.getCreate_time()));
      } catch (Exception ex) {
      }

      try {
        if(bean.getReply_comments() != null && bean.getReply_comments().size() > 0){
          viewHolder.llAuthorReply.setVisibility(View.VISIBLE);
          viewHolder.tvReplyUserName.setText(bean.getReply_comments().get(0).getUser().getNickname() + ":");
          viewHolder.tvReplyContent.setText(bean.getReply_comments().get(0).getText());
        }else{
          viewHolder.llAuthorReply.setVisibility(View.GONE);
        }
      } catch (Exception ex) {
      }

      try {
        viewHolder.tvDiggCount.setText(NumberUtil.getFormatNumber(bean.getDigg_count()));
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }

    private void loadAvatarImage(CommentReplyViewHolder viewHolder, CommentReplyItemBean bean) {
      String avatar = "";
      try {
        CommentReplyItemBean.UserBeanX authorBean = bean.getUser();
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

      Glide.with(context).load(avatar).error(R.drawable.a0b).into(viewHolder.ivAvatar);
    }
  }

  public static class CommentViewHolder extends RecyclerView.ViewHolder {
    ImageView ivAvatar;
    TextView tvNickname;
    TextView tvComment;
    TextView tvFeedbackCount;
    TextView tvCreateTime;
    TextView tvAuthorDigg;
    TextView tvDiggCount;
    View divideLine;

    CommentViewHolder(View itemView) {
      super(itemView);
      ivAvatar = ViewUtil.findViewById(itemView, R.id.iv_avatar);
      tvNickname = ViewUtil.findViewById(itemView, R.id.tv_user_nickname);
      tvComment = ViewUtil.findViewById(itemView, R.id.tv_user_comment);
      tvFeedbackCount = ViewUtil.findViewById(itemView, R.id.tv_feedback_count);
      tvCreateTime = ViewUtil.findViewById(itemView, R.id.tv_create_time);
      tvAuthorDigg = ViewUtil.findViewById(itemView, R.id.tv_author_digg);
      tvDiggCount = ViewUtil.findViewById(itemView, R.id.tv_digg_count);
      divideLine = ViewUtil.findViewById(itemView, R.id.divide_line);
    }
  }

  public static class CommentReplyCountViewHolder extends RecyclerView.ViewHolder {
    TextView tvCommentReplyCount;

    CommentReplyCountViewHolder(View itemView) {
      super(itemView);
      tvCommentReplyCount = ViewUtil.findViewById(itemView, R.id.tv_comment_reply_count);
    }
  }

  public static class CommentReplyViewHolder extends RecyclerView.ViewHolder {
    ImageView ivAvatar;
    TextView tvNickname;
    TextView tvComment;
    TextView tvCreateTime;
    LinearLayout llAuthorReply;
    TextView tvReplyUserName;
    TextView tvReplyContent;
    TextView tvDiggCount;

    CommentReplyViewHolder(View itemView) {
      super(itemView);
      ivAvatar = ViewUtil.findViewById(itemView, R.id.iv_avatar);
      tvNickname = ViewUtil.findViewById(itemView, R.id.tv_user_nickname);
      tvComment = ViewUtil.findViewById(itemView, R.id.tv_user_comment);
      tvCreateTime = ViewUtil.findViewById(itemView, R.id.tv_create_time);
      llAuthorReply = ViewUtil.findViewById(itemView, R.id.ll_author_reply);
      tvReplyUserName = ViewUtil.findViewById(itemView, R.id.tv_reply_username);
      tvReplyContent = ViewUtil.findViewById(itemView, R.id.tv_reply_content);
      tvDiggCount = ViewUtil.findViewById(itemView, R.id.tv_digg_count);
    }
  }
}
