package akenzhang.rouroushoushen.discovery.fragment;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.squareup.okhttp.Request;

import java.io.IOException;
import java.util.List;

import akenzhang.rouroushoushen.R;
import akenzhang.rouroushoushen.discovery.adatper.FocusAdapter;
import akenzhang.rouroushoushen.discovery.entity.Focus_Entity;
import akenzhang.rouroushoushen.ui.BaseFragment;
import akenzhang.rouroushoushen.ui.ContentS;
import akenzhang.rouroushoushen.ui.OkHttpUtils;

/**
 * Created by Administrator on 2016/6/28 0028.
 */
public class Fragment_Focus extends BaseFragment{
    private RecyclerView mRecyclerView;
    private LinearLayout linearLayout;
    private List<Focus_Entity.DataBean.InfoBean> list;

    @Override
    protected int getLayout() {
        return R.layout.discovery_fragment_focus;
    }

    @Override
    protected void initView() {
        mRecyclerView= (RecyclerView) root.findViewById(R.id.focus_content);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(getContext());
//        mRecyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override
    protected void initVariable() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void bindData() {
        OkHttpUtils.getAsync(ContentS.DISCOVERY_FOCUS_URL, new OkHttpUtils.DataCallBack() {
            @Override
            public void requestFailure(Request request, IOException e) {


            }

            @Override
            public void requestSuccess(String result) {
                Focus_Entity focusEntity = Focus_Entity.objectFromData(result);
                list=focusEntity.getData().getInfo();
                FocusAdapter focusAdapter =new FocusAdapter(getContext());
                focusAdapter.setList(list);

                mRecyclerView.setAdapter(focusAdapter);


            }
        });
    }
}
