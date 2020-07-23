package com.shuzutech.cases.baiwangtong;

import com.shuzutech.bean.BasicParameters;
import com.shuzutech.config.InterfaceNum;
import com.shuzutech.model.RequestInterface;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class TJXXCX {
    /**
     * 百望反馈，金税盘不支持发票查询统计；税控统计信息查询返回returncode:00502returnmsg:税控响应超时，异常：SocketTimeoutExceptionjava.net.SocketTimeoutException: Read timed out
     */
    private static String kpzdbs = BasicParameters.bwt_kpzdbs;
    private static String nsrsbh = BasicParameters.bwt_nsrsbh;
    private static String qsrq = "20200601";
    private static String zzrq = "20200629";
    private static InterfaceNum num = BasicParameters.bwt_num;

    @Test(groups = {"统计信息查询"},description = "电子发票的统计信息查询")
    public void eTickettjxxcx() throws IOException, NoSuchAlgorithmException {
        int code = RequestInterface.requestInteface(body(BasicParameters.bwt_dzfplxdm), num);
        Assert.assertEquals(code,0);
    }

    @Test(groups = {"统计信息查询"},description = "卷式发票的统计信息查询")
    public void jTickettjxxcx() throws IOException, NoSuchAlgorithmException {
        int code = RequestInterface.requestInteface(body(BasicParameters.bwt_jpfplxdm), num);
        Assert.assertEquals(code,0);
    }

    @Test(groups = {"统计信息查询"},description = "普通发票的统计信息查询")
    public void pTickettjxxcx() throws IOException, NoSuchAlgorithmException {
        int code = RequestInterface.requestInteface(body(BasicParameters.bwt_zpfplxdm), num);
        Assert.assertEquals(code,0);
    }

    @Test(groups = {"统计信息查询"},description = "专用发票的统计信息查询")
    public void zTickettjxxcx() throws IOException, NoSuchAlgorithmException {
        int code = RequestInterface.requestInteface(body(BasicParameters.bwt_zzfplxdm), num);
        Assert.assertEquals(code,0);
    }

    public static String body(String fplxdm){
        String body ="<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<business id=\"TJXXCX\">\n" +
                "\t<body>\n" +
                "\t\t<input>\n" +
                "\t\t\t<kpzdbs>"+kpzdbs+"</kpzdbs>\n" +
                "<nsrsbh>"+nsrsbh+"</nsrsbh>\n" +
                "\t\t\t<fplxdm>"+fplxdm+"</fplxdm>\n" +
                "\t\t\t<qsrq>"+qsrq+"</qsrq>\n" +
                "\t\t\t<zzrq>"+zzrq+"</zzrq>\n" +
                "\t\t</input>\n" +
                "\t</body>\n" +
                "</business>\n";
        return body;
    }
}
