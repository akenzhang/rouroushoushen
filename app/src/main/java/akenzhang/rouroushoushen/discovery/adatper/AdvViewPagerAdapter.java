package akenzhang.rouroushoushen.discovery.adatper;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Administrator on 2016/6/28 0028.
 */
public class AdvViewPagerAdapter extends PagerAdapter{
    private List<View> list;

    public AdvViewPagerAdapter(List<View> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view =list.get(position);
        container.addView(view);
        return view;
    }




}
