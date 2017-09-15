package wedo.job.bean;

import java.io.Serializable;

/**
 * 用户类
 * Created by Lifu on 2017/9/15.
 */

public class User implements Serializable{
    private String user_id;
    private String user_name;
    private String user_password;
    private String user_phoneNum;
    public User(){}

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_phoneNum() {
        return user_phoneNum;
    }

    public void setUser_phoneNum(String user_phoneNum) {
        this.user_phoneNum = user_phoneNum;
    }
}
