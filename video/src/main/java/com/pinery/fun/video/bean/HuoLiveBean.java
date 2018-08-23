package com.pinery.fun.video.bean;

import java.util.List;

/**
 */
public class HuoLiveBean {

  private int status_code;
  private ExtraBean extra;
  private List<HuoLiveItemBean> data;

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

  public List<HuoLiveItemBean> getData() {
    return data;
  }

  public void setData(List<HuoLiveItemBean> data) {
    this.data = data;
  }

  public static class ExtraBean {
    /**
     * top_button : {"url":"http://hotsoon.snssdk.com/hotsoon/in_app/rank/rich_anchor/?hide_nav_bar=1","icon":{"url_list":["http://p3.pstatp.com/obj/34b50003f1566b2ee7ae","http://pb9.pstatp.com/obj/34b50003f1566b2ee7ae","http://pb3.pstatp.com/obj/34b50003f1566b2ee7ae"],"uri":"34b50003f1566b2ee7ae"},"title":"排行榜"}
     * now : 1514803337249
     * has_more : true
     * fatal_ids : []
     * max_time : 1514803337233
     * min_time : 0
     * rank_round_banner : {"rank_list":[{"url":"https://hotsoon.snssdk.com/hotsoon/in_app/rank/rich_anchor/?enter_type=3&hide_nav_bar=1","list":[{"user_avatar":{"url_list":["http://p3.pstatp.com/live/100x100/50f20000f94aa9a3ff7c.jpg","http://pb9.pstatp.com/live/100x100/50f20000f94aa9a3ff7c.jpg","http://pb3.pstatp.com/live/100x100/50f20000f94aa9a3ff7c.jpg"],"uri":"100x100/50f20000f94aa9a3ff7c"},"score":606933,"user_id":75828267728,"rank":1},{"user_avatar":{"url_list":["http://p1.pstatp.com/live/100x100/50f60007c549d0d4126a.jpg","http://pb3.pstatp.com/live/100x100/50f60007c549d0d4126a.jpg","http://pb3.pstatp.com/live/100x100/50f60007c549d0d4126a.jpg"],"uri":"100x100/50f60007c549d0d4126a"},"score":527252,"user_id":6277887535,"rank":2},{"user_avatar":{"url_list":["http://q.qlogo.cn/qqapp/101302986/C250E1DFABDFDB84E99612E45C6091D1/100"],"uri":"avatar_thumb/http://q.qlogo.cn/qqapp/101302986/C250E1DFABDFDB84E99612E45C6091D1/100"},"score":520745,"user_id":62887807368,"rank":3}],"name":"金主日榜","icon":{"url_list":["http://p3.pstatp.com/live/100x100/34b50003f1566b2ee7ae.jpg","http://pb9.pstatp.com/live/100x100/34b50003f1566b2ee7ae.jpg","http://pb3.pstatp.com/live/100x100/34b50003f1566b2ee7ae.jpg"],"uri":"100x100/34b50003f1566b2ee7ae"}},{"url":"https://hotsoon.snssdk.com/hotsoon/in_app/rank/rich_anchor/?enter_type=4&hide_nav_bar=1","list":[{"user_avatar":{"url_list":["http://p3.pstatp.com/live/100x100/50f30007ba62f33988aa.jpg","http://pb9.pstatp.com/live/100x100/50f30007ba62f33988aa.jpg","http://pb3.pstatp.com/live/100x100/50f30007ba62f33988aa.jpg"],"uri":"100x100/50f30007ba62f33988aa"},"score":950547,"user_id":52161112484,"rank":1},{"user_avatar":{"url_list":["http://p1.pstatp.com/live/100x100/4ec60005ea7e478a6a9d.jpg","http://pb3.pstatp.com/live/100x100/4ec60005ea7e478a6a9d.jpg","http://pb3.pstatp.com/live/100x100/4ec60005ea7e478a6a9d.jpg"],"uri":"100x100/4ec60005ea7e478a6a9d"},"score":735933,"user_id":55977492335,"rank":2},{"user_avatar":{"url_list":["http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKeurpjKLQQIJ0iaMdnJ37ricicnK2dQqKNiaagpGWORNSuesDAeGvOoicWmtbMECs9Y6YbRSYiaXNaSvrQ/0"],"uri":"avatar_thumb/http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKeurpjKLQQIJ0iaMdnJ37ricicnK2dQqKNiaagpGWORNSuesDAeGvOoicWmtbMECs9Y6YbRSYiaXNaSvrQ/0"},"score":713646,"user_id":83793893188,"rank":3}],"name":"金主昨日榜","icon":{"url_list":["http://p3.pstatp.com/live/100x100/34b50003f1566b2ee7ae.jpg","http://pb9.pstatp.com/live/100x100/34b50003f1566b2ee7ae.jpg","http://pb3.pstatp.com/live/100x100/34b50003f1566b2ee7ae.jpg"],"uri":"100x100/34b50003f1566b2ee7ae"}},{"url":"https://hotsoon.snssdk.com/hotsoon/in_app/rank/rich_anchor/?enter_type=5&hide_nav_bar=1","list":[{"user_avatar":{"url_list":["http://p1.pstatp.com/live/100x100/50f4000638e7cb7323ad.jpg","http://pb3.pstatp.com/live/100x100/50f4000638e7cb7323ad.jpg","http://pb3.pstatp.com/live/100x100/50f4000638e7cb7323ad.jpg"],"uri":"100x100/50f4000638e7cb7323ad"},"score":6772576,"user_id":83042640632,"rank":1},{"user_avatar":{"url_list":["http://p1.pstatp.com/live/100x100/34b40003182b24f69eeb.jpg","http://pb3.pstatp.com/live/100x100/34b40003182b24f69eeb.jpg","http://pb3.pstatp.com/live/100x100/34b40003182b24f69eeb.jpg"],"uri":"100x100/34b40003182b24f69eeb"},"score":3358984,"user_id":61967966520,"rank":2},{"user_avatar":{"url_list":["http://p1.pstatp.com/live/100x100/4a6c00015ebbf9c196e6.jpg","http://pb3.pstatp.com/live/100x100/4a6c00015ebbf9c196e6.jpg","http://pb3.pstatp.com/live/100x100/4a6c00015ebbf9c196e6.jpg"],"uri":"100x100/4a6c00015ebbf9c196e6"},"score":3027729,"user_id":55395362823,"rank":3}],"name":"金主周榜","icon":{"url_list":["http://p3.pstatp.com/live/100x100/34b50003f1566b2ee7ae.jpg","http://pb9.pstatp.com/live/100x100/34b50003f1566b2ee7ae.jpg","http://pb3.pstatp.com/live/100x100/34b50003f1566b2ee7ae.jpg"],"uri":"100x100/34b50003f1566b2ee7ae"}},{"url":"https://hotsoon.snssdk.com/hotsoon/in_app/rank/rich_anchor/?enter_type=1&hide_nav_bar=1","list":[{"user_avatar":{"url_list":["http://p3.pstatp.com/live/100x100/50f70006f8355e027304.jpg","http://pb9.pstatp.com/live/100x100/50f70006f8355e027304.jpg","http://pb3.pstatp.com/live/100x100/50f70006f8355e027304.jpg"],"uri":"100x100/50f70006f8355e027304"},"score":137954,"user_id":53448366085,"rank":1},{"user_avatar":{"url_list":["http://p1.pstatp.com/live/100x100/474c0007dc44f1590022.jpg","http://pb3.pstatp.com/live/100x100/474c0007dc44f1590022.jpg","http://pb3.pstatp.com/live/100x100/474c0007dc44f1590022.jpg"],"uri":"100x100/474c0007dc44f1590022"},"score":65533,"user_id":60779821574,"rank":2},{"user_avatar":{"url_list":["http://p3.pstatp.com/live/100x100/1946001f2ae1ae561228.jpg","http://pb9.pstatp.com/live/100x100/1946001f2ae1ae561228.jpg","http://pb3.pstatp.com/live/100x100/1946001f2ae1ae561228.jpg"],"uri":"100x100/1946001f2ae1ae561228"},"score":61995,"user_id":59045653904,"rank":3}],"name":"小时榜","icon":{"url_list":["http://p3.pstatp.com/live/100x100/34b50003f1566b2ee7ae.jpg","http://pb9.pstatp.com/live/100x100/34b50003f1566b2ee7ae.jpg","http://pb3.pstatp.com/live/100x100/34b50003f1566b2ee7ae.jpg"],"uri":"100x100/34b50003f1566b2ee7ae"}},{"url":"https://hotsoon.snssdk.com/hotsoon/in_app/rank/rich_anchor/?enter_type=2&hide_nav_bar=1","list":[{"user_avatar":{"url_list":["http://p3.pstatp.com/live/100x100/551b0002a75087197466.jpg","http://pb9.pstatp.com/live/100x100/551b0002a75087197466.jpg","http://pb3.pstatp.com/live/100x100/551b0002a75087197466.jpg"],"uri":"100x100/551b0002a75087197466"},"score":182952,"user_id":60399146120,"rank":1},{"user_avatar":{"url_list":["http://p3.pstatp.com/live/100x100/4d370001505093ea659f.jpg","http://pb9.pstatp.com/live/100x100/4d370001505093ea659f.jpg","http://pb3.pstatp.com/live/100x100/4d370001505093ea659f.jpg"],"uri":"100x100/4d370001505093ea659f"},"score":179437,"user_id":70072497732,"rank":2},{"user_avatar":{"url_list":["http://p1.pstatp.com/live/100x100/474100049bb08d0c9a92.jpg","http://pb3.pstatp.com/live/100x100/474100049bb08d0c9a92.jpg","http://pb3.pstatp.com/live/100x100/474100049bb08d0c9a92.jpg"],"uri":"100x100/474100049bb08d0c9a92"},"score":48757,"user_id":75186588063,"rank":3}],"name":"上一小时榜","icon":{"url_list":["http://p3.pstatp.com/live/100x100/34b50003f1566b2ee7ae.jpg","http://pb9.pstatp.com/live/100x100/34b50003f1566b2ee7ae.jpg","http://pb3.pstatp.com/live/100x100/34b50003f1566b2ee7ae.jpg"],"uri":"100x100/34b50003f1566b2ee7ae"}}],"change_time":5}
     * total : 6
     * banner : {"banners":[{"avg_color":"#CCA3A3","title":"元旦福利送不停","url_list":["http://p3.pstatp.com/obj/50f10008a8bf1dad950f","http://pb9.pstatp.com/obj/50f10008a8bf1dad950f","http://pb3.pstatp.com/obj/50f10008a8bf1dad950f"],"uri":"50f10008a8bf1dad950f","height":280,"width":750,"tab_types":[8],"id":979,"schema_url":"https://hotsoon.snssdk.com/hotsoon/in_app/activity/video/general/57/?source=hszb&dl=k2Jv"},{"avg_color":"#E0D4BC","title":"秀出你的free
     * style","url_list":["http://p1.pstatp.com/obj/50f700051c9191b15e0c","http://pb3.pstatp.com/obj/50f700051c9191b15e0c","http://pb3.pstatp.com/obj/50f700051c9191b15e0c"],"uri":"50f700051c9191b15e0c","height":280,"width":750,"tab_types":[8],"id":995,"schema_url":"https://hotsoon.snssdk.com/hotsoon/in_app/activity/video/general/58/?source=hszb&dl=k2Jv"},{"avg_color":"#FAE6DC","title":"礼物周星榜","url_list":["http://p9.pstatp.com/obj/3b1f00050526a4d6845a","http://pb1.pstatp.com/obj/3b1f00050526a4d6845a","http://pb3.pstatp.com/obj/3b1f00050526a4d6845a"],"uri":"3b1f00050526a4d6845a","height":280,"width":750,"tab_types":[1,2,8],"id":673,"schema_url":"https://hotsoon.snssdk.com/hotsoon/in_app/week_star_rank/"},{"avg_color":"#EBCEE1","title":"直播排行榜（常驻火山）","url_list":["http://p3.pstatp.com/obj/477b000175a7f1979ba2","http://pb9.pstatp.com/obj/477b000175a7f1979ba2","http://pb3.pstatp.com/obj/477b000175a7f1979ba2"],"uri":"477b000175a7f1979ba2","height":280,"width":750,"tab_types":[8],"id":146,"schema_url":"https://hotsoon.snssdk.com/hotsoon/in_app/rank/rich_anchor/?hide_nav_bar=1"},{"avg_color":"#CCA3A3","title":"直播封面标准","url_list":["http://p3.pstatp.com/obj/2bd2000f2e611afa3828","http://pb9.pstatp.com/obj/2bd2000f2e611afa3828","http://pb3.pstatp.com/obj/2bd2000f2e611afa3828"],"uri":"2bd2000f2e611afa3828","height":280,"width":750,"tab_types":[1,2,8],"id":468,"schema_url":"https://www.huoshan.com/promotion/landing_img/default/?img=fengmian2_f10ea567acc2e5a701f679ba14300202&format=jpg"},{"avg_color":"#E0D4BC","title":"绿色主播联盟","url_list":["http://p3.pstatp.com/obj/2eaa0000729306a3bb51","http://pb9.pstatp.com/obj/2eaa0000729306a3bb51","http://pb3.pstatp.com/obj/2eaa0000729306a3bb51"],"uri":"2eaa0000729306a3bb51","height":280,"width":750,"tab_types":[8],"id":452,"schema_url":"https://hotsoon.snssdk.com/hotsoon/in_app/greenlive/union_hall/"}],"total":6}
     */

    private TopButtonBean top_button;
    private long now;
    private boolean has_more;
    private long max_time;
    private int min_time;
    private RankRoundBannerBean rank_round_banner;
    private int total;
    private BannerBean banner;
    private List<?> fatal_ids;

    public TopButtonBean getTop_button() {
      return top_button;
    }

    public void setTop_button(TopButtonBean top_button) {
      this.top_button = top_button;
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

    public long getMax_time() {
      return max_time;
    }

    public void setMax_time(long max_time) {
      this.max_time = max_time;
    }

    public int getMin_time() {
      return min_time;
    }

    public void setMin_time(int min_time) {
      this.min_time = min_time;
    }

    public RankRoundBannerBean getRank_round_banner() {
      return rank_round_banner;
    }

    public void setRank_round_banner(RankRoundBannerBean rank_round_banner) {
      this.rank_round_banner = rank_round_banner;
    }

    public int getTotal() {
      return total;
    }

    public void setTotal(int total) {
      this.total = total;
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

    public static class TopButtonBean {
      /**
       * url : http://hotsoon.snssdk.com/hotsoon/in_app/rank/rich_anchor/?hide_nav_bar=1
       * icon : {"url_list":["http://p3.pstatp.com/obj/34b50003f1566b2ee7ae","http://pb9.pstatp.com/obj/34b50003f1566b2ee7ae","http://pb3.pstatp.com/obj/34b50003f1566b2ee7ae"],"uri":"34b50003f1566b2ee7ae"}
       * title : 排行榜
       */

      private String url;
      private IconBean icon;
      private String title;

      public String getUrl() {
        return url;
      }

      public void setUrl(String url) {
        this.url = url;
      }

      public IconBean getIcon() {
        return icon;
      }

      public void setIcon(IconBean icon) {
        this.icon = icon;
      }

      public String getTitle() {
        return title;
      }

      public void setTitle(String title) {
        this.title = title;
      }

      public static class IconBean {
        /**
         * url_list : ["http://p3.pstatp.com/obj/34b50003f1566b2ee7ae","http://pb9.pstatp.com/obj/34b50003f1566b2ee7ae","http://pb3.pstatp.com/obj/34b50003f1566b2ee7ae"]
         * uri : 34b50003f1566b2ee7ae
         */

        private String uri;
        private List<String> url_list;

        public String getUri() {
          return uri;
        }

        public void setUri(String uri) {
          this.uri = uri;
        }

        public List<String> getUrl_list() {
          return url_list;
        }

        public void setUrl_list(List<String> url_list) {
          this.url_list = url_list;
        }
      }
    }

    public static class RankRoundBannerBean {
      /**
       * rank_list : [{"url":"https://hotsoon.snssdk.com/hotsoon/in_app/rank/rich_anchor/?enter_type=3&hide_nav_bar=1","list":[{"user_avatar":{"url_list":["http://p3.pstatp.com/live/100x100/50f20000f94aa9a3ff7c.jpg","http://pb9.pstatp.com/live/100x100/50f20000f94aa9a3ff7c.jpg","http://pb3.pstatp.com/live/100x100/50f20000f94aa9a3ff7c.jpg"],"uri":"100x100/50f20000f94aa9a3ff7c"},"score":606933,"user_id":75828267728,"rank":1},{"user_avatar":{"url_list":["http://p1.pstatp.com/live/100x100/50f60007c549d0d4126a.jpg","http://pb3.pstatp.com/live/100x100/50f60007c549d0d4126a.jpg","http://pb3.pstatp.com/live/100x100/50f60007c549d0d4126a.jpg"],"uri":"100x100/50f60007c549d0d4126a"},"score":527252,"user_id":6277887535,"rank":2},{"user_avatar":{"url_list":["http://q.qlogo.cn/qqapp/101302986/C250E1DFABDFDB84E99612E45C6091D1/100"],"uri":"avatar_thumb/http://q.qlogo.cn/qqapp/101302986/C250E1DFABDFDB84E99612E45C6091D1/100"},"score":520745,"user_id":62887807368,"rank":3}],"name":"金主日榜","icon":{"url_list":["http://p3.pstatp.com/live/100x100/34b50003f1566b2ee7ae.jpg","http://pb9.pstatp.com/live/100x100/34b50003f1566b2ee7ae.jpg","http://pb3.pstatp.com/live/100x100/34b50003f1566b2ee7ae.jpg"],"uri":"100x100/34b50003f1566b2ee7ae"}},{"url":"https://hotsoon.snssdk.com/hotsoon/in_app/rank/rich_anchor/?enter_type=4&hide_nav_bar=1","list":[{"user_avatar":{"url_list":["http://p3.pstatp.com/live/100x100/50f30007ba62f33988aa.jpg","http://pb9.pstatp.com/live/100x100/50f30007ba62f33988aa.jpg","http://pb3.pstatp.com/live/100x100/50f30007ba62f33988aa.jpg"],"uri":"100x100/50f30007ba62f33988aa"},"score":950547,"user_id":52161112484,"rank":1},{"user_avatar":{"url_list":["http://p1.pstatp.com/live/100x100/4ec60005ea7e478a6a9d.jpg","http://pb3.pstatp.com/live/100x100/4ec60005ea7e478a6a9d.jpg","http://pb3.pstatp.com/live/100x100/4ec60005ea7e478a6a9d.jpg"],"uri":"100x100/4ec60005ea7e478a6a9d"},"score":735933,"user_id":55977492335,"rank":2},{"user_avatar":{"url_list":["http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKeurpjKLQQIJ0iaMdnJ37ricicnK2dQqKNiaagpGWORNSuesDAeGvOoicWmtbMECs9Y6YbRSYiaXNaSvrQ/0"],"uri":"avatar_thumb/http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKeurpjKLQQIJ0iaMdnJ37ricicnK2dQqKNiaagpGWORNSuesDAeGvOoicWmtbMECs9Y6YbRSYiaXNaSvrQ/0"},"score":713646,"user_id":83793893188,"rank":3}],"name":"金主昨日榜","icon":{"url_list":["http://p3.pstatp.com/live/100x100/34b50003f1566b2ee7ae.jpg","http://pb9.pstatp.com/live/100x100/34b50003f1566b2ee7ae.jpg","http://pb3.pstatp.com/live/100x100/34b50003f1566b2ee7ae.jpg"],"uri":"100x100/34b50003f1566b2ee7ae"}},{"url":"https://hotsoon.snssdk.com/hotsoon/in_app/rank/rich_anchor/?enter_type=5&hide_nav_bar=1","list":[{"user_avatar":{"url_list":["http://p1.pstatp.com/live/100x100/50f4000638e7cb7323ad.jpg","http://pb3.pstatp.com/live/100x100/50f4000638e7cb7323ad.jpg","http://pb3.pstatp.com/live/100x100/50f4000638e7cb7323ad.jpg"],"uri":"100x100/50f4000638e7cb7323ad"},"score":6772576,"user_id":83042640632,"rank":1},{"user_avatar":{"url_list":["http://p1.pstatp.com/live/100x100/34b40003182b24f69eeb.jpg","http://pb3.pstatp.com/live/100x100/34b40003182b24f69eeb.jpg","http://pb3.pstatp.com/live/100x100/34b40003182b24f69eeb.jpg"],"uri":"100x100/34b40003182b24f69eeb"},"score":3358984,"user_id":61967966520,"rank":2},{"user_avatar":{"url_list":["http://p1.pstatp.com/live/100x100/4a6c00015ebbf9c196e6.jpg","http://pb3.pstatp.com/live/100x100/4a6c00015ebbf9c196e6.jpg","http://pb3.pstatp.com/live/100x100/4a6c00015ebbf9c196e6.jpg"],"uri":"100x100/4a6c00015ebbf9c196e6"},"score":3027729,"user_id":55395362823,"rank":3}],"name":"金主周榜","icon":{"url_list":["http://p3.pstatp.com/live/100x100/34b50003f1566b2ee7ae.jpg","http://pb9.pstatp.com/live/100x100/34b50003f1566b2ee7ae.jpg","http://pb3.pstatp.com/live/100x100/34b50003f1566b2ee7ae.jpg"],"uri":"100x100/34b50003f1566b2ee7ae"}},{"url":"https://hotsoon.snssdk.com/hotsoon/in_app/rank/rich_anchor/?enter_type=1&hide_nav_bar=1","list":[{"user_avatar":{"url_list":["http://p3.pstatp.com/live/100x100/50f70006f8355e027304.jpg","http://pb9.pstatp.com/live/100x100/50f70006f8355e027304.jpg","http://pb3.pstatp.com/live/100x100/50f70006f8355e027304.jpg"],"uri":"100x100/50f70006f8355e027304"},"score":137954,"user_id":53448366085,"rank":1},{"user_avatar":{"url_list":["http://p1.pstatp.com/live/100x100/474c0007dc44f1590022.jpg","http://pb3.pstatp.com/live/100x100/474c0007dc44f1590022.jpg","http://pb3.pstatp.com/live/100x100/474c0007dc44f1590022.jpg"],"uri":"100x100/474c0007dc44f1590022"},"score":65533,"user_id":60779821574,"rank":2},{"user_avatar":{"url_list":["http://p3.pstatp.com/live/100x100/1946001f2ae1ae561228.jpg","http://pb9.pstatp.com/live/100x100/1946001f2ae1ae561228.jpg","http://pb3.pstatp.com/live/100x100/1946001f2ae1ae561228.jpg"],"uri":"100x100/1946001f2ae1ae561228"},"score":61995,"user_id":59045653904,"rank":3}],"name":"小时榜","icon":{"url_list":["http://p3.pstatp.com/live/100x100/34b50003f1566b2ee7ae.jpg","http://pb9.pstatp.com/live/100x100/34b50003f1566b2ee7ae.jpg","http://pb3.pstatp.com/live/100x100/34b50003f1566b2ee7ae.jpg"],"uri":"100x100/34b50003f1566b2ee7ae"}},{"url":"https://hotsoon.snssdk.com/hotsoon/in_app/rank/rich_anchor/?enter_type=2&hide_nav_bar=1","list":[{"user_avatar":{"url_list":["http://p3.pstatp.com/live/100x100/551b0002a75087197466.jpg","http://pb9.pstatp.com/live/100x100/551b0002a75087197466.jpg","http://pb3.pstatp.com/live/100x100/551b0002a75087197466.jpg"],"uri":"100x100/551b0002a75087197466"},"score":182952,"user_id":60399146120,"rank":1},{"user_avatar":{"url_list":["http://p3.pstatp.com/live/100x100/4d370001505093ea659f.jpg","http://pb9.pstatp.com/live/100x100/4d370001505093ea659f.jpg","http://pb3.pstatp.com/live/100x100/4d370001505093ea659f.jpg"],"uri":"100x100/4d370001505093ea659f"},"score":179437,"user_id":70072497732,"rank":2},{"user_avatar":{"url_list":["http://p1.pstatp.com/live/100x100/474100049bb08d0c9a92.jpg","http://pb3.pstatp.com/live/100x100/474100049bb08d0c9a92.jpg","http://pb3.pstatp.com/live/100x100/474100049bb08d0c9a92.jpg"],"uri":"100x100/474100049bb08d0c9a92"},"score":48757,"user_id":75186588063,"rank":3}],"name":"上一小时榜","icon":{"url_list":["http://p3.pstatp.com/live/100x100/34b50003f1566b2ee7ae.jpg","http://pb9.pstatp.com/live/100x100/34b50003f1566b2ee7ae.jpg","http://pb3.pstatp.com/live/100x100/34b50003f1566b2ee7ae.jpg"],"uri":"100x100/34b50003f1566b2ee7ae"}}]
       * change_time : 5
       */

      private int change_time;
      private List<RankListBean> rank_list;

      public int getChange_time() {
        return change_time;
      }

      public void setChange_time(int change_time) {
        this.change_time = change_time;
      }

      public List<RankListBean> getRank_list() {
        return rank_list;
      }

      public void setRank_list(List<RankListBean> rank_list) {
        this.rank_list = rank_list;
      }

      public static class RankListBean {
        /**
         * url : https://hotsoon.snssdk.com/hotsoon/in_app/rank/rich_anchor/?enter_type=3&hide_nav_bar=1
         * list : [{"user_avatar":{"url_list":["http://p3.pstatp.com/live/100x100/50f20000f94aa9a3ff7c.jpg","http://pb9.pstatp.com/live/100x100/50f20000f94aa9a3ff7c.jpg","http://pb3.pstatp.com/live/100x100/50f20000f94aa9a3ff7c.jpg"],"uri":"100x100/50f20000f94aa9a3ff7c"},"score":606933,"user_id":75828267728,"rank":1},{"user_avatar":{"url_list":["http://p1.pstatp.com/live/100x100/50f60007c549d0d4126a.jpg","http://pb3.pstatp.com/live/100x100/50f60007c549d0d4126a.jpg","http://pb3.pstatp.com/live/100x100/50f60007c549d0d4126a.jpg"],"uri":"100x100/50f60007c549d0d4126a"},"score":527252,"user_id":6277887535,"rank":2},{"user_avatar":{"url_list":["http://q.qlogo.cn/qqapp/101302986/C250E1DFABDFDB84E99612E45C6091D1/100"],"uri":"avatar_thumb/http://q.qlogo.cn/qqapp/101302986/C250E1DFABDFDB84E99612E45C6091D1/100"},"score":520745,"user_id":62887807368,"rank":3}]
         * name : 金主日榜
         * icon : {"url_list":["http://p3.pstatp.com/live/100x100/34b50003f1566b2ee7ae.jpg","http://pb9.pstatp.com/live/100x100/34b50003f1566b2ee7ae.jpg","http://pb3.pstatp.com/live/100x100/34b50003f1566b2ee7ae.jpg"],"uri":"100x100/34b50003f1566b2ee7ae"}
         */

        private String url;
        private String name;
        private IconBeanX icon;
        private List<ListBean> list;

        public String getUrl() {
          return url;
        }

        public void setUrl(String url) {
          this.url = url;
        }

        public String getName() {
          return name;
        }

        public void setName(String name) {
          this.name = name;
        }

        public IconBeanX getIcon() {
          return icon;
        }

        public void setIcon(IconBeanX icon) {
          this.icon = icon;
        }

        public List<ListBean> getList() {
          return list;
        }

        public void setList(List<ListBean> list) {
          this.list = list;
        }

        public static class IconBeanX {
          /**
           * url_list : ["http://p3.pstatp.com/live/100x100/34b50003f1566b2ee7ae.jpg","http://pb9.pstatp.com/live/100x100/34b50003f1566b2ee7ae.jpg","http://pb3.pstatp.com/live/100x100/34b50003f1566b2ee7ae.jpg"]
           * uri : 100x100/34b50003f1566b2ee7ae
           */

          private String uri;
          private List<String> url_list;

          public String getUri() {
            return uri;
          }

          public void setUri(String uri) {
            this.uri = uri;
          }

          public List<String> getUrl_list() {
            return url_list;
          }

          public void setUrl_list(List<String> url_list) {
            this.url_list = url_list;
          }
        }

        public static class ListBean {
          /**
           * user_avatar : {"url_list":["http://p3.pstatp.com/live/100x100/50f20000f94aa9a3ff7c.jpg","http://pb9.pstatp.com/live/100x100/50f20000f94aa9a3ff7c.jpg","http://pb3.pstatp.com/live/100x100/50f20000f94aa9a3ff7c.jpg"],"uri":"100x100/50f20000f94aa9a3ff7c"}
           * score : 606933
           * user_id : 75828267728
           * rank : 1
           */

          private UserAvatarBean user_avatar;
          private int score;
          private long user_id;
          private int rank;

          public UserAvatarBean getUser_avatar() {
            return user_avatar;
          }

          public void setUser_avatar(UserAvatarBean user_avatar) {
            this.user_avatar = user_avatar;
          }

          public int getScore() {
            return score;
          }

          public void setScore(int score) {
            this.score = score;
          }

          public long getUser_id() {
            return user_id;
          }

          public void setUser_id(long user_id) {
            this.user_id = user_id;
          }

          public int getRank() {
            return rank;
          }

          public void setRank(int rank) {
            this.rank = rank;
          }

          public static class UserAvatarBean {
            /**
             * url_list : ["http://p3.pstatp.com/live/100x100/50f20000f94aa9a3ff7c.jpg","http://pb9.pstatp.com/live/100x100/50f20000f94aa9a3ff7c.jpg","http://pb3.pstatp.com/live/100x100/50f20000f94aa9a3ff7c.jpg"]
             * uri : 100x100/50f20000f94aa9a3ff7c
             */

            private String uri;
            private List<String> url_list;

            public String getUri() {
              return uri;
            }

            public void setUri(String uri) {
              this.uri = uri;
            }

            public List<String> getUrl_list() {
              return url_list;
            }

            public void setUrl_list(List<String> url_list) {
              this.url_list = url_list;
            }
          }
        }
      }
    }

    public static class BannerBean {
      /**
       * banners : [{"avg_color":"#CCA3A3","title":"元旦福利送不停","url_list":["http://p3.pstatp.com/obj/50f10008a8bf1dad950f","http://pb9.pstatp.com/obj/50f10008a8bf1dad950f","http://pb3.pstatp.com/obj/50f10008a8bf1dad950f"],"uri":"50f10008a8bf1dad950f","height":280,"width":750,"tab_types":[8],"id":979,"schema_url":"https://hotsoon.snssdk.com/hotsoon/in_app/activity/video/general/57/?source=hszb&dl=k2Jv"},{"avg_color":"#E0D4BC","title":"秀出你的free
       * style","url_list":["http://p1.pstatp.com/obj/50f700051c9191b15e0c","http://pb3.pstatp.com/obj/50f700051c9191b15e0c","http://pb3.pstatp.com/obj/50f700051c9191b15e0c"],"uri":"50f700051c9191b15e0c","height":280,"width":750,"tab_types":[8],"id":995,"schema_url":"https://hotsoon.snssdk.com/hotsoon/in_app/activity/video/general/58/?source=hszb&dl=k2Jv"},{"avg_color":"#FAE6DC","title":"礼物周星榜","url_list":["http://p9.pstatp.com/obj/3b1f00050526a4d6845a","http://pb1.pstatp.com/obj/3b1f00050526a4d6845a","http://pb3.pstatp.com/obj/3b1f00050526a4d6845a"],"uri":"3b1f00050526a4d6845a","height":280,"width":750,"tab_types":[1,2,8],"id":673,"schema_url":"https://hotsoon.snssdk.com/hotsoon/in_app/week_star_rank/"},{"avg_color":"#EBCEE1","title":"直播排行榜（常驻火山）","url_list":["http://p3.pstatp.com/obj/477b000175a7f1979ba2","http://pb9.pstatp.com/obj/477b000175a7f1979ba2","http://pb3.pstatp.com/obj/477b000175a7f1979ba2"],"uri":"477b000175a7f1979ba2","height":280,"width":750,"tab_types":[8],"id":146,"schema_url":"https://hotsoon.snssdk.com/hotsoon/in_app/rank/rich_anchor/?hide_nav_bar=1"},{"avg_color":"#CCA3A3","title":"直播封面标准","url_list":["http://p3.pstatp.com/obj/2bd2000f2e611afa3828","http://pb9.pstatp.com/obj/2bd2000f2e611afa3828","http://pb3.pstatp.com/obj/2bd2000f2e611afa3828"],"uri":"2bd2000f2e611afa3828","height":280,"width":750,"tab_types":[1,2,8],"id":468,"schema_url":"https://www.huoshan.com/promotion/landing_img/default/?img=fengmian2_f10ea567acc2e5a701f679ba14300202&format=jpg"},{"avg_color":"#E0D4BC","title":"绿色主播联盟","url_list":["http://p3.pstatp.com/obj/2eaa0000729306a3bb51","http://pb9.pstatp.com/obj/2eaa0000729306a3bb51","http://pb3.pstatp.com/obj/2eaa0000729306a3bb51"],"uri":"2eaa0000729306a3bb51","height":280,"width":750,"tab_types":[8],"id":452,"schema_url":"https://hotsoon.snssdk.com/hotsoon/in_app/greenlive/union_hall/"}]
       * total : 6
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
         * avg_color : #CCA3A3
         * title : 元旦福利送不停
         * url_list : ["http://p3.pstatp.com/obj/50f10008a8bf1dad950f","http://pb9.pstatp.com/obj/50f10008a8bf1dad950f","http://pb3.pstatp.com/obj/50f10008a8bf1dad950f"]
         * uri : 50f10008a8bf1dad950f
         * height : 280
         * width : 750
         * tab_types : [8]
         * id : 979
         * schema_url : https://hotsoon.snssdk.com/hotsoon/in_app/activity/video/general/57/?source=hszb&dl=k2Jv
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
