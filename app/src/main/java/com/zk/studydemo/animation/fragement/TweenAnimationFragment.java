package com.zk.studydemo.animation.fragement;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;
import android.widget.Toast;

import com.zk.studydemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * author: ZK.
 * date:   On 2017/11/29.
 */
public class TweenAnimationFragment extends Fragment {


    @BindView(R.id.tv_translate)
    TextView mTvTranslate;
    @BindView(R.id.tv_roate)
    TextView mTvRoate;
    @BindView(R.id.tv_sacle)
    TextView mTvSacle;
    @BindView(R.id.tv_alpha)
    TextView mTvAlpha;
    @BindView(R.id.tv_group)
    TextView mTvGroup;
    Unbinder unbinder;

    public static Fragment newInstance() {
        TweenAnimationFragment fragment = new TweenAnimationFragment();
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragment_tween_anim, container, false);
        unbinder = ButterKnife.bind(this, mView);
        initTranslateAnimation();
        initRoateAnimation();
        initScaleAnimation();
        initAlphaAnimation();
        initGroupAnimation();
        return mView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    /**
     * Animation的方法：
     *
     *animation.setDuration(1000); //设置动画执行的时间
     *animation.setFillAfter(true); // true表示动画结束后停留在结束后的状态，false则回到开始时，默认false
     *animation.setStartOffset(2000);//动画开始前的延迟
     *animation.setRepeatCount(Animation.INFINITE);//设置重复次数，INFINITE（-1）时为无限
     *animation.setInterpolator(new LinearInterpolator())  设置加速器
     *animation.setRepeatMode(Animation.REVERSE);//设置重复模式，RESTART ：0% --> 100% ,0%-->100%; REVERSE: 0-->100%-->0%
     *animation.setAnimationListener（new Animation.AnimationListener({...}); //设置动画的监听器
     */


    /**
     * 平移动画
     * fromXValue : 缩放前X坐标的值
     * toXValue : 缩放后X的值
     * fromYValue : 缩放前y的值
     * toYValue : 缩放后y的值
     * pivotXType : 缩放X轴的参照类型（ ABSOLUTE ： 绝对位置（像素为单位，默认）；RELATIVE_TO_SELF ：相对于自己 ；RELATIVE_TO_PARENT ：相对于父控件）
     * pivotYType:缩放Y轴的参照类型
     */
    private void initTranslateAnimation() {
        TranslateAnimation translateAnimation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 2f,
                Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0f);
        translateAnimation.setDuration(1000);
        translateAnimation.setInterpolator(new LinearInterpolator());
        translateAnimation.setRepeatCount(Animation.INFINITE);//设置重复次数，INFINITE（-1）时为无限
        translateAnimation.setRepeatMode(Animation.REVERSE);//设置重复模式，RESTART ：0% --> 100% ,0%-->100%; REVERSE: 0-->100%-->0%

        mTvTranslate.startAnimation(translateAnimation);

    }

    /**
     * 旋转动画
     * <p>
     * fromDegress ：开始角度
     * toDegress ：结束角度
     * pivotXType： X轴的参照类型（ ABSOLUTE ： 绝对位置（像素为单位，默认）；RELATIVE_TO_SELF ：相对于自己 ；RELATIVE_TO_PARENT ：相对于父控件）
     * pivotXValue：旋转X轴中心点
     * pivotYType： Y轴的参照类型（ ABSOLUTE ： 绝对位置（像素为单位，默认）；RELATIVE_TO_SELF ：相对于自己 ；RELATIVE_TO_PARENT ：相对于父控件）
     * pivotYValue：旋转X轴中心点
     */
    private void initRoateAnimation() {
        RotateAnimation rotateAnimation = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF,
                0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setDuration(600);
        rotateAnimation.setRepeatCount(Animation.INFINITE);
        rotateAnimation.setRepeatMode(Animation.RESTART);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        mTvRoate.startAnimation(rotateAnimation);
    }


    /**
     * 缩放动画
     * fromX : 缩放前X坐标的值
     * toX : 缩放后X的值
     * fromY : 缩放前y的值
     * toY : 缩放后y的值
     * pivotXType : 缩放X轴的参照类型（ ABSOLUTE ： 绝对位置（像素为单位，默认）；RELATIVE_TO_SELF ：相对于自己 ；RELATIVE_TO_PARENT ：相对于父控件）
     * pivotXValue: 缩放的X轴中心点
     * pivotYType:缩放Y轴的参照类型
     * pivotYValue:缩放的Y轴中心点
     */

    private void initScaleAnimation() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.5f, 1.2f, 0.5f, 1.2f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(1000);
        scaleAnimation.setRepeatCount(Animation.INFINITE);
        scaleAnimation.setRepeatMode(Animation.REVERSE);
        mTvSacle.startAnimation(scaleAnimation);
    }

    /**
     * 透明度动画
     * <p>
     * fromAlpha: 开始透明度
     * toAlpha : 结束透明度
     */
    private void initAlphaAnimation() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.1f, 1f);
        alphaAnimation.setDuration(1200);
        alphaAnimation.setRepeatCount(Animation.INFINITE);
        alphaAnimation.setRepeatMode(Animation.REVERSE);
        mTvAlpha.startAnimation(alphaAnimation);
    }

    private void initGroupAnimation() {
        Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.anim_tween);
        mTvGroup.startAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Toast.makeText(getActivity(), "动画开始", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Toast.makeText(getActivity(), "动画结束", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }

}
