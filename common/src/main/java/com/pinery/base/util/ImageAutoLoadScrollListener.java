package com.pinery.base.util;

import android.support.v7.widget.RecyclerView;
import com.bumptech.glide.Glide;

/**
 * Created by gujian on 2019/4/14.
 */

//监听滚动来对图片加载进行判断处理
public class ImageAutoLoadScrollListener extends RecyclerView.OnScrollListener {

  @Override public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
    super.onScrolled(recyclerView, dx, dy);
  }

  @Override public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
    super.onScrollStateChanged(recyclerView, newState);
    switch (newState) {
      case RecyclerView.SCROLL_STATE_IDLE: // The RecyclerView is not currently scrolling.
        //当屏幕停止滚动，加载图片
        try {
          if (recyclerView.getContext() != null) {
            Glide.with(recyclerView.getContext()).resumeRequests();
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
        break;
      case RecyclerView.SCROLL_STATE_DRAGGING: // The RecyclerView is currently being dragged by outside input such as user touch input.
        //当屏幕滚动且用户使用的触碰或手指还在屏幕上，停止加载图片
        //try {
        //  if (getContext() != null) Glide.with(getContext()).pauseRequests();
        //} catch (Exception e) {
        //  e.printStackTrace();
        //}
        break;
      case RecyclerView.SCROLL_STATE_SETTLING: // The RecyclerView is currently animating to a final position while not under outside control.
        //由于用户的操作，屏幕产生惯性滑动，停止加载图片
        try {
          if (recyclerView.getContext() != null) {
            Glide.with(recyclerView.getContext()).pauseRequests();
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
        break;
    }
  }
}
