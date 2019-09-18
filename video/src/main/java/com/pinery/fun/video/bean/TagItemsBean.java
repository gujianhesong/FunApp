package com.pinery.fun.video.bean;

import com.pinery.fun.video.bean.item.TagItemBean;
import com.pinery.fun.video.bean.item.UserBean;
import java.util.List;

/**
 * Created by gujian on 2019/3/20.
 */

public class TagItemsBean {

  private int status_code;
  private ExtraBean extra;
  private List<DataBean> data;

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

  public List<DataBean> getData() {
    return data;
  }

  public void setData(List<DataBean> data) {
    this.data = data;
  }

  public static class ExtraBean {
    private boolean has_more;
    private long now;
    private int offset;
    private List<?> fatal_ids;

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

    public int getOffset() {
      return offset;
    }

    public void setOffset(int offset) {
      this.offset = offset;
    }

    public List<?> getFatal_ids() {
      return fatal_ids;
    }

    public void setFatal_ids(List<?> fatal_ids) {
      this.fatal_ids = fatal_ids;
    }
  }

  public static class DataBean {
    private ContentBean content;
    private int type;

    public ContentBean getContent() {
      return content;
    }

    public void setContent(ContentBean content) {
      this.content = content;
    }

    public int getType() {
      return type;
    }

    public void setType(int type) {
      this.type = type;
    }

    public static class ContentBean {
      private String description;
      private HashtagBean hashtag;
      private UserBean user;
      private List<TagItemBean> items;

      public String getDescription() {
        return description;
      }

      public void setDescription(String description) {
        this.description = description;
      }

      public HashtagBean getHashtag() {
        return hashtag;
      }

      public void setHashtag(HashtagBean hashtag) {
        this.hashtag = hashtag;
      }

      public UserBean getUser() {
        return user;
      }

      public void setUser(UserBean user) {
        this.user = user;
      }

      public List<TagItemBean> getItems() {
        return items;
      }

      public void setItems(List<TagItemBean> items) {
        this.items = items;
      }

      public static class HashtagBean {
        private int status;
        private boolean is_visible;
        private String title;
        private String entrance_desc;
        private int video_cnt;
        private DescH5Bean desc_h5;
        private int fav_cnt;
        private String id_string;
        private String share_h5_url;
        private long id;

        public int getStatus() {
          return status;
        }

        public void setStatus(int status) {
          this.status = status;
        }

        public boolean isIs_visible() {
          return is_visible;
        }

        public void setIs_visible(boolean is_visible) {
          this.is_visible = is_visible;
        }

        public String getTitle() {
          return title;
        }

        public void setTitle(String title) {
          this.title = title;
        }

        public String getEntrance_desc() {
          return entrance_desc;
        }

        public void setEntrance_desc(String entrance_desc) {
          this.entrance_desc = entrance_desc;
        }

        public int getVideo_cnt() {
          return video_cnt;
        }

        public void setVideo_cnt(int video_cnt) {
          this.video_cnt = video_cnt;
        }

        public DescH5Bean getDesc_h5() {
          return desc_h5;
        }

        public void setDesc_h5(DescH5Bean desc_h5) {
          this.desc_h5 = desc_h5;
        }

        public int getFav_cnt() {
          return fav_cnt;
        }

        public void setFav_cnt(int fav_cnt) {
          this.fav_cnt = fav_cnt;
        }

        public String getId_string() {
          return id_string;
        }

        public void setId_string(String id_string) {
          this.id_string = id_string;
        }

        public String getShare_h5_url() {
          return share_h5_url;
        }

        public void setShare_h5_url(String share_h5_url) {
          this.share_h5_url = share_h5_url;
        }

        public long getId() {
          return id;
        }

        public void setId(long id) {
          this.id = id;
        }

        public static class DescH5Bean {
          private String url;
          private int width;
          private int height;

          public String getUrl() {
            return url;
          }

          public void setUrl(String url) {
            this.url = url;
          }

          public int getWidth() {
            return width;
          }

          public void setWidth(int width) {
            this.width = width;
          }

          public int getHeight() {
            return height;
          }

          public void setHeight(int height) {
            this.height = height;
          }
        }
      }


    }
  }
}
