package akenzhang.rouroushoushen.discovery.fragment;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import akenzhang.rouroushoushen.R;
import akenzhang.rouroushoushen.discovery.adatper.AdvViewPagerAdapter;
import akenzhang.rouroushoushen.ui.BaseFragment;

/**
 * Created by Administrator on 2016/6/28 0028.
 */
public class Fragment_Ground extends BaseFragment{
    private List<View> list;
    private ViewPager viewPager;
    int[] res ={R.drawable.bg_newbie_board_boy,R.drawable.bg_newbie_board_girl};
    @Override
    protected int getLayout() {
        return R.layout.discovery_fragment_ground;
    }

    @Override
    protected void initView() {
        viewPager= (ViewPager) root.findViewById(R.id.ground_advview);
        bindData();
        AdvViewPagerAdapter advAdapter =new AdvViewPagerAdapter(list);
        viewPager.setAdapter(advAdapter);
    }

    @Override
    protected void initVariable() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void bindData() {
        list=new ArrayList<>();
        ViewGroup.LayoutParams layoutParams =new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 80);

        for(int i =0 ; i< res.length ; i++){
            ImageView imageView =new ImageView(getActivity());
            imageView.setImageResource(res[i]);
            imageView.setLayoutParams(layoutParams);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);

            list.add(imageView);
        }
    }
}
