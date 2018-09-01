package com.pinery.fun.video.ui.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import com.pinery.base.fragment.BaseFragment;
import com.pinery.base.util.ViewUtil;
import com.pinery.fun.video.R;
import com.pinery.fun.video.ui.adapter.ViewPagerAdapter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gujian on 2018-08-12.
 */

public class HomeFragment extends BaseFragment {
  private TabLayout mIndicator;
  private ViewPager mViewPager;
  private List<Fragment> mFragmentList;
  private List<String> mTitleList;

  @Override protected void initInjector() {

  }

  @Override protected int getLayoutId() {
    return R.layout.fragment_home;
  }

  @Override protected void initViews(View view, Bundle savedInstanceState) {
    mIndicator = ViewUtil.findViewById(view, R.id.indicator1);
    mViewPager = ViewUtil.findViewById(view, R.id.viewPager1);

    initTitile();
    initFragment();
    initViewPager();
  }

  @Override protected void initData() {

  }

  private void initTitile() {
    mTitleList = new ArrayList<>();
    mTitleList.add("视频");
    mTitleList.add("视频2");
    mTitleList.add("直播");
    mTitleList.add("同城");

    mIndicator.setTabMode(TabLayout.MODE_FIXED);
    for(String title : mTitleList){
      mIndicator.addTab(mIndicator.newTab().setText(title));
    }
  }

  private void initFragment() {
    mFragmentList = new ArrayList<>();
    mFragmentList.add(HuoVideoListFragment.newInstance());
    mFragmentList.add(HuoVideoListFragment2.newInstance());
    mFragmentList.add(HuoLiveListFragment.newInstance());
    mFragmentList.add(HuoCityListFragment.newInstance());
  }

  private void initViewPager(){
    //设置适配器
    mViewPager.setAdapter(new ViewPagerAdapter(getFragmentManager(), mFragmentList, mTitleList));
    //将tablayout与fragment关联
    mIndicator.setupWithViewPager(mViewPager);
  }

}
