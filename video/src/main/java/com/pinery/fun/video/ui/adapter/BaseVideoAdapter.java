package com.pinery.fun.video.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.pinery.base.adapter.BaseAdapter;
import com.pinery.fun.video.bean.BaseVideoItemBean;

/**
 * Created by gujian on 2018-08-25.
 */

public abstract class BaseVideoAdapter<VH extends BaseVideoAdapter.BaseViewHolder> extends
    BaseAdapter<VH> implements com.github.jdsjlzx.interfaces.OnItemClickListener,
    com.github.jdsjlzx.interfaces.OnItemLongClickListener {

  protected interface IViewHolderHandler<VH extends BaseViewHolder, T extends BaseVideoItemBean> {
    void setLayoutParams(VH holder, T dataBeanX);

    void fillData(VH viewHodler, T dataBeanX);

    void loadCoverImage(VH viewHodler, T dataBeanX);

    void loadAvatarImage(VH viewHodler, T dataBeanX);
  }

  protected interface IViewHolderProxy<VH extends BaseViewHolder, T extends BaseVideoItemBean> {
    void bindViewHolder(VH viewHodler, T dataBeanX);
  }

  protected abstract class BaseViewHolderHandler<VH extends BaseViewHolder, T extends BaseVideoItemBean>
      implements IViewHolderHandler<VH, T>, IViewHolderProxy<VH, T> {
    public void bindViewHolder(VH viewHodler, T dataBeanX) {
      setLayoutParams(viewHodler, dataBeanX);
      fillData(viewHodler, dataBeanX);
      loadCoverImage(viewHodler, dataBeanX);
      loadAvatarImage(viewHodler, dataBeanX);
    }

    protected abstract boolean shouldHandle(BaseViewHolder viewHodler, BaseVideoItemBean dataBeanX);
  }

  public static class BaseViewHolder extends RecyclerView.ViewHolder{

    public BaseViewHolder(View itemView) {
      super(itemView);
    }
  }

}
