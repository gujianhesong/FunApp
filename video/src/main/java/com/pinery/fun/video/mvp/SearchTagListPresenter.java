package com.pinery.fun.video.mvp;

import com.pinery.base.mvp.BaseRxJavaPresenter;
import com.pinery.fun.video.bean.SearchTagListBean;
import com.pinery.fun.video.callback.OnDataCallback;
import com.pinery.fun.video.model.SearchModel;

import javax.inject.Inject;

/**
 * Created by gujian on 2019-3-21
 */
public class SearchTagListPresenter extends BaseRxJavaPresenter<SearchContract.TagListView>
        implements SearchContract.TagListPresenter {

    private SearchModel model;

    @Inject
    public SearchTagListPresenter() {
        model = new SearchModel();
    }

    @Override
    public void onStart() {
    }

    @Override
    public void requestTagList() {
        addDisposable(model.requestTagList(new OnDataCallback<SearchTagListBean>() {
            @Override
            public void onSuccess(SearchTagListBean bean) {
                if (mView != null) {
                    mView.updateTagList(bean);
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
