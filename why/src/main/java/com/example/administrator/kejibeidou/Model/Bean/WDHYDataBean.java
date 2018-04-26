package com.example.administrator.kejibeidou.Model.Bean;

import java.util.List;

/**
 * Created by 小慧莹 on 2018/3/8.
 */

public class WDHYDataBean

{
    /**
     * result : [{"id":74,"img":"https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=114395345,3231482796&fm=27&gp=0.jpg","nickName":"卫栖梧","phone":"17601259510"},{"id":74,"img":"https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=114395345,3231482796&fm=27&gp=0.jpg","nickName":"卫栖梧","phone":"17601259510"},{"id":74,"img":"https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=114395345,3231482796&fm=27&gp=0.jpg","nickName":"卫栖梧","phone":"17601259510"},{"id":42,"img":"https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=114395345,3231482796&fm=27&gp=0.jpg","nickName":"456213","phone":"17601259512"}]
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
         * id : 74
         * img : https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=114395345,3231482796&fm=27&gp=0.jpg
         * nickName : 卫栖梧
         * phone : 17601259510
         */

        private int id;
        private String img;
        private String nickName;
        private String phone;

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

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }
    }
}
