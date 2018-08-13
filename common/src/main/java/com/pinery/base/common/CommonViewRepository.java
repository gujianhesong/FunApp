package com.pinery.base.common;

import android.content.Context;
import android.support.annotation.NonNull;
import com.pinery.base.common.loading.ILoadingView;
import com.pinery.base.common.toast.IToastView;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import javax.inject.Inject;

import static dagger.internal.Preconditions.checkNotNull;

public abstract class CommonViewRepository implements ILoadingView, ILoadingView.Factory,
    IToastView, IToastView.Factory {

    private ILoadingView mLoadingView;
    private IToastView mToastView;

    public CommonViewRepository(Context context) {
        try {
            Class<? extends ILoadingView> c = provideLoadingView();
            Constructor<? extends ILoadingView> constructor = c.getConstructor(Context.class);
            mLoadingView = checkNotNull(constructor.newInstance(context), "loadingView can not be null");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        try {
            Class<? extends IToastView> c = provideToastView();
            Constructor<? extends IToastView> constructor = c.getConstructor(Context.class);
            mToastView = checkNotNull(constructor.newInstance(context), "toastView can not be null");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showLoading(boolean cancelable) {
        if(mLoadingView != null){
            mLoadingView.showLoading(cancelable);
        }
    }

    @Override
    public void hideLoading() {
        if(mLoadingView != null){
            mLoadingView.hideLoading();
        }
    }

    @Override
    public boolean isShowing() {
        if(mLoadingView != null){
            return mLoadingView.isShowing();
        }
        return false;
    }

    @Override
    public void showShortToast(CharSequence text) {
        if(mToastView != null){
            mToastView.showShortToast(text);
        }
    }

    @Override
    public void showLongToast(CharSequence text) {
        if(mToastView != null){
            mToastView.showLongToast(text);
        }
    }

    @Override
    public void showShortNewToast(CharSequence text) {
        if(mToastView != null){
            mToastView.showShortNewToast(text);
        }
    }

    @Override
    public void showLongNewToast(CharSequence text) {
        if(mToastView != null){
            mToastView.showLongNewToast(text);
        }
    }

}
