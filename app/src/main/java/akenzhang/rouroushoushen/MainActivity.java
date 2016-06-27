package akenzhang.rouroushoushen;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import akenzhang.rouroushoushen.discovery.DiscoveryFragment;
import akenzhang.rouroushoushen.homepage.HomepageFragment;
import akenzhang.rouroushoushen.me.MeFragment;
import akenzhang.rouroushoushen.release.ReleaseFragment;
import akenzhang.rouroushoushen.service.ServiceFragment;
import akenzhang.rouroushoushen.ui.BaseActivity;
import akenzhang.rouroushoushen.ui.MainActivityViewPagerAdapter;

public class MainActivity extends BaseActivity {

    private ViewPager viewpager;
    private Fragment fragments[];

    //申明RadionButton对象
    private RadioGroup rgHomeTab;
    private RadioButton btnHomePage; //home_tab_homepage
    private RadioButton btnHomeDiscovery;  //home_tab_discovery
    private RadioButton btnHomeRelease; //home_tab_release
    private RadioButton btnHomeService; //home_tab_service
    private RadioButton btnHomeMe; //home_tab_me


    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

        //初始化ViewPager viewpager
        viewpager = (ViewPager) this.findViewById(R.id.viewpager);

        //初始化RadioButton按钮
        rgHomeTab = (RadioGroup) this.findViewById(R.id.home_tab);
        btnHomePage = (RadioButton) this.findViewById(R.id.home_tab_homepage); //home_radiobtn_homepage
        btnHomeDiscovery = (RadioButton) this.findViewById(R.id.home_tab_discovery);  //home_tab_discovery
        btnHomeRelease = (RadioButton) this.findViewById(R.id.home_tab_release); //home_tab_release
        btnHomeService = (RadioButton) this.findViewById(R.id.home_tab_service); //home_tab_service
        btnHomeMe = (RadioButton) this.findViewById(R.id.home_tab_me); //home_tab_me
    }

    @Override
    protected void initVariable() {

        fragments = new Fragment[]{
                new HomepageFragment()
                ,new DiscoveryFragment()
                ,new ReleaseFragment()
                ,new ServiceFragment()
                ,new MeFragment()
        };

        MainActivityViewPagerAdapter adapter = new MainActivityViewPagerAdapter((getSupportFragmentManager()));

        //将Fragment集合传给adapter
        adapter.setmFragmentList(fragments);

        //设置适配器
        viewpager.setAdapter(adapter);

    }

    @Override
    protected void initListener() {

        rgHomeTab.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId) {
                    case R.id.home_tab_homepage:
                        //将当前的Fragment设置为HomepageFragment
                        viewpager.setCurrentItem(0,true);
                        break;

                    case R.id.home_tab_discovery:
                        //将当前的Fragment设置为DiscoveryFragment
                        viewpager.setCurrentItem(1,true);
                        break;

                    case R.id.home_tab_release:
                        //将当前的Fragment设置为ReleaseFragment
                        viewpager.setCurrentItem(2,true);
                        break;

                    case R.id.home_tab_service:
                        //将当前的Fragment设置为ServiceFragment
                        viewpager.setCurrentItem(3,true);
                        break;

                    case R.id.home_tab_me:
                        //将当前的Fragment设置为MeFragment
                        viewpager.setCurrentItem(4,true);
                        break;

                    default:
                        break;
                }
            }
        });

    }

    @Override
    protected void bindData() {

    }

}
