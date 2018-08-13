package com.pinery.base.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import android.view.WindowManager;

/**
 * Created by gujian on 2018-08-12.
 */

public class ScreenUtil {

  /**
   * 获取窗口尺寸，不包含状态栏的高度
   */
  public static Point getWindowSize(Context context) {
    WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
    Point point = new Point();
    wm.getDefaultDisplay().getSize(point);

    return point;
  }

  /**
   * 获取可适配横竖屏的,窗口尺寸，不包含状态栏的高度
   */
  public static Point getWindowSizeFitOriatation(Context context) {
    WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
    Point point = new Point();
    wm.getDefaultDisplay().getSize(point);
    final int wWidth = point.x;
    final int wHeight = point.y;

    final int windowWidth = wWidth > wHeight ? wHeight : wWidth;
    final int windowHeight = wWidth > wHeight ? wWidth : wHeight;

    Point winSize = new Point();
    if (checkIsLandScape(context)) {
      winSize.x = windowHeight;
      winSize.y = windowWidth;
    } else {
      winSize.x = windowWidth;
      winSize.y = windowHeight;
    }

    return winSize;
  }

  /**
   * 获取屏幕尺寸，包含状态栏的高度
   */
  @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1) public static Point getScreenSize(
      Context context) {
    DisplayMetrics displayMetrics = new DisplayMetrics();
    WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
    windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
    final int width = displayMetrics.widthPixels;
    final int height = displayMetrics.heightPixels;
    return new Point(width, height);
  }

  /**
   * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
   */
  public static int dp2px(Context context, float dpValue) {
    final float scale = context.getResources().getDisplayMetrics().density;
    return (int) (dpValue * scale + 0.5f);
  }

  /**
   * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
   */
  public static int px2dp(Context context, float pxValue) {
    final float scale = context.getResources().getDisplayMetrics().density;
    return (int) (pxValue / scale + 0.5f);
  }

  /**
   * 将sp值转换为px值，保证文字大小不变
   *
   * @param spValue （DisplayMetrics类中属性scaledDensity）
   */
  public static int sp2px(Context context, float spValue) {
    final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
    return (int) (spValue * fontScale + 0.5f);
  }

  /**
   * 将px值转换为sp值，保证文字大小不变
   *
   * @param pxValue （DisplayMetrics类中属性scaledDensity）
   */
  public static int px2sp(Context context, float pxValue) {
    final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
    return (int) (pxValue / fontScale + 0.5f);
  }

  /**
   * 是否横屏
   */
  public static boolean checkIsLandScape(Context context) {
    Configuration configuration = context.getResources().getConfiguration();
    return configuration.orientation == Configuration.ORIENTATION_LANDSCAPE;
  }

  /**
   * 获取当前横竖屏
   */
  public static int getCurrentOrientation(Context context) {
    Configuration configuration = context.getResources().getConfiguration();
    return configuration.orientation;
  }

  /**
   * 状态栏高度
   */
  public static int getStatusBarHeight(Context context) {
    int result = 0;
    int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
    if (resourceId > 0) {
      result = context.getResources().getDimensionPixelSize(resourceId);
    }
    return result;
  }

  public static int getNavigationBarHeight(Context context) {
    Resources resources = context.getResources();
    int resourceId = resources.getIdentifier("navigation_bar_height", "dimen", "android");
    //获取NavigationBar的高度
    int height = resources.getDimensionPixelSize(resourceId);
    return height;
  }

  public static boolean checkDeviceHasNavigationBar(Context activity) {
    //通过判断设备是否有返回键、菜单键(不是虚拟键,是手机屏幕外的按键)来确定是否有navigation bar
    boolean hasMenuKey = ViewConfiguration.get(activity).hasPermanentMenuKey();
    boolean hasBackKey = KeyCharacterMap.deviceHasKey(KeyEvent.KEYCODE_BACK);
    if (!hasMenuKey && !hasBackKey) {
      // 做任何你需要做的,这个设备有一个导航栏
      return true;
    }
    return false;
  }
}
