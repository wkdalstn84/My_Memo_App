package com.didgustn319.my_memo_app.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.didgustn319.my_memo_app.fragment.HomeFragment;
import com.didgustn319.my_memo_app.fragment.MemoViewFragment;
import com.didgustn319.my_memo_app.fragment.MyPageFragment;

import java.util.List;

public class MemoViewPagerAdapter extends FragmentStatePagerAdapter {

    List<String> pageTiTles;
    public MemoViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }
    public MemoViewPagerAdapter(FragmentManager fm,List<String> pageTiTles) {
        super(fm);
        this.pageTiTles = pageTiTles;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
//        return super.getPageTitle(position);
        return pageTiTles.get(position).toString();
    }

    @Override
    public Fragment getItem(int position) {
        return new MemoViewFragment();
    }

    @Override
    public int getCount() {
        return pageTiTles.size();
    }
}
