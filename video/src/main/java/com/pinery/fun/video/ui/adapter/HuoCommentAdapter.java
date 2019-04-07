package com.pinery.fun.video.ui.adapter;

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
import com.pinery.base.util.ViewUtil;
import com.pinery.fun.video.R;
import com.pinery.fun.video.bean.CommentsItemBean;
import com.pinery.fun.video.util.NumberUtil;
import com.pinery.fun.video.util.TimeUtil;
import java.util.List;

public class HuoCommentAdapter extends BaseAdapter<HuoCommentAdapter.CommentViewHolder>
    implements com.github.jdsjlzx.interfaces.OnItemClickListener,
    com.github.jdsjlzx.interfaces.OnItemLongClickListener {
  private Context context;
  private List<CommentsItemBean> list;
  private View.OnClickListener mOnClickListener;

  public HuoCommentAdapter(Context context, List<CommentsItemBean> list) {
    this.context = context;
    this.list = list;
  }

  @Override public CommentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    final View view =
        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_huo_comment, parent, false);
    return new CommentViewHolder(view);
  }

  @Override public void onBindViewHolder(CommentViewHolder holder, int position) {
    CommentsItemBean bean = list.get(position);
    if (bean != null) {
      fillData(holder, bean);
      loadAvatarImage(holder, bean);
    }
  }

  private void fillData(CommentViewHolder viewHolder, CommentsItemBean bean) {
    try {
      viewHolder.tvNickname.setText(bean.getUser().getNickname());
    } catch (Exception ex) {
    }

    try {
      viewHolder.tvComment.setText(bean.getText());
    } catch (Exception ex) {
    }

    try {
      if (bean.getReply_comments() != null && bean.getReply_comments().size() > 0) {
        viewHolder.llAuthorReply.setVisibility(View.VISIBLE);
        viewHolder.tvReplyUserName.setText(bean.getReply_comments().get(0).getUser().getNickname());
        viewHolder.tvReplyContent.setText(bean.getReply_comments().get(0).getText());
      } else {
        viewHolder.llAuthorReply.setVisibility(View.GONE);
      }
    } catch (Exception ex) {
    }

    try {
      if (bean.getReply_count() > 0) {
        viewHolder.tvFeedbackCount.setText(String.format("查看全部%d条回复>", bean.getReply_count()));
        viewHolder.tvFeedbackCount.setVisibility(View.VISIBLE);
      } else {
        viewHolder.tvFeedbackCount.setVisibility(View.GONE);
      }

      viewHolder.tvFeedbackCount.setOnClickListener(mOnClickListener);
      viewHolder.tvFeedbackCount.setTag(bean);

    } catch (Exception ex) {
    }

    try {
      viewHolder.tvCreateTime.setText(TimeUtil.getCommentTime(bean.getCreate_time()));
    } catch (Exception ex) {
    }

    try {
      if (bean.getAuthor_digg() == 1) {
        viewHolder.tvAuthorDigg.setVisibility(View.VISIBLE);
      } else {
        viewHolder.tvAuthorDigg.setVisibility(View.GONE);
      }
    } catch (Exception ex) {
    }

    try {
      viewHolder.tvDiggCount.setText(NumberUtil.getFormatNumber(bean.getDigg_count()));
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  private void loadAvatarImage(CommentViewHolder viewHodler, CommentsItemBean bean) {
    String avatar = "";
    try {
      avatar = bean.getUser().getAvatar_thumb().getUrl_list().get(0);
    } catch (Exception ex) {
    }

    Glide.with(context).load(avatar).error(R.drawable.a0b).into(viewHodler.ivAvatar);
  }

  @Override public int getItemCount() {
    return list != null ? list.size() : 0;
  }

  @Override public void onItemClick(View view, int position) {

  }

  @Override public void onItemLongClick(View view, int position) {

  }

  public void setOnClickListener(View.OnClickListener listener){
    mOnClickListener = listener;
  }

  public static class CommentViewHolder extends RecyclerView.ViewHolder {
    ImageView ivAvatar;
    TextView tvNickname;
    TextView tvComment;
    LinearLayout llAuthorReply;
    TextView tvReplyUserName;
    TextView tvReplyContent;
    TextView tvFeedbackCount;
    TextView tvCreateTime;
    TextView tvAuthorDigg;
    TextView tvDiggCount;

    CommentViewHolder(View itemView) {
      super(itemView);
      ivAvatar = ViewUtil.findViewById(itemView, R.id.iv_avatar);
      tvNickname = ViewUtil.findViewById(itemView, R.id.tv_user_nickname);
      tvComment = ViewUtil.findViewById(itemView, R.id.tv_user_comment);
      llAuthorReply = ViewUtil.findViewById(itemView, R.id.ll_author_reply);
      tvReplyUserName = ViewUtil.findViewById(itemView, R.id.tv_reply_username);
      tvReplyContent = ViewUtil.findViewById(itemView, R.id.tv_reply_content);
      tvFeedbackCount = ViewUtil.findViewById(itemView, R.id.tv_feedback_count);
      tvCreateTime = ViewUtil.findViewById(itemView, R.id.tv_create_time);
      tvAuthorDigg = ViewUtil.findViewById(itemView, R.id.tv_author_digg);
      tvDiggCount = ViewUtil.findViewById(itemView, R.id.tv_digg_count);
    }
  }
}
