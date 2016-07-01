package akenzhang.rouroushoushen.homepage;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import akenzhang.rouroushoushen.R;
import akenzhang.rouroushoushen.homepage.fragment.HomeAdd;
import akenzhang.rouroushoushen.ui.BaseFragment;

/**
 * Created by Administrator on 2016/6/27.
 */
public class HomepageFragment extends BaseFragment {
    private ImageView homeAdd;
    private RelativeLayout addMore;

    @Override
    protected int getLayout() {
        return R.layout.homepage_fragment_default_layout;
    }

    @Override
    protected void initView() {
        homeAdd = (ImageView) root.findViewById(R.id.home_add);
        addMore = (RelativeLayout) root.findViewById(R.id.id_home_add_more);
    }

    @Override
    protected void initVariable() {

    }

    @Override
    protected void initListener() {
        homeAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),HomeAdd.class));
            }
        });
        addMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),HomeAdd.class));
            }
        });
    }

    @Override
    protected void bindData() {

    }
}
