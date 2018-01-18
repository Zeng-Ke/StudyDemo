package com.zk.studydemo;

import android.os.Bundle;
import android.view.View;

import com.zk.studydemo.animation.AnimationActivity;
import com.zk.studydemo.customview.CustomViewAvtivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


    }


    public void customview(View view) {
        launch(CustomViewAvtivity.class);
    }

    @OnClick({R.id.btn_custom_view, R.id.btn_animation})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_custom_view:
                launch(CustomViewAvtivity.class);
                break;
            case R.id.btn_animation:
                launch(AnimationActivity.class);
                break;
        }
    }
}
