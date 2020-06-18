package com.shuzutech.cases.fpgl;

import com.shuzutech.bean.BasicParameters;
import com.shuzutech.model.RequestInterface;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class FPXF {
    /**
     * 发票修复：
     * 1.先修复
     * 2.修复成功之后，发票查询，发票补打，发票作废，发票冲红
     * 110101201707010064~~499000152528
     * 110101201707010057~~499000152456
     * 91320191MA1ML4CL25~~661921253676
     * 110101201707010043~~499000152157
     * 旋极  发票修复
     * 宁波  发票修复
     * 95767043
     *
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    private static String jsbh = BasicParameters.jsbh;
    private static String fplxdm = "026";
    private static String xfrq = "2020-06-10";//格式：YYYY-mm-dd

    @Test
    public void fpxf() throws IOException, NoSuchAlgorithmException {
        String body = body();
        int code = RequestInterface.requestInteface(body, BasicParameters.num);
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
