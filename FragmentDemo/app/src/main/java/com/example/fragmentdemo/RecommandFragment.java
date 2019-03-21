package com.example.fragmentdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RecommandFragment extends Fragment  implements View.OnClickListener,ViewPager.OnPageChangeListener{

    private ViewPager mViewPager;
    private TextView mTv1, mTv2, mTv3;
    private List<Fragment> mFragmentLists;
    private ViewPagerAdapter mAapter;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_recommand, container, false);
        initView(view);

        return view;
    }

    private void initView(View view) {
        mViewPager = view.findViewById(R.id.mViewPager);

        mTv1 = view.findViewById(R.id.mTextViewFirst);
        mTv2 = view.findViewById(R.id.mTextViewSecond);
        mTv3 = view.findViewById(R.id.mTextViewThird);

        mViewPager.addOnPageChangeListener(this);
        mTv1.setOnClickListener(this);
        mTv2.setOnClickListener(this);
        mTv3.setOnClickListener(this);

        mFragmentLists = new ArrayList<>();
        mFragmentLists.add(new FirstFragment());
        mFragmentLists.add(new SecondFragment());
        mFragmentLists.add(new ThirdFragment());

        mAapter = new ViewPagerAdapter(getChildFragmentManager());
        mViewPager.setAdapter(mAapter);

        resetTextViewColor();
        mTv1.setTextColor(Color.parseColor("#1FB79F"));

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.mTextViewFirst:

                mViewPager.setCurrentItem(0);
                break;

            case R.id.mTextViewSecond:

                mViewPager.setCurrentItem(1);
                break;

            case R.id.mTextViewThird:

                mViewPager.setCurrentItem(2);
                break;
        }
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int position) {

        resetTextViewColor();
        switch (position) {

            case 0:

                mTv1.setTextColor(Color.parseColor("#1FB79F"));
                break;

            case 1:

                mTv2.setTextColor(Color.parseColor("#1FB79F"));
                break;

            case 2:

                mTv3.setTextColor(Color.parseColor("#1FB79F"));
                break;
        }

    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }

    /**
     * 创建适配器
     */
    class ViewPagerAdapter extends FragmentPagerAdapter {

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        //获取Fragment
        @Override
        public Fragment getItem(int position) {
            return mFragmentLists.get(position);
        }

        //显示的个数
        @Override
        public int getCount() {
            return mFragmentLists.size();

        }
    }

    private void resetTextViewColor() {

        mTv1.setTextColor(Color.parseColor("#4a4a4a"));
        mTv2.setTextColor(Color.parseColor("#4a4a4a"));
        mTv3.setTextColor(Color.parseColor("#4a4a4a"));
    }
}
