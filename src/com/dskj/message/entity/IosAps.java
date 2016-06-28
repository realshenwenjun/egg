package com.dskj.message.entity;

import java.io.Serializable;

/**
 * Created by chenbo on 2016/4/22.
 */
public class IosAps implements Serializable {
    private static final long serialVersionUID = 3712467736765714863L;

    private String alert;
    private Integer badge;
    private String sound;
    private String category;

    public String getAlert() {
        return alert;
    }

    public void setAlert(String alert) {
        this.alert = alert;
    }

    public Integer getBadge() {
        return badge;
    }

    public void setBadge(Integer badge) {
        this.badge = badge;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
