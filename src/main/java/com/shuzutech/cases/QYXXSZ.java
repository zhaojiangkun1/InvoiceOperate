package com.shuzutech.cases;

import com.shuzutech.config.InterfaceNum;
import com.shuzutech.model.RequestInterface;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class QYXXSZ {
    private static String jsbh = "";
    private static String nsrsbh = "110101201707010041";
    private static String dz = "南京市雨花台区软件大道168号润和创智中心3栋309室";
    private static String dh = "18061495423";
    private static String yh = "南京市工商银行";
    private static String zh = "3201000323459889";
    @Test
    public void qyxxsz() throws IOException, NoSuchAlgorithmException {
        String body = body();
        int code = RequestInterface.requestInteface(body, InterfaceNum.DEV);
        Assert.assertEquals(code,0);
    }

    public String body(){
        String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?><business id=\"QYXXSZ\"><body><input><jsbh>"+
                jsbh+"</jsbh><nsrsbh>"+nsrsbh+"</nsrsbh><dz>"+dz+"</dz><dh>"+dh+"</dh><yh>"+yh+"</yh><zh>"+zh+"</zh></input></body></business>";
        return body;
    }
}