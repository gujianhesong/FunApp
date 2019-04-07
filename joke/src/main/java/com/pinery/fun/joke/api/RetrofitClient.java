package com.pinery.fun.joke.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pinery.fun.joke.util.LenientConvertFactory;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public class RetrofitClient {
  private RetrofitClient() {
  }

  private static class Holder {
    private static RetrofitClient instance = new RetrofitClient();
  }

  public static RetrofitClient getInstance() {
    return Holder.instance;
  }

  private static HashMap<String, Retrofit> retrofitMap = new HashMap<>();

  public static synchronized Retrofit getRetrofit(String url) {
    Retrofit retrofit = retrofitMap.get(url);
    if (retrofit != null) {
      return retrofit;
    }

    LoggingInterceptor httpLoggingInterceptor = new LoggingInterceptor();
    OkHttpClient okHttpClient = new OkHttpClient.Builder()
        .addInterceptor(httpLoggingInterceptor)
        .connectTimeout(15, TimeUnit.SECONDS)
        .readTimeout(15, TimeUnit.SECONDS)
        .retryOnConnectionFailure(false)
        .build();

    Gson gson = new GsonBuilder()
        //.registerTypeAdapter(BaseVideoItemBean.class, new VideoItemInfoDeserializer())
        .create();

    retrofit = new Retrofit.Builder().baseUrl(url)
        .client(okHttpClient)
        //.addConverterFactory(GsonConverterFactory.create(gson))
        .addConverterFactory(LenientConvertFactory.create(gson))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build();
    retrofitMap.put(url, retrofit);

    return retrofit;
  }

  public <T> T getApiService(String url, Class<T> cl) {
    return getRetrofit(url).create(cl);
  }

  private static class LoggingInterceptor implements Interceptor {
    private static final String UA = "User-Agent";

    @Override public Response intercept(Chain chain) throws IOException {
      Request request = chain.request().newBuilder().addHeader(UA, makeUA()).build();
      return chain.proceed(request);
    }

    private String makeUA() {
      //String s = Build.BRAND + "/" + Build.MODEL + "/" + Build.VERSION.RELEASE;
      //return Build.BRAND + "/" + Build.MODEL + "/" + Build.VERSION.RELEASE;
      return "Mozilla/5.0 (Linux; Android 4.4.2; Nexus 4 Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/34.0.1847.114 Mobile Safari/537.36";
    }
  }
}

