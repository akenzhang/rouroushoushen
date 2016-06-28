package akenzhang.rouroushoushen.service;

import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Administrator on 2016/6/28 0028.
 */
public class MyPagerAdapter extends PagerAdapter{
    private List<View> list;

    public MyPagerAdapter(List<View> list){
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Log.e("MyPagerAdapter------","----->positon:"+position);
        View view = list.get(position);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        Log.e("------","positon:"+position);
        container.removeView(list.get(position));
    }
}
