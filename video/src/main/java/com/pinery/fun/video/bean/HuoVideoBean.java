package com.pinery.fun.video.bean;

import java.util.List;

/**
 * 2017/12/28
 */

public class HuoVideoBean {

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
     * total : 10
     * has_more : true
     * fatal_ids : []
     * max_time : 1514808730809
     * min_time : 1514808730819
     * now : 1514808730862
     * banner : {"banners":[{"avg_color":"#EBCECE","title":"火山官方红包活动","url_list":["http://p1.pstatp.com/obj/50f50006a3bef7cbfeb6","http://pb3.pstatp.com/obj/50f50006a3bef7cbfeb6","http://pb3.pstatp.com/obj/50f50006a3bef7cbfeb6"],"uri":"50f50006a3bef7cbfeb6","height":281,"width":751,"tab_types":[7],"id":1002,"schema_url":"sslocal://webview?url=https%3A%2F%2Fs3a.bytecdn.cn%2Fhuoshan%2Fresource%2Factivity_static%2Fpage%2Fnew_year%2Findex.html%3Futm_source%3Dvideo_detail&hide_more=1"}],"total":1}
     */

    private int total;
    private boolean has_more;
    private long max_time;
    private long min_time;
    private long now;
    private BannerBean banner;
    private List<?> fatal_ids;

    public int getTotal() {
      return total;
    }

    public void setTotal(int total) {
      this.total = total;
    }

    public boolean isHas_more() {
      return has_more;
    }

    public void setHas_more(boolean has_more) {
      this.has_more = has_more;
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

    public long getNow() {
      return now;
    }

    public void setNow(long now) {
      this.now = now;
    }

    public BannerBean getBanner() {
      return banner;
    }

    public void setBanner(BannerBean banner) {
      this.banner = banner;
    }

    public List<?> getFatal_ids() {
      return fatal_ids;
    }

    public void setFatal_ids(List<?> fatal_ids) {
      this.fatal_ids = fatal_ids;
    }

    public static class BannerBean {
      /**
       * banners : [{"avg_color":"#EBCECE","title":"火山官方红包活动","url_list":["http://p1.pstatp.com/obj/50f50006a3bef7cbfeb6","http://pb3.pstatp.com/obj/50f50006a3bef7cbfeb6","http://pb3.pstatp.com/obj/50f50006a3bef7cbfeb6"],"uri":"50f50006a3bef7cbfeb6","height":281,"width":751,"tab_types":[7],"id":1002,"schema_url":"sslocal://webview?url=https%3A%2F%2Fs3a.bytecdn.cn%2Fhuoshan%2Fresource%2Factivity_static%2Fpage%2Fnew_year%2Findex.html%3Futm_source%3Dvideo_detail&hide_more=1"}]
       * total : 1
       */

      private int total;
      private List<BannersBean> banners;

      public int getTotal() {
        return total;
      }

      public void setTotal(int total) {
        this.total = total;
      }

      public List<BannersBean> getBanners() {
        return banners;
      }

      public void setBanners(List<BannersBean> banners) {
        this.banners = banners;
      }

      public static class BannersBean {
        /**
         * avg_color : #EBCECE
         * title : 火山官方红包活动
         * url_list : ["http://p1.pstatp.com/obj/50f50006a3bef7cbfeb6","http://pb3.pstatp.com/obj/50f50006a3bef7cbfeb6","http://pb3.pstatp.com/obj/50f50006a3bef7cbfeb6"]
         * uri : 50f50006a3bef7cbfeb6
         * height : 281
         * width : 751
         * tab_types : [7]
         * id : 1002
         * schema_url : sslocal://webview?url=https%3A%2F%2Fs3a.bytecdn.cn%2Fhuoshan%2Fresource%2Factivity_static%2Fpage%2Fnew_year%2Findex.html%3Futm_source%3Dvideo_detail&hide_more=1
         */

        private String avg_color;
        private String title;
        private String uri;
        private int height;
        private int width;
        private int id;
        private String schema_url;
        private List<String> url_list;
        private List<Integer> tab_types;

        public String getAvg_color() {
          return avg_color;
        }

        public void setAvg_color(String avg_color) {
          this.avg_color = avg_color;
        }

        public String getTitle() {
          return title;
        }

        public void setTitle(String title) {
          this.title = title;
        }

        public String getUri() {
          return uri;
        }

        public void setUri(String uri) {
          this.uri = uri;
        }

        public int getHeight() {
          return height;
        }

        public void setHeight(int height) {
          this.height = height;
        }

        public int getWidth() {
          return width;
        }

        public void setWidth(int width) {
          this.width = width;
        }

        public int getId() {
          return id;
        }

        public void setId(int id) {
          this.id = id;
        }

        public String getSchema_url() {
          return schema_url;
        }

        public void setSchema_url(String schema_url) {
          this.schema_url = schema_url;
        }

        public List<String> getUrl_list() {
          return url_list;
        }

        public void setUrl_list(List<String> url_list) {
          this.url_list = url_list;
        }

        public List<Integer> getTab_types() {
          return tab_types;
        }

        public void setTab_types(List<Integer> tab_types) {
          this.tab_types = tab_types;
        }
      }
    }
  }
}