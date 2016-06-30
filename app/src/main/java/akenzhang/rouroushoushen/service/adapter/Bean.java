package akenzhang.rouroushoushen.service.adapter;

import java.util.List;

/**
 * Created by Administrator on 2016/6/30 0030.
 */
public class Bean {

    /**
     * code : 0
     * msg : ok
     * data : [{"title":"肉肉优选","brief":"精选各种好用，好吃不胖的优质商品。","is_new":0,"link_type":"outside","icon":"http://api.rourougo.com/assets/img/service/rouroushop.png","url":"https://wap.koudaitong.com/v2/showcase/homepage?alias=1d44uqik8","item_id":"cfe8d5cfe7a9647afed658b22f8236dc"},{"title":"肉肉监督","brief":"私人定制减肥服务，减肥达人帮你瘦下来。","is_new":0,"link_type":"outside","icon":"http://api.rourougo.com/assets/img/service/jiandufuwu.png","url":"https://wap.koudaitong.com/v2/feature/znkh25tc","item_id":"b91ca6384ef1e357d8f0d3d120642c29"},{"title":"肉肉课堂","brief":"肉肉妞教你涨姿势啦","is_new":0,"link_type":"inside","icon":"http://api.rourougo.com/assets/img/service/gaonengfangan.png","type_name":"classroom","item_id":"2c9694909967f0908e9b96fca5ccfcb4"}]
     */

    private int code;
    private String msg;
    /**
     * title : 肉肉优选
     * brief : 精选各种好用，好吃不胖的优质商品。
     * is_new : 0
     * link_type : outside
     * icon : http://api.rourougo.com/assets/img/service/rouroushop.png
     * url : https://wap.koudaitong.com/v2/showcase/homepage?alias=1d44uqik8
     * item_id : cfe8d5cfe7a9647afed658b22f8236dc
     */

    private List<DataBean> data;

    public static Bean objectFromData(String str) {

        return new com.google.gson.Gson().fromJson(str, Bean.class);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private String title;
        private String brief;
        private int is_new;
        private String link_type;
        private String icon;
        private String url;
        private String item_id;

        public static DataBean objectFromData(String str) {

            return new com.google.gson.Gson().fromJson(str, DataBean.class);
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getBrief() {
            return brief;
        }

        public void setBrief(String brief) {
            this.brief = brief;
        }

        public int getIs_new() {
            return is_new;
        }

        public void setIs_new(int is_new) {
            this.is_new = is_new;
        }

        public String getLink_type() {
            return link_type;
        }

        public void setLink_type(String link_type) {
            this.link_type = link_type;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getItem_id() {
            return item_id;
        }

        public void setItem_id(String item_id) {
            this.item_id = item_id;
        }
    }
}
