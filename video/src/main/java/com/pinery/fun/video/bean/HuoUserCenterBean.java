package com.pinery.fun.video.bean;

import java.util.List;

/**
 * Created by gujian on 2018/9/2.
 */

public class HuoUserCenterBean {

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
    private boolean allow_be_located;
    private boolean allow_find_by_contacts;
    private boolean allow_others_download_video;
    private boolean allow_others_download_when_sharing_video;
    private boolean allow_share_show_profile;
    private boolean allow_show_in_gossip;
    private boolean allow_show_my_action;
    private boolean allow_strange_comment;
    private boolean allow_unfollower_comment;
    private AnchorLevelBean anchor_level;
    private AvatarJpgBean avatar_jpg;
    private AvatarLargeBean avatar_large;
    private AvatarMediumBean avatar_medium;
    private AvatarThumbBean avatar_thumb;
    private String bg_img_url;
    private int birthday;
    private String birthday_description;
    private boolean birthday_valid;
    private int block_status;
    private String city;
    private int cluster_follower_count;
    private int comment_restrict;
    private String constellation;
    private int disable_ichat;
    private int enable_ichat_img;
    private String encrypted_id;
    private int exp;
    private int fan_ticket_count;
    private boolean fold_stranger_chat;
    private int follow_status;
    private int gender;
    private boolean has_hashtag_item;
    private boolean hotsoon_verified;
    private String hotsoon_verified_reason;
    private int ichat_restrict_type;
    private long id;
    private String id_str;
    private int income_share_percent;
    private boolean is_follower;
    private boolean is_following;
    private int last_live_seconds_from_now;
    private int last_live_time;
    private int level;
    private boolean need_profile_guide;
    private boolean need_remind;
    private String nickname;
    private PayGradeBean pay_grade;
    private int pay_scores;
    private boolean push_comment_status;
    private boolean push_digg;
    private boolean push_follow;
    private boolean push_friend_action;
    private boolean push_ichat;
    private boolean push_status;
    private boolean push_video_post;
    private boolean push_video_recommend;
    private String share_desc;
    private String share_title;
    private String share_url;
    private int short_id;
    private String signature;
    private StatsBean stats;
    private int total_fans_count;
    private int type_a1;
    private boolean verified;
    private boolean verified_mobile;
    private String verified_reason;
    private List<TopFansBean> top_fans;
    private List<?> top_fans_weekly;

    public boolean isAllow_be_located() {
      return allow_be_located;
    }

    public void setAllow_be_located(boolean allow_be_located) {
      this.allow_be_located = allow_be_located;
    }

    public boolean isAllow_find_by_contacts() {
      return allow_find_by_contacts;
    }

    public void setAllow_find_by_contacts(boolean allow_find_by_contacts) {
      this.allow_find_by_contacts = allow_find_by_contacts;
    }

    public boolean isAllow_others_download_video() {
      return allow_others_download_video;
    }

    public void setAllow_others_download_video(boolean allow_others_download_video) {
      this.allow_others_download_video = allow_others_download_video;
    }

    public boolean isAllow_others_download_when_sharing_video() {
      return allow_others_download_when_sharing_video;
    }

    public void setAllow_others_download_when_sharing_video(
        boolean allow_others_download_when_sharing_video) {
      this.allow_others_download_when_sharing_video = allow_others_download_when_sharing_video;
    }

    public boolean isAllow_share_show_profile() {
      return allow_share_show_profile;
    }

    public void setAllow_share_show_profile(boolean allow_share_show_profile) {
      this.allow_share_show_profile = allow_share_show_profile;
    }

    public boolean isAllow_show_in_gossip() {
      return allow_show_in_gossip;
    }

    public void setAllow_show_in_gossip(boolean allow_show_in_gossip) {
      this.allow_show_in_gossip = allow_show_in_gossip;
    }

    public boolean isAllow_show_my_action() {
      return allow_show_my_action;
    }

    public void setAllow_show_my_action(boolean allow_show_my_action) {
      this.allow_show_my_action = allow_show_my_action;
    }

    public boolean isAllow_strange_comment() {
      return allow_strange_comment;
    }

    public void setAllow_strange_comment(boolean allow_strange_comment) {
      this.allow_strange_comment = allow_strange_comment;
    }

    public boolean isAllow_unfollower_comment() {
      return allow_unfollower_comment;
    }

    public void setAllow_unfollower_comment(boolean allow_unfollower_comment) {
      this.allow_unfollower_comment = allow_unfollower_comment;
    }

    public AnchorLevelBean getAnchor_level() {
      return anchor_level;
    }

    public void setAnchor_level(AnchorLevelBean anchor_level) {
      this.anchor_level = anchor_level;
    }

    public AvatarJpgBean getAvatar_jpg() {
      return avatar_jpg;
    }

    public void setAvatar_jpg(AvatarJpgBean avatar_jpg) {
      this.avatar_jpg = avatar_jpg;
    }

    public AvatarLargeBean getAvatar_large() {
      return avatar_large;
    }

    public void setAvatar_large(AvatarLargeBean avatar_large) {
      this.avatar_large = avatar_large;
    }

    public AvatarMediumBean getAvatar_medium() {
      return avatar_medium;
    }

    public void setAvatar_medium(AvatarMediumBean avatar_medium) {
      this.avatar_medium = avatar_medium;
    }

    public AvatarThumbBean getAvatar_thumb() {
      return avatar_thumb;
    }

    public void setAvatar_thumb(AvatarThumbBean avatar_thumb) {
      this.avatar_thumb = avatar_thumb;
    }

    public String getBg_img_url() {
      return bg_img_url;
    }

    public void setBg_img_url(String bg_img_url) {
      this.bg_img_url = bg_img_url;
    }

    public int getBirthday() {
      return birthday;
    }

    public void setBirthday(int birthday) {
      this.birthday = birthday;
    }

    public String getBirthday_description() {
      return birthday_description;
    }

    public void setBirthday_description(String birthday_description) {
      this.birthday_description = birthday_description;
    }

    public boolean isBirthday_valid() {
      return birthday_valid;
    }

    public void setBirthday_valid(boolean birthday_valid) {
      this.birthday_valid = birthday_valid;
    }

    public int getBlock_status() {
      return block_status;
    }

    public void setBlock_status(int block_status) {
      this.block_status = block_status;
    }

    public String getCity() {
      return city;
    }

    public void setCity(String city) {
      this.city = city;
    }

    public int getCluster_follower_count() {
      return cluster_follower_count;
    }

    public void setCluster_follower_count(int cluster_follower_count) {
      this.cluster_follower_count = cluster_follower_count;
    }

    public int getComment_restrict() {
      return comment_restrict;
    }

    public void setComment_restrict(int comment_restrict) {
      this.comment_restrict = comment_restrict;
    }

    public String getConstellation() {
      return constellation;
    }

    public void setConstellation(String constellation) {
      this.constellation = constellation;
    }

    public int getDisable_ichat() {
      return disable_ichat;
    }

    public void setDisable_ichat(int disable_ichat) {
      this.disable_ichat = disable_ichat;
    }

    public int getEnable_ichat_img() {
      return enable_ichat_img;
    }

    public void setEnable_ichat_img(int enable_ichat_img) {
      this.enable_ichat_img = enable_ichat_img;
    }

    public String getEncrypted_id() {
      return encrypted_id;
    }

    public void setEncrypted_id(String encrypted_id) {
      this.encrypted_id = encrypted_id;
    }

    public int getExp() {
      return exp;
    }

    public void setExp(int exp) {
      this.exp = exp;
    }

    public int getFan_ticket_count() {
      return fan_ticket_count;
    }

    public void setFan_ticket_count(int fan_ticket_count) {
      this.fan_ticket_count = fan_ticket_count;
    }

    public boolean isFold_stranger_chat() {
      return fold_stranger_chat;
    }

    public void setFold_stranger_chat(boolean fold_stranger_chat) {
      this.fold_stranger_chat = fold_stranger_chat;
    }

    public int getFollow_status() {
      return follow_status;
    }

    public void setFollow_status(int follow_status) {
      this.follow_status = follow_status;
    }

    public int getGender() {
      return gender;
    }

    public void setGender(int gender) {
      this.gender = gender;
    }

    public boolean isHas_hashtag_item() {
      return has_hashtag_item;
    }

    public void setHas_hashtag_item(boolean has_hashtag_item) {
      this.has_hashtag_item = has_hashtag_item;
    }

    public boolean isHotsoon_verified() {
      return hotsoon_verified;
    }

    public void setHotsoon_verified(boolean hotsoon_verified) {
      this.hotsoon_verified = hotsoon_verified;
    }

    public String getHotsoon_verified_reason() {
      return hotsoon_verified_reason;
    }

    public void setHotsoon_verified_reason(String hotsoon_verified_reason) {
      this.hotsoon_verified_reason = hotsoon_verified_reason;
    }

    public int getIchat_restrict_type() {
      return ichat_restrict_type;
    }

    public void setIchat_restrict_type(int ichat_restrict_type) {
      this.ichat_restrict_type = ichat_restrict_type;
    }

    public long getId() {
      return id;
    }

    public void setId(long id) {
      this.id = id;
    }

    public String getId_str() {
      return id_str;
    }

    public void setId_str(String id_str) {
      this.id_str = id_str;
    }

    public int getIncome_share_percent() {
      return income_share_percent;
    }

    public void setIncome_share_percent(int income_share_percent) {
      this.income_share_percent = income_share_percent;
    }

    public boolean isIs_follower() {
      return is_follower;
    }

    public void setIs_follower(boolean is_follower) {
      this.is_follower = is_follower;
    }

    public boolean isIs_following() {
      return is_following;
    }

    public void setIs_following(boolean is_following) {
      this.is_following = is_following;
    }

    public int getLast_live_seconds_from_now() {
      return last_live_seconds_from_now;
    }

    public void setLast_live_seconds_from_now(int last_live_seconds_from_now) {
      this.last_live_seconds_from_now = last_live_seconds_from_now;
    }

    public int getLast_live_time() {
      return last_live_time;
    }

    public void setLast_live_time(int last_live_time) {
      this.last_live_time = last_live_time;
    }

    public int getLevel() {
      return level;
    }

    public void setLevel(int level) {
      this.level = level;
    }

    public boolean isNeed_profile_guide() {
      return need_profile_guide;
    }

    public void setNeed_profile_guide(boolean need_profile_guide) {
      this.need_profile_guide = need_profile_guide;
    }

    public boolean isNeed_remind() {
      return need_remind;
    }

    public void setNeed_remind(boolean need_remind) {
      this.need_remind = need_remind;
    }

    public String getNickname() {
      return nickname;
    }

    public void setNickname(String nickname) {
      this.nickname = nickname;
    }

    public PayGradeBean getPay_grade() {
      return pay_grade;
    }

    public void setPay_grade(PayGradeBean pay_grade) {
      this.pay_grade = pay_grade;
    }

    public int getPay_scores() {
      return pay_scores;
    }

    public void setPay_scores(int pay_scores) {
      this.pay_scores = pay_scores;
    }

    public boolean isPush_comment_status() {
      return push_comment_status;
    }

    public void setPush_comment_status(boolean push_comment_status) {
      this.push_comment_status = push_comment_status;
    }

    public boolean isPush_digg() {
      return push_digg;
    }

    public void setPush_digg(boolean push_digg) {
      this.push_digg = push_digg;
    }

    public boolean isPush_follow() {
      return push_follow;
    }

    public void setPush_follow(boolean push_follow) {
      this.push_follow = push_follow;
    }

    public boolean isPush_friend_action() {
      return push_friend_action;
    }

    public void setPush_friend_action(boolean push_friend_action) {
      this.push_friend_action = push_friend_action;
    }

    public boolean isPush_ichat() {
      return push_ichat;
    }

    public void setPush_ichat(boolean push_ichat) {
      this.push_ichat = push_ichat;
    }

    public boolean isPush_status() {
      return push_status;
    }

    public void setPush_status(boolean push_status) {
      this.push_status = push_status;
    }

    public boolean isPush_video_post() {
      return push_video_post;
    }

    public void setPush_video_post(boolean push_video_post) {
      this.push_video_post = push_video_post;
    }

    public boolean isPush_video_recommend() {
      return push_video_recommend;
    }

    public void setPush_video_recommend(boolean push_video_recommend) {
      this.push_video_recommend = push_video_recommend;
    }

    public String getShare_desc() {
      return share_desc;
    }

    public void setShare_desc(String share_desc) {
      this.share_desc = share_desc;
    }

    public String getShare_title() {
      return share_title;
    }

    public void setShare_title(String share_title) {
      this.share_title = share_title;
    }

    public String getShare_url() {
      return share_url;
    }

    public void setShare_url(String share_url) {
      this.share_url = share_url;
    }

    public int getShort_id() {
      return short_id;
    }

    public void setShort_id(int short_id) {
      this.short_id = short_id;
    }

    public String getSignature() {
      return signature;
    }

    public void setSignature(String signature) {
      this.signature = signature;
    }

    public StatsBean getStats() {
      return stats;
    }

    public void setStats(StatsBean stats) {
      this.stats = stats;
    }

    public int getTotal_fans_count() {
      return total_fans_count;
    }

    public void setTotal_fans_count(int total_fans_count) {
      this.total_fans_count = total_fans_count;
    }

    public int getType_a1() {
      return type_a1;
    }

    public void setType_a1(int type_a1) {
      this.type_a1 = type_a1;
    }

    public boolean isVerified() {
      return verified;
    }

    public void setVerified(boolean verified) {
      this.verified = verified;
    }

    public boolean isVerified_mobile() {
      return verified_mobile;
    }

    public void setVerified_mobile(boolean verified_mobile) {
      this.verified_mobile = verified_mobile;
    }

    public String getVerified_reason() {
      return verified_reason;
    }

    public void setVerified_reason(String verified_reason) {
      this.verified_reason = verified_reason;
    }

    public List<TopFansBean> getTop_fans() {
      return top_fans;
    }

    public void setTop_fans(List<TopFansBean> top_fans) {
      this.top_fans = top_fans;
    }

    public List<?> getTop_fans_weekly() {
      return top_fans_weekly;
    }

    public void setTop_fans_weekly(List<?> top_fans_weekly) {
      this.top_fans_weekly = top_fans_weekly;
    }

    public static class AnchorLevelBean {
      private int experience;
      private int highest_experience_this_level;
      private int level;
      private int lowest_experience_this_level;
      private ProfileDialogBgBean profile_dialog_bg;
      private ProfileDialogBgBackBean profile_dialog_bg_back;
      private SmallIconBean small_icon;
      private StageLevelBean stage_level;
      private int task_decrease_experience;
      private int task_end_time;
      private int task_start_experience;
      private int task_start_time;
      private int task_target_experience;

      public int getExperience() {
        return experience;
      }

      public void setExperience(int experience) {
        this.experience = experience;
      }

      public int getHighest_experience_this_level() {
        return highest_experience_this_level;
      }

      public void setHighest_experience_this_level(int highest_experience_this_level) {
        this.highest_experience_this_level = highest_experience_this_level;
      }

      public int getLevel() {
        return level;
      }

      public void setLevel(int level) {
        this.level = level;
      }

      public int getLowest_experience_this_level() {
        return lowest_experience_this_level;
      }

      public void setLowest_experience_this_level(int lowest_experience_this_level) {
        this.lowest_experience_this_level = lowest_experience_this_level;
      }

      public ProfileDialogBgBean getProfile_dialog_bg() {
        return profile_dialog_bg;
      }

      public void setProfile_dialog_bg(ProfileDialogBgBean profile_dialog_bg) {
        this.profile_dialog_bg = profile_dialog_bg;
      }

      public ProfileDialogBgBackBean getProfile_dialog_bg_back() {
        return profile_dialog_bg_back;
      }

      public void setProfile_dialog_bg_back(ProfileDialogBgBackBean profile_dialog_bg_back) {
        this.profile_dialog_bg_back = profile_dialog_bg_back;
      }

      public SmallIconBean getSmall_icon() {
        return small_icon;
      }

      public void setSmall_icon(SmallIconBean small_icon) {
        this.small_icon = small_icon;
      }

      public StageLevelBean getStage_level() {
        return stage_level;
      }

      public void setStage_level(StageLevelBean stage_level) {
        this.stage_level = stage_level;
      }

      public int getTask_decrease_experience() {
        return task_decrease_experience;
      }

      public void setTask_decrease_experience(int task_decrease_experience) {
        this.task_decrease_experience = task_decrease_experience;
      }

      public int getTask_end_time() {
        return task_end_time;
      }

      public void setTask_end_time(int task_end_time) {
        this.task_end_time = task_end_time;
      }

      public int getTask_start_experience() {
        return task_start_experience;
      }

      public void setTask_start_experience(int task_start_experience) {
        this.task_start_experience = task_start_experience;
      }

      public int getTask_start_time() {
        return task_start_time;
      }

      public void setTask_start_time(int task_start_time) {
        this.task_start_time = task_start_time;
      }

      public int getTask_target_experience() {
        return task_target_experience;
      }

      public void setTask_target_experience(int task_target_experience) {
        this.task_target_experience = task_target_experience;
      }

      public static class ProfileDialogBgBean {
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

      public static class ProfileDialogBgBackBean {
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

      public static class SmallIconBean {
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

      public static class StageLevelBean {
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

    public static class AvatarJpgBean {
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

    public static class AvatarLargeBean {
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

    public static class AvatarMediumBean {
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

    public static class AvatarThumbBean {
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

    public static class PayGradeBean {
      private DiamondIconBean diamond_icon;
      private String grade_banner;
      private String grade_describe;
      private IconBean icon;
      private ImIconBean im_icon;
      private ImIconWithLevelBean im_icon_with_level;
      private int level;
      private LiveIconBean live_icon;
      private String name;
      private NewImIconWithLevelBean new_im_icon_with_level;
      private NewLiveIconBean new_live_icon;
      private NewNavLiveIconBean new_nav_live_icon;
      private int next_diamond;
      private NextIconBean next_icon;
      private String next_name;
      private int now_diamond;
      private int pay_diamond_bak;
      private ProfileDialogBgBeanX profile_dialog_bg;
      private ProfileDialogBgBackBeanX profile_dialog_bg_back;
      private int screen_chat_type;
      private int this_grade_max_diamond;
      private int this_grade_min_diamond;
      private int total_diamond_count;
      private int upgrade_need_consume;
      private List<GradeIconListBean> grade_icon_list;

      public DiamondIconBean getDiamond_icon() {
        return diamond_icon;
      }

      public void setDiamond_icon(DiamondIconBean diamond_icon) {
        this.diamond_icon = diamond_icon;
      }

      public String getGrade_banner() {
        return grade_banner;
      }

      public void setGrade_banner(String grade_banner) {
        this.grade_banner = grade_banner;
      }

      public String getGrade_describe() {
        return grade_describe;
      }

      public void setGrade_describe(String grade_describe) {
        this.grade_describe = grade_describe;
      }

      public IconBean getIcon() {
        return icon;
      }

      public void setIcon(IconBean icon) {
        this.icon = icon;
      }

      public ImIconBean getIm_icon() {
        return im_icon;
      }

      public void setIm_icon(ImIconBean im_icon) {
        this.im_icon = im_icon;
      }

      public ImIconWithLevelBean getIm_icon_with_level() {
        return im_icon_with_level;
      }

      public void setIm_icon_with_level(ImIconWithLevelBean im_icon_with_level) {
        this.im_icon_with_level = im_icon_with_level;
      }

      public int getLevel() {
        return level;
      }

      public void setLevel(int level) {
        this.level = level;
      }

      public LiveIconBean getLive_icon() {
        return live_icon;
      }

      public void setLive_icon(LiveIconBean live_icon) {
        this.live_icon = live_icon;
      }

      public String getName() {
        return name;
      }

      public void setName(String name) {
        this.name = name;
      }

      public NewImIconWithLevelBean getNew_im_icon_with_level() {
        return new_im_icon_with_level;
      }

      public void setNew_im_icon_with_level(NewImIconWithLevelBean new_im_icon_with_level) {
        this.new_im_icon_with_level = new_im_icon_with_level;
      }

      public NewLiveIconBean getNew_live_icon() {
        return new_live_icon;
      }

      public void setNew_live_icon(NewLiveIconBean new_live_icon) {
        this.new_live_icon = new_live_icon;
      }

      public NewNavLiveIconBean getNew_nav_live_icon() {
        return new_nav_live_icon;
      }

      public void setNew_nav_live_icon(NewNavLiveIconBean new_nav_live_icon) {
        this.new_nav_live_icon = new_nav_live_icon;
      }

      public int getNext_diamond() {
        return next_diamond;
      }

      public void setNext_diamond(int next_diamond) {
        this.next_diamond = next_diamond;
      }

      public NextIconBean getNext_icon() {
        return next_icon;
      }

      public void setNext_icon(NextIconBean next_icon) {
        this.next_icon = next_icon;
      }

      public String getNext_name() {
        return next_name;
      }

      public void setNext_name(String next_name) {
        this.next_name = next_name;
      }

      public int getNow_diamond() {
        return now_diamond;
      }

      public void setNow_diamond(int now_diamond) {
        this.now_diamond = now_diamond;
      }

      public int getPay_diamond_bak() {
        return pay_diamond_bak;
      }

      public void setPay_diamond_bak(int pay_diamond_bak) {
        this.pay_diamond_bak = pay_diamond_bak;
      }

      public ProfileDialogBgBeanX getProfile_dialog_bg() {
        return profile_dialog_bg;
      }

      public void setProfile_dialog_bg(ProfileDialogBgBeanX profile_dialog_bg) {
        this.profile_dialog_bg = profile_dialog_bg;
      }

      public ProfileDialogBgBackBeanX getProfile_dialog_bg_back() {
        return profile_dialog_bg_back;
      }

      public void setProfile_dialog_bg_back(ProfileDialogBgBackBeanX profile_dialog_bg_back) {
        this.profile_dialog_bg_back = profile_dialog_bg_back;
      }

      public int getScreen_chat_type() {
        return screen_chat_type;
      }

      public void setScreen_chat_type(int screen_chat_type) {
        this.screen_chat_type = screen_chat_type;
      }

      public int getThis_grade_max_diamond() {
        return this_grade_max_diamond;
      }

      public void setThis_grade_max_diamond(int this_grade_max_diamond) {
        this.this_grade_max_diamond = this_grade_max_diamond;
      }

      public int getThis_grade_min_diamond() {
        return this_grade_min_diamond;
      }

      public void setThis_grade_min_diamond(int this_grade_min_diamond) {
        this.this_grade_min_diamond = this_grade_min_diamond;
      }

      public int getTotal_diamond_count() {
        return total_diamond_count;
      }

      public void setTotal_diamond_count(int total_diamond_count) {
        this.total_diamond_count = total_diamond_count;
      }

      public int getUpgrade_need_consume() {
        return upgrade_need_consume;
      }

      public void setUpgrade_need_consume(int upgrade_need_consume) {
        this.upgrade_need_consume = upgrade_need_consume;
      }

      public List<GradeIconListBean> getGrade_icon_list() {
        return grade_icon_list;
      }

      public void setGrade_icon_list(List<GradeIconListBean> grade_icon_list) {
        this.grade_icon_list = grade_icon_list;
      }

      public static class DiamondIconBean {
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

      public static class IconBean {
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

      public static class ImIconBean {
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

      public static class ImIconWithLevelBean {
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

      public static class LiveIconBean {
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

      public static class NewImIconWithLevelBean {
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

      public static class NewLiveIconBean {
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

      public static class NewNavLiveIconBean {
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

      public static class NextIconBean {
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

      public static class ProfileDialogBgBeanX {
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

      public static class ProfileDialogBgBackBeanX {
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

      public static class GradeIconListBean {
        private IconBeanX icon;
        private int icon_diamond;
        private int level;
        private String level_str;

        public IconBeanX getIcon() {
          return icon;
        }

        public void setIcon(IconBeanX icon) {
          this.icon = icon;
        }

        public int getIcon_diamond() {
          return icon_diamond;
        }

        public void setIcon_diamond(int icon_diamond) {
          this.icon_diamond = icon_diamond;
        }

        public int getLevel() {
          return level;
        }

        public void setLevel(int level) {
          this.level = level;
        }

        public String getLevel_str() {
          return level_str;
        }

        public void setLevel_str(String level_str) {
          this.level_str = level_str;
        }

        public static class IconBeanX {
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

    public static class StatsBean {
      private long id;
      private String id_str;
      private int following_count;
      private int follower_count;
      private int record_count;
      private int total_duration;
      private int daily_fan_ticket_count;
      private int daily_income;
      private int item_count;
      private int favorite_item_count;
      private int diamond_count;
      private int diamond_consumed_count;
      private int tuwen_item_count;

      public long getId() {
        return id;
      }

      public void setId(long id) {
        this.id = id;
      }

      public String getId_str() {
        return id_str;
      }

      public void setId_str(String id_str) {
        this.id_str = id_str;
      }

      public int getFollowing_count() {
        return following_count;
      }

      public void setFollowing_count(int following_count) {
        this.following_count = following_count;
      }

      public int getFollower_count() {
        return follower_count;
      }

      public void setFollower_count(int follower_count) {
        this.follower_count = follower_count;
      }

      public int getRecord_count() {
        return record_count;
      }

      public void setRecord_count(int record_count) {
        this.record_count = record_count;
      }

      public int getTotal_duration() {
        return total_duration;
      }

      public void setTotal_duration(int total_duration) {
        this.total_duration = total_duration;
      }

      public int getDaily_fan_ticket_count() {
        return daily_fan_ticket_count;
      }

      public void setDaily_fan_ticket_count(int daily_fan_ticket_count) {
        this.daily_fan_ticket_count = daily_fan_ticket_count;
      }

      public int getDaily_income() {
        return daily_income;
      }

      public void setDaily_income(int daily_income) {
        this.daily_income = daily_income;
      }

      public int getItem_count() {
        return item_count;
      }

      public void setItem_count(int item_count) {
        this.item_count = item_count;
      }

      public int getFavorite_item_count() {
        return favorite_item_count;
      }

      public void setFavorite_item_count(int favorite_item_count) {
        this.favorite_item_count = favorite_item_count;
      }

      public int getDiamond_count() {
        return diamond_count;
      }

      public void setDiamond_count(int diamond_count) {
        this.diamond_count = diamond_count;
      }

      public int getDiamond_consumed_count() {
        return diamond_consumed_count;
      }

      public void setDiamond_consumed_count(int diamond_consumed_count) {
        this.diamond_consumed_count = diamond_consumed_count;
      }

      public int getTuwen_item_count() {
        return tuwen_item_count;
      }

      public void setTuwen_item_count(int tuwen_item_count) {
        this.tuwen_item_count = tuwen_item_count;
      }
    }

    public static class TopFansBean {
      private boolean allow_be_located;
      private boolean allow_find_by_contacts;
      private boolean allow_others_download_video;
      private boolean allow_others_download_when_sharing_video;
      private boolean allow_share_show_profile;
      private boolean allow_show_in_gossip;
      private boolean allow_show_my_action;
      private boolean allow_strange_comment;
      private boolean allow_unfollower_comment;
      private AvatarJpgBeanX avatar_jpg;
      private AvatarLargeBeanX avatar_large;
      private AvatarMediumBeanX avatar_medium;
      private AvatarThumbBeanX avatar_thumb;
      private String bg_img_url;
      private int birthday;
      private String birthday_description;
      private boolean birthday_valid;
      private int block_status;
      private String city;
      private int comment_restrict;
      private String constellation;
      private int disable_ichat;
      private int enable_ichat_img;
      private String encrypted_id;
      private int exp;
      private int fan_ticket_count;
      private boolean fold_stranger_chat;
      private int follow_status;
      private int gender;
      private boolean hotsoon_verified;
      private String hotsoon_verified_reason;
      private int ichat_restrict_type;
      private long id;
      private String id_str;
      private int income_share_percent;
      private boolean is_follower;
      private boolean is_following;
      private int level;
      private boolean need_profile_guide;
      private String nickname;
      private PayGradeBeanX pay_grade;
      private int pay_scores;
      private boolean push_comment_status;
      private boolean push_digg;
      private boolean push_follow;
      private boolean push_friend_action;
      private boolean push_ichat;
      private boolean push_status;
      private boolean push_video_post;
      private boolean push_video_recommend;
      private String share_desc;
      private String share_title;
      private String share_url;
      private int short_id;
      private String signature;
      private StatsBeanX stats;
      private int type_a1;
      private boolean verified;
      private boolean verified_mobile;
      private String verified_reason;

      public boolean isAllow_be_located() {
        return allow_be_located;
      }

      public void setAllow_be_located(boolean allow_be_located) {
        this.allow_be_located = allow_be_located;
      }

      public boolean isAllow_find_by_contacts() {
        return allow_find_by_contacts;
      }

      public void setAllow_find_by_contacts(boolean allow_find_by_contacts) {
        this.allow_find_by_contacts = allow_find_by_contacts;
      }

      public boolean isAllow_others_download_video() {
        return allow_others_download_video;
      }

      public void setAllow_others_download_video(boolean allow_others_download_video) {
        this.allow_others_download_video = allow_others_download_video;
      }

      public boolean isAllow_others_download_when_sharing_video() {
        return allow_others_download_when_sharing_video;
      }

      public void setAllow_others_download_when_sharing_video(
          boolean allow_others_download_when_sharing_video) {
        this.allow_others_download_when_sharing_video = allow_others_download_when_sharing_video;
      }

      public boolean isAllow_share_show_profile() {
        return allow_share_show_profile;
      }

      public void setAllow_share_show_profile(boolean allow_share_show_profile) {
        this.allow_share_show_profile = allow_share_show_profile;
      }

      public boolean isAllow_show_in_gossip() {
        return allow_show_in_gossip;
      }

      public void setAllow_show_in_gossip(boolean allow_show_in_gossip) {
        this.allow_show_in_gossip = allow_show_in_gossip;
      }

      public boolean isAllow_show_my_action() {
        return allow_show_my_action;
      }

      public void setAllow_show_my_action(boolean allow_show_my_action) {
        this.allow_show_my_action = allow_show_my_action;
      }

      public boolean isAllow_strange_comment() {
        return allow_strange_comment;
      }

      public void setAllow_strange_comment(boolean allow_strange_comment) {
        this.allow_strange_comment = allow_strange_comment;
      }

      public boolean isAllow_unfollower_comment() {
        return allow_unfollower_comment;
      }

      public void setAllow_unfollower_comment(boolean allow_unfollower_comment) {
        this.allow_unfollower_comment = allow_unfollower_comment;
      }

      public AvatarJpgBeanX getAvatar_jpg() {
        return avatar_jpg;
      }

      public void setAvatar_jpg(AvatarJpgBeanX avatar_jpg) {
        this.avatar_jpg = avatar_jpg;
      }

      public AvatarLargeBeanX getAvatar_large() {
        return avatar_large;
      }

      public void setAvatar_large(AvatarLargeBeanX avatar_large) {
        this.avatar_large = avatar_large;
      }

      public AvatarMediumBeanX getAvatar_medium() {
        return avatar_medium;
      }

      public void setAvatar_medium(AvatarMediumBeanX avatar_medium) {
        this.avatar_medium = avatar_medium;
      }

      public AvatarThumbBeanX getAvatar_thumb() {
        return avatar_thumb;
      }

      public void setAvatar_thumb(AvatarThumbBeanX avatar_thumb) {
        this.avatar_thumb = avatar_thumb;
      }

      public String getBg_img_url() {
        return bg_img_url;
      }

      public void setBg_img_url(String bg_img_url) {
        this.bg_img_url = bg_img_url;
      }

      public int getBirthday() {
        return birthday;
      }

      public void setBirthday(int birthday) {
        this.birthday = birthday;
      }

      public String getBirthday_description() {
        return birthday_description;
      }

      public void setBirthday_description(String birthday_description) {
        this.birthday_description = birthday_description;
      }

      public boolean isBirthday_valid() {
        return birthday_valid;
      }

      public void setBirthday_valid(boolean birthday_valid) {
        this.birthday_valid = birthday_valid;
      }

      public int getBlock_status() {
        return block_status;
      }

      public void setBlock_status(int block_status) {
        this.block_status = block_status;
      }

      public String getCity() {
        return city;
      }

      public void setCity(String city) {
        this.city = city;
      }

      public int getComment_restrict() {
        return comment_restrict;
      }

      public void setComment_restrict(int comment_restrict) {
        this.comment_restrict = comment_restrict;
      }

      public String getConstellation() {
        return constellation;
      }

      public void setConstellation(String constellation) {
        this.constellation = constellation;
      }

      public int getDisable_ichat() {
        return disable_ichat;
      }

      public void setDisable_ichat(int disable_ichat) {
        this.disable_ichat = disable_ichat;
      }

      public int getEnable_ichat_img() {
        return enable_ichat_img;
      }

      public void setEnable_ichat_img(int enable_ichat_img) {
        this.enable_ichat_img = enable_ichat_img;
      }

      public String getEncrypted_id() {
        return encrypted_id;
      }

      public void setEncrypted_id(String encrypted_id) {
        this.encrypted_id = encrypted_id;
      }

      public int getExp() {
        return exp;
      }

      public void setExp(int exp) {
        this.exp = exp;
      }

      public int getFan_ticket_count() {
        return fan_ticket_count;
      }

      public void setFan_ticket_count(int fan_ticket_count) {
        this.fan_ticket_count = fan_ticket_count;
      }

      public boolean isFold_stranger_chat() {
        return fold_stranger_chat;
      }

      public void setFold_stranger_chat(boolean fold_stranger_chat) {
        this.fold_stranger_chat = fold_stranger_chat;
      }

      public int getFollow_status() {
        return follow_status;
      }

      public void setFollow_status(int follow_status) {
        this.follow_status = follow_status;
      }

      public int getGender() {
        return gender;
      }

      public void setGender(int gender) {
        this.gender = gender;
      }

      public boolean isHotsoon_verified() {
        return hotsoon_verified;
      }

      public void setHotsoon_verified(boolean hotsoon_verified) {
        this.hotsoon_verified = hotsoon_verified;
      }

      public String getHotsoon_verified_reason() {
        return hotsoon_verified_reason;
      }

      public void setHotsoon_verified_reason(String hotsoon_verified_reason) {
        this.hotsoon_verified_reason = hotsoon_verified_reason;
      }

      public int getIchat_restrict_type() {
        return ichat_restrict_type;
      }

      public void setIchat_restrict_type(int ichat_restrict_type) {
        this.ichat_restrict_type = ichat_restrict_type;
      }

      public long getId() {
        return id;
      }

      public void setId(long id) {
        this.id = id;
      }

      public String getId_str() {
        return id_str;
      }

      public void setId_str(String id_str) {
        this.id_str = id_str;
      }

      public int getIncome_share_percent() {
        return income_share_percent;
      }

      public void setIncome_share_percent(int income_share_percent) {
        this.income_share_percent = income_share_percent;
      }

      public boolean isIs_follower() {
        return is_follower;
      }

      public void setIs_follower(boolean is_follower) {
        this.is_follower = is_follower;
      }

      public boolean isIs_following() {
        return is_following;
      }

      public void setIs_following(boolean is_following) {
        this.is_following = is_following;
      }

      public int getLevel() {
        return level;
      }

      public void setLevel(int level) {
        this.level = level;
      }

      public boolean isNeed_profile_guide() {
        return need_profile_guide;
      }

      public void setNeed_profile_guide(boolean need_profile_guide) {
        this.need_profile_guide = need_profile_guide;
      }

      public String getNickname() {
        return nickname;
      }

      public void setNickname(String nickname) {
        this.nickname = nickname;
      }

      public PayGradeBeanX getPay_grade() {
        return pay_grade;
      }

      public void setPay_grade(PayGradeBeanX pay_grade) {
        this.pay_grade = pay_grade;
      }

      public int getPay_scores() {
        return pay_scores;
      }

      public void setPay_scores(int pay_scores) {
        this.pay_scores = pay_scores;
      }

      public boolean isPush_comment_status() {
        return push_comment_status;
      }

      public void setPush_comment_status(boolean push_comment_status) {
        this.push_comment_status = push_comment_status;
      }

      public boolean isPush_digg() {
        return push_digg;
      }

      public void setPush_digg(boolean push_digg) {
        this.push_digg = push_digg;
      }

      public boolean isPush_follow() {
        return push_follow;
      }

      public void setPush_follow(boolean push_follow) {
        this.push_follow = push_follow;
      }

      public boolean isPush_friend_action() {
        return push_friend_action;
      }

      public void setPush_friend_action(boolean push_friend_action) {
        this.push_friend_action = push_friend_action;
      }

      public boolean isPush_ichat() {
        return push_ichat;
      }

      public void setPush_ichat(boolean push_ichat) {
        this.push_ichat = push_ichat;
      }

      public boolean isPush_status() {
        return push_status;
      }

      public void setPush_status(boolean push_status) {
        this.push_status = push_status;
      }

      public boolean isPush_video_post() {
        return push_video_post;
      }

      public void setPush_video_post(boolean push_video_post) {
        this.push_video_post = push_video_post;
      }

      public boolean isPush_video_recommend() {
        return push_video_recommend;
      }

      public void setPush_video_recommend(boolean push_video_recommend) {
        this.push_video_recommend = push_video_recommend;
      }

      public String getShare_desc() {
        return share_desc;
      }

      public void setShare_desc(String share_desc) {
        this.share_desc = share_desc;
      }

      public String getShare_title() {
        return share_title;
      }

      public void setShare_title(String share_title) {
        this.share_title = share_title;
      }

      public String getShare_url() {
        return share_url;
      }

      public void setShare_url(String share_url) {
        this.share_url = share_url;
      }

      public int getShort_id() {
        return short_id;
      }

      public void setShort_id(int short_id) {
        this.short_id = short_id;
      }

      public String getSignature() {
        return signature;
      }

      public void setSignature(String signature) {
        this.signature = signature;
      }

      public StatsBeanX getStats() {
        return stats;
      }

      public void setStats(StatsBeanX stats) {
        this.stats = stats;
      }

      public int getType_a1() {
        return type_a1;
      }

      public void setType_a1(int type_a1) {
        this.type_a1 = type_a1;
      }

      public boolean isVerified() {
        return verified;
      }

      public void setVerified(boolean verified) {
        this.verified = verified;
      }

      public boolean isVerified_mobile() {
        return verified_mobile;
      }

      public void setVerified_mobile(boolean verified_mobile) {
        this.verified_mobile = verified_mobile;
      }

      public String getVerified_reason() {
        return verified_reason;
      }

      public void setVerified_reason(String verified_reason) {
        this.verified_reason = verified_reason;
      }

      public static class AvatarJpgBeanX {
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

      public static class AvatarLargeBeanX {
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

      public static class AvatarMediumBeanX {
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

      public static class AvatarThumbBeanX {
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

      public static class PayGradeBeanX {
        private DiamondIconBeanX diamond_icon;
        private String grade_banner;
        private String grade_describe;
        private IconBeanXX icon;
        private ImIconBeanX im_icon;
        private ImIconWithLevelBeanX im_icon_with_level;
        private int level;
        private LiveIconBeanX live_icon;
        private String name;
        private NewImIconWithLevelBeanX new_im_icon_with_level;
        private NewLiveIconBeanX new_live_icon;
        private NewNavLiveIconBeanX new_nav_live_icon;
        private int next_diamond;
        private NextIconBeanX next_icon;
        private String next_name;
        private int now_diamond;
        private int pay_diamond_bak;
        private ProfileDialogBgBeanXX profile_dialog_bg;
        private ProfileDialogBgBackBeanXX profile_dialog_bg_back;
        private int screen_chat_type;
        private int this_grade_max_diamond;
        private int this_grade_min_diamond;
        private int total_diamond_count;
        private int upgrade_need_consume;
        private List<GradeIconListBeanX> grade_icon_list;

        public DiamondIconBeanX getDiamond_icon() {
          return diamond_icon;
        }

        public void setDiamond_icon(DiamondIconBeanX diamond_icon) {
          this.diamond_icon = diamond_icon;
        }

        public String getGrade_banner() {
          return grade_banner;
        }

        public void setGrade_banner(String grade_banner) {
          this.grade_banner = grade_banner;
        }

        public String getGrade_describe() {
          return grade_describe;
        }

        public void setGrade_describe(String grade_describe) {
          this.grade_describe = grade_describe;
        }

        public IconBeanXX getIcon() {
          return icon;
        }

        public void setIcon(IconBeanXX icon) {
          this.icon = icon;
        }

        public ImIconBeanX getIm_icon() {
          return im_icon;
        }

        public void setIm_icon(ImIconBeanX im_icon) {
          this.im_icon = im_icon;
        }

        public ImIconWithLevelBeanX getIm_icon_with_level() {
          return im_icon_with_level;
        }

        public void setIm_icon_with_level(ImIconWithLevelBeanX im_icon_with_level) {
          this.im_icon_with_level = im_icon_with_level;
        }

        public int getLevel() {
          return level;
        }

        public void setLevel(int level) {
          this.level = level;
        }

        public LiveIconBeanX getLive_icon() {
          return live_icon;
        }

        public void setLive_icon(LiveIconBeanX live_icon) {
          this.live_icon = live_icon;
        }

        public String getName() {
          return name;
        }

        public void setName(String name) {
          this.name = name;
        }

        public NewImIconWithLevelBeanX getNew_im_icon_with_level() {
          return new_im_icon_with_level;
        }

        public void setNew_im_icon_with_level(NewImIconWithLevelBeanX new_im_icon_with_level) {
          this.new_im_icon_with_level = new_im_icon_with_level;
        }

        public NewLiveIconBeanX getNew_live_icon() {
          return new_live_icon;
        }

        public void setNew_live_icon(NewLiveIconBeanX new_live_icon) {
          this.new_live_icon = new_live_icon;
        }

        public NewNavLiveIconBeanX getNew_nav_live_icon() {
          return new_nav_live_icon;
        }

        public void setNew_nav_live_icon(NewNavLiveIconBeanX new_nav_live_icon) {
          this.new_nav_live_icon = new_nav_live_icon;
        }

        public int getNext_diamond() {
          return next_diamond;
        }

        public void setNext_diamond(int next_diamond) {
          this.next_diamond = next_diamond;
        }

        public NextIconBeanX getNext_icon() {
          return next_icon;
        }

        public void setNext_icon(NextIconBeanX next_icon) {
          this.next_icon = next_icon;
        }

        public String getNext_name() {
          return next_name;
        }

        public void setNext_name(String next_name) {
          this.next_name = next_name;
        }

        public int getNow_diamond() {
          return now_diamond;
        }

        public void setNow_diamond(int now_diamond) {
          this.now_diamond = now_diamond;
        }

        public int getPay_diamond_bak() {
          return pay_diamond_bak;
        }

        public void setPay_diamond_bak(int pay_diamond_bak) {
          this.pay_diamond_bak = pay_diamond_bak;
        }

        public ProfileDialogBgBeanXX getProfile_dialog_bg() {
          return profile_dialog_bg;
        }

        public void setProfile_dialog_bg(ProfileDialogBgBeanXX profile_dialog_bg) {
          this.profile_dialog_bg = profile_dialog_bg;
        }

        public ProfileDialogBgBackBeanXX getProfile_dialog_bg_back() {
          return profile_dialog_bg_back;
        }

        public void setProfile_dialog_bg_back(ProfileDialogBgBackBeanXX profile_dialog_bg_back) {
          this.profile_dialog_bg_back = profile_dialog_bg_back;
        }

        public int getScreen_chat_type() {
          return screen_chat_type;
        }

        public void setScreen_chat_type(int screen_chat_type) {
          this.screen_chat_type = screen_chat_type;
        }

        public int getThis_grade_max_diamond() {
          return this_grade_max_diamond;
        }

        public void setThis_grade_max_diamond(int this_grade_max_diamond) {
          this.this_grade_max_diamond = this_grade_max_diamond;
        }

        public int getThis_grade_min_diamond() {
          return this_grade_min_diamond;
        }

        public void setThis_grade_min_diamond(int this_grade_min_diamond) {
          this.this_grade_min_diamond = this_grade_min_diamond;
        }

        public int getTotal_diamond_count() {
          return total_diamond_count;
        }

        public void setTotal_diamond_count(int total_diamond_count) {
          this.total_diamond_count = total_diamond_count;
        }

        public int getUpgrade_need_consume() {
          return upgrade_need_consume;
        }

        public void setUpgrade_need_consume(int upgrade_need_consume) {
          this.upgrade_need_consume = upgrade_need_consume;
        }

        public List<GradeIconListBeanX> getGrade_icon_list() {
          return grade_icon_list;
        }

        public void setGrade_icon_list(List<GradeIconListBeanX> grade_icon_list) {
          this.grade_icon_list = grade_icon_list;
        }

        public static class DiamondIconBeanX {
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

        public static class IconBeanXX {
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

        public static class ImIconBeanX {
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

        public static class ImIconWithLevelBeanX {
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

        public static class LiveIconBeanX {
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

        public static class NewImIconWithLevelBeanX {
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

        public static class NewLiveIconBeanX {
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

        public static class NewNavLiveIconBeanX {
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

        public static class NextIconBeanX {
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

        public static class ProfileDialogBgBeanXX {
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

        public static class ProfileDialogBgBackBeanXX {
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

        public static class GradeIconListBeanX {
          private IconBeanXXX icon;
          private int icon_diamond;
          private int level;
          private String level_str;

          public IconBeanXXX getIcon() {
            return icon;
          }

          public void setIcon(IconBeanXXX icon) {
            this.icon = icon;
          }

          public int getIcon_diamond() {
            return icon_diamond;
          }

          public void setIcon_diamond(int icon_diamond) {
            this.icon_diamond = icon_diamond;
          }

          public int getLevel() {
            return level;
          }

          public void setLevel(int level) {
            this.level = level;
          }

          public String getLevel_str() {
            return level_str;
          }

          public void setLevel_str(String level_str) {
            this.level_str = level_str;
          }

          public static class IconBeanXXX {
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

      public static class StatsBeanX {
        private int daily_fan_ticket_count;
        private int daily_income;
        private int diamond_consumed_count;
        private int diamond_count;
        private int favorite_item_count;
        private int follower_count;
        private int following_count;
        private long id;
        private String id_str;
        private int item_count;
        private int record_count;
        private int total_duration;
        private int tuwen_item_count;

        public int getDaily_fan_ticket_count() {
          return daily_fan_ticket_count;
        }

        public void setDaily_fan_ticket_count(int daily_fan_ticket_count) {
          this.daily_fan_ticket_count = daily_fan_ticket_count;
        }

        public int getDaily_income() {
          return daily_income;
        }

        public void setDaily_income(int daily_income) {
          this.daily_income = daily_income;
        }

        public int getDiamond_consumed_count() {
          return diamond_consumed_count;
        }

        public void setDiamond_consumed_count(int diamond_consumed_count) {
          this.diamond_consumed_count = diamond_consumed_count;
        }

        public int getDiamond_count() {
          return diamond_count;
        }

        public void setDiamond_count(int diamond_count) {
          this.diamond_count = diamond_count;
        }

        public int getFavorite_item_count() {
          return favorite_item_count;
        }

        public void setFavorite_item_count(int favorite_item_count) {
          this.favorite_item_count = favorite_item_count;
        }

        public int getFollower_count() {
          return follower_count;
        }

        public void setFollower_count(int follower_count) {
          this.follower_count = follower_count;
        }

        public int getFollowing_count() {
          return following_count;
        }

        public void setFollowing_count(int following_count) {
          this.following_count = following_count;
        }

        public long getId() {
          return id;
        }

        public void setId(long id) {
          this.id = id;
        }

        public String getId_str() {
          return id_str;
        }

        public void setId_str(String id_str) {
          this.id_str = id_str;
        }

        public int getItem_count() {
          return item_count;
        }

        public void setItem_count(int item_count) {
          this.item_count = item_count;
        }

        public int getRecord_count() {
          return record_count;
        }

        public void setRecord_count(int record_count) {
          this.record_count = record_count;
        }

        public int getTotal_duration() {
          return total_duration;
        }

        public void setTotal_duration(int total_duration) {
          this.total_duration = total_duration;
        }

        public int getTuwen_item_count() {
          return tuwen_item_count;
        }

        public void setTuwen_item_count(int tuwen_item_count) {
          this.tuwen_item_count = tuwen_item_count;
        }
      }
    }
  }

  public static class ExtraBean {
    private long now;

    public long getNow() {
      return now;
    }

    public void setNow(long now) {
      this.now = now;
    }
  }
}
