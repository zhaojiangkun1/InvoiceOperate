package com.shuzutech.cases.baiwangtong.FPGL;

import com.shuzutech.bean.BasicParameters;
import com.shuzutech.config.InterfaceNum;
import com.shuzutech.model.RequestInterface;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class JKSJCX {
    private static String sblx = "";
    private static String nsrsbh = BasicParameters.bwt_nsrsbh;
    private static String jqbh = BasicParameters.bwt_kpzdbs;
    private static InterfaceNum num = BasicParameters.bwt_num;

    @Test(groups = {"监控数据查询"}, description = "电子发票的监控数据查询")
    public void eTicketjksjcx() throws IOException, NoSuchAlgorithmException {
        int code = RequestInterface.requestInteface(body(BasicParameters.bwt_dzfplxdm), num);
        Assert.assertEquals(code, 0);
    }

    @Test(groups = {"监控数据查询"}, description = "卷式发票的监控数据查询")
    public void jTicketjksjcx() throws IOException, NoSuchAlgorithmException {
        int code = RequestInterface.requestInteface(body(BasicParameters.bwt_jpfplxdm), num);
        Assert.assertEquals(code, 0);
    }

    @Test(groups = {"监控数据查询"}, description = "普通发票的监控数据查询")
    public void pTicketjksjcx() throws IOException, NoSuchAlgorithmException {
        int code = RequestInterface.requestInteface(body(BasicParameters.bwt_zpfplxdm), num);
        Assert.assertEquals(code, 0);
    }

    @Test(groups = {"监控数据查询"}, description = "专用发票的监控数据查询")
    public void zTicketjksjcx() throws IOException, NoSuchAlgorithmException {
        int code = RequestInterface.requestInteface(body(BasicParameters.bwt_zzfplxdm), num);
        Assert.assertEquals(code, 0);
    }

    private static String body(String fplxdm) {
        String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<business id=\"JKSJCX\">\n" +
                "\t<body>\n" +
                "\t\t<input>\n" +
                "\t\t\t<sblx>" + sblx + "</sblx>\n" +
                "\t\t\t<nsrsbh>" + nsrsbh + "</nsrsbh>\n" +
                "\t\t\t<jqbh>" + jqbh + "</jqbh>\n" +
                "\t\t\t<fplxdm>" + fplxdm + "</fplxdm>\n" +
                "\t\t</input>\n" +
                "\t</body>\n" +
                "</business>\n";
        return body;
    }
}
