package com.pinery.fun.video.util;

import java.text.DecimalFormat;

/**
 * Created by gujian on 2018-08-25.
 */

public class NumberUtil {

  public static String getFormatNumber(int count){
    if(count <= 0){
      return "";
    }else if(count < 10000){
      return String.valueOf(count);
    }else{
      return new DecimalFormat("0.0").format(count / 10000f) + "万";
    }

  }

}
