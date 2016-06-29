package akenzhang.rouroushoushen.me.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import akenzhang.rouroushoushen.R;
import akenzhang.rouroushoushen.me.bean.MyInfoBean;
import akenzhang.rouroushoushen.me.ui.ItemMyStoreActivity;

/**
 * Created by Administrator on 2016/6/28.
 */
public class MeCommonAdapter extends CommonAdapter {

    private Context context;

    public MeCommonAdapter(List list, int resId, Context context) {
        super(list, resId, context);

        this.context = context;
    }

    @Override
    public void setContent(ViewHolder vh, Object item) {
        MyInfoBean myInfoBean = (MyInfoBean) item;
        ((ImageView) vh.getViews(R.id.id_image_listview)).setImageResource(((MyInfoBean) item).getmImageID());
        ((TextView) vh.getViews(R.id.id_name_listview)).setText(myInfoBean.getmName());

        if (myInfoBean.getmName().equals("我的消息")
                || myInfoBean.getmName().equals("我的私信")
                || myInfoBean.getmName().equals("我的等级")
                || myInfoBean.getmName().equals("积分商城")
                || myInfoBean.getmName().equals("我的订单")
                || myInfoBean.getmName().equals("设置")) {
            ((TextView) vh.getViews(R.id.id_num_listview)).setText(null);
        } else {
            ((TextView) vh.getViews(R.id.id_num_listview)).setText(String.valueOf(myInfoBean.getmNum()));
        }

        //这里给等级图片赋值
        if (myInfoBean.getmName().equals("我的等级")) {
            ((ImageView) vh.getViews(R.id.id_pic_listview)).setImageResource(myInfoBean.getmLevelImage());
        }

        //这里给积分商城图片赋值
        if (myInfoBean.getmName().equals("积分商城")) {
            ((ImageView) vh.getViews(R.id.id_pic_listview)).setImageResource(myInfoBean.getmStoreImage());
        }

        ((ImageView)vh.getViews(R.id.ic_back_listview)).setTag(myInfoBean.getmName());


        //ic_back_right 设置点击事件
        ((ImageView)vh.getViews(R.id.ic_back_listview)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tag = v.getTag().toString();
                //Toast.makeText(context,tag,Toast.LENGTH_SHORT).show();

                switch (tag)
                {
                    case "积分商城":
                        //Toast.makeText(context,"你点击："+tag,Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(context,ItemMyStoreActivity.class);
                        context.startActivity(intent);
                        break;

                    default:
                        break;
                }
            }
        });
    }
 }
