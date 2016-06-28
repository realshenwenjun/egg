package com.dskj.enu;

import java.util.Calendar;

/*
 * 一天访问次数限制
 */
public enum OSAskLimit {
    ANDROID, IOS, OTHER;
    private int o = 300000;
    private int i = 0;
    private long d = 86400000;
    private long time = 0;

    public int getO() {
        return o;
    }

    public void setO(int o) {
        this.o = o;
    }

    private OSAskLimit() {
        init();
    }

    private void init() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR, -12);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        time = cal.getTimeInMillis();
        i = 0;
    }

    public Boolean getOSAuth() {
        if ((System.currentTimeMillis() - time) >= d)
            init();
        if (i >= o)
            return false;
        this.i++;
        return true;
    }
}
