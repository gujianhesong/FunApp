package com.pinery.test;

import android.content.Context;
import com.pinery.base.common.CommonViewRepository;
import com.pinery.base.common.loading.ILoadingView;
import com.pinery.base.common.toast.IToastView;

/**
 * Created by gujian on 2018-08-11.
 */

public class DefaultCommonViewRepository extends CommonViewRepository {

  public DefaultCommonViewRepository(Context context){
    super(context);
  }

  @Override public Class<? extends ILoadingView> provideLoadingView() {
    return LoadingView.class;
  }

  @Override public Class<? extends IToastView> provideToastView() {
    return ToastView.class;
  }

}
