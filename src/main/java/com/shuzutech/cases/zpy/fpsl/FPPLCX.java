package com.shuzutech.cases.zpy.fpsl;

import com.shuzutech.config.InterfaceNum;
import com.shuzutech.model.RequestInterface;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class FPPLCX {
    private static String nsrsbh = "110101201707010057";
    private static String fpzt = "09";
    private static String start_date = "2020-04-01";
    private static String end_date = "2020-04-24";
    private static String page = "1";
    private static String pagesize = "5";

    @Test
    public void fpplcx() throws IOException, NoSuchAlgorithmException {
        String body = body();
        int code = RequestInterface.requestInteface(body, InterfaceNum.DEV);
        Assert.assertEquals(code, 0);
    }

    public static String body() {
        String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?><business id=\"FPPLCX\"><body><input><nsrsbh>" + nsrsbh + "</nsrsbh>"+
                "<fpzt>"+fpzt+"</fpzt>"+
                "<start_date>" + start_date + "</start_date><end_date>" + end_date + "</end_date>"+
                "<page>" + page + "</page><pagesize>" + pagesize + "</pagesize></input></body></business>";
        return body;
    }
}

