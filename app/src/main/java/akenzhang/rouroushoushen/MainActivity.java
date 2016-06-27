package akenzhang.rouroushoushen;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;
import akenzhang.rouroushoushen.discovery.DiscoveryFragment;
import akenzhang.rouroushoushen.homepage.Guide_Pages;
import akenzhang.rouroushoushen.homepage.HomepageFragment;
import akenzhang.rouroushoushen.me.MeFragment;
import akenzhang.rouroushoushen.release.ReleaseFragment;
import akenzhang.rouroushoushen.service.ServiceFragment;
import akenzhang.rouroushoushen.ui.BaseActivity;
import akenzhang.rouroushoushen.ui.BaseFragment;
import akenzhang.rouroushoushen.ui.MyViewPagerAdapter;

public class MainActivity extends BaseActivity {

    private ViewPager viewpager;
    private Fragment fragments[];

    private RadioButton btnHomePage;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        viewpager = (ViewPager) this.findViewById(R.id.viewpager);

        btnHomePage = (RadioButton) this.findViewById(R.id.home_tab_homepage);
    }

    @Override
    protected void initVariable() {

        fragments = new Fragment[]{
                new HomepageFragment()
                ,new DiscoveryFragment()
                ,new  MeFragment()
                ,new ReleaseFragment()
                ,new ServiceFragment()
        };

        MyViewPagerAdapter adapter = new MyViewPagerAdapter((getSupportFragmentManager()));

        //将Fragment集合传给adapter
        adapter.setmFragmentList(fragments);

        //设置适配器
        viewpager.setAdapter(adapter);

    }

    @Override
    protected void initListener() {

        btnHomePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"",Toast.LENGTH_SHORT).show();
                viewpager.setCurrentItem(0,true);
            }
            });
    }

    @Override
    protected void bindData() {

    }

}
