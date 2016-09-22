package com.dskj.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by ASUS on 2016/9/22.
 */
public class URLCodeUtil {
    public static String encode(String s) throws UnsupportedEncodingException {
        String e = URLEncoder.encode(s,"UTF-8");
        e = e.replaceAll("\\+","%20");
        e = e.replaceAll("\\*","%2A");
        e = e.replaceAll("%7E","~");
        return e;
    }
}
