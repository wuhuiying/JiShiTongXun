package com.example.administrator.kejibeidou.Model.Bean;

import java.util.List;

/**
 * Created by 小慧莹 on 2018/2/27.
 */

public class Fragment1DataBean {

    /**
     * result : [{"id":0,"img":"http://www.bwstudent.com/one/headImage/20180203104233.jpg","url":"https://www.baidu.com/"},{"id":0,"img":"http://www.bwstudent.com/one/headImage/20180203104233.jpg","url":"https://www.baidu.com/"},{"id":0,"img":"http://www.bwstudent.com/one/headImage/20180203104233.jpg","url":"https://www.baidu.com/"}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

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

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * id : 0
         * img : http://www.bwstudent.com/one/headImage/20180203104233.jpg
         * url : https://www.baidu.com/
         */

        private int id;
        private String img;
        private String url;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
