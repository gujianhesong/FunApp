package com.pinery.fun.video.api;

import com.pinery.fun.video.bean.CommentListBean;
import com.pinery.fun.video.bean.CommentReplyListBean;
import com.pinery.fun.video.bean.HuoCityBean;
import com.pinery.fun.video.bean.HuoLiveBean;
import com.pinery.fun.video.bean.HuoVideoBean;
import io.reactivex.Flowable;
import java.util.HashMap;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

public interface ApiService {

  /**
   * 首次刷新视频列表
   * @param map
   * @return
   */
  @GET("hotsoon/feed/?type=video&min_time=0&offset=0&count=20&req_from=enter_auto&live_sdk_version=373&ac=wifi&channel=local"
      + "&aid=1112&app_name=live_stream&device_platform=android&ssmix=a"
      + "&language=zh&openudid=ebc5a2ef6694b29"
      + "&_rticket=1534073513114&ts=1534073512&as=a245c1b7e8ba6b5af03241&cp=1aa0b85184067ba2e2dtbf&mas=00df3d59f4183004c8964417704f16641d4406620488e046e2")
  Flowable<HuoVideoBean> firstRefreshVideoData(@QueryMap HashMap<String, Object> map);

  /**
   * 刷新视频列表
   * @param map
   * @return
   */
  @GET("hotsoon/feed/?type=video&min_time=0&offset=0&count=20&req_from=feed_refresh&live_sdk_version=373&ac=wifi&channel=local"
      + "&aid=1112&app_name=live_stream&device_platform=android&ssmix=a"
      + "&language=zh&openudid=ebc5a2ef6694b29"
      + "&_rticket=1534073862768&ts=1534073862&as=a295c117f6e07b1c703043&cp=1b01b6516c017dc7e2mwba&mas=009dcef44d73c3be7e0a8f704cc45948d00688ca04c8e406a4")
  Flowable<HuoVideoBean> refreshVideoData(@QueryMap HashMap<String, Object> map);

  /**
   * 加载更多视频列表
   * @param map
   * @return
   */
  @GET("hotsoon/feed/?type=video&count=20&req_from=feed_loadmore&live_sdk_version=373"
      + "&ac=wifi&channel=local&aid=1112&app_name=live_stream&device_platform=android&ssmix=a"
      + "&language=zh&openudid=ebc5a2ef6694b29"
      + "&_rticket=1534073715340&ts=1534073715&as=a21591f733670bab209691&cp=1e7bb757340e78bde2zzds&mas=00b5d96ac196bb7b26037acd182d4621802620c054ad524da4")
  Flowable<HuoVideoBean> loadMoreVideoData(@QueryMap HashMap<String, Object> map);

  /**
   * 首次刷新Live列表
   * @param map
   * @return
   */
  @GET("/hotsoon/feed/?type=live&live_source=live_big_picture&min_time=0&offset=0&count=20&req_from=enter_auto&live_sdk_version=373&ac=wifi&channel=local"
      + "&aid=1112&app_name=live_stream&device_platform=android&ssmix=a"
      + "&language=zh&uuid=99000821058393&openudid=ebc5a2ef6694b29"
      + "&_rticket=1534559660964&ts=1534559661&as=a2e538b77d1aab05672236&cp=85a2b75fdd717c57e2ezdg&mas=003f08210dc11c93846a5894d4da7f447864ae228a8000a8e8")
  Flowable<HuoLiveBean> firstRefreshLiveData(@QueryMap HashMap<String, Object> map);

  /**
   * 刷新Live列表
   * @param map
   * @return
   */
  @GET("/hotsoon/feed/?type=live&live_source=live_big_picture&min_time=0&offset=0&count=20&req_from=feed_refresh&live_sdk_version=373&ac=wifi&channel=local"
      + "&aid=1112&app_name=live_stream&device_platform=android&ssmix=a"
      + "&language=zh&uuid=99000821058393&openudid=ebc5a2ef6694b29"
      + "&_rticket=1534559660964&ts=1534559661&as=a2e538b77d1aab05672236&cp=85a2b75fdd717c57e2ezdg&mas=003f08210dc11c93846a5894d4da7f447864ae228a8000a8e8")
  Flowable<HuoLiveBean> refreshLiveData(@QueryMap HashMap<String, Object> map);

  /**
   * 加载更多Live列表
   * @param map
   * @return
   */
  @GET("/hotsoon/feed/?type=live&live_source=live_big_picture&count=20&req_from=feed_loadmore&live_sdk_version=373&ac=wifi&channel=local"
      + "&aid=1112&app_name=live_stream&device_platform=android&ssmix=a"
      + "&language=zh&uuid=99000821058393&openudid=ebc5a2ef6694b29"
      + "&_rticket=1534559660964&ts=1534559661&as=a2e538b77d1aab05672236&cp=85a2b75fdd717c57e2ezdg&mas=003f08210dc11c93846a5894d4da7f447864ae228a8000a8e8")
  Flowable<HuoLiveBean> loadMoreLiveData(@QueryMap HashMap<String, Object> map);

  /**
   * 首次刷新同城列表
   * @param map
   * @return
   */
  @GET("hotsoon/feed/?type=city&min_time=0&offset=0&count=20&req_from=enter_auto&live_sdk_version=373&ac=wifi&channel=local"
      + "&aid=1112&app_name=live_stream&device_platform=android&ssmix=a"
      + "&language=zh&openudid=ebc5a2ef6694b29"
      + "&_rticket=1534073513114&ts=1534073512&as=a245c1b7e8ba6b5af03241&cp=1aa0b85184067ba2e2dtbf&mas=00df3d59f4183004c8964417704f16641d4406620488e046e2")
  Flowable<HuoCityBean> firstRefreshCityData(@QueryMap HashMap<String, Object> map);

  /**
   * 刷新同城列表
   * @param map
   * @return
   */
  @GET("hotsoon/feed/?type=city&min_time=0&offset=0&count=20&req_from=feed_refresh&live_sdk_version=373&ac=wifi&channel=local"
      + "&aid=1112&app_name=live_stream&device_platform=android&ssmix=a"
      + "&language=zh&openudid=ebc5a2ef6694b29"
      + "&_rticket=1534073862768&ts=1534073862&as=a295c117f6e07b1c703043&cp=1b01b6516c017dc7e2mwba&mas=009dcef44d73c3be7e0a8f704cc45948d00688ca04c8e406a4")
  Flowable<HuoCityBean> refreshCityData(@QueryMap HashMap<String, Object> map);

  /**
   * 加载更多同城列表
   * @param map
   * @return
   */
  @GET("hotsoon/feed/?type=city&count=20&req_from=feed_loadmore&live_sdk_version=373"
      + "&ac=wifi&channel=local&aid=1112&app_name=live_stream&device_platform=android&ssmix=a"
      + "&language=zh&openudid=ebc5a2ef6694b29"
      + "&_rticket=1534073715340&ts=1534073715&as=a21591f733670bab209691&cp=1e7bb757340e78bde2zzds&mas=00b5d96ac196bb7b26037acd182d4621802620c054ad524da4")
  Flowable<HuoCityBean> loadMoreCityData(@QueryMap HashMap<String, Object> map);

  /**
   * 评论列表
   * @param map
   * @return
   */
  @GET("/hotsoon/item/{id}/comments/?count=20&live_sdk_version=373&ac=wifi&channel=local"
      + "&aid=1112&app_name=live_stream&device_platform=android&ssmix=a"
      + "&language=zh&uuid=99000821058393&openudid=ebc5a2ef6694b29"
      + "&_rticket=1534559660964&ts=1534559661&as=a2e538b77d1aab05672236&cp=85a2b75fdd717c57e2ezdg&mas=003f08210dc11c93846a5894d4da7f447864ae228a8000a8e8")
  Flowable<CommentListBean> loadComments(@Path("id") String id, @QueryMap HashMap<String, Object> map);

  /**
   * 评论回复
   * @param map
   * @return
   */
  @GET("/hotsoon/item/comment/{id}/_get_reply_comments/?count=20&live_sdk_version=373&ac=wifi&channel=local"
      + "&aid=1112&app_name=live_stream&device_platform=android&ssmix=a"
      + "&language=zh&uuid=99000821058393&openudid=ebc5a2ef6694b29"
      + "&_rticket=1534559660964&ts=1534559661&as=a2e538b77d1aab05672236&cp=85a2b75fdd717c57e2ezdg&mas=003f08210dc11c93846a5894d4da7f447864ae228a8000a8e8")
  Flowable<CommentReplyListBean> loadCommentReply(@Path("id") String id, @QueryMap HashMap<String, Object> map);


  ////    @GET("hotsoon/feed/?type=city&min_time=0&count=20&req_from=enter_auto&live_sdk_version=273")
  ////    Observable<SameCityBean> sameCityBean();
  //@GET("hotsoon/feed/?type=video&min_time=0&count=20&req_from=enter_auto&live_sdk_version=273&iid=20058720887&device_id=39500980677&ac=wifi&channel=360&aid=1112&app_name=live_stream&version_code=273&version_name=2.7.3&device_platform=android&ssmix=a&device_type=GT-P5210&device_brand=samsung&os_api=19&os_version=4.4.4&uuid=865854081230173&openudid=4058040115108878&manifest_version_code=273&resolution=480*800&dpi=128&update_version_code=2732&ts=1513384710&as=a235f643b670ca1b74&cp=6206ab58694835b0e2")
  //Observable<SameCityBean> sameCityBean();
  //
  ////轮播图
  //@GET("hotsoon/feed/?type=live&live_source=live_big_picture&min_time=0&offset=7&count=20&req_from=feed_refresh&live_sdk_version=300&iid=22011786718&device_id=39901824739&ac=wifi&channel=360&aid=1112&app_name=live_stream&version_code=300&version_name=3.0.0&device_platform=android&ssmix=a&device_type=2014811&device_brand=Xiaomi&language=zh&os_api=19&os_version=4.4.2&uuid=866048010542381&openudid=54ee7588ea182536&manifest_version_code=300&resolution=480*800&dpi=160&update_version_code=3003&_rticket=1514711700564&ts=1514711700&as=a2a54a34b469ea9a48&cp=aa9aa55d4e8545a1e2&mas=005f05d7bd059a5c71d8659b129f747ea44b40da17")
  //Observable<Livebean> getNoParams();
  //
  //@GET("hotsoon/search/recommend/?offset=0&count=20&type=user&live_sdk_version=273&iid=20058720887&device_id=39500980677&ac=wifi&channel=360&aid=1112&app_name=live_stream&version_code=273&version_name=2.7.3&device_platform=android&ssmix=a&device_type=GT-P5210&device_brand=samsung&os_api=19&os_version=4.4.4&uuid=865854081230173&openudid=4058040115108878&manifest_version_code=273&resolution=480*800&dpi=128&update_version_code=2732&ts=1513385604&as=a215069374089a3ed4&cp=6881a05b444137ebe2")
  //Observable<SearchBean> getSearchs();




}
