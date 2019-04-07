package com.pinery.base.widget;

import android.app.Activity;
import android.content.Context;
import com.pinery.base.common.loading.ILoadingView;

/**
 * 实现提示加载中Dialog {@link ILoadingView}
 */
public class LoadingView implements ILoadingView {

    private Context mContext;
    private LoadingDialog mLoadingDialog;
    private int taskCount;

    public LoadingView(Activity activity) {
        mContext = activity;
        mLoadingDialog = new LoadingDialog(mContext);
        taskCount = 0;
    }

    @Override
    public void showLoading(boolean cancelable) {
        if (mLoadingDialog != null) {
            if (!mLoadingDialog.isShowing()) {
                mLoadingDialog.show();
            }
            taskCount++;
        }
    }

    @Override
    public void hideLoading() {
        if (mLoadingDialog != null) {
            taskCount--;
            if (mLoadingDialog.isShowing() && taskCount <= 0) {
                mLoadingDialog.dismiss();
            }
        }
    }

    @Override
    public boolean isShowing() {
        return mLoadingDialog != null && mLoadingDialog.isShowing();
    }

}
