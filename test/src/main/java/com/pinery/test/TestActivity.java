package com.pinery.test;

import android.view.View;
import android.widget.Button;
import com.pinery.base.activity.BaseActivity;
import com.pinery.base.common.CommonViewRepository;

/**
 * Created by gujian on 2018-08-11.
 */

public class TestActivity extends BaseActivity<TestPresenter> implements TestContract.View{
  private Button btnShow;

  @Override protected void initInjector() {
    DaggerTestActivityComponent.create().inject(this);
  }

  @Override protected int getLayoutResId() {
    return R.layout.activity_test;
  }

  @Override protected void initViews() {
    btnShow = (Button) findViewById(R.id.btn_show);
    btnShow.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        mPresenter.checkUpdate();
      }
    });

    getSupportFragmentManager().beginTransaction().replace(R.id.rl_fragment, TestFragment.newInstance()).commit();
  }

  @Override protected void initData() {

  }

  @Override protected CommonViewRepository provideCommonViewRepository() {
    return new DefaultCommonViewRepository(this);
  }

  @Override public void showUpdate(String message) {
    showToast(message);
  }
}
