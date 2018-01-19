package com.zk.studydemo.animation.view;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

/**
 * author: ZK.
 * date:   On 2018/1/19.
 */
public class ObjectAnimationView extends View {


    private @ColorInt
    int shaderStartColor = Color.parseColor("#0519FF00");
    private @ColorInt
    int shaderEndColor = Color.parseColor("#AA19FF00");
    private int mWidth;
    private int mHeight;

    private boolean hasStartAnim = false;
    private int mRoateAngle;
    private Paint mPaint;

    public ObjectAnimationView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }



    private void initPaint() {
        mPaint = new Paint();
        Shader shader = new SweepGradient(0, 0, shaderStartColor, shaderEndColor);
        mPaint.setShader(shader);
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(mWidth / 2, mHeight / 2);
        if (!hasStartAnim) {
            startAnim();
            hasStartAnim = true;
        } else {
            drawCircle(canvas);
        }
    }

    private void startAnim() {
        // "roateAngle" 一定要有 get，set方法。它变化的值会通过set方法回传
        ObjectAnimator objectAnimator = ObjectAnimator.ofInt(this, "roateAngle", 0, 360);
        objectAnimator.setDuration(2000);
        objectAnimator.setInterpolator(new LinearInterpolator());
        objectAnimator.setDuration(2000);
        objectAnimator.setRepeatMode(ValueAnimator.RESTART);
        objectAnimator.setRepeatCount(ValueAnimator.INFINITE);
        objectAnimator.start();

    }

    //自定义属性getter方法
    public int getRoateAngle() {
        return mRoateAngle;
    }

    //自定义属性的setter方法
    public void setRoateAngle(int roateAngle) {
        mRoateAngle = roateAngle;
        invalidate();
    }

    public void drawCircle(Canvas canvas) {
        canvas.rotate(mRoateAngle);
        canvas.drawCircle(0, 0, Math.min(mWidth, mHeight) / 2, mPaint);

    }
}
