package akenzhang.rouroushoushen.me.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
import akenzhang.rouroushoushen.R;
import akenzhang.rouroushoushen.me.bean.ItemMyStoreBean;

/**
 * Created by Administrator on 2016/6/29.
 */
public class ItemMyStoreAdaper extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    public static int STORE = 1;
    private LayoutInflater mInflater;
    private List<ItemMyStoreBean> mListItemBean;
    private Context mContext;
    private int mType;

    public ItemMyStoreAdaper(List<ItemMyStoreBean> mListItemBean,Context mContext,int mType){

        this.mListItemBean = mListItemBean;
        this.mContext = mContext;
        this.mInflater = LayoutInflater.from(mContext);
        this.mType = mType;

    }

    @Override
    public int getItemViewType(int position) {
        return STORE;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int mType) {

        View itemView =null;

        //加载商城的布局文件
        if(mType==STORE && itemView==null){
            itemView = mInflater.inflate(R.layout.me_fragment_item_my_store_recyclerview_layout,parent,false);
            return new StoreItemViewHolder(itemView);
        }
        return null;
    }

    /*
    根部不同的mType实现不同的数据
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if(holder instanceof StoreItemViewHolder){
            ItemMyStoreBean  bean = mListItemBean.get(position);
            StoreItemViewHolder storeHolder = (StoreItemViewHolder)holder;

            //赋值
            storeHolder.mImageID01.setImageResource(bean.getmImageID01());
            storeHolder.mImageID02.setImageResource(bean.getmImageID02());
            storeHolder.mDescription01.setText(bean.getmDescription01());
            storeHolder.mDescription02.setText(bean.getmDescription02());
            storeHolder.mScoreDescription01.setText(bean.getmScoreDescription01());
            storeHolder.mScoreDescription02.setText(bean.getmScoreDescription02());

        }
    }

    @Override
    public int getItemCount() {
        return mListItemBean.size();
    }

    class StoreItemViewHolder extends RecyclerView.ViewHolder{

        private ImageView mImageID01,mImageID02;
        private TextView mDescription01,mDescription02,mScoreDescription01,mScoreDescription02;

        public StoreItemViewHolder(View itemView) {
            super(itemView);

            //赋值操作
            mImageID01 = (ImageView) itemView.findViewById(R.id.id_my_store_item_image01);
            mImageID02 = (ImageView) itemView.findViewById(R.id.id_my_store_item_image02);

            mDescription01 = (TextView) itemView.findViewById(R.id.id_my_store_item_Description01);
            mDescription02 = (TextView) itemView.findViewById(R.id.id_my_store_item_Description02);

            mScoreDescription01 = (TextView) itemView.findViewById(R.id.id_my_store_item_ScoreDescription01);
            mScoreDescription02 = (TextView) itemView.findViewById(R.id.id_my_store_item_ScoreDescription02);
        }
    }

}
