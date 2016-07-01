package akenzhang.rouroushoushen.discovery.adatper;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import akenzhang.rouroushoushen.R;
import akenzhang.rouroushoushen.discovery.entity.Group_Entity;
import akenzhang.rouroushoushen.ui.ContentS;

/**
 * Created by Administrator on 2016/7/1 0001.
 */
public class GroupAdapter extends BaseAdapter{
    private List<Group_Entity.DataBean.RecommendGroupsBean> groupsBeanList;
    private LayoutInflater layoutInflater;
    private Context context;

    public GroupAdapter(List<Group_Entity.DataBean.RecommendGroupsBean> groupsBeanList, Context context) {
        this.groupsBeanList = groupsBeanList;
        this.context = context;
    }

    @Override




    public int getCount() {
        return groupsBeanList.size();
    }

    @Override
    public Object getItem(int position) {
        Group_Entity.DataBean.RecommendGroupsBean bean =groupsBeanList.get(position);



        return bean;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Group_Entity.DataBean.RecommendGroupsBean bean =groupsBeanList.get(position);
        layoutInflater=LayoutInflater.from(context);
        View view =layoutInflater.inflate(R.layout.group_item,parent,false);
        ImageView groupUserImg= (ImageView) view.findViewById(R.id.group_userimg);
        ImageView groupImg = (ImageView) view.findViewById(R.id.group_groupimg);
        TextView userName = (TextView) view.findViewById(R.id.group_username);
        TextView userNum = (TextView) view.findViewById(R.id.group_peoplenumber);
        TextView groupname = (TextView) view.findViewById(R.id.group_groupname);
        TextView groupcontent = (TextView) view.findViewById(R.id.group_groupcontent);
        groupcontent.setText(bean.getLeader().getManifesto());
        groupname.setText(bean.getTitle());
        userNum.setText(bean.getGroupNu());
        userName.setText(bean.getLeader().getNiceName());
        String groupImgUrl = ContentS.ROUROUAPIURL+bean.getIcon();
        String groupUserImgUrl=ContentS.ROUROUAPIURL+bean.getLeader().getAvatar();
        Picasso.with(context).load(groupImgUrl).config(Bitmap.Config.RGB_565).into(groupImg);
        Picasso.with(context).load(groupUserImgUrl).config(Bitmap.Config.RGB_565).into(groupUserImg);


        return view;
    }
}
