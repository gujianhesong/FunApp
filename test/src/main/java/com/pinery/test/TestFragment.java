package com.pinery.test;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.pinery.base.fragment.BaseFragment;

/**
 * Created by gujian on 2018-08-11.
 */
public class TestFragment extends BaseFragment<TestPresenter> implements TestContract.View {
  private Button btnShow;

  public static TestFragment newInstance(){
    return new TestFragment();
  }

  @Override protected void initInjector() {
    DaggerTestFragmentComponent.create().inject(this);
  }

  @Override protected int getLayoutId() {
    return R.layout.fragment_test;
  }

  @Override protected void initViews(View view, Bundle savedInstanceState) {
    btnShow = (Button) view.findViewById(R.id.btn_show);
    btnShow.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        mPresenter.checkUpdate();
      }
    });
  }

  @Override protected void initData() {

  }

  @Override public void showUpdate(String message) {
    showToast(message);
  }
}
