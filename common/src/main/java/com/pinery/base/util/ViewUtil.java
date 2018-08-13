package com.pinery.base.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Outline;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewOutlineProvider;

/**
 * View视图工具类
 */
public class ViewUtil {

  /**
   * 设置视图裁剪的圆角半径
   */
  @TargetApi(Build.VERSION_CODES.LOLLIPOP) public static void setClipViewCornerRadius(View view,
      final int radius) {

    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
      //不支持5.0版本以下的系统
      return;
    }

    if (view == null) return;

    if (radius <= 0) {
      return;
    }

        /*mView.setOutlineProvider(new ViewOutlineProvider() {

            @Override
            public void getOutline(View mView, Outline outline) {
                outline.setRoundRect(mView.getLeft(), mView.getTop(), mView.getRight(), mView.getBottom(), radius);
            }
        });*/
    view.setOutlineProvider(new ViewOutlineProvider() {

      @Override public void getOutline(View view, Outline outline) {
        outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), radius);
      }
    });
    view.setClipToOutline(true);
  }

  /**
   * 通过id获取视图,不用强制类型转换
   */
  public static <E extends View> E findViewById(View rootView, int id) {
    try {
      return (E) rootView.findViewById(id);
    } catch (Exception ex) {
      ex.printStackTrace();
    }

    return null;
  }

  /**
   * 通过id获取视图,不用强制类型转换
   */
  public static <E extends View> E findViewById(Activity activity, int id) {
    try {
      return (E) activity.findViewById(id);
    } catch (Exception ex) {
      ex.printStackTrace();
    }

    return null;
  }

  /**
   * 是否点在view内
   */
  public static boolean isTouchInView(View view, int x, int y) {
    Rect rect = new Rect();
    view.getDrawingRect(rect);
    int[] location = new int[2];
    view.getLocationOnScreen(location);
    rect.left = location[0];
    rect.top = location[1];
    rect.right = rect.right + location[0];
    rect.bottom = rect.bottom + location[1];
    return rect.contains(x, y);
  }
}
