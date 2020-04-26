package com.shuzutech.cases;

import com.shuzutech.bean.TestEnvironment;
import com.shuzutech.model.RequestInterface;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class FPXF {
    private static String jsbh = "110101201707010057~~499000152456 ";
    private static String fplxdm = "004";
    private static String xfrq = "2020-04-21";//格式：YYYY-mm-dd

    /**
     * 发票修复：
     * 1.先修复
     * 2.修复成功之后，发票查询，发票补打，发票作废，发票冲红
     *
     * 旋极  发票修复
     * 宁波  发票修复
     *
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */

    @Test
    public void fpxf() throws IOException, NoSuchAlgorithmException {
        String body = body();
        int code = RequestInterface.requestInteface(body, TestEnvironment.num);
        Assert.assertEquals(code,0);
    }

    public String body(){
        String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?>" + "<business id=\"FPXF\">" + "<body>" + "<input>" +
                "<jsbh>" + jsbh + "</jsbh>" +
                "<fplxdm>" + fplxdm + "</fplxdm>" +
                "<xfrq>" + xfrq + "</xfrq>" +
                "</input>" +
                "</body>" +
                "</business>";
        return body;
    }
}
