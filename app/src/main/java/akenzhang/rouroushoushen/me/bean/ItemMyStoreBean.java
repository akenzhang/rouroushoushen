package akenzhang.rouroushoushen.me.bean;

/**
 * Created by Administrator on 2016/6/29.
 */
public class ItemMyStoreBean {
    private int mImageID01;
    private String mDescription01;
    private String mScoreDescription01;

    private int mImageID02;
    private String mDescription02;
    private String mScoreDescription02;

    public ItemMyStoreBean(int mImageID01,String mDescription01,String mScoreDescription01,int mImageID02,String mDescription02,String mScoreDescription02){
        this.mImageID01 = mImageID01;
        this.mImageID02 = mImageID02;

        this.mDescription01 = mDescription01;
        this.mDescription02 = mDescription02;

        this.mScoreDescription01 = mScoreDescription01;
        this.mScoreDescription02 = mScoreDescription02;
    }

    public int getmImageID01() {
        return mImageID01;
    }

    public void setmImageID01(int mImageID01) {
        this.mImageID01 = mImageID01;
    }

    public String getmDescription01() {
        return mDescription01;
    }

    public void setmDescription01(String mDescription01) {
        this.mDescription01 = mDescription01;
    }

    public String getmScoreDescription01() {
        return mScoreDescription01;
    }

    public void setmScoreDescription01(String mScoreDescription01) {
        this.mScoreDescription01 = mScoreDescription01;
    }

    public int getmImageID02() {
        return mImageID02;
    }

    public void setmImageID02(int mImageID02) {
        this.mImageID02 = mImageID02;
    }

    public String getmDescription02() {
        return mDescription02;
    }

    public void setmDescription02(String mDescription02) {
        this.mDescription02 = mDescription02;
    }

    public String getmScoreDescription02() {
        return mScoreDescription02;
    }

    public void setmScoreDescription02(String mScoreDescription02) {
        this.mScoreDescription02 = mScoreDescription02;
    }
}
