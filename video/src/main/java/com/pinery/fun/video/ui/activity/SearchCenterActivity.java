package com.pinery.fun.video.ui.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.utils.TextUtils;
import com.pinery.base.activity.BaseActivity;
import com.pinery.base.callback.OnClickRefreshCallback;
import com.pinery.base.common.CommonViewRepository;
import com.pinery.base.util.NetWorkUtil;
import com.pinery.base.util.ViewUtil;
import com.pinery.fun.video.R;
import com.pinery.fun.video.callback.OnSearchCallback;
import com.pinery.fun.video.common.Constants;
import com.pinery.fun.video.ui.adapter.ViewPagerAdapter;
import com.pinery.fun.video.ui.fragment.SearchSongFragment;
import com.pinery.fun.video.ui.fragment.SearchTagFragment;
import com.pinery.fun.video.ui.fragment.SearchUserFragment;
import com.pinery.fun.video.ui.fragment.SearchVideoFragment;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gujian on 2019/3/21.
 */
@Route(path = Constants.PATH_SEARCH_CENTER)
public class SearchCenterActivity extends BaseActivity {

  private EditText etSearch;
  private TextView btnSearch;
  private Toolbar toolbar;

  private TabLayout mIndicator;
  private ViewPager mViewPager;
  private List<Fragment> mFragmentList;
  private List<String> mTitleList;

  @Override protected void initInjector() {
  }

  @Override protected int getLayoutResId() {
    return R.layout.activity_search_center;
  }

  @Override protected void initViews() {
    initToolbar();
    initTitile();
    initFragment();
    initViewPager();
  }

  @Override protected void initData() {
    if (!NetWorkUtil.isNetWorkAvailable(this)) {
      showErrorMessage(getString(R.string.tip_network_error));
      return;
    }
  }

  private void initToolbar() {
    toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    toolbar.setNavigationIcon(R.drawable.wk);
    toolbar.setNavigationOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        finish();
      }
    });

    etSearch = ViewUtil.findViewById(this, R.id.et_search);
    etSearch.setOnKeyListener(new View.OnKeyListener() {
      @Override
      public boolean onKey(View v, int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_ENTER) {
          // 先隐藏键盘
          ((InputMethodManager) getSystemService(INPUT_METHOD_SERVICE))
              .hideSoftInputFromWindow(SearchCenterActivity.this.getCurrentFocus()
                  .getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

          String keyword = etSearch.getText().toString();
          if (!TextUtils.isEmpty(keyword)) {
            search(keyword);
          }
          return true;
        }
        return false;
      }
    });
    btnSearch = ViewUtil.findViewById(this, R.id.btn_search);
    btnSearch.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        String keyword = etSearch.getText().toString();
        if (!TextUtils.isEmpty(keyword)) {
          search(keyword);
        }
      }
    });
  }

  @Override protected CommonViewRepository provideCommonViewRepository() {
    return null;
  }

  private void initTitile() {
    mTitleList = new ArrayList<>();
    mTitleList.add("视频");
    mTitleList.add("用户");
    mTitleList.add("话题圈");
    mTitleList.add("音乐");

    mIndicator = ViewUtil.findViewById(this, R.id.indicator);
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
        Fragment fragment = mFragmentList.get(tab.getPosition());
        if (fragment instanceof OnClickRefreshCallback) {
          ((OnClickRefreshCallback) fragment).onClickRefresh();
        }
      }
    });
  }

  private void initFragment() {
    mFragmentList = new ArrayList<>();
    mFragmentList.add(SearchVideoFragment.newInstance());
    mFragmentList.add(SearchUserFragment.newInstance());
    mFragmentList.add(SearchTagFragment.newInstance());
    mFragmentList.add(SearchSongFragment.newInstance());
  }

  private void initViewPager() {
    mViewPager = ViewUtil.findViewById(this, R.id.viewPager);
    mViewPager.setAdapter(
        new ViewPagerAdapter(getSupportFragmentManager(), mFragmentList, mTitleList));
    mIndicator.setupWithViewPager(mViewPager);
  }

  private void search(String keyword) {
    for (Fragment fragment : mFragmentList) {
      if (fragment instanceof OnSearchCallback) {
        ((OnSearchCallback) fragment).onSearch(keyword);
      }
    }
  }
}
