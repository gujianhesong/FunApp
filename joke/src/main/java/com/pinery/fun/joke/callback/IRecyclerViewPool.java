package com.pinery.fun.joke.callback;

import android.support.v7.widget.RecyclerView;

/**
 * @author hesong
 * @time 2018/3/15
 * @desc
 * @version: 3.1.2
 */

public interface IRecyclerViewPool {

  void setRecyclerViewPool(RecyclerView.RecycledViewPool pool);

  RecyclerView.RecycledViewPool getRecyclerViewPool();

}
