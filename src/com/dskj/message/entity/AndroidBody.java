package com.dskj.message.entity;

import java.io.Serializable;

/**
 * Created by chenbo on 2016/4/22.
 */
public class AndroidBody implements Serializable {
    private static final long serialVersionUID = -4384143044106007775L;

    private String ticker;
    private String title;
    private String text;
    private String icon;
    private String largeIcon;
    private String img;
    private String sound;
    private int builder_id;
    private String play_vibrate;
    private String play_lights;
    private String play_sound;
    private String after_open;
    private String url;
    private String activity;
    private String custom;

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getLargeIcon() {
        return largeIcon;
    }

    public void setLargeIcon(String largeIcon) {
        this.largeIcon = largeIcon;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public int getBuilder_id() {
        return builder_id;
    }

    public void setBuilder_id(int builder_id) {
        this.builder_id = builder_id;
    }

    public String getPlay_vibrate() {
        return play_vibrate;
    }

    public void setPlay_vibrate(String play_vibrate) {
        this.play_vibrate = play_vibrate;
    }

    public String getPlay_lights() {
        return play_lights;
    }

    public void setPlay_lights(String play_lights) {
        this.play_lights = play_lights;
    }

    public String getPlay_sound() {
        return play_sound;
    }

    public void setPlay_sound(String play_sound) {
        this.play_sound = play_sound;
    }

    public String getAfter_open() {
        return after_open;
    }

    public void setAfter_open(String after_open) {
        this.after_open = after_open;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getCustom() {
        return custom;
    }

    public void setCustom(String custom) {
        this.custom = custom;
    }
}
