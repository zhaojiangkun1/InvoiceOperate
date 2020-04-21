package com.shuzutech.cases;

import com.shuzutech.config.InterfaceNum;
import com.shuzutech.model.RequestInterface;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class QYXXSZ {
    private static String jsbh = "";
    private static String nsrsbh = "110101201707010064";
    private static String dz = "南京市江北新区新科二路2号南大软件学院222D室";
    private static String dh = "02558801191";
    private static String yh = "中国农业银行股份有限公司南京茶亭东街支行";
    private static String zh = "10107501040008319";
    @Test
    public void qyxxsz() throws IOException, NoSuchAlgorithmException {
        String body = body();
        int code = RequestInterface.requestInteface(body, InterfaceNum.TEST);
        Assert.assertEquals(code,0);
    }

    public String body(){
        String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?><business id=\"QYXXSZ\"><body><input><jsbh>"+
                jsbh+"</jsbh><nsrsbh>"+nsrsbh+"</nsrsbh><dz>"+dz+"</dz><dh>"+dh+"</dh><yh>"+yh+"</yh><zh>"+zh+"</zh></input></body></business>";
        return body;
    }
}