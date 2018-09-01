package com.pinery.fun.video.dagger;

import com.pinery.fun.video.ui.viewproxy.CommentReplyViewProxy;
import com.pinery.fun.video.ui.viewproxy.CommentsListViewProxy;
import dagger.Component;

@Component() public interface CommentsViewProxyComponent {

  void inject(CommentsListViewProxy viewProxy);

  void inject(CommentReplyViewProxy viewProxy);
}
