package com.pinery.base.util;

import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Log打印日志类
 */
public class LogUtil {

  /**
   * 设置打印日志是否可用
   */
  public static void setEnable(boolean logEnable) {
    hideLog = !logEnable;
  }

  public static boolean hideLog = false;

  private static final String TAG = "CUSTOME_TAG";

  private static final boolean isSaveLog = true; // 是否把保存日志到SD卡中

  /**
   * @param message
   */
  public static void v(String message) {
    v("", message);
  }

  /**
   * @param tag
   * @param message
   */
  public static void v(String tag, String message) {
    if (hideLog) {
      return;
    }

    tag = TAG + "-" + tag;
    message = getFunctionName() + message;

    Log.v(tag, message);
  }

  /**
   * @param message
   */
  public static void d(String message) {
    d("", message);
  }

  /**
   * @param tag
   * @param message
   */
  public static void d(String tag, String message) {
    if (hideLog) {
      return;
    }

    tag = TAG + "-" + tag;
    message = getFunctionName() + message;

    Log.d(tag, message);
  }

  /**
   * @param message
   */
  public static void w(String message) {
    w("", message);
  }

  /**
   * @param tag
   * @param message
   */
  public static void w(String tag, String message) {
    if (hideLog) {
      return;
    }

    tag = TAG + "-" + tag;
    message = getFunctionName() + message;

    Log.w(tag, message);
  }

  /**
   */
  public static void i() {
    i("", "");
  }

  /**
   * @param message
   */
  public static void i(String message) {
    i("", message);
  }

  /**
   * @param showLog
   * @param message
   */
  public static void i(boolean showLog, String message) {
    if (!showLog) {
      return;
    }

    i(message);
  }

  /**
   * @param tag
   * @param message
   */
  public static void i(String tag, String message) {
    if (hideLog) {
      return;
    }

    tag = TAG + "-" + tag;
    message = getFunctionName() + message;

    Log.i(tag, message);
  }

  /**
   * @param message
   */
  public static void e(String message) {
    e(TAG, message);
  }

  /**
   * @param tag
   * @param message
   */
  public static void e(String tag, String message) {
    e(tag, message, null);
  }

  /**
   * @param throwable
   */
  public static void e(final Throwable throwable) {
    e(TAG, "", throwable);
  }

  /**
   * @param tag
   * @param message
   */
  public static void e(String tag, final String message, final Throwable throwable) {
    if (hideLog) {
      return;
    }

    final String tagName = getFunctionName() + message;

    Log.e(tag, tagName, throwable);
  }

  /**
   * @param message
   */
  public static void printStack(String message) {
    try {
      throw new Exception("打印堆栈:" + message);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 获取捕捉到的异常的字符串
   */
  public static String getStackTraceString(Throwable tr) {
    if (tr == null) {
      return "";
    }

    Throwable t = tr;
    while (t != null) {
      if (t instanceof UnknownHostException) {
        return "";
      }
      t = t.getCause();
    }

    StringWriter sw = new StringWriter();
    PrintWriter pw = new PrintWriter(sw);
    tr.printStackTrace(pw);
    return sw.toString();
  }

  private static String getFunctionName() {
    StackTraceElement[] sts = Thread.currentThread().getStackTrace();

    if (sts == null) {
      return "";
    }

    for (StackTraceElement st : sts) {
      if (st.isNativeMethod()) {
        continue;
      }

      if (st.getClassName().equals(Thread.class.getName())) {
        continue;
      }

      if (st.getClassName().equals(LogUtil.class.getName())) {
        continue;
      }

      return "["
          + Thread.currentThread().getId()
          + ": "
          + st.getFileName()
          + " : "
          + st.getLineNumber()
          + " : "
          + st.getMethodName()
          + "]---";
    }

    return "";
  }

  /**
   * 标识每条日志产生的时间
   */
  private static String time() {
    return "[" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(
        new Date(System.currentTimeMillis())) + "] ";
  }

  /**
   * 以年月日作为日志文件名称
   */
  private static String date() {
    return new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis()));
  }
}
