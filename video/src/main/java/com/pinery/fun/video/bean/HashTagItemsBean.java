package com.pinery.fun.video.bean;

import com.pinery.fun.video.bean.item.HashTagItemBean;
import java.util.List;

/**
 * Created by gujian on 2019/3/20.
 */

public class HashTagItemsBean {

  private int status_code;
  //private ExtraBean extra;
  //private List<DataBeanX> data;

  public int getStatus_code() {
    return status_code;
  }

  public void setStatus_code(int status_code) {
    this.status_code = status_code;
  }

  //public ExtraBean getExtra() {
  //  return extra;
  //}
  //
  //public void setExtra(ExtraBean extra) {
  //  this.extra = extra;
  //}

  //public List<DataBeanX> getData() {
  //  return data;
  //}
  //
  //public void setData(List<DataBeanX> data) {
  //  this.data = data;
  //}

  public static class ExtraBean {
    private LogPbBean log_pb;
    private int total;
    private int max_cursor;
    private boolean has_more;
    private long now;
    private List<?> fatal_ids;

    public LogPbBean getLog_pb() {
      return log_pb;
    }

    public void setLog_pb(LogPbBean log_pb) {
      this.log_pb = log_pb;
    }

    public int getTotal() {
      return total;
    }

    public void setTotal(int total) {
      this.total = total;
    }

    public int getMax_cursor() {
      return max_cursor;
    }

    public void setMax_cursor(int max_cursor) {
      this.max_cursor = max_cursor;
    }

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

    public List<?> getFatal_ids() {
      return fatal_ids;
    }

    public void setFatal_ids(List<?> fatal_ids) {
      this.fatal_ids = fatal_ids;
    }

    public static class LogPbBean {
      private String impr_id;

      public String getImpr_id() {
        return impr_id;
      }

      public void setImpr_id(String impr_id) {
        this.impr_id = impr_id;
      }
    }
  }

  public static class DataBeanX {
    //private HashTagItemBean data;
    private int type;

    //public HashTagItemBean getData() {
    //  return data;
    //}
    //
    //public void setData(HashTagItemBean data) {
    //  this.data = data;
    //}

    public int getType() {
      return type;
    }

    public void setType(int type) {
      this.type = type;
    }


  }
}
