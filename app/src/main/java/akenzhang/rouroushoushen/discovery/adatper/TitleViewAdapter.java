package akenzhang.rouroushoushen.discovery.adatper;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import java.util.List;

import akenzhang.rouroushoushen.discovery.fragment.Fragment_Focus;
import akenzhang.rouroushoushen.discovery.fragment.Fragment_Ground;
import akenzhang.rouroushoushen.discovery.fragment.Fragment_Group;
import akenzhang.rouroushoushen.ui.BaseFragment;

/**
 * Created by Administrator on 2016/6/28 0028.
 */
public class TitleViewAdapter extends FragmentPagerAdapter{

    private List<String > titles;
    private Context context;

    public TitleViewAdapter(FragmentManager fm, List<String> titles, Context context) {
        super(fm);
        this.titles = titles;
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        Log.e("-----",""+position);
        BaseFragment fragment ;
        switch (position){
            case 0:
                fragment=new Fragment_Ground();
                return fragment;
            case 1:
                fragment=new Fragment_Group();
                return fragment;
            case 2:
                fragment=new Fragment_Focus();
                return fragment;

        }
        return null;
    }

    @Override
    public int getCount() {
        return titles.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }


}
