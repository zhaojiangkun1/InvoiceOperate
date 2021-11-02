package com.shuzutech.cases.zpy.qyxx;

import com.shuzutech.bean.BasicParameters;
import com.shuzutech.model.RequestInterface;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class QYXXSZ {
    private static String dz = "南京市江北新区新科二路2号南大软件学院222D室  400-100-008";
    private static String dh = "6";
    private static String yh = "中国农业银行股份有限公司南京茶亭东街支行  1010750104000831";
    private static String zh = "9";

    /**
     * 一税多号需要验证
     *
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    @Test(groups = {"企业信息设置"}, description = "根据税号去设置企业信息")
    public void qyxxsz() throws IOException, NoSuchAlgorithmException {
        String body = body("", BasicParameters.nsrsbh);
        int code = RequestInterface.requestInteface(body, BasicParameters.num);
        Assert.assertEquals(code, 0);
    }

    public String body(String jsbh, String nsrsbh) {
        String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?><business id=\"QYXXSZ\"><body><input><jsbh>" +
                jsbh + "</jsbh><nsrsbh>" + nsrsbh + "</nsrsbh><dz>" + dz + "</dz><dh>" + dh + "</dh><yh>" + yh + "</yh><zh>" + zh + "</zh></input></body></business>";
        return body;
    }
}