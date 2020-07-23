package com.shuzutech.cases.baiwangtong;

import com.shuzutech.bean.BasicParameters;
import com.shuzutech.config.InterfaceNum;
import com.shuzutech.model.RequestInterface;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class CXSBZT {
    private static String kpzdbs = BasicParameters.bwt_kpzdbs;
    private static String nsrsbh = "";
    private static InterfaceNum num = BasicParameters.bwt_num;

    @Test(groups = {"查询设备状态"},description = "根据开票终端标识去查询设备状态")
    public void byKpzdbsCxsbzt() throws IOException, NoSuchAlgorithmException {
        String body = body(kpzdbs,nsrsbh);
        int code = RequestInterface.requestInteface(body, num);
        Assert.assertEquals(code,0);
    }

    @Test(groups = {"查询设备状态"},description = "根据纳税人识别号查询设备状态")
    public void byNsrsbhCxsbzt() throws IOException, NoSuchAlgorithmException {
        String body = body("",BasicParameters.bwt_nsrsbh);
        int code = RequestInterface.requestInteface(body, num);
        Assert.assertEquals(code,0);
    }

    @Test(groups = {"查询设备状态"},description = "开票终端标识不存在，查询设备状态")
    public void kpzdbsIsNotExist() throws IOException, NoSuchAlgorithmException {
        String body = body("599000152131","");
        int code = RequestInterface.requestInteface(body, num);
        Assert.assertEquals(code,1000009);
    }

    @Test(groups = {"查询设备状态"},description = "所查商户不存在，查询设备状态")
    public void nsrsbhIsNotExist() throws IOException, NoSuchAlgorithmException {
        String body = body("","110101202007010037");
        int code = RequestInterface.requestInteface(body, num);
        Assert.assertEquals(code,1000009);
    }

    private static String body(String kpzdbs,String nsrsbh){
        String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?><business id=\"CXSBZT\"><body><input><kpzdbs>"+kpzdbs+"</kpzdbs>"+"<nsrsbh>"+nsrsbh+"</nsrsbh></input></body></business>";
        return body;
    }
}


