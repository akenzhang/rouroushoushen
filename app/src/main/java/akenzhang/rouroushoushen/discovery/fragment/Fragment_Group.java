package akenzhang.rouroushoushen.discovery.fragment;

import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.squareup.okhttp.Request;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.List;

import akenzhang.rouroushoushen.R;
import akenzhang.rouroushoushen.discovery.adatper.GroupAdapter;
import akenzhang.rouroushoushen.discovery.entity.Group_Entity;
import akenzhang.rouroushoushen.ui.AutoGallery;
import akenzhang.rouroushoushen.ui.BaseFragment;
import akenzhang.rouroushoushen.ui.ContentS;
import akenzhang.rouroushoushen.ui.OkHttpUtils;

/**
 * Created by Administrator on 2016/6/28 0028.
 */
public class Fragment_Group extends BaseFragment{

    private AutoGallery autoGallery;
    private List<Group_Entity.DataBean.FlashViewsBean> imglist;
    private LayoutInflater mInflater;
    private ListView listView;
    private View view;

    private int mCurrentSelectedPosition = 0;
    private List<Group_Entity.DataBean.RecommendGroupsBean> grouplist;

    @Override
    protected int getLayout() {
        return R.layout.discovery_fragment_group;
    }

    @Override
    protected void initView() {
        mInflater = LayoutInflater.from(getActivity());
        listView = (ListView) root.findViewById(R.id.group_list);
        view=mInflater.inflate(R.layout.group_head,null);
        listView.addHeaderView(view);

        autoGallery = (AutoGallery) view.findViewById(R.id.group_advview);

    }

    @Override
    protected void initVariable() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void bindData() {
        OkHttpUtils.getAsync(ContentS.DISCOVERY_GROUP_URL, new OkHttpUtils.DataCallBack() {
            @Override
            public void requestFailure(Request request, IOException e) {

            }

            @Override
            public void requestSuccess(String result) {

                Log.e("----------", result);
                Group_Entity groupEntity =Group_Entity.objectFromData(result);
                imglist =groupEntity.getData().getFlash_views();
                grouplist =groupEntity.getData().getRecommend_groups();

                GroupAdapter groupAdapter =new GroupAdapter(grouplist,getContext());
                listView.setAdapter(groupAdapter);

                int topSize = imglist.size();
                autoGallery.setLength(topSize);
                autoGallery.setAdapter(new FocusHeadAdapter());
                autoGallery.setDelayMillis(3000);
                autoGallery.setSelection(mCurrentSelectedPosition);
                autoGallery.start();

            }
        });

    }
    class FocusHeadAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }

        @Override
        public Object getItem(int position) {
            return imglist.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHoler holer = null;
            if (convertView==null){
                convertView = mInflater.inflate(R.layout.group_head_img,null);
                holer = new ViewHoler(convertView);
                convertView.setTag(holer);
            }else{
                holer = (ViewHoler) convertView.getTag();
            }
            String url = ContentS.ROUROUAPIURL+imglist.get(position % imglist.size()).getImages();
            Picasso.with(getActivity()).load(url).config(Bitmap.Config.RGB_565).into(holer.img);
            return convertView;
        }

        class ViewHoler{
            private ImageView img;

            public ViewHoler(View view) {
                img = (ImageView) view.findViewById(R.id.group_head_img);
            }
        }
    }
}
