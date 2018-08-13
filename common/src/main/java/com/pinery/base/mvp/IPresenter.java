package com.pinery.base.mvp;

/**
 * Presenter基类
 */
public interface IPresenter<T extends IView>{

    void attachView(T view);

    void detachView();

    void onStart();
}