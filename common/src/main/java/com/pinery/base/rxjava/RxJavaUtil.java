package com.pinery.base.rxjava;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.Callable;

/**
 * @author hesong
 * @e-mail hes1335@13322.com
 * @time 2018/4/11
 * @desc
 * @version: 3.1.2
 */

public class RxJavaUtil {
  public interface MethodExcutor{
    boolean excute();
  }

  public static <T> ObservableTransformer schedulersTransform() {
    return new ObservableTransformer<T, T>() {
      @Override public ObservableSource<T> apply(Observable<T> upstream) {
        return upstream.subscribeOn(Schedulers.io())
            .unsubscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());
      }
    };
  }

  public static Observable wrappedMethod(final MethodExcutor excutor) {
    return Observable.defer(new Callable<ObservableSource<?>>() {
      @Override public ObservableSource<?> call() throws Exception {
        return Observable.just(excutor.excute());
      }
    });
  }

  public static void doMethodExcute(final MethodExcutor excutor, final Consumer<Boolean> consumer) {
    RxJavaUtil.wrappedMethod(excutor)
        .compose(RxJavaUtil.schedulersTransform())
        .subscribe(consumer);
  }

  public static void doMethodExcute(final MethodExcutor excutor) {
    RxJavaUtil.wrappedMethod(excutor)
        .compose(RxJavaUtil.schedulersTransform())
        .subscribe(new Consumer() {
          @Override public void accept(Object o) throws Exception {

          }
        });
  }


}
