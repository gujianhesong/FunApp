package com.pinery.fun.video.ui.activity;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import android.widget.ImageView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.bumptech.glide.Glide;
import com.pinery.base.activity.BaseActivity;
import com.pinery.base.common.CommonViewRepository;
import com.pinery.base.util.NetWorkUtil;
import com.pinery.base.util.ViewUtil;
import com.pinery.fun.video.R;
import com.pinery.fun.video.bean.SearchTagListBean;
import com.pinery.fun.video.common.Constants;
import com.pinery.fun.video.dagger.DaggerSearchCenterActivityComponent;
import com.pinery.fun.video.mvp.SearchContract;
import com.pinery.fun.video.mvp.SearchTagListPresenter;
import com.pinery.fun.video.ui.adapter.ViewPagerAdapter;
import com.pinery.fun.video.ui.fragment.SearchTagItemListFragment;

import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gujian on 2019/3/21.
 */
@Route(path = Constants.PATH_SEARCH_CENTER)
public class SearchCenterActivity extends BaseActivity<SearchTagListPresenter> implements
    SearchContract.TagListView {

  private Toolbar toolbar;
  private Banner mBanner;

  private TabLayout mIndicator;
  private ViewPager mViewPager;
  private List<Fragment> mFragmentList;
  private List<String> mTitleList;

  @Override protected void initInjector() {
    DaggerSearchCenterActivityComponent.builder().build().inject(this);
  }

  @Override protected int getLayoutResId() {
    return R.layout.activity_search_center;
  }

  @Override protected void initViews() {
    mIndicator = ViewUtil.findViewById(this, R.id.indicator);
    mViewPager = ViewUtil.findViewById(this, R.id.viewPager);

    mBanner = ViewUtil.findViewById(this, R.id.banner);
    mBanner.setDelayTime(5000);
    mBanner.setImageLoader(mImageLoader);
    mBanner.setOnBannerListener(mOnBannerListener);
  }

  @Override protected void initData() {
    if (!NetWorkUtil.isNetWorkAvailable(this)) {
      showErrorMessage(getString(R.string.tip_network_error));
      return;
    }

    mPresenter.requestTagList();
  }

  @Override protected CommonViewRepository provideCommonViewRepository() {
    return null;
  }

  @Override
  public void updateTagList(SearchTagListBean bean) {
    mTitleList = new ArrayList<>();
    mFragmentList = new ArrayList<>();

    //显示banner
    mBanner.setImages(bean.getData().getBanners());
    //banner设置方法全部调用完毕时最后调用
    mBanner.start();

    for (SearchTagListBean.DataBeanX.TagsBean tag : bean.getData().getTags()) {
      mTitleList.add(tag.getName());
      mFragmentList.add(SearchTagItemListFragment.newInstance(tag.getId()));
    }

    for (String title : mTitleList) {
      mIndicator.addTab(mIndicator.newTab().setText(title));
    }

    //设置适配器
    mViewPager.setAdapter(
        new ViewPagerAdapter(getSupportFragmentManager(), mFragmentList, mTitleList));
    //将tablayout与fragment关联
    mIndicator.setupWithViewPager(mViewPager);
  }

  @Override public void error(Throwable throwable) {

  }

  private ImageLoader mImageLoader = new ImageLoader() {
    @Override public void displayImage(Context context, Object path, ImageView imageView) {
      if (path instanceof SearchTagListBean.DataBeanX.BannersBean){
        String imgUrl = ((SearchTagListBean.DataBeanX.BannersBean) path).getUrl_list().get(0);
        Glide.with(context).load(imgUrl).into(imageView);
      }
    }
  };

  private OnBannerListener mOnBannerListener = new OnBannerListener() {
    @Override public void OnBannerClick(int position) {

    }
  };

}
