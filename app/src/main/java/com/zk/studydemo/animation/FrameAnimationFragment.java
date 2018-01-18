package com.zk.studydemo.animation;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
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
 * date:   On 2018/1/18.
 */
public class FrameAnimationFragment extends Fragment {

    @BindView(R.id.tv_frame)
    TextView mTvFrame;
    Unbinder unbinder;

    public static Fragment newInstance() {
        FrameAnimationFragment fragment = new FrameAnimationFragment();
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragement_frame_anim, container, false);
        unbinder = ButterKnife.bind(this, mView);

        mTvFrame.setBackgroundResource(R.drawable.animation_frame);
        AnimationDrawable animationDrawable = (AnimationDrawable) mTvFrame.getBackground();
        animationDrawable.start();

        return mView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
