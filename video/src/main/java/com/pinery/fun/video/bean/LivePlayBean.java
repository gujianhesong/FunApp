package com.pinery.fun.video.bean;

import java.io.Serializable;

/**
 * Created by gujian on 2018-09-01.
 */

public class LivePlayBean implements Serializable {

  private String url;
  private String authorName;
  private String authorAvatar;

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getAuthorName() {
    return authorName;
  }

  public void setAuthorName(String authorName) {
    this.authorName = authorName;
  }

  public String getAuthorAvatar() {
    return authorAvatar;
  }

  public void setAuthorAvatar(String authorAvatar) {
    this.authorAvatar = authorAvatar;
  }
}
