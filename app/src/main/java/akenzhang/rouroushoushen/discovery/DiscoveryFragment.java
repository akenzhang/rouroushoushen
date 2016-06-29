package akenzhang.rouroushoushen.discovery;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

import akenzhang.rouroushoushen.R;
import akenzhang.rouroushoushen.discovery.adatper.TitleViewAdapter;
import akenzhang.rouroushoushen.ui.BaseFragment;

/**
 * Created by Administrator on 2016/6/27.
 */
public class DiscoveryFragment extends BaseFragment {

    private List<String> titles;
    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    protected int getLayout() {
        return R.layout.discovery_fragment_default_layout;
    }

    @Override
    protected void initView() {
        viewPager= (ViewPager) root.findViewById(R.id.discovery_content);
        tabLayout = (TabLayout) root.findViewById(R.id.discovery_head);



    }

    @Override
    protected void initVariable() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void bindData() {
        titles=new ArrayList<>();
        titles.add("广场");
        titles.add("肉肉团");
        titles.add("关注");
        viewPager.setOffscreenPageLimit(3);
        TitleViewAdapter titleViewAdapter = new TitleViewAdapter(this.getChildFragmentManager(),titles,getContext());
        viewPager.setAdapter(titleViewAdapter);
        tabLayout.setupWithViewPager(viewPager);


    }
}
