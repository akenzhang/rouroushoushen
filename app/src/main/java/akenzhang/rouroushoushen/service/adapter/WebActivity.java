package akenzhang.rouroushoushen.service.adapter;

import android.content.Intent;
import android.webkit.WebView;

import akenzhang.rouroushoushen.R;
import akenzhang.rouroushoushen.ui.BaseActivity;

/**
 * Created by Administrator on 2016/6/30 0030.
 */
public class WebActivity extends BaseActivity{


    private WebView webView;
    @Override
    protected int getLayout() {
        return R.layout.service_framg;


    }

    @Override
    protected void initView() {
        webView = (WebView) findViewById(R.id.webView);
        Intent intent =getIntent();
       String string = intent.getStringExtra("Data");
        webView.loadUrl(string);
    }

    @Override
    protected void initVariable() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void bindData() {

    }

}
