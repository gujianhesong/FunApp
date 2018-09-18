package com.pinery.fun.video.ui.viewproxy;

import android.animation.ObjectAnimator;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.pinery.base.util.NetWorkUtil;
import com.pinery.base.util.ViewUtil;
import com.pinery.fun.video.R;
import com.pinery.fun.video.bean.CommentListBean;
import com.pinery.fun.video.bean.CommentsItemBean;
import com.pinery.fun.video.dagger.DaggerCommentsViewProxyComponent;
import com.pinery.fun.video.mvp.HuoCommentPresenter;
import com.pinery.fun.video.mvp.HuoCommentsContract;
import com.pinery.fun.video.ui.adapter.BaseAdapter;
import com.pinery.fun.video.ui.adapter.HuoCommentAdapter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gujian on 2018-08-25.
 */

public class CommentsListViewProxy extends BaseListViewProxy<HuoCommentPresenter>
    implements HuoCommentsContract.View {

  private static final int STATE_HIDE_COMMENT = 0;
  private static final int STATE_SHOW_COMMENT = 1;
  private static final int STATE_SHOW_COMMENT_REPLY = 2;

  private int mState = STATE_HIDE_COMMENT;

  private float screenRatio = 2 / 3f;

  private List<CommentsItemBean> mDatas = new ArrayList<>();
  private int mPage;
  private String id;

  private CommentReplyViewProxy commentReplyViewProxy;

  private TextView tvCommentsCount;

  public static CommentsListViewProxy newInstance(Context context, String id) {
    return new CommentsListViewProxy(context, id);
  }

  public CommentsListViewProxy(Context context, String id) {
    super(context);
    this.id = id;
  }

  @Override protected void initInjector() {
    DaggerCommentsViewProxyComponent.create().inject(this);
  }

  @Override public int getLayoutId() {
    return R.layout.layout_video_comments;
  }

  @Override protected void initView(View view) {
    super.initView(view);

    tvCommentsCount = ViewUtil.findViewById(view, R.id.tv_comments_count);
  }

  @Override protected void initData() {
    if (mDatas.isEmpty()) {
      mRecyclerView.forceToRefresh();
    } else {
    }
  }

  @Override protected BaseAdapter generateAdapter() {
    HuoCommentAdapter adapter = new HuoCommentAdapter(mContext, mDatas);
    adapter.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        if(v.getTag() instanceof CommentsItemBean){
          CommentsItemBean bean = (CommentsItemBean) v.getTag();
          if(bean != null){

            RelativeLayout parent = (RelativeLayout) getView().getParent();
            if(parent != null){
              if(commentReplyViewProxy == null){
                commentReplyViewProxy = CommentReplyViewProxy.newInstance(mContext);
              }

              commentReplyViewProxy.showInContainer(parent);
              commentReplyViewProxy.onCreateView();
              commentReplyViewProxy.requestData(String.valueOf(bean.getId()));

              mState = STATE_SHOW_COMMENT_REPLY;
            }
          }
        }
      }
    });
    //adapter.bindRecyclerView(mRecyclerView);
    return adapter;
  }

  @Override public void onRefresh() {
    if (!NetWorkUtil.isNetWorkAvailable(mContext)) {
      showErrorMessage(true, mContext.getString(R.string.tip_network_error));
      return;
    }

    mPage = 0;
    mPresenter.loadData(id, mPage);
  }

  @Override public void onLoadMore() {
    if (!NetWorkUtil.isNetWorkAvailable(mContext)) {
      showErrorMessage(false, mContext.getString(R.string.tip_network_error));
      return;
    }

    mPresenter.loadData(id, mPage);
  }

  @Override public void updateList(CommentListBean bean) {
    mPage++;

    List<CommentsItemBean> list = bean.getData().getComments();
    if (list != null) {
      mDatas.addAll(list);
    }

    tvCommentsCount.setText(String.format("%d条评论", bean.getExtra().getTotal()));

    notifyCompleteRefresh(list != null ? list.size() : 0);

    if(!bean.getExtra().isHas_more()){
      mRecyclerView.setLoadMoreEnabled(false);
    }

  }

  @Override public void error(Throwable throwable) {
    showToast(throwable.getMessage());
  }

  public boolean onBackPressed() {
    switch (mState){
      case STATE_HIDE_COMMENT:

        return false;

      case STATE_SHOW_COMMENT:

        new ShowAnimateHandler(getView()).hide();
        mState = STATE_HIDE_COMMENT;
        return true;

      case STATE_SHOW_COMMENT_REPLY:

        if(commentReplyViewProxy != null){
          commentReplyViewProxy.hide();
        }
        mState = STATE_SHOW_COMMENT;
        return true;
    }

    return false;
  }

  public void showInContainer(RelativeLayout container){
    if(getView().getParent() == null){
      int parentHeight = container.getHeight();
      RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
          (int) (parentHeight * screenRatio));
      params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
      container.addView(getView(), params);
      onCreateView();

      mState = STATE_SHOW_COMMENT;
      new ShowAnimateHandler(getView()).show();
    }else{
      mState = STATE_SHOW_COMMENT;
      new ShowAnimateHandler(getView()).show();
    }

  }

  private class ShowAnimateHandler{
    private View view;

    public ShowAnimateHandler(View view){
      this.view = view;
    }

    public void show(){
      if(view.getParent() == null){
        return;
      }

      ViewGroup parent = (ViewGroup) view.getParent();
      int parentHeight = parent.getHeight();

      ObjectAnimator animator = ObjectAnimator.ofFloat(view, "translationY", (int) (parentHeight * screenRatio), 0);
      animator.setDuration(300).start();
    }

    public void hide(){
      if(view.getParent() == null){
        return;
      }

      ViewGroup parent = (ViewGroup) view.getParent();
      int parentHeight = parent.getHeight();

      ObjectAnimator animator = ObjectAnimator.ofFloat(view, "translationY", 0, (int) (parentHeight * screenRatio));
      animator.setDuration(300).start();
    }

  }

}