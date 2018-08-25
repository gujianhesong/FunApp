package com.pinery.fun.video.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import com.pinery.fun.video.bean.BaseVideoItemBean;
import java.util.List;

public abstract class HuoBaseVideoAdapter
    extends BaseVideoAdapter<BaseVideoAdapter.BaseViewHolder> {

  protected List<BaseVideoItemBean> list;
  protected Context context;
  protected RecyclerView recyclerView;

  private ViewHolderProxyHandler viewHolderProxyHandler;

  public HuoBaseVideoAdapter(Context context, List<BaseVideoItemBean> list) {
    this.context = context;
    this.list = list;

    viewHolderProxyHandler = new ViewHolderProxyHandler(provideViewHolderHandler());
  }

  public void bindRecyclerView(RecyclerView recyclerView) {
    this.recyclerView = recyclerView;
  }

  @Override public void onBindViewHolder(BaseViewHolder viewHodler, int position) {
    BaseVideoItemBean dataBeanX = list.get(position);
    if (viewHodler != null && dataBeanX != null) {
      viewHolderProxyHandler.bindViewHolder(viewHodler, dataBeanX);
    }
  }

  @Override public int getItemCount() {
    return list != null ? list.size() : 0;
  }

  protected class ViewHolderProxyHandler
      implements IViewHolderProxy<BaseViewHolder, BaseVideoItemBean> {
    List<BaseViewHolderHandler> list;

    ViewHolderProxyHandler(List<BaseViewHolderHandler> list) {
      this.list = list;
    }

    @Override public void bindViewHolder(BaseViewHolder viewHodler, BaseVideoItemBean dataBeanX) {
      if (list != null) {
        for (BaseViewHolderHandler handler : list) {
          if (handler != null) {
            if(handler.shouldHandle(viewHodler, dataBeanX)){
              handler.bindViewHolder(viewHodler, dataBeanX);
            }
          }
        }
      }

      /*if (viewHodler instanceof CityVideoViewHolder && dataBeanX instanceof HuoVideoItemBean) {
        videoViewHolderHandler.bindViewHolder((CityVideoViewHolder) viewHodler,
            (HuoVideoItemBean) dataBeanX);
      } else if (viewHodler instanceof CityLiveViewHolder && dataBeanX instanceof HuoLiveItemBean) {
        liveViewHolderHandler.bindViewHolder((CityLiveViewHolder) viewHodler,
            (HuoLiveItemBean) dataBeanX);
      }*/
    }
  }

  protected abstract List<BaseViewHolderHandler> provideViewHolderHandler();
}
