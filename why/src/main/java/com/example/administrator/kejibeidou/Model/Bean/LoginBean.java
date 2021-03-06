package com.example.administrator.kejibeidou.Model.Bean;

/**
 * Created by 小慧莹 on 2018/2/27.
 */

public class LoginBean {

    /**
     * result : {"password":"e10adc3949ba59abbe56e057f20f883e","sessionId":"2018032616182556","userName":"20180227094902","userId":56}
     * message : 用户登录成功
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
         * password : e10adc3949ba59abbe56e057f20f883e
         * sessionId : 2018032616182556
         * userName : 20180227094902
         * userId : 56
         */

        private String password;
        private String sessionId;
        private String userName;
        private int userId;

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }
    }
}
