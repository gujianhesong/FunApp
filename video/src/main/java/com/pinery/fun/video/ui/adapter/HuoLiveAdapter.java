package com.pinery.fun.video.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.android.arouter.launcher.ARouter;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.pinery.base.util.GlideUtil;
import com.pinery.base.util.ViewUtil;
import com.pinery.fun.video.R;
import com.pinery.fun.video.bean.BaseVideoItemBean;
import com.pinery.fun.video.bean.HuoLiveItemBean;
import com.pinery.fun.video.bean.LivePlayBean;
import com.pinery.fun.video.common.Constants;
import java.util.ArrayList;
import java.util.List;

public class HuoLiveAdapter extends HuoBaseVideoAdapter {
  private static final int ITEM_TYPE_UNKNOWN = 0;
  private static final int ITEM_TYPE_LIVE = 1;

  public HuoLiveAdapter(Context context, List<BaseVideoItemBean> list) {
    super(context, list);
  }

  public void bindRecyclerView(RecyclerView recyclerView) {
    this.recyclerView = recyclerView;
  }

  @Override
  public BaseVideoAdapter.BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    if (viewType == ITEM_TYPE_LIVE) {
      final View view =
          LayoutInflater.from(parent.getContext()).inflate(R.layout.item_huo_live, parent, false);
      return new LiveViewHolder(view);
    }
    return null;
  }

  @Override public int getItemViewType(int position) {
    BaseVideoItemBean itemBean = list.get(position);
    if (itemBean instanceof HuoLiveItemBean) {
      return ITEM_TYPE_LIVE;
    }
    return ITEM_TYPE_UNKNOWN;
  }

  @Override protected List<BaseViewHolderHandler> provideViewHolderHandler() {
    List<BaseViewHolderHandler> list = new ArrayList<>();
    list.add(new LiveViewHolderHandler());
    return list;
  }

  @Override public void onItemClick(View view, int position) {
    BaseVideoItemBean itemBean = list.get(position);

    if (itemBean instanceof HuoLiveItemBean) {
      HuoLiveItemBean liveItemBean = (HuoLiveItemBean) itemBean;
      String url = liveItemBean.getData().getStream_url().getRtmp_pull_url();
      String userName = liveItemBean.getData().getOwner().getNickname();
      String avatar = liveItemBean.getData().getOwner().getAvatar_thumb().getUrl_list().get(0);

      LivePlayBean bean = new LivePlayBean();
      bean.setUrl(url);
      bean.setAuthorName(userName);
      bean.setAuthorAvatar(avatar);

      ARouter.getInstance()
          .build(Constants.PATH_LIVE_PLAY)
          .withSerializable(Constants.KEY_LIVE_PLAY_BEAN, bean)
          .navigation();
    }
  }

  @Override public void onItemLongClick(View view, int position) {

  }

  class LiveViewHolderHandler extends BaseViewHolderHandler<LiveViewHolder, HuoLiveItemBean> {

    @Override
    protected boolean shouldHandle(BaseViewHolder viewHodler, BaseVideoItemBean dataBeanX) {
      if(viewHodler instanceof LiveViewHolder && dataBeanX instanceof HuoLiveItemBean){
        return true;
      }
      return false;
    }

    @Override public void setLayoutParams(LiveViewHolder holder, HuoLiveItemBean dataBeanX) {
      try {
        int parentWidth = recyclerView.getMeasuredWidth();
        int videoWidth = dataBeanX.getData().getCover().getWidth();
        int videoHeight = dataBeanX.getData().getCover().getHeight();
        if (holder.ivImage.getDrawable() != null) {
          videoWidth = holder.ivImage.getDrawable().getIntrinsicWidth();
          videoHeight = holder.ivImage.getDrawable().getIntrinsicHeight();
        }

        int width = parentWidth;
        int height = (int) (videoHeight * 1f / videoWidth * width);

        ViewGroup.LayoutParams params = holder.ivImage.getLayoutParams();
        params.width = width;
        params.height = height;

        holder.ivImage.setScaleType(ImageView.ScaleType.FIT_XY);
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }

    @Override public void fillData(LiveViewHolder viewHodler, HuoLiveItemBean dataBeanX) {
      try {
        viewHodler.tvLocation.setText(dataBeanX.getData().getOwner().getCity());
      } catch (Exception ex) {
      }

      try {
        viewHodler.tvName.setText(dataBeanX.getData().getOwner().getNickname());
      } catch (Exception ex) {
      }

      try {
        viewHodler.tvCount.setText(String.format("%d人", dataBeanX.getData().getUser_count()));
      } catch (Exception ex) {
      }
    }

    @Override
    public void loadCoverImage(final LiveViewHolder viewHodler, final HuoLiveItemBean dataBeanX) {
      setLayoutParams(viewHodler, dataBeanX);

      String url = dataBeanX.getData().getCover().getUrl_list().get(0);
      GlideUtil.loadImage(viewHodler.ivImage, url);
    }

    @Override public void loadAvatarImage(LiveViewHolder viewHodler, HuoLiveItemBean dataBeanX) {

    }
  }

  class LiveViewHolder extends BaseVideoAdapter.BaseViewHolder {
    ImageView ivImage;
    TextView tvLocation;
    TextView tvName;
    TextView tvCount;

    LiveViewHolder(View itemView) {
      super(itemView);
      ivImage = ViewUtil.findViewById(itemView, R.id.iv_image);
      tvLocation = ViewUtil.findViewById(itemView, R.id.tv_location);
      tvName = ViewUtil.findViewById(itemView, R.id.tv_name);
      tvCount = ViewUtil.findViewById(itemView, R.id.tv_count);
    }
  }
}
