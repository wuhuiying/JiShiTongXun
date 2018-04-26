package com.example.administrator.kejibeidou.Model.Bean;

/**
 * Created by 小慧莹 on 2018/3/19.
 */

public class SouSuoDataBean {

    /**
     * result : {"createTime":1519660800000,"email":"1779434766@qq.com","id":56,"nickName":"zhangsan","phone":"15510264338"}
     * message : 查询成功
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
        /**
         * createTime : 1519660800000
         * email : 1779434766@qq.com
         * id : 56
         * nickName : zhangsan
         * phone : 15510264338
         */

        private long createTime;
        private String email;
        private int id;
        private String nickName;
        private String phone;

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
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
