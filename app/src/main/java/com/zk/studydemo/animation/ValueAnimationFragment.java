package com.zk.studydemo.animation;

import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;

import com.zk.studydemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * author: ZK.
 * date:   On 2018/1/18.
 */
public class ValueAnimationFragment extends Fragment {


    Unbinder unbinder;
    @BindView(R.id.tv_value)
    TextView mTvValue;
    private ValueAnimator mValueAnimator;

    public static Fragment newInstance() {
        ValueAnimationFragment fragment = new ValueAnimationFragment();
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragement_value_anim, container, false);
        unbinder = ButterKnife.bind(this, mView);


        ValueAnimator mValueAnimator = ValueAnimator.ofInt(0, 10, -10); //它会由0逐渐变化到10，在逐渐变化到-10
        mValueAnimator.setDuration(5000);  //设置这一个过程的时长
        mValueAnimator.setInterpolator(new LinearInterpolator()); //设置加速器为匀速
        mValueAnimator.setRepeatCount(ValueAnimator.INFINITE);  //设置重复次数为无穷次
        mValueAnimator.setRepeatMode(ValueAnimator.RESTART);  //设置重复模式 为 0% --> 100% --> 0%
        mValueAnimator.start();  //开始

        //添加变化的回调，每次变化的值都可以通过回调的animation的getAnimatedValue（）拿到
        mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Log.d("====", animation.getAnimatedValue() + "");
                mTvValue.setText(String.valueOf(animation.getAnimatedValue()));
            }
        });
        return mView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        mValueAnimator.removeAllUpdateListeners();//移除所有的动画监听
    }
}
