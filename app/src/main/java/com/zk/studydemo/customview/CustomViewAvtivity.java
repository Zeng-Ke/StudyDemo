package com.zk.studydemo.customview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.zk.studydemo.BaseActivity;
import com.zk.studydemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * author: ZK.
 * date:   On 2018/1/16.
 */
public class CustomViewAvtivity extends BaseActivity {


    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    private List<PageModel> mPageModels = new ArrayList<>();

    {
        mPageModels.add(new PageModel("color", R.layout.view_color));
        mPageModels.add(new PageModel("circle", R.layout.view_circle));
        mPageModels.add(new PageModel("rect", R.layout.view_rect));
        mPageModels.add(new PageModel("point", R.layout.view_point));
        mPageModels.add(new PageModel("oval", R.layout.view_oval));
        mPageModels.add(new PageModel("line", R.layout.view_line));
        mPageModels.add(new PageModel("Arc", R.layout.view_arc));
        mPageModels.add(new PageModel("path", R.layout.view_path));
        mPageModels.add(new PageModel("bitmap", R.layout.view_bitmap));
        mPageModels.add(new PageModel("text", R.layout.view_text));
        mPageModels.add(new PageModel("cake", R.layout.view_cake));
        mPageModels.add(new PageModel("roate", R.layout.view_roate));
        mPageModels.add(new PageModel("scale", R.layout.view_scale));
        mPageModels.add(new PageModel("rado", R.layout.view_rado));
        mPageModels.add(new PageModel("二阶贝塞尔", R.layout.view_bezier_two_level));
        mPageModels.add(new PageModel("粘性球", R.layout.view_sticky));
        mPageModels.add(new PageModel("MagicCircle", R.layout.view_magic));
        mPageModels.add(new PageModel("SrearchView", R.layout.view_search));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view);
        mTabLayout = findViewById(R.id.tab_layout);
        mViewPager = findViewById(R.id.viewpager);

        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                PageModel pageModel = mPageModels.get(position);
                return PageFragment.newInstance(pageModel.layoutId);
            }

            @Override
            public int getCount() {
                return mPageModels.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return mPageModels.get(position).title;
            }
        });
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

    }


    private class PageModel {

        public String title;
        public int layoutId;

        public PageModel(String title, int layoutId) {
            this.title = title;
            this.layoutId = layoutId;
        }
    }
}
