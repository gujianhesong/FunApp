package com.pinery.fun.video.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by gujian on 2018-08-26.
 */

public class TimeUtil {

  public static String getYYMMDD(long timeSecond) {
    return new SimpleDateFormat("yyyy-MM-dd").format(new Date(timeSecond * 1000));
  }

  public static String getCommentTime(long timeSecond){
    Date date = new Date(timeSecond * 1000);
    Date nowDate = new Date();

    long deltaTimeSecond = nowDate.getTime() / 1000 - timeSecond;
    if(deltaTimeSecond < 60){
      deltaTimeSecond = 60;
    }

    if(deltaTimeSecond < 60 * 60){
      return String.format("%d分钟前", deltaTimeSecond / 60);
    }else if(deltaTimeSecond < 60 * 60 * 24){
      return String.format("%d小时前", deltaTimeSecond / (60 * 60));
    }else{
      return getYYMMDD(timeSecond);
    }

  }

}
