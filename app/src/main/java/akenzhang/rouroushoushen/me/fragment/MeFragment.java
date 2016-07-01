package akenzhang.rouroushoushen.me.fragment;

import android.app.Activity;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import akenzhang.rouroushoushen.R;
import akenzhang.rouroushoushen.me.adapter.MeCommonAdapter;
import akenzhang.rouroushoushen.me.bean.MyInfoBean;
import akenzhang.rouroushoushen.ui.BaseActivity;
import akenzhang.rouroushoushen.ui.BaseFragment;

/**
 * Created by Administrator on 2016/6/27.
 */
public class MeFragment extends BaseFragment {

    private ListView listview;
    private View mHeaderView;
    List<MyInfoBean> mMyInfoList;
    private TextView mUsername;
    private ImageView mUserimageview;

    @Override
    protected int getLayout() {
        return R.layout.me_fragment_default_layout;
    }

    @Override
    protected void initView() {
        mUsername = (TextView) root.findViewById(R.id.username);
        listview = (ListView) root.findViewById(R.id.id_listview);
        mHeaderView = this.getActivity().getLayoutInflater().inflate(R.layout.me_fragment_default_listview_header_layout,null);
        mUserimageview = (ImageView) mHeaderView.findViewById(R.id.id_user_imageview);
    }

    @Override
    protected void initVariable() {

        mMyInfoList = new ArrayList<MyInfoBean>();
        MyInfoBean myInfoBean = null;

        int[] images={
                R.drawable.item_my_record
                ,R.drawable.item_my_message
                ,R.drawable.item_my_chat
                ,R.drawable.item_my_level
                ,R.drawable.item_my_score
                ,R.drawable.item_my_store
                ,R.drawable.item_my_order
                ,R.drawable.item_my_tag
                ,R.drawable.item_my_collection
                ,R.drawable.item_my_settings
        };
        String[] names = {
                "我的记录"
                ,"我的消息"
                ,"我的私信"
                ,"我的等级"
                ,"我的积分"
                ,"积分商城"
                ,"我的订单"
                ,"标签"
                ,"收藏"
                ,"设置"
        };
        int[] nums = {
                0
                ,0
                ,0
                ,0
                ,0
                ,12
                ,0
                ,0
                ,0
                ,0
        };

        int[] levelimages={
                R.drawable.level_0
                ,R.drawable.level_1
                ,R.drawable.level_2
                ,R.drawable.level_3
                ,R.drawable.level_4
        };

        int[] storeimages={
            R.drawable.ic_plan_new
        };

        for(int i=0;i<images.length;i++)
        {
            myInfoBean = new MyInfoBean();

            myInfoBean.setmImageID(images[i]);
            myInfoBean.setmName(names[i]);
            myInfoBean.setmNum(nums[i]);
            myInfoBean.setmLevelImage(levelimages[0]); //这里hard code
            myInfoBean.setmStoreImage(storeimages[0]);

            mMyInfoList.add(myInfoBean);
        }

        MeCommonAdapter adapter = new MeCommonAdapter(mMyInfoList,R.layout.me_fragment_default_listview_layout,getActivity());

        if(listview.getHeaderViewsCount()==0) {
            listview.addHeaderView(mHeaderView);
        }
        listview.setAdapter(adapter);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void bindData() {

        //获取SharedPreferences保存的QQ用户信息
        SharedPreferences mySharedPreferences = this.getActivity().getSharedPreferences("akenzhang", Activity.MODE_PRIVATE);
        if(mySharedPreferences!=null) {
            String nickname = mySharedPreferences.getString("nickname", "");
            String image = mySharedPreferences.getString("image", "");
            String gender = mySharedPreferences.getString("gender", "");

            if(!nickname.equals("")) {
                //将获取到的QQ信息设置到界面
                mUsername.setText(nickname + "(" + gender + ")");
                //设置用户的图像
                Picasso.with(this.getActivity()).load(image).into(mUserimageview);
            }
        }
    }
}
