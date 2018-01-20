package com.zk.studydemo.animation.fragement;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.LinearLayout;

import com.zk.studydemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * author: ZK.
 * date:   On 2018/1/18.
 */
public class LayoutAnimationFragemnt extends Fragment {

    @BindView(R.id.ll_root)
    LinearLayout mLlRoot;
    Unbinder unbinder;

    public static Fragment newInstance() {
        LayoutAnimationFragemnt fragment = new LayoutAnimationFragemnt();
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragement_layoutanim, container, false);
        unbinder = ButterKnife.bind(this, mView);

        //也可以直接在xml布局中指定mLlRoot的    android:layoutAnimation="@anim/anim_normal"
        Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.anim_normal);
        LayoutAnimationController controller = new LayoutAnimationController(animation);
        controller.setOrder(LayoutAnimationController.ORDER_RANDOM);
        controller.setDelay(0.5f);
        mLlRoot.setLayoutAnimation(controller);

        return mView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
