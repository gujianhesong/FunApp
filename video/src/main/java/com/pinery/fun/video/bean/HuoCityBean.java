package com.pinery.fun.video.bean;

import java.util.List;

/**
 * Created by gujian on 2018-08-22.
 */

public class HuoCityBean {

  private int status_code;
  private ExtraBean extra;
  private List<BaseVideoItemBean> data;

  public int getStatus_code() {
    return status_code;
  }

  public void setStatus_code(int status_code) {
    this.status_code = status_code;
  }

  public ExtraBean getExtra() {
    return extra;
  }

  public void setExtra(ExtraBean extra) {
    this.extra = extra;
  }

  public List<BaseVideoItemBean> getData() {
    return data;
  }

  public void setData(List<BaseVideoItemBean> data) {
    this.data = data;
  }

  public static class ExtraBean {
    /**
     * log_pb : {"rid":"20180822220532010015024098691F43"}
     * now : 1534946733202
     * has_more : true
     * is_backup : 0
     * fatal_ids : []
     * cost : 483
     * max_time : 1534946132749
     * min_time : 1534946612749
     * total : 10
     */

    private LogPbBean log_pb;
    private long now;
    private boolean has_more;
    private int is_backup;
    private int cost;
    private long max_time;
    private long min_time;
    private int total;
    private List<?> fatal_ids;

    public LogPbBean getLog_pb() {
      return log_pb;
    }

    public void setLog_pb(LogPbBean log_pb) {
      this.log_pb = log_pb;
    }

    public long getNow() {
      return now;
    }

    public void setNow(long now) {
      this.now = now;
    }

    public boolean isHas_more() {
      return has_more;
    }

    public void setHas_more(boolean has_more) {
      this.has_more = has_more;
    }

    public int getIs_backup() {
      return is_backup;
    }

    public void setIs_backup(int is_backup) {
      this.is_backup = is_backup;
    }

    public int getCost() {
      return cost;
    }

    public void setCost(int cost) {
      this.cost = cost;
    }

    public long getMax_time() {
      return max_time;
    }

    public void setMax_time(long max_time) {
      this.max_time = max_time;
    }

    public long getMin_time() {
      return min_time;
    }

    public void setMin_time(long min_time) {
      this.min_time = min_time;
    }

    public int getTotal() {
      return total;
    }

    public void setTotal(int total) {
      this.total = total;
    }

    public List<?> getFatal_ids() {
      return fatal_ids;
    }

    public void setFatal_ids(List<?> fatal_ids) {
      this.fatal_ids = fatal_ids;
    }

    public static class LogPbBean {
      /**
       * rid : 20180822220532010015024098691F43
       */

      private String rid;

      public String getRid() {
        return rid;
      }

      public void setRid(String rid) {
        this.rid = rid;
      }
    }
  }

}
