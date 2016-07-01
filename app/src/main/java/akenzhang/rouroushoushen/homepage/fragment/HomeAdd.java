package akenzhang.rouroushoushen.homepage.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import akenzhang.rouroushoushen.MainActivity;
import akenzhang.rouroushoushen.R;
import akenzhang.rouroushoushen.ui.BaseActivity;

/**
 * Created by Administrator on 2016/6/29 0029.
 */
public class HomeAdd extends BaseActivity {
    private ImageView backTohome;
    @Override
    protected int getLayout() {
        return R.layout.home_add;
    }

    @Override
    protected void initView() {
        backTohome = (ImageView) findViewById(R.id.home_getback);

    }

    @Override
    protected void initVariable() {

    }

    @Override
    protected void initListener() {
        backTohome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(HomeAdd.this, MainActivity.class);
                intent.putExtra("fragment","0");
                startActivity(intent);
            }
        });
    }

    @Override
    protected void bindData() {

    }
}
