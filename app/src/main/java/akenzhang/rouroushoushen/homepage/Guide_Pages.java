package akenzhang.rouroushoushen.homepage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import akenzhang.rouroushoushen.R;
import akenzhang.rouroushoushen.homepage.ui.GuidPagerAdpter;
import akenzhang.rouroushoushen.ui.BaseActivity;
import akenzhang.rouroushoushen.ui.LoginActivity;

public class Guide_Pages extends BaseActivity {

    private ViewPager viewPager;
    private List<View> viewList;
    private int[] backImages;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        initView();




    }

    @Override
    protected int getLayout() {
        return R.layout.activity_guide__pages;
    }

    @Override
    protected void initView() {
        viewPager = (ViewPager) findViewById(R.id.id_guid_Pager);
        button= (Button) findViewById(R.id.id_btn_sing);
        bindData();
        GuidPagerAdpter adpter =new GuidPagerAdpter(viewList);
        initListener();
        viewPager.setAdapter(adpter);

    }

    @Override
    protected void initVariable() {

    }

    @Override
    protected void initListener() {
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position==2){
                    Log.e("-------", "" + position);
                    button.setVisibility(View.VISIBLE);
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startActivity(new Intent(Guide_Pages.this,LoginActivity.class));
                        }
                    });
                }else{
                    button.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    protected void bindData() {
        backImages= new int[]{R.drawable.bg_guide_new_1, R.drawable.bg_guide_new_2,R.drawable.bg_guide_new_3};
        viewList =new ArrayList<>();
        ViewGroup.LayoutParams layoutParams =new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
        for (int i = 0; i<backImages.length; i++){

            ImageView imageView =new ImageView(Guide_Pages.this);
            imageView.setImageResource(backImages[i]);
            imageView.setLayoutParams(layoutParams);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);

            viewList.add(imageView);
        }
    }
}
