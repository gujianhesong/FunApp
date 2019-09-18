package com.pinery.fun.video.ui.activity;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.bumptech.glide.Glide;
import com.pinery.base.activity.BaseActivity;
import com.pinery.base.common.CommonViewRepository;
import com.pinery.base.util.NetWorkUtil;
import com.pinery.base.util.ViewUtil;
import com.pinery.fun.video.R;
import com.pinery.fun.video.bean.SearchTagListBean;
import com.pinery.fun.video.common.Constants;
import com.pinery.fun.video.dagger.DaggerTagCenterActivityComponent;
import com.pinery.fun.video.mvp.TagContract;
import com.pinery.fun.video.mvp.TagListPresenter;
import com.pinery.fun.video.ui.adapter.ViewPagerAdapter;
import com.pinery.fun.video.ui.fragment.TagItemListFragment;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gujian on 2019/3/21.
 */
@Route(path = Constants.PATH_TAG_CENTER)
public class TagCenterActivity extends BaseActivity<TagListPresenter> implements
    TagContract.TagListView {

  private Toolbar toolbar;
  private Banner mBanner;

  private TextView tvSearch;
  private TabLayout mIndicator;
  private ViewPager mViewPager;
  private List<Fragment> mFragmentList;
  private List<String> mTitleList;

  @Override protected void initInjector() {
    DaggerTagCenterActivityComponent.builder().build().inject(this);
  }

  @Override protected int getLayoutResId() {
    return R.layout.activity_tag_center;
  }

  @Override protected void initViews() {
    initToolbar();

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

  private void initToolbar() {
    toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    toolbar.setNavigationIcon(R.drawable.wk);
    toolbar.setNavigationOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        finish();
      }
    });

    tvSearch = ViewUtil.findViewById(this, R.id.tv_search);
    tvSearch.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        ARouter.getInstance()
            .build(Constants.PATH_SEARCH_CENTER)
            .navigation();
      }
    });
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
      mFragmentList.add(TagItemListFragment.newInstance(tag.getId()));
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
