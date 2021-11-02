package com.shuzutech.cases.baiwangtong.FPGL;

import com.shuzutech.bean.BasicParameters;
import com.shuzutech.config.InterfaceNum;
import com.shuzutech.model.RequestInterface;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class GPXXCX {
    private static String kpzdbs = BasicParameters.bwt_kpzdbs;
    private static String sblx = "";
    private static String fpzt = "1";
    private static String nsrsbh = BasicParameters.bwt_nsrsbh;
    private static String qtzd = "";
    private static String lgqxx = "";
    private static InterfaceNum num = BasicParameters.bwt_num;

    @Test(groups = {"购票信息查询"}, description = "电子发票的购票信息查询")
    public void eTicketgpxxcx() throws IOException, NoSuchAlgorithmException {
        int code = RequestInterface.requestInteface(body(BasicParameters.bwt_dzfplxdm), num);
        Assert.assertEquals(code, 0);
    }

    @Test(groups = {"购票信息查询"}, description = "卷式发票的购票信息查询")
    public void jTicketgpxxcx() throws IOException, NoSuchAlgorithmException {
        int code = RequestInterface.requestInteface(body(BasicParameters.bwt_jpfplxdm), num);
        Assert.assertEquals(code, 0);
    }

    @Test(groups = {"购票信息查询"}, description = "增值税普通发票的购票信息查询")
    public void pTicketgpxxcx() throws IOException, NoSuchAlgorithmException {
        int code = RequestInterface.requestInteface(body(BasicParameters.bwt_zpfplxdm), num);
        System.out.println(code);
        Assert.assertEquals(code, 0);
    }

    @Test(groups = {"购票信息查询"}, description = "增值税专用发票的购票信息查询")
    public void zTicketgpxxcx() throws IOException, NoSuchAlgorithmException {
        int code = RequestInterface.requestInteface(body(BasicParameters.bwt_zzfplxdm), num);
        Assert.assertEquals(code, 0);
    }

    private static String body(String fplxdm) {
        String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<business id=\"GPXXCX\">\n" +
                "\t<body>\n" +
                "\t\t<input>\n" +
                "\t\t\t<kpzdbs>" + kpzdbs + "</kpzdbs>\n" +
                "\t\t\t<fplxdm>" + fplxdm + "</fplxdm>\n" +
                "\t\t\t<sblx>" + sblx + "</sblx>\n" +
                "\t\t\t<fpzt>" + fpzt + "</fpzt>\n" +
                "\t\t\t<nsrsbh>" + nsrsbh + "</nsrsbh>\n" +
                "\t\t\t<qtzd>" + qtzd + "</qtzd>\n" +
                "\t\t\t<lgqxx>" + lgqxx + "</lgqxx>\n" +
                "\t\t</input>\n" +
                "\t</body>\n" +
                "</business>";
        return body;
    }
}
