package com.example.administrator.kejibeidou.Model.Bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by 小慧莹 on 2018/3/2.
 */

public class Fragment1_DataBean {

    /**
     * result : {"1":[{"createTime":"2018-01-30 00:00:00","id":3,"newsImg":"http://www.bwstudent.com/one/headImage/20180203104233.jpg","source":"测试网","title":"\u201c海洋六号\u201d深海科考成果丰硕初篇"},{"createTime":"2018-01-30 00:00:00","id":4,"newsImg":"http://www.bwstudent.com/one/headImage/20180203104233.jpg","source":"石油网","title":"\u201c海洋六号\u201d深海科考成果丰硕上"}],"2":[{"createTime":"2018-01-30 00:00:00","id":13,"newsImg":"http://www.bwstudent.com/one/headImage/20180203104233.jpg","source":"原子弹网","title":"世界最强氘氚中子源究竟\u201c强\u201d在哪"},{"createTime":"2018-01-30 00:00:00","id":14,"newsImg":"http://www.bwstudent.com/one/headImage/20180203104233.jpg","source":"国际网","title":"北科院举办\u201c创新北京\u201d国际论坛"}],"3":[{"createTime":"2018-01-30 00:00:00","id":7,"newsImg":"http://www.bwstudent.com/one/headImage/20180203104233.jpg","source":"石头网","title":"\u201c海洋八号\u201d深海科考成果丰硕上"},{"createTime":"2018-01-27 00:00:00","id":17,"newsImg":"www.baidu.com","source":"zhoangwen","title":"zhongwenwenag"}]}
     * message : 请求成功
     * status : 0000
     */

    private ResultBean result;
    private String message;
    private String status;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static class ResultBean {
        @SerializedName("1")
        private List<_$1Bean> _$1;
        @SerializedName("2")
        private List<_$2Bean> _$2;
        @SerializedName("3")
        private List<_$3Bean> _$3;

        public List<_$1Bean> get_$1() {
            return _$1;
        }

        public void set_$1(List<_$1Bean> _$1) {
            this._$1 = _$1;
        }

        public List<_$2Bean> get_$2() {
            return _$2;
        }

        public void set_$2(List<_$2Bean> _$2) {
            this._$2 = _$2;
        }

        public List<_$3Bean> get_$3() {
            return _$3;
        }

        public void set_$3(List<_$3Bean> _$3) {
            this._$3 = _$3;
        }

        public static class _$1Bean {
            /**
             * createTime : 2018-01-30 00:00:00
             * id : 3
             * newsImg : http://www.bwstudent.com/one/headImage/20180203104233.jpg
             * source : 测试网
             * title : “海洋六号”深海科考成果丰硕初篇
             */

            private String createTime;
            private int id;
            private String newsImg;
            private String source;
            private String title;

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getNewsImg() {
                return newsImg;
            }

            public void setNewsImg(String newsImg) {
                this.newsImg = newsImg;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }
        }

        public static class _$2Bean {
            /**
             * createTime : 2018-01-30 00:00:00
             * id : 13
             * newsImg : http://www.bwstudent.com/one/headImage/20180203104233.jpg
             * source : 原子弹网
             * title : 世界最强氘氚中子源究竟“强”在哪
             */

            private String createTime;
            private int id;
            private String newsImg;
            private String source;
            private String title;

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getNewsImg() {
                return newsImg;
            }

            public void setNewsImg(String newsImg) {
                this.newsImg = newsImg;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }
        }

        public static class _$3Bean {
            /**
             * createTime : 2018-01-30 00:00:00
             * id : 7
             * newsImg : http://www.bwstudent.com/one/headImage/20180203104233.jpg
             * source : 石头网
             * title : “海洋八号”深海科考成果丰硕上
             */

            private String createTime;
            private int id;
            private String newsImg;
            private String source;
            private String title;

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getNewsImg() {
                return newsImg;
            }

            public void setNewsImg(String newsImg) {
                this.newsImg = newsImg;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }
        }
    }
}
