package com.pinery.fun.video.bean;

import java.util.List;

/**
 * Created by gujian on 2018-08-25.
 */

public class CommentListBean {

  private DataBean data;
  private ExtraBean extra;
  private int status_code;

  public DataBean getData() {
    return data;
  }

  public void setData(DataBean data) {
    this.data = data;
  }

  public ExtraBean getExtra() {
    return extra;
  }

  public void setExtra(ExtraBean extra) {
    this.extra = extra;
  }

  public int getStatus_code() {
    return status_code;
  }

  public void setStatus_code(int status_code) {
    this.status_code = status_code;
  }

  public static class DataBean {
    private List<CommentsItemBean> comments;

    public List<CommentsItemBean> getComments() {
      return comments;
    }

    public void setComments(List<CommentsItemBean> comments) {
      this.comments = comments;
    }
  }

  public static class ExtraBean {
    /**
     * has_more : true
     * now : 1535198166128
     * screen_delay : 600
     * total : 1365
     */

    private boolean has_more;
    private long now;
    private int screen_delay;
    private int total;

    public boolean isHas_more() {
      return has_more;
    }

    public void setHas_more(boolean has_more) {
      this.has_more = has_more;
    }

    public long getNow() {
      return now;
    }

    public void setNow(long now) {
      this.now = now;
    }

    public int getScreen_delay() {
      return screen_delay;
    }

    public void setScreen_delay(int screen_delay) {
      this.screen_delay = screen_delay;
    }

    public int getTotal() {
      return total;
    }

    public void setTotal(int total) {
      this.total = total;
    }
  }
}
