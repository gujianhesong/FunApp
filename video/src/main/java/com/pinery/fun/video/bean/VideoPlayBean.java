package com.pinery.fun.video.bean;

import java.io.Serializable;

/**
 * Created by gujian on 2018-09-01.
 */

public class VideoPlayBean implements Serializable{

  private String id;
  private String url;
  private String coverUrl;
  private String authorName;
  private String authorAvatar;
  private int commentCount;
  private int loveCount;
  private int shareCount;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getCoverUrl() {
    return coverUrl;
  }

  public void setCoverUrl(String coverUrl) {
    this.coverUrl = coverUrl;
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

  public int getCommentCount() {
    return commentCount;
  }

  public void setCommentCount(int commentCount) {
    this.commentCount = commentCount;
  }

  public int getLoveCount() {
    return loveCount;
  }

  public void setLoveCount(int loveCount) {
    this.loveCount = loveCount;
  }

  public int getShareCount() {
    return shareCount;
  }

  public void setShareCount(int shareCount) {
    this.shareCount = shareCount;
  }
}
