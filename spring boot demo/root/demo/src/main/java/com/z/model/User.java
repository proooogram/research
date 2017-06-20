package com.z.model;

import java.io.Serializable;

/**
 * Created by agui on 2017/6/20.
 */
public class User implements Serializable{
    //model serialVersionUID 设定为固定值 否则类一改变 此指变了 导致旧有的已经存储在redis中的binary中的serialVersionUID和现在class中的不匹配 而序列化（载入）失败
    private static final long serialVersionUID = -1L;
    private Integer id;
    private String username;
    private String password;
    private String email;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public User(){}

    public User(Integer id, String username, String password, String email){
        this.id=id;
        this.username=username;
        this.password = password;
        this.email=email;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
