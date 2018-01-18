package com.zk.studydemo.animation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.zk.studydemo.BaseActivity;
import com.zk.studydemo.R;
import com.zk.studydemo.customview.CustomViewAvtivity;
import com.zk.studydemo.customview.PageFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * author: ZK.
 * date:   On 2018/1/18.
 */
public class AnimationActivity extends BaseActivity {


    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;
    @BindView(R.id.viewpager)
    ViewPager mViewpager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view);
        ButterKnife.bind(this);
        final List<Fragment> fragments = new ArrayList<>();
        final List<String> titles = new ArrayList<>();
        fragments.add(TweenAnimationFragment.newInstance());
        titles.add("补间动画");

        fragments.add(FrameAnimationFragment.newInstance());
        titles.add("帧动画");

        fragments.add(LayoutAnimationFragemnt.newInstance());
        titles.add("子View动画");

        fragments.add(LaunchAnimationFragemnt.newInstance());
        titles.add("带动画跳转");

        fragments.add(ValueAnimationFragment.newInstance());
        titles.add("ValueAnimation");

        mViewpager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {

                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return titles.get(position);
            }
        });
        mTabLayout.setupWithViewPager(mViewpager);
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
    }


}
