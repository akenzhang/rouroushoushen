package akenzhang.rouroushoushen.me.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import akenzhang.rouroushoushen.R;
import akenzhang.rouroushoushen.me.bean.MyInfoBean;

/**
 * Created by Administrator on 2016/6/28.
 */
public class MeCommonAdapter extends CommonAdapter {

    public MeCommonAdapter(List list, int resId, Context context) {
        super(list, resId, context);
    }

    @Override
    public void setContent(ViewHolder vh, Object item) {
        MyInfoBean myInfoBean = (MyInfoBean)item;
        ((ImageView)vh.getViews(R.id.id_image_listview)).setImageResource(((MyInfoBean)item).getmImageID());
        ((TextView)vh.getViews(R.id.id_name_listview)).setText(myInfoBean.getmName());
        ((TextView)vh.getViews(R.id.id_num_listview)).setText(String.valueOf(myInfoBean.getmNum()));
    }
}
