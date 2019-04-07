package com.pinery.fun.video.mvp;

import com.pinery.base.mvp.BaseRxJavaPresenter;
import com.pinery.fun.video.bean.SearchTagItemsBean;
import com.pinery.fun.video.callback.OnDataCallback;
import com.pinery.fun.video.model.SearchModel;

import javax.inject.Inject;

/**
 * Created by gujian on 2019-3-21
 */
public class SearchTagItemsPresenter extends BaseRxJavaPresenter<SearchContract.TagItemsView>
        implements SearchContract.TagItemsPresenter {

    private SearchModel model;

    @Inject
    public SearchTagItemsPresenter() {
        model = new SearchModel();
    }


    @Override
    public void onStart() {
    }

    @Override
    public void requestTagItems(int tagId) {
        addDisposable(model.requestTagItems(tagId, 0, new OnDataCallback<SearchTagItemsBean>() {
            @Override
            public void onSuccess(SearchTagItemsBean bean) {
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
        addDisposable(model.requestTagItems(tagId, page, new OnDataCallback<SearchTagItemsBean>() {
            @Override
            public void onSuccess(SearchTagItemsBean bean) {
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
