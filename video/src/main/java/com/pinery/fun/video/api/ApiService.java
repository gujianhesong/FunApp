package com.pinery.fun.video.api;

import com.pinery.fun.video.bean.CommentListBean;
import com.pinery.fun.video.bean.CommentReplyListBean;
import com.pinery.fun.video.bean.HashTagItemsBean;
import com.pinery.fun.video.bean.HuoCityBean;
import com.pinery.fun.video.bean.HuoLiveBean;
import com.pinery.fun.video.bean.HuoUserCenterBean;
import com.pinery.fun.video.bean.HuoUserVideoListBean;
import com.pinery.fun.video.bean.HuoVideoBean;
import com.pinery.fun.video.bean.SearchBean;
import com.pinery.fun.video.bean.TagItemsBean;
import com.pinery.fun.video.bean.SearchTagListBean;
import io.reactivex.Flowable;
import java.util.HashMap;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

public interface ApiService {

  /**
   * 请求视频列表
   */
  @GET("hotsoon/feed/?type=video&live_sdk_version=373&ac=wifi&channel=local"
      + "&aid=1112&app_name=live_stream&device_platform=android&ssmix=a"
      + "&language=zh&openudid=ebc5a2ef6694b29"
      + "&_rticket=1534073862768&ts=1534073862&as=a295c117f6e07b1c703043&cp=1b01b6516c017dc7e2mwba&mas=009dcef44d73c3be7e0a8f704cc45948d00688ca04c8e406a4")
  Flowable<HuoVideoBean> requestVideoData(@QueryMap HashMap<String, Object> map);

  /**
   * 请求Live列表
   */
  @GET(
      "/hotsoon/feed/?type=live&live_source=live_big_picture&live_sdk_version=373&ac=wifi&channel=local"
          + "&aid=1112&app_name=live_stream&device_platform=android&ssmix=a"
          + "&language=zh&uuid=99000821058393&openudid=ebc5a2ef6694b29"
          + "&_rticket=1534559660964&ts=1534559661&as=a2e538b77d1aab05672236&cp=85a2b75fdd717c57e2ezdg&mas=003f08210dc11c93846a5894d4da7f447864ae228a8000a8e8")
  Flowable<HuoLiveBean> requestLiveData(@QueryMap HashMap<String, Object> map);

  /**
   * 请求同城列表
   */
  @GET("hotsoon/feed/?type=city&live_sdk_version=373&ac=wifi&channel=local"
      + "&aid=1112&app_name=live_stream&device_platform=android&ssmix=a"
      + "&language=zh&openudid=ebc5a2ef6694b29"
      + "&_rticket=1534073513114&ts=1534073512&as=a245c1b7e8ba6b5af03241&cp=1aa0b85184067ba2e2dtbf&mas=00df3d59f4183004c8964417704f16641d4406620488e046e2")
  Flowable<HuoCityBean> requestCityData(@QueryMap HashMap<String, Object> map);

  /**
   * 评论列表
   */
  @GET("/hotsoon/item/{id}/comments/?live_sdk_version=373&ac=wifi&channel=local"
      + "&aid=1112&app_name=live_stream&device_platform=android&ssmix=a"
      + "&language=zh&uuid=99000821058393&openudid=ebc5a2ef6694b29"
      + "&_rticket=1534559660964&ts=1534559661&as=a2e538b77d1aab05672236&cp=85a2b75fdd717c57e2ezdg&mas=003f08210dc11c93846a5894d4da7f447864ae228a8000a8e8")
  Flowable<CommentListBean> loadComments(@Path("id") String id,
      @QueryMap HashMap<String, Object> map);

  /**
   * 评论回复
   */
  @GET("/hotsoon/item/comment/{id}/_get_reply_comments/?live_sdk_version=373&ac=wifi&channel=local"
      + "&aid=1112&app_name=live_stream&device_platform=android&ssmix=a"
      + "&language=zh&uuid=99000821058393&openudid=ebc5a2ef6694b29"
      + "&_rticket=1534559660964&ts=1534559661&as=a2e538b77d1aab05672236&cp=85a2b75fdd717c57e2ezdg&mas=003f08210dc11c93846a5894d4da7f447864ae228a8000a8e8")
  Flowable<CommentReplyListBean> loadCommentReply(@Path("id") String id,
      @QueryMap HashMap<String, Object> map);

  /**
   * 用户中心
   */
  @GET(
      "/hotsoon/user/{id}/?live_sdk_version=430&iid=42991411996&device_id=57063848101&ac=wifi&channel=360"
          + "&aid=1112&app_name=live_stream&version_code=430&version_name=4.3.0&device_platform=android&ssmix=a"
          + "&device_type=SM-G9350&device_brand=samsung&language=zh&os_api=22&os_version=5.1.1&uuid=867268209422257"
          + "&openudid=4055041127922850&manifest_version_code=420&resolution=768*1366&dpi=254"
          + "&update_version_code=4315&_rticket=1535877312875&ts=1535877312&as=a2050a6860ac3bb00b4355"
          + "&cp=a4cbbe520eb98f0ae2IcQg&mas=00efd8137646c47339e67520d06fca94d160c48e4006686ec4")
  Flowable<HuoUserCenterBean> requestUserCenterInfo(@Path("id") String userId,
      @QueryMap HashMap<String, Object> map);

  /**
   * 首次刷新用户视频列表
   */
  @GET("hotsoon/user/{id}/items/?min_time=0&offset=0&count=20"
      + "&req_from=enter_auto&diff_stream=0&live_sdk_version=430&iid=42991411996&device_id=57063848101&ac=wifi&channel=360"
      + "&aid=1112&app_name=live_stream&version_code=430&version_name=4.3.0&device_platform=android&ssmix=a"
      + "&device_type=SM-G9350&device_brand=samsung&language=zh&os_api=22&os_version=5.1.1&uuid=867268209422257"
      + "&openudid=4055041127922850&manifest_version_code=420&resolution=768*1366&dpi=254"
      + "&update_version_code=4315&_rticket=1535877312875&ts=1535877312&as=a2050a6860ac3bb00b4355"
      + "&cp=a4cbbe520eb98f0ae2IcQg&mas=00efd8137646c47339e67520d06fca94d160c48e4006686ec4")
  Flowable<HuoUserVideoListBean> requestUserVideoList(@Path("id") String userId,
      @QueryMap HashMap<String, Object> map);

  /**
   * 搜索-标签列表
   */
  @GET(
      "/hotsoon/search/tag_list/?live_sdk_version=430&iid=42991411996&device_id=57063848101&ac=wifi&channel=360"
          + "&aid=1112&app_name=live_stream&version_code=430&version_name=4.3.0&device_platform=android&ssmix=a"
          + "&device_type=SM-G9350&device_brand=samsung&language=zh&os_api=22&os_version=5.1.1&uuid=867268209422257"
          + "&openudid=4055041127922850&manifest_version_code=420&resolution=768*1366&dpi=254"
          + "&update_version_code=4315&_rticket=1535877312875&ts=1535877312&as=a2050a6860ac3bb00b4355"
          + "&cp=a4cbbe520eb98f0ae2IcQg&mas=00efd8137646c47339e67520d06fca94d160c48e4006686ec4")
  Flowable<SearchTagListBean> requestSearchTagList(@QueryMap HashMap<String, Object> map);

  /**
   * 搜索-指定标签的列表
   */
  //@Headers({
  //        "User-Agent: Mozilla/5.0 (Linux; Android 4.4.2; Nexus 4 Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/34.0.1847.114 Mobile Safari/537.36"
  //})
  @GET(
      "/hotsoon/search/tag/{id}/items/?live_sdk_version=430&iid=42991411996&device_id=57063848101&ac=wifi&channel=360"
          + "&aid=1112&app_name=live_stream&version_code=430&version_name=4.3.0&device_platform=android&ssmix=a"
          + "&device_type=SM-G9350&device_brand=samsung&language=zh&os_api=22&os_version=5.1.1&uuid=867268209422257"
          + "&openudid=4055041127922850&manifest_version_code=420&resolution=768*1366&dpi=254"
          + "&update_version_code=4315&_rticket=1535877312875&ts=1535877312&as=a2050a6860ac3bb00b4355"
          + "&cp=a4cbbe520eb98f0ae2IcQg&mas=00efd8137646c47339e67520d06fca94d160c48e4006686ec4")
  //  @GET("/hotsoon/search/tag/{id}/items/?live_sdk_version=430&iid=42991411996&device_id=57063848101&ac=wifi&channel=360&aid=1112&app_name=live_stream&version_code=430&version_name=4.3.0&device_platform=android&ssmix=a&device_type=SM-G9350&device_brand=samsung&language=zh&os_api=22&os_version=5.1.1&uuid=867268209422257&openudid=4055041127922850&manifest_version_code=420&resolution=576*1024&dpi=191&update_version_code=4315&_rticket=1553870683001&ts=1553870682&as=a2a502c9aa95dcdfde4355&cp=2255c058a4e891f1e2OcWg&mas=0043708cb145a9f1cd30b1d8938542356b0c48cc4e06686ef2")
  Flowable<TagItemsBean> requestSearchTagItems(@Path("id") int tagId,
      @QueryMap HashMap<String, Object> map);

  /**
   * 指定标签的视频列表
   */
  @Headers({
      "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8",
      "Accept-Encoding: gzip, deflate",
      "Accept-Language: zh-CN,zh;q=0.9,en;q=0.8,zh-TW;q=0.7,und;q=0.6",
      "Upgrade-Insecure-Requests: 1",
      "Cache-Control: no-cache",
      "Pragma: no-cache",
      "Cookie: odin_tt=bcc2a3f66576892aca0ace828c7ee82ec1bf24cfb2e9e330af9f75c285a417823b8037ac9bcede3997b4a72fa05accdb995b00003e3947153b80f633e35e5f0c; _ga=GA1.2.247662212.1553926145; _gid=GA1.2.462043801.1553926145",
  })
  @GET(
      "/hotsoon/hashtag/{id}/items/?live_sdk_version=430&iid=42991411996&device_id=57063848101&ac=wifi&channel=360"
          + "&aid=1112&app_name=live_stream&version_code=430&version_name=4.3.0&device_platform=android&ssmix=a"
          + "&device_type=SM-G9350&device_brand=samsung&language=zh&os_api=22&os_version=5.1.1&uuid=867268209422257"
          + "&openudid=4055041127922850&manifest_version_code=420&resolution=768*1366&dpi=254"
          + "&update_version_code=4315&_rticket=1535877312875&ts=1535877312&as=a2050a6860ac3bb00b4355"
          + "&cp=a4cbbe520eb98f0ae2IcQg&mas=00efd8137646c47339e67520d06fca94d160c48e4006686ec4")
  Flowable<HashTagItemsBean> requestHashTagItems(@Path("id") String hashTag,
      @QueryMap HashMap<String, Object> map);

  /**
   * 搜索列表
   */
  @GET("/hotsoon/general_search/?live_sdk_version=595&iid=67555531880&device_id=48119665719&ac=wifi&channel=local&aid=1112&app_name=live_stream&version_code=595&version_name=5.9.5&device_platform=android&ssmix=a&device_type=1603-A03&device_brand=360&language=zh&os_api=23&os_version=6.0&uuid=99000821058393&openudid=ebc5a2ef6694b29&manifest_version_code=595&resolution=1080*1920&dpi=480&update_version_code=5951&_rticket=1555751076293&ab_version=501253%2C822321%2C839333%2C833187%2C800225%2C846163%2C769884%2C744768%2C705072%2C788368%2C692223%2C770522%2C831156%2C803343%2C788458%2C712301%2C827150%2C841788%2C844123%2C850035%2C840427%2C557631%2C661942%2C374105%2C840441%2C840608%2C815650%2C845494%2C848614%2C662290%2C682009%2C830471%2C838591%2C689929%2C837343%2C837342%2C840759%2C665355%2C837346%2C795732%2C841501%2C848650%2C818773%2C835592%2C819014%2C643980%2C734849%2C819048%2C404278%2C773276%2C457534%2C799684%2C832767%2C845222%2C797936%2C797621%2C814444%2C691946%2C722530&ts=1555751076&as=a2158e1b049a6ca04a4811&cp=e7a8c55447aeba0ae2OwWa&mas=0089ec100f4e3496be801dbc4bb33eed866ce44c4cd6454cf6")
  Flowable<SearchBean> searchData(@QueryMap HashMap<String, Object> map);
}
