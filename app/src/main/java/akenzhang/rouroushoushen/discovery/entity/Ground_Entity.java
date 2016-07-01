package akenzhang.rouroushoushen.discovery.entity;

import com.google.gson.Gson;

import java.util.List;

/**
 * Created by Administrator on 2016/6/30 0030.
 */
public class Ground_Entity {

    /**
     * code : 0
     * msg : ok
     * data : {"flash_views":[{"images":"/desc/20160527/14643403494876.jpg","type":"article","position":"发现","data":{"linkurl":"https://wap.koudaitong.com/v2/feature/xbtvmac0","title":"代餐"}},{"images":"/desc/20160512/1463046849810.jpg","type":"article","position":"发现","data":{"linkurl":"https://wap.koudaitong.com/v2/feature/1ff4zxohf","title":"乌龙"}},{"images":"/desc/20160602/14648512151023.jpg","type":"article","position":"发现","data":{"linkurl":"https://wap.koudaitong.com/v2/feature/knzruavw","title":"跳绳"}}],"recommend_posts":[{"_id":"577462618658d4ec028b461e","userId":"5651233b8658d481438b478c","images":"/Note/160630/247302c8fb5e031ec639636ee6c55d1b.jpg@360w_90Q_1x.jpg","user":{"_id":"5651233b8658d481438b478c","niceName":"拜拜肉🤐","avatar":"/Avatar/160403/4efcf7da65d36f2978e27de60a8f3bb9.jpg","manifesto":"至少不是最糟糕🌸"}},{"_id":"5774619f8658d4bd758b4603","userId":"5771354b8658d4a2538b4d93","images":"/Note/160630/6c427c02bf97f33685e6c7b026b28bc4.jpeg@360w_90Q_1x.jpg","user":{"_id":"5771354b8658d4a2538b4d93","niceName":"微凉","avatar":"/Avatar/160627/b4b4a0a1cc50372c727d35c3d5097138.jpeg","manifesto":"纵然没有国色天香，拥有火辣身材也是一道靓丽的风景线。"}},{"_id":"5773ef128658d4d8458b4e88","userId":"574283558658d447688b46e3","images":"/Note/160629/9e5e0dabc35acb889b88bae6654eeae6.jpg@360w_90Q_1x.jpg","user":{"_id":"574283558658d447688b46e3","niceName":"里格","avatar":"/Avatar/160628/7381daf4e61e5068f433ee5eb4625fe6.jpg","manifesto":"就想瘦"}},{"_id":"5773ba3b8658d48e518b4c0a","userId":"575de7538658d47f4c8b456f","images":"/Note/160629/dd9871a1b6d762a50be5999b06657e34.jpeg@360w_90Q_1x.jpg","user":{"_id":"575de7538658d47f4c8b456f","niceName":"小a","avatar":"http://q.qlogo.cn/qqapp/1103566442/260E298E79DCB2016B8DF520A602CE55/100","manifesto":"把减肥当成事业一样爱着"}},{"_id":"5773b5df8658d471518b4bde","userId":"575de7538658d47f4c8b456f","images":"/Note/160629/c4e217a8124595715d8cfd9f49f4f64f.jpeg@360w_90Q_1x.jpg","user":{"_id":"575de7538658d47f4c8b456f","niceName":"小a","avatar":"http://q.qlogo.cn/qqapp/1103566442/260E298E79DCB2016B8DF520A602CE55/100","manifesto":"把减肥当成事业一样爱着"}},{"_id":"5773aa0c8658d430518b4b14","userId":"56dec19c8658d49d228b524a","images":"/Note/160629/6ad4cdd1d0bb65be22bf7c71627809aa.jpeg@360w_90Q_1x.jpg","user":{"_id":"56dec19c8658d49d228b524a","niceName":"那年秋天，你在这里吗","avatar":"http://q.qlogo.cn/qqapp/1103566442/1789141E7649750792547BBE7062DACB/100"}},{"_id":"577362ae8658d4284d8b48d6","userId":"57709aa68658d4a2538b4722","images":"/Note/160629/846879dc6e41bc38e09a02c6d59734d5.jpeg@360w_90Q_1x.jpg","user":{"_id":"57709aa68658d4a2538b4722","niceName":"Roy","avatar":"/Avatar/160629/98e860423b4f6bd52aa39b0a0e4d3654.jpeg","manifesto":"Fitting"}},{"_id":"57735fff8658d407468b48df","userId":"5749c8608658d49f5b8b4f7d","images":"/Note/160629/a5cdb17e3236ae9375cc1ec0142e49a6.jpeg@360w_90Q_1x.jpg","user":{"_id":"5749c8608658d49f5b8b4f7d","niceName":"♛ 情爱","avatar":"http://wx.qlogo.cn/mmopen/esrvgDGxbxdPtzxy14pYicEfpvTlaqrSRVrqQLJ8tc6vu62VJicLqjdIWFNs6qMyiakIn3wJrhCgc5CJ4dHFjEcSjT9sAz1rQWj/0","manifesto":"减肥100天，目标40斤！"}},{"_id":"57732f888658d480518b46f4","userId":"5759f67b8658d463098b458d","images":"/Note/160629/ed836b6ae2d0775d6c0f45bdfb6da79f.jpeg@360w_90Q_1x.jpg","user":{"_id":"5759f67b8658d463098b458d","niceName":"美妞S","avatar":"/Avatar/160610/c5f4d740c4e7f2f06bc7ce81717c5f9a.jpeg","manifesto":"一胖毁三观！做美女，不做胖子！"}}],"recommend_users":[{"_id":"55a295208658d4e6658b4825","niceName":"不会飞","avatar":"/Avatar/150713/8dda8914990dee42105a06ff1953c05d.jpeg","manifesto":"忍一时之欲，无百日之忧~","group_type":"large","groupType":"large","group_role":"leader","group_id":"561f17a88658d4df628b91bf","groupRole":"leader"},{"_id":"56490c2c8658d411498b478d","niceName":"兜兜妈","avatar":"/Avatar/151127/9c1d90eb6b26644870b0018de2423d31.jpeg","manifesto":"我要瘦瘦瘦","group_type":"large","groupType":"large","group_role":"leader","group_id":"567e90038658d49b358b895e","groupRole":"leader"},{"_id":"56c5e6eb8658d4f2408b4668","niceName":"叶胖纸","avatar":"/Avatar/160218/ca69f42f7c0f66db4cef014c3f3807d5.jpg","manifesto":"已疯","group_type":"large","groupType":"large","group_role":"leader","group_id":"56e7bd378658d4504b8b53b8","groupRole":"leader"},{"_id":"5651233b8658d481438b478c","niceName":"拜拜肉🤐","avatar":"/Avatar/160403/4efcf7da65d36f2978e27de60a8f3bb9.jpg","manifesto":"至少不是最糟糕🌸","group_type":"large","groupType":"large","group_role":"member","group_id":"561f17a88658d4df628b91bf","groupRole":"member"},{"_id":"56efb4b98658d4bf098b4df6","niceName":"俩孩她妈","avatar":"http://wx.qlogo.cn/mmopen/bSb5dSzPn0KBpuOjFlglCVkRX6fjlkibcVY0rtO7biaLwfRUELQicvK6waOevBjAiazKu6ypTXTKMLp82SViaicHX3PA/0","group_type":"large","groupType":"large","group_role":"leader","group_id":"570f9ebe8658d4af378b5067","groupRole":"leader"},{"_id":"55cd73998658d43d568b4d9a","niceName":"薇慈慈","avatar":"/Avatar/160422/cfe2631219be4b4167edd66ed29ce8cf.jpg","manifesto":"Better me，real me。","group_type":"large","groupType":"large","group_role":"member","group_id":"55cd641d8658d437628b4d6c","groupRole":"member"},{"_id":"5691b1fb8658d4f7228c0c87","niceName":"_Dilemma_9","avatar":"/Avatar/160531/b84490664788ab051371800664b77a8e.jpg","manifesto":"85go","group_role":"","group_type":"","groupType":"","groupRole":""},{"_id":"56dfd64a8658d49d228b5e53","niceName":"🎉忘记了✘如何笑","avatar":"http://q.qlogo.cn/qqapp/1103566442/B360A38B59DACB682919A51E98154D0A/100","manifesto":"燃烧吧，脂肪君","group_type":"large","groupType":"large","group_role":"leader","group_id":"573d1c008658d4f72c8b4668","groupRole":"leader"},{"_id":"56c86ad18658d4d0058b655d","niceName":"二井二井二","avatar":"http://tp3.sinaimg.cn/3914907054/180/5750499516/0","group_type":"large","groupType":"large","group_role":"leader","group_id":"57328f978658d479278b4629","groupRole":"leader"},{"_id":"56d9b2d18658d49d6e8b5de0","niceName":"小米蕉＆芭乐","avatar":"http://q.qlogo.cn/qqapp/1103566442/A60B443CDEB6B8B17E38733DF7C27B44/100","group_type":"large","groupType":"large","group_role":"member","group_id":"561f17a88658d4df628b91bf","groupRole":"member"}]}
     */

    private int code;
    private String msg;
    private DataBean data;

    @Override
    public String toString() {
        return "Ground_Entity{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public static Ground_Entity objectFromData(String str) {

        return new Gson().fromJson(str, Ground_Entity.class);
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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * images : /desc/20160527/14643403494876.jpg
         * type : article
         * position : 发现
         * data : {"linkurl":"https://wap.koudaitong.com/v2/feature/xbtvmac0","title":"代餐"}
         */

        private List<FlashViewsBean> flash_views;
        /**
         * _id : 577462618658d4ec028b461e
         * userId : 5651233b8658d481438b478c
         * images : /Note/160630/247302c8fb5e031ec639636ee6c55d1b.jpg@360w_90Q_1x.jpg
         * user : {"_id":"5651233b8658d481438b478c","niceName":"拜拜肉🤐","avatar":"/Avatar/160403/4efcf7da65d36f2978e27de60a8f3bb9.jpg","manifesto":"至少不是最糟糕🌸"}
         */

        private List<RecommendPostsBean> recommend_posts;

        @Override
        public String toString() {
            return "DataBean{" +
                    "flash_views=" + flash_views +
                    ", recommend_posts=" + recommend_posts +
                    ", recommend_users=" + recommend_users +
                    '}';
        }

        /**
         * _id : 55a295208658d4e6658b4825
         * niceName : 不会飞
         * avatar : /Avatar/150713/8dda8914990dee42105a06ff1953c05d.jpeg
         * manifesto : 忍一时之欲，无百日之忧~
         * group_type : large
         * groupType : large
         * group_role : leader
         * group_id : 561f17a88658d4df628b91bf
         * groupRole : leader
         */



        private List<RecommendUsersBean> recommend_users;

        public List<FlashViewsBean> getFlash_views() {
            return flash_views;
        }

        public void setFlash_views(List<FlashViewsBean> flash_views) {
            this.flash_views = flash_views;
        }

        public List<RecommendPostsBean> getRecommend_posts() {
            return recommend_posts;
        }

        public void setRecommend_posts(List<RecommendPostsBean> recommend_posts) {
            this.recommend_posts = recommend_posts;
        }

        public List<RecommendUsersBean> getRecommend_users() {
            return recommend_users;
        }

        public void setRecommend_users(List<RecommendUsersBean> recommend_users) {
            this.recommend_users = recommend_users;
        }

        public static class FlashViewsBean {
            private String images;
            private String type;
            private String position;

            public FlashViewsBean(String images, String type, String position) {
                this.images = images;
                this.type = type;
                this.position = position;
            }


            @Override
            public String toString() {
                return "FlashViewsBean{" +
                        "images='" + images + '\'' +
                        ", type='" + type + '\'' +
                        ", position='" + position + '\'' +
                        ", data=" + data +
                        '}';
            }

            /**
             * linkurl : https://wap.koudaitong.com/v2/feature/xbtvmac0
             * title : 代餐
             */



            private DataBean data;

            public String getImages() {
                return images;
            }

            public void setImages(String images) {
                this.images = images;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getPosition() {
                return position;
            }

            public void setPosition(String position) {
                this.position = position;
            }

            public DataBean getData() {
                return data;
            }

            public void setData(DataBean data) {
                this.data = data;
            }

            public static class DataBeanS {
                private String linkurl;
                private String title;

                public String getLinkurl() {
                    return linkurl;
                }

                public void setLinkurl(String linkurl) {
                    this.linkurl = linkurl;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }
            }
        }

        public static class RecommendPostsBean {
            private String _id;
            private String userId;
            private String images;
            /**
             * _id : 5651233b8658d481438b478c
             * niceName : 拜拜肉🤐
             * avatar : /Avatar/160403/4efcf7da65d36f2978e27de60a8f3bb9.jpg
             * manifesto : 至少不是最糟糕🌸
             */

            private UserBean user;

            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
            }

            public String getUserId() {
                return userId;
            }

            public void setUserId(String userId) {
                this.userId = userId;
            }

            public String getImages() {
                return images;
            }

            public void setImages(String images) {
                this.images = images;
            }

            public UserBean getUser() {
                return user;
            }

            public void setUser(UserBean user) {
                this.user = user;
            }

            public static class UserBean {
                private String _id;
                private String niceName;
                private String avatar;
                private String manifesto;

                public String get_id() {
                    return _id;
                }

                public void set_id(String _id) {
                    this._id = _id;
                }

                public String getNiceName() {
                    return niceName;
                }

                public void setNiceName(String niceName) {
                    this.niceName = niceName;
                }

                public String getAvatar() {
                    return avatar;
                }

                public void setAvatar(String avatar) {
                    this.avatar = avatar;
                }

                public String getManifesto() {
                    return manifesto;
                }

                public void setManifesto(String manifesto) {
                    this.manifesto = manifesto;
                }
            }
        }

        public static class RecommendUsersBean {
            private String _id;
            private String niceName;
            private String avatar;
            private String manifesto;
            private String group_type;
            private String groupType;
            private String group_role;
            private String group_id;
            private String groupRole;

            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
            }

            public String getNiceName() {
                return niceName;
            }

            public void setNiceName(String niceName) {
                this.niceName = niceName;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getManifesto() {
                return manifesto;
            }

            public void setManifesto(String manifesto) {
                this.manifesto = manifesto;
            }

            public String getGroup_type() {
                return group_type;
            }

            public void setGroup_type(String group_type) {
                this.group_type = group_type;
            }

            public String getGroupType() {
                return groupType;
            }

            public void setGroupType(String groupType) {
                this.groupType = groupType;
            }

            public String getGroup_role() {
                return group_role;
            }

            public void setGroup_role(String group_role) {
                this.group_role = group_role;
            }

            public String getGroup_id() {
                return group_id;
            }

            public void setGroup_id(String group_id) {
                this.group_id = group_id;
            }

            public String getGroupRole() {
                return groupRole;
            }

            public void setGroupRole(String groupRole) {
                this.groupRole = groupRole;
            }
        }
    }
}
