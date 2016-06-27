package akenzhang.rouroushoushen.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Auther Created by xzl on 2016/6/15 11:13.
 * E-mail zuliang_xie@sina.com
 */
public class MainActivityViewPagerAdapter extends FragmentStatePagerAdapter {

    private Fragment mFragmentList[];
    public void setmFragmentList(Fragment mFragmentList[]) {
        this.mFragmentList = mFragmentList;
    }

    public MainActivityViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList[position];
    }

    @Override
    public int getCount() {
        return mFragmentList.length;
    }
}
