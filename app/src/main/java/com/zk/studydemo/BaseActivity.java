package com.zk.studydemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

/**
 * author: ZK.
 * date:   On 2018/1/16.
 */
public class BaseActivity extends AppCompatActivity {


    public void launch(Class activityClass) {
        Intent intent = new Intent(this, activityClass);
        this.startActivity(intent);
    }
}
