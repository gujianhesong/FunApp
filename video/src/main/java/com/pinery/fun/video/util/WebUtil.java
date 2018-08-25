package com.pinery.fun.video.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;

/**
 * Created by gujian on 2018-08-25.
 */

public class WebUtil {

  public static void openUrl(Context context, String url){
    if(context == null || TextUtils.isEmpty(url)){
      return;
    }

    Uri uri = Uri.parse(url);
    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
    if(!(context instanceof Activity)){
      intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    }
    context.startActivity(intent);
  }


}

