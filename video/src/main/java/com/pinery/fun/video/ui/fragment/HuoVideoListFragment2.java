package com.pinery.fun.video.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.pinery.fun.video.ui.viewproxy.HuoVideoListViewProxy;

/**
 * Created by gujian on 2018-08-12.
 */

public class HuoVideoListFragment2 extends Fragment {
  HuoVideoListViewProxy mProxy;

  public static HuoVideoListFragment2 newInstance() {
    return new HuoVideoListFragment2();
  }

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    if(mProxy == null){
      mProxy = HuoVideoListViewProxy.newInstance(container.getContext());
    }

    return mProxy.onCreateView();
  }

  @Override public void onDestroyView() {
    super.onDestroyView();

    if(mProxy != null){
      mProxy.onDestroyView();
    }
  }
}