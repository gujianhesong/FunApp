package com.pinery.fun.video.mvp;

import com.pinery.base.callback.OnDataCallback;
import com.pinery.base.mvp.BaseRxJavaPresenter;
import com.pinery.fun.video.bean.TagItemsBean;
import com.pinery.fun.video.model.TagModel;

import javax.inject.Inject;

/**
 * Created by gujian on 2019-3-21
 */
public class TagItemsPresenter extends BaseRxJavaPresenter<TagContract.TagItemsView>
        implements TagContract.TagItemsPresenter {

    private TagModel model;

    @Inject
    public TagItemsPresenter() {
        model = new TagModel();
    }


    @Override
    public void onStart() {
    }

    @Override
    public void requestTagItems(int tagId) {
        addDisposable(model.requestTagItems(tagId, 0, new OnDataCallback<TagItemsBean>() {
            @Override
            public void onSuccess(TagItemsBean bean) {
                if (mView != null) {
                    mView.updateTagItems(bean, true);
                }
            }

            @Override
            public void onError(Throwable throwable) {
                if (mView != null) {
                    mView.error(throwable);
                }
            }
        }));
    }

    @Override
    public void loadMoreData(int tagId, int page) {
        addDisposable(model.requestTagItems(tagId, page, new OnDataCallback<TagItemsBean>() {
            @Override
            public void onSuccess(TagItemsBean bean) {
                if (mView != null) {
                    mView.updateTagItems(bean, false);
                }
            }

            @Override
            public void onError(Throwable throwable) {
                if (mView != null) {
                    mView.error(throwable);
                }
            }
        }));
    }
}
