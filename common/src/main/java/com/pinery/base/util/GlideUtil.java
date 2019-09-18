package com.pinery.base.util;

import android.text.TextUtils;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

/**
 * Created by gujian on 2019/4/7.
 */
public class GlideUtil {

  public static void loadImage(final ImageView view, final String url, int placeHolder) {
    view.setImageDrawable(null);

    final int tagId = view.getId();
    view.setTag(tagId, url);
    Glide.with(view.getContext())
        .load(url)
        .error(placeHolder)
        .into(new SimpleTarget<GlideDrawable>() {
          @Override public void onResourceReady(GlideDrawable resource,
              GlideAnimation<? super GlideDrawable> glideAnimation) {

            Object tag = view.getTag(tagId);
            if (tag instanceof String) {
              String strTag = (String) tag;
              if (TextUtils.equals(url, strTag)) {
                view.setImageDrawable(resource);
              }
            }
          }
        });
  }

  public static void loadImage(final ImageView view, final String url) {
    view.setImageDrawable(null);

    final int tagId = view.getId();
    view.setTag(tagId, url);
    Glide.with(view.getContext())
        .load(url)
        .into(new SimpleTarget<GlideDrawable>() {
          @Override public void onResourceReady(GlideDrawable resource,
              GlideAnimation<? super GlideDrawable> glideAnimation) {

            Object tag = view.getTag(tagId);
            if (tag instanceof String) {
              String strTag = (String) tag;
              if (TextUtils.equals(url, strTag)) {
                view.setImageDrawable(resource);
              }
            }
          }
        });
  }
}
