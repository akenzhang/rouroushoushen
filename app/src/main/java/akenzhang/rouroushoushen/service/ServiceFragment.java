package akenzhang.rouroushoushen.service;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import akenzhang.rouroushoushen.R;
import akenzhang.rouroushoushen.ui.BaseFragment;

/**
 * Created by Administrator on 2016/6/27.
 */
public class ServiceFragment extends BaseFragment implements View.OnClickListener
{
    private LinearLayout mLinearLayout;


    @Override
    protected int getLayout() {
        return R.layout.service_fragment_default_layout;
    }

    @Override
    protected void initView() {
        mLinearLayout = (LinearLayout) root.findViewById(R.id.dianji01);

        mLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),ServiceonClickActivity.class);
                startActivity(intent);
               // Toast.makeText(getActivity(),"",Toast.LENGTH_SHORT).show();
            }
        });
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



    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(),ServiceonClickActivity.class);
        startActivity(intent);
    }
}