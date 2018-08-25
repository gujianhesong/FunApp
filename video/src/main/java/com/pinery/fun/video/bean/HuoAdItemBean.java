package com.pinery.fun.video.bean;

import java.util.List;

/**
 * 广告
 * Created by gujian on 2018-08-25.
 */

public class HuoAdItemBean extends BaseVideoItemBean{

  /**
   * type : 5
   * rid : 2018082510574701001502415704161B
   * data : {"log_extra":"{\"ad_price\":\"W4DFqwADllRbgMWrAAOWVA88hiUJtTJredDmrQ\",\"convert_id\":0,\"orit\":30001,\"req_id\":\"2018082510574701001502415704161B\",\"rit\":30001,\"send_rit\":30001,\"tpl_id\":10019}","text":"【团购】正宗06年老班章，才这个价？后悔早买了吧","cell_width":375,"image_list":[{"width":375,"url_list":["http://sf3-ttcdn-tos.pstatp.com/img/web.business.image/201808255d0d6449c6e34b5c4b15bcba~640x0.image","http://sf6-ttcdn-tos.pstatp.com/img/web.business.image/201808255d0d6449c6e34b5c4b15bcba~640x0.image","http://sf1-ttcdn-tos.pstatp.com/img/web.business.image/201808255d0d6449c6e34b5c4b15bcba~640x0.image"],"uri":"large/web.business.image/201808255d0d6449c6e34b5c4b15bcba","height":604}],"web_url":"https://haohuo.snssdk.com/views/product/item.html?id=3294517611798383525&origin_type=1&tt_project_id=6","id":1609730527869966,"filter_words":[{"is_selected":false,"id":"4:2","name":"看过了"},{"is_selected":false,"id":"2:0","name":"来源:一品轩"},{"is_selected":false,"id":"1:186","name":"茶/饮料"},{"is_selected":false,"id":"1:7","name":"食品饮料"}],"author":{"nickname":"一品轩","avatar":{"url_list":["http://p0.pstatp.com/origin/3796/2975850990"],"uri":"http://p0.pstatp.com/origin/3796/2975850990"}},"click_track_url_list":[],"video_info":{"thumb_height":720,"play_track_url_list":[],"thumb_width":1280,"url_list":["https://api.huoshan.com/hotsoon/item/video/_playback/?video_id=v02033760000bdu171eue3moghvq7t3g&line=0&app_id=1112","https://api.huoshan.com/hotsoon/item/video/_playback/?video_id=v02033760000bdu171eue3moghvq7t3g&line=1&app_id=1112"],"video_id":"v02033760000bdu171eue3moghvq7t3g","effective_play_time":0,"effective_play_track_url_list":null,"width":0,"playover_track_url_list":[],"video_signature":"","video_transpose":0,"img_uri":"","duration":0,"video_group_id":6593456242453119240,"video_duration":13,"height":0},"share_url":"","label":"广告","cell_style":2,"share_title":"【团购】正宗06年老班章，才这个价？后悔早买了吧","track_url_list":[],"type":"web","cell_height":604,"draw_log_extra":"{\"ad_price\":\"W4DFqwADlnBbgMWrAAOWcBwh4e3clJa0wECh9A\",\"convert_id\":0,\"orit\":30001,\"req_id\":\"2018082510574701001502415704161B\",\"rit\":30003,\"send_rit\":30001,\"tpl_id\":10019}","share_icon":{"width":375,"url_list":["http://sf3-ttcdn-tos.pstatp.com/img/web.business.image/201808255d0d6449c6e34b5c4b15bcba~640x0.image","http://sf6-ttcdn-tos.pstatp.com/img/web.business.image/201808255d0d6449c6e34b5c4b15bcba~640x0.image","http://sf1-ttcdn-tos.pstatp.com/img/web.business.image/201808255d0d6449c6e34b5c4b15bcba~640x0.image"],"uri":"large/web.business.image/201808255d0d6449c6e34b5c4b15bcba","height":604},"button_text":"点击查看","show_type":2,"web_title":"一品轩","allow_comment":false,"hide_nickname":true,"digg_count":4223,"allow_dislike":true,"share_description":"【团购】正宗06年老班章，才这个价？后悔早买了吧","allow_share":true}
   */

  private int type;
  private String rid;
  private DataBean data;

  public int getType() {
    return type;
  }

  public void setType(int type) {
    this.type = type;
  }

  public String getRid() {
    return rid;
  }

  public void setRid(String rid) {
    this.rid = rid;
  }

  public DataBean getData() {
    return data;
  }

  public void setData(DataBean data) {
    this.data = data;
  }

  public static class DataBean {
    /**
     * log_extra : {"ad_price":"W4DFqwADllRbgMWrAAOWVA88hiUJtTJredDmrQ","convert_id":0,"orit":30001,"req_id":"2018082510574701001502415704161B","rit":30001,"send_rit":30001,"tpl_id":10019}
     * text : 【团购】正宗06年老班章，才这个价？后悔早买了吧
     * cell_width : 375
     * image_list : [{"width":375,"url_list":["http://sf3-ttcdn-tos.pstatp.com/img/web.business.image/201808255d0d6449c6e34b5c4b15bcba~640x0.image","http://sf6-ttcdn-tos.pstatp.com/img/web.business.image/201808255d0d6449c6e34b5c4b15bcba~640x0.image","http://sf1-ttcdn-tos.pstatp.com/img/web.business.image/201808255d0d6449c6e34b5c4b15bcba~640x0.image"],"uri":"large/web.business.image/201808255d0d6449c6e34b5c4b15bcba","height":604}]
     * web_url : https://haohuo.snssdk.com/views/product/item.html?id=3294517611798383525&origin_type=1&tt_project_id=6
     * id : 1609730527869966
     * filter_words : [{"is_selected":false,"id":"4:2","name":"看过了"},{"is_selected":false,"id":"2:0","name":"来源:一品轩"},{"is_selected":false,"id":"1:186","name":"茶/饮料"},{"is_selected":false,"id":"1:7","name":"食品饮料"}]
     * author : {"nickname":"一品轩","avatar":{"url_list":["http://p0.pstatp.com/origin/3796/2975850990"],"uri":"http://p0.pstatp.com/origin/3796/2975850990"}}
     * click_track_url_list : []
     * video_info : {"thumb_height":720,"play_track_url_list":[],"thumb_width":1280,"url_list":["https://api.huoshan.com/hotsoon/item/video/_playback/?video_id=v02033760000bdu171eue3moghvq7t3g&line=0&app_id=1112","https://api.huoshan.com/hotsoon/item/video/_playback/?video_id=v02033760000bdu171eue3moghvq7t3g&line=1&app_id=1112"],"video_id":"v02033760000bdu171eue3moghvq7t3g","effective_play_time":0,"effective_play_track_url_list":null,"width":0,"playover_track_url_list":[],"video_signature":"","video_transpose":0,"img_uri":"","duration":0,"video_group_id":6593456242453119240,"video_duration":13,"height":0}
     * share_url :
     * label : 广告
     * cell_style : 2
     * share_title : 【团购】正宗06年老班章，才这个价？后悔早买了吧
     * track_url_list : []
     * type : web
     * cell_height : 604
     * draw_log_extra : {"ad_price":"W4DFqwADlnBbgMWrAAOWcBwh4e3clJa0wECh9A","convert_id":0,"orit":30001,"req_id":"2018082510574701001502415704161B","rit":30003,"send_rit":30001,"tpl_id":10019}
     * share_icon : {"width":375,"url_list":["http://sf3-ttcdn-tos.pstatp.com/img/web.business.image/201808255d0d6449c6e34b5c4b15bcba~640x0.image","http://sf6-ttcdn-tos.pstatp.com/img/web.business.image/201808255d0d6449c6e34b5c4b15bcba~640x0.image","http://sf1-ttcdn-tos.pstatp.com/img/web.business.image/201808255d0d6449c6e34b5c4b15bcba~640x0.image"],"uri":"large/web.business.image/201808255d0d6449c6e34b5c4b15bcba","height":604}
     * button_text : 点击查看
     * show_type : 2
     * web_title : 一品轩
     * allow_comment : false
     * hide_nickname : true
     * digg_count : 4223
     * allow_dislike : true
     * share_description : 【团购】正宗06年老班章，才这个价？后悔早买了吧
     * allow_share : true
     */

    private String log_extra;
    private String text;
    private int cell_width;
    private String web_url;
    private long id;
    private AuthorBean author;
    private VideoInfoBean video_info;
    private String share_url;
    private String label;
    private int cell_style;
    private String share_title;
    private String type;
    private int cell_height;
    private String draw_log_extra;
    private ShareIconBean share_icon;
    private String button_text;
    private int show_type;
    private String web_title;
    private boolean allow_comment;
    private boolean hide_nickname;
    private int digg_count;
    private boolean allow_dislike;
    private String share_description;
    private boolean allow_share;
    private List<ImageListBean> image_list;
    private List<FilterWordsBean> filter_words;
    private List<?> click_track_url_list;
    private List<?> track_url_list;

    public String getLog_extra() {
      return log_extra;
    }

    public void setLog_extra(String log_extra) {
      this.log_extra = log_extra;
    }

    public String getText() {
      return text;
    }

    public void setText(String text) {
      this.text = text;
    }

    public int getCell_width() {
      return cell_width;
    }

    public void setCell_width(int cell_width) {
      this.cell_width = cell_width;
    }

    public String getWeb_url() {
      return web_url;
    }

    public void setWeb_url(String web_url) {
      this.web_url = web_url;
    }

    public long getId() {
      return id;
    }

    public void setId(long id) {
      this.id = id;
    }

    public AuthorBean getAuthor() {
      return author;
    }

    public void setAuthor(AuthorBean author) {
      this.author = author;
    }

    public VideoInfoBean getVideo_info() {
      return video_info;
    }

    public void setVideo_info(VideoInfoBean video_info) {
      this.video_info = video_info;
    }

    public String getShare_url() {
      return share_url;
    }

    public void setShare_url(String share_url) {
      this.share_url = share_url;
    }

    public String getLabel() {
      return label;
    }

    public void setLabel(String label) {
      this.label = label;
    }

    public int getCell_style() {
      return cell_style;
    }

    public void setCell_style(int cell_style) {
      this.cell_style = cell_style;
    }

    public String getShare_title() {
      return share_title;
    }

    public void setShare_title(String share_title) {
      this.share_title = share_title;
    }

    public String getType() {
      return type;
    }

    public void setType(String type) {
      this.type = type;
    }

    public int getCell_height() {
      return cell_height;
    }

    public void setCell_height(int cell_height) {
      this.cell_height = cell_height;
    }

    public String getDraw_log_extra() {
      return draw_log_extra;
    }

    public void setDraw_log_extra(String draw_log_extra) {
      this.draw_log_extra = draw_log_extra;
    }

    public ShareIconBean getShare_icon() {
      return share_icon;
    }

    public void setShare_icon(ShareIconBean share_icon) {
      this.share_icon = share_icon;
    }

    public String getButton_text() {
      return button_text;
    }

    public void setButton_text(String button_text) {
      this.button_text = button_text;
    }

    public int getShow_type() {
      return show_type;
    }

    public void setShow_type(int show_type) {
      this.show_type = show_type;
    }

    public String getWeb_title() {
      return web_title;
    }

    public void setWeb_title(String web_title) {
      this.web_title = web_title;
    }

    public boolean isAllow_comment() {
      return allow_comment;
    }

    public void setAllow_comment(boolean allow_comment) {
      this.allow_comment = allow_comment;
    }

    public boolean isHide_nickname() {
      return hide_nickname;
    }

    public void setHide_nickname(boolean hide_nickname) {
      this.hide_nickname = hide_nickname;
    }

    public int getDigg_count() {
      return digg_count;
    }

    public void setDigg_count(int digg_count) {
      this.digg_count = digg_count;
    }

    public boolean isAllow_dislike() {
      return allow_dislike;
    }

    public void setAllow_dislike(boolean allow_dislike) {
      this.allow_dislike = allow_dislike;
    }

    public String getShare_description() {
      return share_description;
    }

    public void setShare_description(String share_description) {
      this.share_description = share_description;
    }

    public boolean isAllow_share() {
      return allow_share;
    }

    public void setAllow_share(boolean allow_share) {
      this.allow_share = allow_share;
    }

    public List<ImageListBean> getImage_list() {
      return image_list;
    }

    public void setImage_list(List<ImageListBean> image_list) {
      this.image_list = image_list;
    }

    public List<FilterWordsBean> getFilter_words() {
      return filter_words;
    }

    public void setFilter_words(List<FilterWordsBean> filter_words) {
      this.filter_words = filter_words;
    }

    public List<?> getClick_track_url_list() {
      return click_track_url_list;
    }

    public void setClick_track_url_list(List<?> click_track_url_list) {
      this.click_track_url_list = click_track_url_list;
    }

    public List<?> getTrack_url_list() {
      return track_url_list;
    }

    public void setTrack_url_list(List<?> track_url_list) {
      this.track_url_list = track_url_list;
    }

    public static class AuthorBean {
      /**
       * nickname : 一品轩
       * avatar : {"url_list":["http://p0.pstatp.com/origin/3796/2975850990"],"uri":"http://p0.pstatp.com/origin/3796/2975850990"}
       */

      private String nickname;
      private AvatarBean avatar;

      public String getNickname() {
        return nickname;
      }

      public void setNickname(String nickname) {
        this.nickname = nickname;
      }

      public AvatarBean getAvatar() {
        return avatar;
      }

      public void setAvatar(AvatarBean avatar) {
        this.avatar = avatar;
      }

      public static class AvatarBean {
        /**
         * url_list : ["http://p0.pstatp.com/origin/3796/2975850990"]
         * uri : http://p0.pstatp.com/origin/3796/2975850990
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

    public static class VideoInfoBean {
      /**
       * thumb_height : 720
       * play_track_url_list : []
       * thumb_width : 1280
       * url_list : ["https://api.huoshan.com/hotsoon/item/video/_playback/?video_id=v02033760000bdu171eue3moghvq7t3g&line=0&app_id=1112","https://api.huoshan.com/hotsoon/item/video/_playback/?video_id=v02033760000bdu171eue3moghvq7t3g&line=1&app_id=1112"]
       * video_id : v02033760000bdu171eue3moghvq7t3g
       * effective_play_time : 0
       * effective_play_track_url_list : null
       * width : 0
       * playover_track_url_list : []
       * video_signature :
       * video_transpose : 0
       * img_uri :
       * duration : 0
       * video_group_id : 6593456242453119240
       * video_duration : 13
       * height : 0
       */

      private int thumb_height;
      private int thumb_width;
      private String video_id;
      private int effective_play_time;
      private Object effective_play_track_url_list;
      private int width;
      private String video_signature;
      private int video_transpose;
      private String img_uri;
      private int duration;
      private long video_group_id;
      private int video_duration;
      private int height;
      private List<?> play_track_url_list;
      private List<String> url_list;
      private List<?> playover_track_url_list;

      public int getThumb_height() {
        return thumb_height;
      }

      public void setThumb_height(int thumb_height) {
        this.thumb_height = thumb_height;
      }

      public int getThumb_width() {
        return thumb_width;
      }

      public void setThumb_width(int thumb_width) {
        this.thumb_width = thumb_width;
      }

      public String getVideo_id() {
        return video_id;
      }

      public void setVideo_id(String video_id) {
        this.video_id = video_id;
      }

      public int getEffective_play_time() {
        return effective_play_time;
      }

      public void setEffective_play_time(int effective_play_time) {
        this.effective_play_time = effective_play_time;
      }

      public Object getEffective_play_track_url_list() {
        return effective_play_track_url_list;
      }

      public void setEffective_play_track_url_list(Object effective_play_track_url_list) {
        this.effective_play_track_url_list = effective_play_track_url_list;
      }

      public int getWidth() {
        return width;
      }

      public void setWidth(int width) {
        this.width = width;
      }

      public String getVideo_signature() {
        return video_signature;
      }

      public void setVideo_signature(String video_signature) {
        this.video_signature = video_signature;
      }

      public int getVideo_transpose() {
        return video_transpose;
      }

      public void setVideo_transpose(int video_transpose) {
        this.video_transpose = video_transpose;
      }

      public String getImg_uri() {
        return img_uri;
      }

      public void setImg_uri(String img_uri) {
        this.img_uri = img_uri;
      }

      public int getDuration() {
        return duration;
      }

      public void setDuration(int duration) {
        this.duration = duration;
      }

      public long getVideo_group_id() {
        return video_group_id;
      }

      public void setVideo_group_id(long video_group_id) {
        this.video_group_id = video_group_id;
      }

      public int getVideo_duration() {
        return video_duration;
      }

      public void setVideo_duration(int video_duration) {
        this.video_duration = video_duration;
      }

      public int getHeight() {
        return height;
      }

      public void setHeight(int height) {
        this.height = height;
      }

      public List<?> getPlay_track_url_list() {
        return play_track_url_list;
      }

      public void setPlay_track_url_list(List<?> play_track_url_list) {
        this.play_track_url_list = play_track_url_list;
      }

      public List<String> getUrl_list() {
        return url_list;
      }

      public void setUrl_list(List<String> url_list) {
        this.url_list = url_list;
      }

      public List<?> getPlayover_track_url_list() {
        return playover_track_url_list;
      }

      public void setPlayover_track_url_list(List<?> playover_track_url_list) {
        this.playover_track_url_list = playover_track_url_list;
      }
    }

    public static class ShareIconBean {
      /**
       * width : 375
       * url_list : ["http://sf3-ttcdn-tos.pstatp.com/img/web.business.image/201808255d0d6449c6e34b5c4b15bcba~640x0.image","http://sf6-ttcdn-tos.pstatp.com/img/web.business.image/201808255d0d6449c6e34b5c4b15bcba~640x0.image","http://sf1-ttcdn-tos.pstatp.com/img/web.business.image/201808255d0d6449c6e34b5c4b15bcba~640x0.image"]
       * uri : large/web.business.image/201808255d0d6449c6e34b5c4b15bcba
       * height : 604
       */

      private int width;
      private String uri;
      private int height;
      private List<String> url_list;

      public int getWidth() {
        return width;
      }

      public void setWidth(int width) {
        this.width = width;
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

      public List<String> getUrl_list() {
        return url_list;
      }

      public void setUrl_list(List<String> url_list) {
        this.url_list = url_list;
      }
    }

    public static class ImageListBean {
      /**
       * width : 375
       * url_list : ["http://sf3-ttcdn-tos.pstatp.com/img/web.business.image/201808255d0d6449c6e34b5c4b15bcba~640x0.image","http://sf6-ttcdn-tos.pstatp.com/img/web.business.image/201808255d0d6449c6e34b5c4b15bcba~640x0.image","http://sf1-ttcdn-tos.pstatp.com/img/web.business.image/201808255d0d6449c6e34b5c4b15bcba~640x0.image"]
       * uri : large/web.business.image/201808255d0d6449c6e34b5c4b15bcba
       * height : 604
       */

      private int width;
      private String uri;
      private int height;
      private List<String> url_list;

      public int getWidth() {
        return width;
      }

      public void setWidth(int width) {
        this.width = width;
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

      public List<String> getUrl_list() {
        return url_list;
      }

      public void setUrl_list(List<String> url_list) {
        this.url_list = url_list;
      }
    }

    public static class FilterWordsBean {
      /**
       * is_selected : false
       * id : 4:2
       * name : 看过了
       */

      private boolean is_selected;
      private String id;
      private String name;

      public boolean isIs_selected() {
        return is_selected;
      }

      public void setIs_selected(boolean is_selected) {
        this.is_selected = is_selected;
      }

      public String getId() {
        return id;
      }

      public void setId(String id) {
        this.id = id;
      }

      public String getName() {
        return name;
      }

      public void setName(String name) {
        this.name = name;
      }
    }
  }
}
