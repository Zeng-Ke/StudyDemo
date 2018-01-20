package com.zk.studydemo.animation.fragement;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zk.studydemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * author: ZK.
 * date:   On 2018/1/19.
 */
public class AnimatorSetFragment extends Fragment {

    @BindView(R.id.tv_animator_set)
    TextView mTvAnimatorSet;
    Unbinder unbinder;

    public static Fragment newInstance() {
        AnimatorSetFragment fragment = new AnimatorSetFragment();
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragement_animatorset, container, false);
        unbinder = ButterKnife.bind(this, mView);

        //平移动画，
        float currentTranslateY = mTvAnimatorSet.getTranslationY();
        ObjectAnimator translateAnimtor = ObjectAnimator.ofFloat(mTvAnimatorSet, "translationY", currentTranslateY, 500, currentTranslateY);

        //旋转动画
        ObjectAnimator rotationAnimtor = ObjectAnimator.ofFloat(mTvAnimatorSet, "rotation", 0f, 360f);

        //缩放动画
        ObjectAnimator scaleAnimtor = ObjectAnimator.ofFloat(mTvAnimatorSet, "scaleX", 0.5f, 1.5f, 1f);

        //透明度动画 ，在5秒内先让透明度从1变到0再变到1
        ObjectAnimator alphaAnimtor = ObjectAnimator.ofFloat(mTvAnimatorSet, "alpha", 1f, 0f, 1f);


        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(translateAnimtor).with(rotationAnimtor).with(scaleAnimtor).before(alphaAnimtor);
        animatorSet.setDuration(3000);
        animatorSet.start();

/*
        //通过xml的方式加载动画
        Animator animator = AnimatorInflater.loadAnimator(getContext(), R.animator.anim_set);
        animator.setTarget(mTvAnimatorSet);
        animator.start();
*/
        return mView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
