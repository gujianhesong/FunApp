package com.pinery.test;

import com.pinery.base.mvp.BaseRxJavaPresenter;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import javax.inject.Inject;

/**
 * Created by gujian on 2018-08-11.
 */

public class TestPresenter extends BaseRxJavaPresenter<TestContract.View>
    implements TestContract.Presenter {

  @Inject public TestPresenter() {

  }

  @Override public void onStart() {

  }

  @Override public void checkUpdate() {
    Flowable.create(new FlowableOnSubscribe<Integer>() {
      @Override public void subscribe(@NonNull FlowableEmitter<Integer> e) throws Exception {
        e.onNext(1);
        e.onNext(2);
        e.onNext(3);
        e.onNext(4);
      }
    }, BackpressureStrategy.BUFFER)
        .subscribeOn(Schedulers.newThread())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Consumer<Integer>() {
          @Override public void accept(@NonNull Integer integer) throws Exception {
            mView.showUpdate("hahaha" + integer);
          }
        }, new Consumer<Throwable>() {
          @Override public void accept(@NonNull Throwable throwable) throws Exception {

          }
        });

  }

}
