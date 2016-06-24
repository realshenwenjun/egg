package com.dskj.user.entity;

import java.io.Serializable;

public class ChatUser implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -6732780067016630645L;
    private String username;
    private String password;
    private String nickname;

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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

}
