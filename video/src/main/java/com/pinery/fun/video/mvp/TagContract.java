package com.pinery.fun.video.mvp;

import com.pinery.base.mvp.IPresenter;
import com.pinery.base.mvp.IView;
import com.pinery.fun.video.bean.TagItemsBean;
import com.pinery.fun.video.bean.SearchTagListBean;

/**
 * @author hesong
 * @time 2019/3/21
 * @desc
 */

public interface TagContract {

  interface TagListView extends IView {
    void updateTagList(SearchTagListBean bean);
    void error(Throwable throwable);
  }

  interface TagItemsView extends IView {
    void updateTagItems(TagItemsBean bean, boolean isRefresh);
    void error(Throwable throwable);
  }

  interface TagListPresenter extends IPresenter<TagListView> {
    void requestTagList();
  }

  interface TagItemsPresenter extends IPresenter<TagItemsView> {
    void requestTagItems(int tagId);
    void loadMoreData(int tagId, int page);
  }

}
