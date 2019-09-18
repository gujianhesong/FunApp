package com.pinery.fun.video;

import android.app.Application;
import com.alibaba.android.arouter.launcher.ARouter;
import com.pinery.base.BaseApplication;
import com.pinery.base.util.ScreenDensityUtil;

/**
 * Created by hesong-os on 2018/8/9.
 */

public class VideoApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();

    init();
  }

  private void init() {
    BaseApplication.register(this, ".Video");

    initArouter();
    screenCompact();
  }

  private void initArouter() {
    ARouter.openLog();     // 打印日志
    ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
    ARouter.init(this); // 尽可能早，推荐在Application中初始化
  }

  private void screenCompact(){
    ScreenDensityUtil.setDensity(this);
  }
}
