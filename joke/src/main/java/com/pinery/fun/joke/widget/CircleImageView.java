package com.pinery.fun.joke.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

/**
 * 圆形ImageView
 *
 * Created by hesong on 18/8/18
 */

public class CircleImageView extends AppCompatImageView {

  private static final int COVER_COLOR = 0x22ffff00;

  private Path mPath;
  private int mRadius;

  private int mWidth;
  private int mHeight;
  private int mLastRadius;

  private Paint mCoverPaint;

  public CircleImageView(Context context) {
    super(context);

    init();
  }

  public CircleImageView(Context context, AttributeSet attrs) {
    super(context, attrs);

    init();
  }

  private void init() {
    setBackground(new ColorDrawable(Color.WHITE));

    mPath = new Path();
    mPath.setFillType(Path.FillType.EVEN_ODD);

    mCoverPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    mCoverPaint.setColor(COVER_COLOR);
  }

  private void checkPathChanged() {

    if (getWidth() == mWidth && getHeight() == mHeight) {
      return;
    }

    mWidth = getWidth();
    mHeight = getHeight();
    mRadius = Math.min(mWidth, mHeight) / 2;

    mPath.reset();
    mPath.addCircle(mWidth / 2, mHeight / 2, mRadius, Path.Direction.CW);
  }

  private void drawCoverLayer(Canvas canvas) {
    canvas.drawPath(mPath, mCoverPaint);
  }

  @Override public void draw(Canvas canvas) {

    int saveCount = canvas.save();

    checkPathChanged();

    canvas.clipPath(mPath);

    super.draw(canvas);

    //drawCoverLayer(canvas);

    canvas.restoreToCount(saveCount);
  }
}
