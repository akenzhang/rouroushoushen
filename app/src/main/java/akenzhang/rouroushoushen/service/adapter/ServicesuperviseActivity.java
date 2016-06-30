package akenzhang.rouroushoushen.service.adapter;

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

import akenzhang.rouroushoushen.R;
import akenzhang.rouroushoushen.service.MyPagerAdapter;

public class ServicesuperviseActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView superviseback;
    private ViewPager superviseViewP;
    private List<View> list;
    private int[] res = {R.drawable.b, R.drawable.d};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service_supervise);
        superviseback= (TextView) findViewById(R.id.superviseback);

        superviseViewP = (ViewPager) findViewById(R.id.superviseViewP);

        // 获取数据源
        getData();
        // 选择适配器
        MyPagerAdapter adapter = new MyPagerAdapter(list);
        // 设置适配器
        superviseViewP.setAdapter(adapter);
        //图片轮滑
        loadImage();

        superviseback.setOnClickListener(this);
    }

    private void getData() {
        list = new ArrayList<View>();
        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        for (int i = 0; i < res.length; i++) {
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
                    superviseViewP.setCurrentItem(intFlag, true);
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
        ServicesuperviseActivity.this.finish();
    }
}
