package com.zk.studydemo.animation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationSet;
import android.widget.TextView;

import com.zk.studydemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * author: ZK.
 * date:   On 2018/1/19.
 */
public class ObjectAnimationFragment extends Fragment {

    @BindView(R.id.tv_object)
    TextView mTvObject;
    Unbinder unbinder;

    public static Fragment newInstance() {
        ObjectAnimationFragment fragment = new ObjectAnimationFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragement_object, container, false);
        unbinder = ButterKnife.bind(this, mView);
        initAnim();

        return mView;

    }

    private void initAnim() {

        //平移动画，
        float currentTranslateY = mTvObject.getTranslationY();
        ObjectAnimator translateAnimtor = ObjectAnimator.ofFloat(mTvObject, "translationY", currentTranslateY, 500, currentTranslateY);
        translateAnimtor.setDuration(5000);

        //旋转动画
        ObjectAnimator rotationAnimtor = ObjectAnimator.ofFloat(mTvObject, "rotation", 0f, 360f);
        rotationAnimtor.setDuration(5000);

        //缩放动画
        ObjectAnimator scaleAnimtor = ObjectAnimator.ofFloat(mTvObject, "scaleX", 0.5f, 1.5f, 1f);
        scaleAnimtor.setDuration(5000);

        //透明度动画 ，在5秒内先让透明度从1变到0再变到1
        ObjectAnimator alphaAnimtor = ObjectAnimator.ofFloat(mTvObject, "alpha", 1f, 0f, 1f);
        alphaAnimtor.setDuration(5000);


        translateAnimtor.start();
        rotationAnimtor.start();
        scaleAnimtor.start();
        alphaAnimtor.start();

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
