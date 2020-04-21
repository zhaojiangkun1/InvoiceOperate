package com.shuzutech.h5Case;

import com.shuzutech.config.InterfaceNum;

import java.util.Locale;
import java.util.ResourceBundle;

public class GetRequestAddr {
    private static ResourceBundle bundle = ResourceBundle.getBundle("application", Locale.CHINA);
    public static String getRequestAddr(InterfaceNum num){
        String string = num.toString();
        String url = "";
        if (string.contains("TEST")){
            url = bundle.getString("testUrl");
        }
        if (string.contains("DEV")){
            url = bundle.getString("devUrl");
        }
        if (string.contains("PRO")){
            url = bundle.getString("proUrl");
        }
        return url;
    }
}
