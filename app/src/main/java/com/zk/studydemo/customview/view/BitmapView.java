package com.zk.studydemo.customview.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.zk.studydemo.R;


/**
 * author: ZK.
 * date:   On 2017/11/29.
 * description:图片
 */
public class BitmapView extends View {

    private float width;
    private float height;

    private Paint mCheckPaint;
    private Bitmap mBitmap;
    private int mBitmapWidth;
    private int mBitmapHeight;
    private int index = 0;
    private boolean hasChecked = false;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                try {
                    Thread.sleep(30);
                    invalidate();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }
    };
    private int mSingleWidth;
    private Paint mBackgroundPaint;


    public BitmapView(Context context) {
        super(context);
        initPaint();
    }

    public BitmapView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }


    public void initPaint() {
        mCheckPaint = new Paint();
        mCheckPaint.setColor(Color.BLACK);
        mCheckPaint.setAntiAlias(true);
        mCheckPaint.setStrokeWidth(20);
        mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.check_mark);
        mBitmapWidth = mBitmap.getWidth();
        mBitmapHeight = mBitmap.getHeight();
        mSingleWidth = mBitmapWidth / 13;


        mBackgroundPaint = new Paint();
        mBackgroundPaint.setColor(Color.YELLOW);
        mBackgroundPaint.setAntiAlias(true);


    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        height = h;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(width / 2, height / 2);
        canvas.drawCircle(mSingleWidth/2 ,mSingleWidth/2 ,mSingleWidth/2 + 30,mBackgroundPaint);
        canvas.drawBitmap(mBitmap, new Rect(mSingleWidth * index, 0, mSingleWidth * (index + 1), mBitmapHeight), new Rect(0, 0,
                mSingleWidth, mBitmapHeight), mCheckPaint);
        if (hasChecked) {
            if (index >= 0) {
                index--;
            }else  hasChecked = !hasChecked;

        } else {
            if (index < 12) {
                index++;

            }else  hasChecked = !hasChecked;
        }
        mHandler.sendEmptyMessage(0);
    }

    public void setOnClick() {
        setOnClickListener(mOnClickListener);
    }


    @Override
    public void setOnClickListener(@Nullable OnClickListener l) {
        super.setOnClickListener(l);

    }

    OnClickListener mOnClickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            hasChecked = !hasChecked;
            mHandler.sendEmptyMessage(0);
        }
    };
}
