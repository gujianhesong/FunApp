package com.pinery.fun.video.bean;

import com.pinery.fun.video.bean.item.SearchSongItemsBean;
import com.pinery.fun.video.bean.item.SearchTagItemsBean;
import com.pinery.fun.video.bean.item.SearchUserItemsBean;
import com.pinery.fun.video.bean.item.SearchVideoItemsBean;
import java.util.List;

/**
 * Created by gujian on 2019/4/20.
 */

public class SearchBean {

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
    private long now;
    private boolean has_more;
    private int query_id;
    private String req_id;
    private int offset;
    private String query;
    private int total;
    private String search_id;
    private List<?> fatal_ids;

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

    public int getQuery_id() {
      return query_id;
    }

    public void setQuery_id(int query_id) {
      this.query_id = query_id;
    }

    public String getReq_id() {
      return req_id;
    }

    public void setReq_id(String req_id) {
      this.req_id = req_id;
    }

    public int getOffset() {
      return offset;
    }

    public void setOffset(int offset) {
      this.offset = offset;
    }

    public String getQuery() {
      return query;
    }

    public void setQuery(String query) {
      this.query = query;
    }

    public int getTotal() {
      return total;
    }

    public void setTotal(int total) {
      this.total = total;
    }

    public String getSearch_id() {
      return search_id;
    }

    public void setSearch_id(String search_id) {
      this.search_id = search_id;
    }

    public List<?> getFatal_ids() {
      return fatal_ids;
    }

    public void setFatal_ids(List<?> fatal_ids) {
      this.fatal_ids = fatal_ids;
    }
  }

  public static class DataBean {
    private SearchVideoItemsBean item_result;
    private SearchUserItemsBean user_result;
    private SearchTagItemsBean hashtag_result;
    private SearchSongItemsBean song_result;
    private int type;

    public SearchVideoItemsBean getItem_result() {
      return item_result;
    }

    public void setItem_result(SearchVideoItemsBean item_result) {
      this.item_result = item_result;
    }

    public SearchUserItemsBean getUser_result() {
      return user_result;
    }

    public void setUser_result(SearchUserItemsBean user_result) {
      this.user_result = user_result;
    }

    public SearchTagItemsBean getHashtag_result() {
      return hashtag_result;
    }

    public void setHashtag_result(SearchTagItemsBean hashtag_result) {
      this.hashtag_result = hashtag_result;
    }

    public SearchSongItemsBean getSong_result() {
      return song_result;
    }

    public void setSong_result(SearchSongItemsBean song_result) {
      this.song_result = song_result;
    }

    public int getType() {
      return type;
    }

    public void setType(int type) {
      this.type = type;
    }
  }
}
