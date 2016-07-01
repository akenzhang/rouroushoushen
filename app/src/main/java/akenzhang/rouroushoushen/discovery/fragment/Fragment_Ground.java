package akenzhang.rouroushoushen.discovery.fragment;

import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.okhttp.Request;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.List;

import akenzhang.rouroushoushen.R;
import akenzhang.rouroushoushen.discovery.entity.Ground_Entity;
import akenzhang.rouroushoushen.ui.AutoGallery;
import akenzhang.rouroushoushen.ui.BaseFragment;
import akenzhang.rouroushoushen.ui.ContentS;
import akenzhang.rouroushoushen.ui.OkHttpUtils;

/**
 * Created by Administrator on 2016/6/28 0028.
 */
public class Fragment_Ground extends BaseFragment{

    private List<Ground_Entity.DataBean.RecommendPostsBean> postsBeans;
    private List<Ground_Entity.DataBean.FlashViewsBean> headImages;
    private AutoGallery mAutoGallery;
    private int mCurrentSelectedPosition = 0;
    private LayoutInflater mInflater;

    private int[] res =new int[]{
            R.drawable.bg_newbie_board_girl,R.drawable.bg_newbie_board_boy};
    @Override
    protected int getLayout() {
        return R.layout.discovery_fragment_ground;
    }

    @Override
    protected void initView() {
        mInflater = LayoutInflater.from(getActivity());
        //viewPager= (ViewPager) root.findViewById(R.id.ground_advview);
        mAutoGallery = (AutoGallery) root.findViewById(R.id.auto_gallery);


    }

    @Override
    protected void initVariable() {
        bindData();


    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void bindData() {
        OkHttpUtils.getAsync(ContentS.DISCOVERY_GROUND_URL, new OkHttpUtils.DataCallBack() {
            @Override
            public void requestFailure(Request request, IOException e) {
                Log.e("---------","error");
            }

            @Override
            public void requestSuccess(String result) {
                Ground_Entity groundEntity = Ground_Entity.objectFromData(result);
                headImages=groundEntity.getData().getFlash_views();
                postsBeans=groundEntity.getData().getRecommend_posts();


                int topSize = headImages.size();
                mAutoGallery.setLength(topSize);
                mAutoGallery.setAdapter(new HeaderImgAdapter());
                mAutoGallery.setDelayMillis(3000);
                mAutoGallery.setSelection(mCurrentSelectedPosition);
                mAutoGallery.start();

            }
        });


    }

    class HeaderImgAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }

        @Override
        public Object getItem(int position) {
            return headImages.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHoler holer = null;
            if (convertView==null){
                convertView = mInflater.inflate(R.layout.autogallery_image_item,null);
                holer = new ViewHoler(convertView);
                convertView.setTag(holer);
            }else{
                holer = (ViewHoler) convertView.getTag();
            }
            String url = ContentS.ROUROUAPIURL+headImages.get(position % headImages.size()).getImages();
            Picasso.with(getActivity()).load(url).config(Bitmap.Config.RGB_565).into(holer.img);
            return convertView;
        }

        class ViewHoler{
            private ImageView img;

            public ViewHoler(View view) {
                img = (ImageView) view.findViewById(R.id.img_item);
            }
        }
    }
}
