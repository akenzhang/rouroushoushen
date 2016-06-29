package akenzhang.rouroushoushen.service.GoAdapter;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import akenzhang.rouroushoushen.MainActivity;
import akenzhang.rouroushoushen.R;
import akenzhang.rouroushoushen.service.MyPagerAdapter;
import akenzhang.rouroushoushen.service.adapter.ServiceFragment;
import akenzhang.rouroushoushen.service.adapter.ServiceonClickActivity;

public class ServiceonClickgo extends AppCompatActivity implements View.OnClickListener{

    private TextView goback;
    private TextView goclose;
    private ViewPager mViewPager;
    private List<View> list;
    private int[] res = {R.drawable.b,R.drawable.d};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.serviceon_click_go);

        mViewPager = (ViewPager) findViewById(R.id.goviewPg);
        goback = (TextView) findViewById(R.id.goback);
        goclose = (TextView) findViewById(R.id.goclose);

        // 获取数据源
        getData();
        // 选择适配器
        MyPagerAdapter adapter = new MyPagerAdapter(list);
        // 设置适配器
        mViewPager.setAdapter(adapter);
        //自动轮播
        loadImage();

        goback.setOnClickListener(this);
        goclose.setOnClickListener(this);
    }

    private void getData(){
        list = new ArrayList<View>();
        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
        for (int i = 0; i< res.length;i++){
            ImageView iv = new ImageView(this);
            iv.setImageResource(res[i]);
            iv.setLayoutParams(lp);
            iv.setScaleType(ImageView.ScaleType.FIT_XY);
            list.add(iv);
        }
    }
    private void loadImage(){

        new Thread(new Runnable() {
            int intFlag=0;
            @Override
            public void run() {
                for (;;){
                    SystemClock.sleep(2000);
                    mViewPager.setCurrentItem(intFlag, true);
                    if(intFlag==0) {
                        intFlag=1;
                    }
                    else
                        intFlag=0;
                }
            }
        }){

    }.start();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.goback:
                Intent intent = new Intent(ServiceonClickgo.this,ServiceonClickActivity.class);
                startActivity(intent);
                ServiceonClickgo.this.finish();

                break;
            case R.id.goclose:
                ServiceonClickgo.this.finish();
                break;
        }
    }
}
