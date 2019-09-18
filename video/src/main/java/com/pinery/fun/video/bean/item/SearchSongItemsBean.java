package com.pinery.fun.video.bean.item;

import java.util.List;

/**
 * Created by gujian on 2019/4/21.
 */

public class SearchSongItemsBean {
  private List<SongsBean> songs;

  public List<SongsBean> getSongs() {
    return songs;
  }

  public void setSongs(List<SongsBean> songs) {
    this.songs = songs;
  }

  public static class SongsBean {
    private SongBean song;
    private List<String> highlight;

    public SongBean getSong() {
      return song;
    }

    public void setSong(SongBean song) {
      this.song = song;
    }

    public List<String> getHighlight() {
      return highlight;
    }

    public void setHighlight(List<String> highlight) {
      this.highlight = highlight;
    }

    public static class SongBean {
      private String extra;
      private int source_platform;
      private AudioTrackBean audio_track;
      private String lyric;
      private int duration;
      private long id;
      private String album;
      private String author;
      private PlayUrlBean play_url;
      private String share_url;
      private String id_str;
      private String schema_url;
      private String share_title;
      private int status;
      private int lyric_type;
      private CoverLargeBean cover_large;
      private CoverThumbBean cover_thumb;
      private CoverHdBean cover_hd;
      private String title;
      private int video_cnt;
      private String uri;
      private String share_description;
      private CoverMediumBean cover_medium;
      private List<String> url_list;

      public String getExtra() {
        return extra;
      }

      public void setExtra(String extra) {
        this.extra = extra;
      }

      public int getSource_platform() {
        return source_platform;
      }

      public void setSource_platform(int source_platform) {
        this.source_platform = source_platform;
      }

      public AudioTrackBean getAudio_track() {
        return audio_track;
      }

      public void setAudio_track(AudioTrackBean audio_track) {
        this.audio_track = audio_track;
      }

      public String getLyric() {
        return lyric;
      }

      public void setLyric(String lyric) {
        this.lyric = lyric;
      }

      public int getDuration() {
        return duration;
      }

      public void setDuration(int duration) {
        this.duration = duration;
      }

      public long getId() {
        return id;
      }

      public void setId(long id) {
        this.id = id;
      }

      public String getAlbum() {
        return album;
      }

      public void setAlbum(String album) {
        this.album = album;
      }

      public String getAuthor() {
        return author;
      }

      public void setAuthor(String author) {
        this.author = author;
      }

      public PlayUrlBean getPlay_url() {
        return play_url;
      }

      public void setPlay_url(PlayUrlBean play_url) {
        this.play_url = play_url;
      }

      public String getShare_url() {
        return share_url;
      }

      public void setShare_url(String share_url) {
        this.share_url = share_url;
      }

      public String getId_str() {
        return id_str;
      }

      public void setId_str(String id_str) {
        this.id_str = id_str;
      }

      public String getSchema_url() {
        return schema_url;
      }

      public void setSchema_url(String schema_url) {
        this.schema_url = schema_url;
      }

      public String getShare_title() {
        return share_title;
      }

      public void setShare_title(String share_title) {
        this.share_title = share_title;
      }

      public int getStatus() {
        return status;
      }

      public void setStatus(int status) {
        this.status = status;
      }

      public int getLyric_type() {
        return lyric_type;
      }

      public void setLyric_type(int lyric_type) {
        this.lyric_type = lyric_type;
      }

      public CoverLargeBean getCover_large() {
        return cover_large;
      }

      public void setCover_large(CoverLargeBean cover_large) {
        this.cover_large = cover_large;
      }

      public CoverThumbBean getCover_thumb() {
        return cover_thumb;
      }

      public void setCover_thumb(CoverThumbBean cover_thumb) {
        this.cover_thumb = cover_thumb;
      }

      public CoverHdBean getCover_hd() {
        return cover_hd;
      }

      public void setCover_hd(CoverHdBean cover_hd) {
        this.cover_hd = cover_hd;
      }

      public String getTitle() {
        return title;
      }

      public void setTitle(String title) {
        this.title = title;
      }

      public int getVideo_cnt() {
        return video_cnt;
      }

      public void setVideo_cnt(int video_cnt) {
        this.video_cnt = video_cnt;
      }

      public String getUri() {
        return uri;
      }

      public void setUri(String uri) {
        this.uri = uri;
      }

      public String getShare_description() {
        return share_description;
      }

      public void setShare_description(String share_description) {
        this.share_description = share_description;
      }

      public CoverMediumBean getCover_medium() {
        return cover_medium;
      }

      public void setCover_medium(CoverMediumBean cover_medium) {
        this.cover_medium = cover_medium;
      }

      public List<String> getUrl_list() {
        return url_list;
      }

      public void setUrl_list(List<String> url_list) {
        this.url_list = url_list;
      }

      public static class AudioTrackBean {
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

      public static class PlayUrlBean {
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

      public static class CoverLargeBean {
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

      public static class CoverThumbBean {
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

      public static class CoverHdBean {
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

      public static class CoverMediumBean {
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
