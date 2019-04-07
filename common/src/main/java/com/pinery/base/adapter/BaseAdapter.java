package com.pinery.base.adapter;

import android.support.v7.widget.RecyclerView;
import com.github.jdsjlzx.interfaces.OnItemClickListener;
import com.github.jdsjlzx.interfaces.OnItemLongClickListener;

/**
 * Created by gujian on 2018-08-25.
 */

public abstract class BaseAdapter<VH extends RecyclerView.ViewHolder>
    extends RecyclerView.Adapter<VH> implements OnItemClickListener, OnItemLongClickListener {
}
