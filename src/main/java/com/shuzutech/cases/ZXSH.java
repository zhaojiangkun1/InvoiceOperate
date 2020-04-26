package com.shuzutech.cases;

import com.shuzutech.config.InterfaceNum;
import com.shuzutech.model.RequestInterface;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class ZXSH {
    private static String nsrsbh = "110101201707010043"; //必填
    private static String skph = "A20016420000265";//多个盘时必填
    private static String cancelTime = "20200524";//发票业务注销时间

    @Test
    public void zxsh() throws IOException, NoSuchAlgorithmException {
        String body = body();
        int code = RequestInterface.requestInteface(body, InterfaceNum.TEST);
        Assert.assertEquals(code,0);
    }

    private String body(){
        String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?><business id=\"ZXSH\"><body><input><nsrsbh>"+nsrsbh+"</nsrsbh><skph>"+skph+"</skph><cancelTime>"+cancelTime+"</cancelTime></input></body></business>";
        return body;
    }
}
