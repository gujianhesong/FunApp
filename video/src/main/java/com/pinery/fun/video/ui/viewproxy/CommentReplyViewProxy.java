package com.pinery.fun.video.ui.viewproxy;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.pinery.base.util.NetWorkUtil;
import com.pinery.base.util.ViewUtil;
import com.pinery.fun.video.R;
import com.pinery.fun.video.bean.CommentListBean;
import com.pinery.fun.video.bean.CommentReplyItemBean;
import com.pinery.fun.video.bean.CommentReplyListBean;
import com.pinery.fun.video.bean.CommentsItemBean;
import com.pinery.fun.video.dagger.DaggerCommentsViewProxyComponent;
import com.pinery.fun.video.mvp.HuoCommentPresenter;
import com.pinery.fun.video.mvp.HuoCommentReplyContract;
import com.pinery.fun.video.mvp.HuoCommentReplyPresenter;
import com.pinery.fun.video.mvp.HuoCommentsContract;
import com.pinery.fun.video.ui.adapter.BaseAdapter;
import com.pinery.fun.video.ui.adapter.HuoCommentAdapter;
import com.pinery.fun.video.ui.adapter.HuoCommentReplyAdapter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gujian on 2018-08-25.
 */

public class CommentReplyViewProxy extends BaseListViewProxy<HuoCommentReplyPresenter>
    implements HuoCommentReplyContract.View {

  private List<CommentReplyListBean> mDatas = new ArrayList<>();
  private int mPage;
  private String id;

  private TextView tvClose;

  public static CommentReplyViewProxy newInstance(Context context) {
    return new CommentReplyViewProxy(context);
  }

  public CommentReplyViewProxy(Context context) {
    super(context);
  }

  @Override protected void initInjector() {
    DaggerCommentsViewProxyComponent.create().inject(this);
  }

  @Override public int getLayoutId() {
    return R.layout.layout_comment_reply;
  }

  @Override protected void initView(View view) {
    super.initView(view);

    tvClose = ViewUtil.findViewById(view, R.id.tv_close);
    tvClose.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        hide();
      }
    });
  }

  @Override protected void initData() {
    mRecyclerView.forceToRefresh();
  }

  @Override protected BaseAdapter generateAdapter() {
    HuoCommentReplyAdapter adapter = new HuoCommentReplyAdapter(mContext, mDatas);
    //adapter.bindRecyclerView(mRecyclerView);
    return adapter;
  }

  @Override public void onRefresh() {

  }

  @Override public void onLoadMore() {
    if (!NetWorkUtil.isNetWorkAvailable(mContext)) {
      showErrorMessage(false, mContext.getString(R.string.tip_network_error));
      return;
    }

    mPresenter.loadData(id, mPage);
  }

  @Override public void updateList(CommentReplyListBean bean) {
    mPage++;

    mDatas.add(bean);

    notifyCompleteRefresh(bean.getData().getComments() != null ? bean.getData().getComments().size() : 0);

    mRecyclerView.setLoadMoreEnabled(bean.getExtra().isHas_more());

  }

  @Override public void error(Throwable throwable) {
    showToast(throwable.getMessage());
  }

  public void showInContainer(RelativeLayout container){
    if(getView().getParent() == null){
      int parentHeight = container.getHeight();
      RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, parentHeight);
      container.addView(getView(), params);
    }

    onCreateView();
    new ShowAnimateHandler(getView()).show();

  }

  public void hide(){
    new ShowAnimateHandler(getView()).hide();
  }

  public void requestData(String id){
    this.id = id;

    if (!NetWorkUtil.isNetWorkAvailable(mContext)) {
      showErrorMessage(true, mContext.getString(R.string.tip_network_error));
      return;
    }

    mDatas.clear();

    mPage = 0;
    mPresenter.loadData(id, mPage);
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

      ObjectAnimator animator = ObjectAnimator.ofFloat(view, "translationY", parentHeight, 0);
      animator.setDuration(400).start();
    }

    public void hide(){
      if(view.getParent() == null){
        return;
      }

      ViewGroup parent = (ViewGroup) view.getParent();
      int parentHeight = parent.getHeight();

      ObjectAnimator animator = ObjectAnimator.ofFloat(view, "translationY", 0, parentHeight);
      animator.setDuration(400).start();
    }

  }

}