package com.zk.studydemo.animation.fragement;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zk.studydemo.BaseActivity;
import com.zk.studydemo.R;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * author: ZK.
 * date:   On 2018/1/18.
 */
public class LaunchAnimationFragemnt extends Fragment {

    Unbinder unbinder;

    public static Fragment newInstance() {
        LaunchAnimationFragemnt fragment = new LaunchAnimationFragemnt();
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragment_enter_exist_anim, container, false);
        unbinder = ButterKnife.bind(this, mView);

        return mView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.btn_launch)
    public void onViewClicked() {
        ((BaseActivity) getActivity()).launch(AnimEnterAndExistActivity.class);
        getActivity().overridePendingTransition(R.anim.anim_activity_enter, R.anim.anim_activity_exist);
    }
}
