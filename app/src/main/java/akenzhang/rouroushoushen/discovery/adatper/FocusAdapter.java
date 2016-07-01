package akenzhang.rouroushoushen.discovery.adatper;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;

import java.util.List;

import akenzhang.rouroushoushen.R;
import akenzhang.rouroushoushen.discovery.entity.Focus_Entity;
import akenzhang.rouroushoushen.ui.ContentS;

/**
 * Created by Administrator on 2016/6/30 0030.
 */
public class FocusAdapter extends RecyclerView.Adapter{

    public static  int focus_type=1;
    private LayoutInflater layoutInflater;
    private LinearLayout linearLayout;
    private List<Focus_Entity.DataBean.InfoBean> list;
    private String type;
    private Focus_Entity.DataBean.InfoBean infoBean;
    private Context context;

    public List<Focus_Entity.DataBean.InfoBean> getList() {
        return list;
    }

    public void setList(List<Focus_Entity.DataBean.InfoBean> list) {
        this.list = list;
    }

    public FocusAdapter(Context context) {
        this.context = context;
    }

    @Override


    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view =null;
        if (focus_type==1&& view==null){
            layoutInflater=LayoutInflater.from(context);
            view = layoutInflater.inflate(R.layout.focus_inner,parent,false);
            return new FocusInnerData(view);
        }

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof FocusInnerData){
            infoBean =list.get(position);
            FocusInnerData focusInnerData = (FocusInnerData) holder;
//            private ImageView userImage,userLv,focusImg;
//            private TextView username,data,contentText,action,greaded,speaded;

            focusInnerData.getUsername().setText(infoBean.getNiceName());
            focusInnerData.getData().setText(String.valueOf(infoBean.getCreatetime()));
//            focusInnerData.getUserLv().setImageResource(infoBean.getImages());
            focusInnerData.getContentText().setText(infoBean.getContent());
            String focusImgUrl = ContentS.ROUROUAPIURL+infoBean.getImages();
            String userimgUrl = ContentS.ROUROUAPIURL+infoBean.getAvatar();
            Picasso.with(context).load(focusImgUrl).config(Bitmap.Config.RGB_565).into(focusInnerData.getFocusImg());
            Picasso.with(context).load(userimgUrl).config(Bitmap.Config.RGB_565).into(focusInnerData.getUserImage());

        }

    }

    @Override
    public int getItemCount() {
            return list.size();

    }

    @Override
    public int getItemViewType(int position) {
        return focus_type;
    }
}
