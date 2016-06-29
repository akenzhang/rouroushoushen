package akenzhang.rouroushoushen.me.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

import akenzhang.rouroushoushen.MainActivity;
import akenzhang.rouroushoushen.R;
import akenzhang.rouroushoushen.me.adapter.ItemMyStoreAdaper;
import akenzhang.rouroushoushen.me.bean.ItemMyStoreBean;
import akenzhang.rouroushoushen.ui.BaseActivity;

/**
 * Created by Administrator on 2016/6/29.
 */
public class ItemMyStoreActivity extends BaseActivity {

    private RecyclerView itemstore_recyclerview;
    private ItemMyStoreAdaper adaper;
    private List<ItemMyStoreBean> mListItemBean;
    private LinearLayoutManager mLayoutManager;
    private ImageView btn;

    @Override
    protected int getLayout() {
        return R.layout.me_fragment_item_my_store_layout;
    }

    @Override
    protected void initView() {
        itemstore_recyclerview = (RecyclerView) this.findViewById(R.id.id_itemstore_recyclerview);
        btn = (ImageView) this.findViewById(R.id.id_btn_my_item_store_back);
    }

    @Override
    protected void initVariable() {

        //造数据
        mListItemBean = new ArrayList<>();
        mListItemBean.add(new ItemMyStoreBean(R.drawable.item_my_store01,"彩色牛奶杯","1080积分",R.drawable.item_my_store02,"减肥食品","20积分"));
        mListItemBean.add(new ItemMyStoreBean(R.drawable.item_my_store03,"彩色牛奶杯","1080积分",R.drawable.item_my_store04,"减肥食品","20积分"));
        mListItemBean.add(new ItemMyStoreBean(R.drawable.item_my_store05,"彩色牛奶杯","1080积分",R.drawable.item_my_store06,"减肥食品","20积分"));
        mListItemBean.add(new ItemMyStoreBean(R.drawable.item_my_store07,"彩色牛奶杯","1080积分",R.drawable.item_my_store08,"减肥食品","20积分"));
        mListItemBean.add(new ItemMyStoreBean(R.drawable.item_my_store09,"彩色牛奶杯","1080积分",R.drawable.item_my_store10,"减肥食品","20积分"));

        //设置大小
        itemstore_recyclerview.setHasFixedSize(true);
        //设置布局管理器
        mLayoutManager = new LinearLayoutManager(this, OrientationHelper.VERTICAL,false);
        itemstore_recyclerview.setLayoutManager(mLayoutManager);
        adaper = new ItemMyStoreAdaper(mListItemBean,this,1);
        itemstore_recyclerview.setAdapter(adaper);
    }

    @Override
    protected void initListener() {

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ItemMyStoreActivity.this, MainActivity.class);
                intent.putExtra("fragment","4");
                startActivity(intent);
            }
        });
    }

    @Override
    protected void bindData() {


    }
}
