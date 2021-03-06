package com.pinery.fun.video.bean;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

/**
 * Created by gujian on 2018-08-23.
 */

public class VideoItemInfoDeserializer implements JsonDeserializer<BaseVideoItemBean> {
  private static final int TYPE_LIVE = 1;
  private static final int TYPE_VIDEO = 3;
  private static final int TYPE_AD = 5;

  @Override public BaseVideoItemBean deserialize(JsonElement json, Type typeOfT,
      JsonDeserializationContext context) throws JsonParseException {
    JsonObject jsonObject = json.getAsJsonObject();
    //获取里面的type字段，用作区分的标志
    int type = jsonObject.get("type").getAsInt();
    switch (type) {
      case TYPE_LIVE:
        //直播
        return new Gson().fromJson(json, HuoLiveItemBean.class);
      case TYPE_VIDEO:
        //视频
        return new Gson().fromJson(json, HuoVideoItemBean.class);
      case TYPE_AD:
        //广告
        return new Gson().fromJson(json, HuoAdItemBean.class);
      default:
        return null;
    }
  }
}
