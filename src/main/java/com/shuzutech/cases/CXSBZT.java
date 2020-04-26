package com.shuzutech.cases;

import com.shuzutech.bean.TestEnvironment;
import com.shuzutech.model.RequestInterface;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class CXSBZT {
    /**
     * 该接口封装了宁波的CXSBXX接口
     * 根据平台连接方式去判断，如果是宁波间连就是走之前接口，如果是宁波直连则走CXSBXX接口
     * @throws IOException
     * @throws NoSuchAlgorithmException
     * 91320191MA1ML4CL25~~661826092245  主盘
     * 91320191MA1ML4CL25~~661921253676  分盘
     * 91320191MA1ML4CL25~~91320191MA1ML4CL25
     * 110101201601010075~~A20017260026921   110101201707010064   91440300MA5FPUAP6F
     * 110101201707010057~~499000152456  增加了nsrsbh   110101201707010043   91510107690912532D
     */
    private static String jsbh = "";
    private static String nsrsbh = "91440300MA5FPUAP6F";

    @Test(groups = {"查询设备状态"})
    public void cxsbzt() throws IOException, NoSuchAlgorithmException {
        String body = body();
        int code = RequestInterface.requestInteface(body, TestEnvironment.num);
        Assert.assertEquals(code,0);
    }

    public String body(){
        String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?><business id=\"CXSBZT\"><body><input><jsbh>"+jsbh+"</jsbh><nsrsbh>"+nsrsbh+"</nsrsbh></input></body></business>";
        return body;
    }
}
