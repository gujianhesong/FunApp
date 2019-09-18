package com.pinery.fun.joke.ui.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import com.bumptech.glide.Glide;
import com.pinery.base.callback.OnClickRefreshCallback;
import com.pinery.base.fragment.BaseFragment;
import com.pinery.base.util.LogUtil;
import com.pinery.base.util.ViewUtil;
import com.pinery.fun.joke.JokeApplication;
import com.pinery.fun.joke.R;
import com.pinery.fun.joke.ui.adapter.ViewPagerAdapter;
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
    mTitleList.add("推荐");
    mTitleList.add("视频");
    mTitleList.add("图片");
    mTitleList.add("笑话");

    mIndicator.setTabMode(TabLayout.MODE_FIXED);
    for (String title : mTitleList) {
      mIndicator.addTab(mIndicator.newTab().setText(title));
    }
    mIndicator.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
      @Override public void onTabSelected(TabLayout.Tab tab) {
      }

      @Override public void onTabUnselected(TabLayout.Tab tab) {
      }

      @Override public void onTabReselected(TabLayout.Tab tab) {
        Fragment fragment =  mFragmentList.get(tab.getPosition());
        if (fragment instanceof OnClickRefreshCallback){
          ((OnClickRefreshCallback)fragment).onClickRefresh();
        }
      }
    });
  }

  private void initFragment() {
    mFragmentList = new ArrayList<>();
    mFragmentList.add(JokeListFragment.newInstance(""));
    mFragmentList.add(JokeListFragment.newInstance("video"));
    mFragmentList.add(JokeListFragment.newInstance("image"));
    mFragmentList.add(JokeListFragment.newInstance("text"));
  }

  private void initViewPager() {
    //设置适配器
    mViewPager.setAdapter(new ViewPagerAdapter(getFragmentManager(), mFragmentList, mTitleList));
    mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
      @Override
      public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

      }

      @Override public void onPageSelected(int position) {
        LogUtil.i("onPageSelected : " + position);

        //清空Glide内存缓存
        Glide.get(getContext().getApplicationContext()).clearMemory();

        //通知gc
        JokeApplication.getInstance().notifyGc();
      }

      @Override public void onPageScrollStateChanged(int state) {

      }
    });
    //将tablayout与fragment关联
    mIndicator.setupWithViewPager(mViewPager);
  }
}
