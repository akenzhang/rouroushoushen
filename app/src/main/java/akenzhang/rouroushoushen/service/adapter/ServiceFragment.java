package akenzhang.rouroushoushen.service.adapter;

import android.content.Intent;
import android.preference.SwitchPreference;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.squareup.okhttp.Request;

import org.w3c.dom.Document;

import java.io.IOException;
import java.util.List;

import akenzhang.rouroushoushen.R;
import akenzhang.rouroushoushen.ui.BaseFragment;

/**
 * Created by Administrator on 2016/6/27.
 */
public class ServiceFragment extends BaseFragment implements View.OnClickListener
{
    private ImageView mTopBarMenu;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private RecyclerView mRecyclerView;
    private MyRecylerAdapter adapter;
    private LinearLayoutManager manager;
    private List<Bean.DataBean> mlist;
    private String URL = "http://api.rourougo.com/service/index?token=23973ba7cb8eb3aa5b6e7f40f064f01e54c9fbf4";


    @Override
    protected int getLayout() {
        return R.layout.service_fragment_default_layout;
    }

    @Override
    protected void initView() {
        mSwipeRefreshLayout = (SwipeRefreshLayout) root.findViewById(R.id.SwipeRefreshLayout);
        mRecyclerView = (RecyclerView) root.findViewById(R.id.RecyclerView);
    }


    @Override
    protected void initVariable() {
        mRecyclerView.setHasFixedSize(true);
        manager = new LinearLayoutManager(getContext(), OrientationHelper.VERTICAL,false);
        mRecyclerView.setLayoutManager(manager);
        adapter = new MyRecylerAdapter(getContext(),0);

        requestData(URL);


//      设置下拉
//      设置进度条背景颜色
        mSwipeRefreshLayout.setProgressBackgroundColorSchemeResource(R.color.white);
//      设置进度条颜色
        mSwipeRefreshLayout.setColorSchemeResources(R.color.red,R.color.blue);
//      设置进度条的偏移量
        mSwipeRefreshLayout.setProgressViewOffset(false,0,50);
        //设置动画
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

    }

    @Override
    protected void initListener() {
        adapter.setmOnRecyclerViewClickListener(new MyRecylerAdapter.OnRecyclerViewClickListener() {
            @Override
            public void onItemClick(View view, Bean.DataBean beanD, int position) {
               Intent intent = new Intent(getContext(),WebActivity.class);
                intent.putExtra("Data",beanD.getUrl());
                startActivity(intent);

            }
        });
    }

    @Override
    protected void bindData() {

    }



    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(),ServiceonClickActivity.class);
        startActivity(intent);
    }
    private void requestData(String url){
        OkHttpUtils.getAsync(url, new OkHttpUtils.DataCallBack() {
            @Override
            public void requestFailure(Request request, IOException e) {

            }

            @Override
            public void requestSuccess(String result) {
                Gson gson = new Gson();
                Bean bean = gson.fromJson(result,Bean.class);
                mlist = bean.getData();
                adapter.setMlist(mlist);
                mRecyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        });
    }

}