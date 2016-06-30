package akenzhang.rouroushoushen.service.adapter;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import akenzhang.rouroushoushen.R;

/**
 * Created by Administrator on 2016/6/30 0030.
 */
public class MyRecylerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int NORMAL = 0;//新闻列表视图
    private static final int OTHER = 1;
    private static final int FOOTER = 2; //上拉加载更多布局
    private List<Bean.DataBean> list;
    private int mType;
    private Context context;
    private LayoutInflater minflater;
    private OnRecyclerViewClickListener mOnRecyclerViewClickListener;

    public MyRecylerAdapter(Context context, int mType) {
        minflater = LayoutInflater.from(context);
        this.mType = mType;
        this.context = context;
    }
    public void setMlist(List<Bean.DataBean> list) {
        this.list = list;
    }

    public void setmOnRecyclerViewClickListener(OnRecyclerViewClickListener mOnRecyclerViewClickListener) {
        this.mOnRecyclerViewClickListener =  mOnRecyclerViewClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewItem;
        if (viewType == NORMAL){
            viewItem = minflater.inflate(R.layout.servise_fragment_defukt_item,parent,false);
            return  new ServiceHolder(viewItem);
        }
        return null;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof  ServiceHolder){
           final Bean.DataBean beanD = list.get(position);
            holder.itemView.setTag(beanD);
            ((ServiceHolder) holder).titleTxt.setText(beanD.getTitle());
            ((ServiceHolder) holder).authorTxt.setText(beanD.getBrief());
            Picasso.with(context).load(beanD.getIcon()).into(((ServiceHolder)holder).imageView);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(mOnRecyclerViewClickListener!=null)
                        mOnRecyclerViewClickListener.onItemClick(view,beanD ,position);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
//        if (position + 1 == getItemCount()) {
//            return FOOTER;
//        } else {
            return NORMAL;
//        }
    }

    class ServiceHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView titleTxt, authorTxt;
        public ServiceHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.service_item_image);
            titleTxt = (TextView) itemView.findViewById(R.id.service_item_title_txt);
            authorTxt = (TextView) itemView.findViewById(R.id.service_item_author_txt);
        }
    }

    public interface OnRecyclerViewClickListener {
        void onItemClick(View view,Bean.DataBean beanD, int position);
    }
    /**
     * 上拉刷新加载更多布局
     */
    private class FooterItemViewHolder extends RecyclerView.ViewHolder {
        public FooterItemViewHolder(View itemView) {
            super(itemView);
        }
    }

}
