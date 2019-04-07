package com.pinery.fun.joke.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.widget.RecyclerView;
import com.pinery.fun.joke.callback.IRecyclerViewPool;
import java.util.List;

/**
 * Created by gujian on 2018-08-12.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {
  private List<Fragment> mFragmentList;
  private List<String> mTitleList;
  private RecyclerView.RecycledViewPool mPool;

  public ViewPagerAdapter(FragmentManager fm, List<Fragment> fragmentList, List<String> titleList) {
    super(fm);
    mFragmentList = fragmentList;
    mTitleList = titleList;
    mPool = new RecyclerView.RecycledViewPool();
  }

  @Override public Fragment getItem(int position) {
    Fragment fragment = mFragmentList.get(position);
    if(fragment != null && fragment instanceof IRecyclerViewPool){
      IRecyclerViewPool iRecyclerViewPool = (IRecyclerViewPool)fragment;
      if(iRecyclerViewPool.getRecyclerViewPool() == null){
        iRecyclerViewPool.setRecyclerViewPool(mPool);
      }
    }
    return fragment;
  }

  @Override public int getCount() {
    return mFragmentList.size();
  }

  @Override public CharSequence getPageTitle(int position) {
    return mTitleList.get(position);
  }
}
