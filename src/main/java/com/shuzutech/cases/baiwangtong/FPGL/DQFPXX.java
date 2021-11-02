package com.shuzutech.cases.baiwangtong.FPGL;

import com.shuzutech.bean.BasicParameters;
import com.shuzutech.model.RequestBody;
import com.shuzutech.model.RequestInterface;
import com.shuzutech.model.ZpyInputManagement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class DQFPXX {
    private static String kpzdbs = BasicParameters.bwt_kpzdbs;
    private static String nsrsbh = "";

    @Test(groups = {"当前未开票号码查询"}, description = "查询当前电子票的发票信息")
    public void eTicketDqfpxx() throws IOException, NoSuchAlgorithmException {
//        String body = body(kpzdbs, nsrsbh, BasicParameters.bwt_dzfplxdm);
        int code = RequestInterface.requestInteface(RequestBody.getRequestBody("DQFPXX", ZpyInputManagement.dqfpxx("026")), BasicParameters.bwt_num);
        System.out.println(code);
        Assert.assertEquals(code, 0);
    }

    @Test(groups = {"当前未开票号码查询"}, description = "查询当前增值税卷票的发票信息")
    public void jTicketDqfpxx() throws IOException, NoSuchAlgorithmException {
        String body = body(kpzdbs, nsrsbh, BasicParameters.bwt_jpfplxdm);
        int code = RequestInterface.requestInteface(body, BasicParameters.bwt_num);
        System.out.println(code);
        Assert.assertEquals(code, 0);
    }

    @Test(groups = {"当前未开票号码查询"}, description = "查询当前增值税普票的发票信息")
    public void pTicketDqfpxx() throws IOException, NoSuchAlgorithmException {
        String body = body(kpzdbs, nsrsbh, BasicParameters.bwt_zpfplxdm);
        int code = RequestInterface.requestInteface(body, BasicParameters.bwt_num);
        System.out.println(code);
        Assert.assertEquals(code, 0);
    }

    @Test(groups = {"当前未开票号码查询"}, description = "查询当前增值税专票的发票信息")
    public void zTicketDqfpxx() throws IOException, NoSuchAlgorithmException {
        String body = body(kpzdbs, nsrsbh, BasicParameters.bwt_zzfplxdm);
        int code = RequestInterface.requestInteface(body, BasicParameters.bwt_num);
        System.out.println(code);
        Assert.assertEquals(code, 0);
    }

    @Test(groups = {"当前未开票号码查询"}, description = "根据纳税人识别号查询当前的发票信息")
    public void byNsrsbhDqfpxx() throws IOException, NoSuchAlgorithmException {
        String body = body("", BasicParameters.bwt_nsrsbh, BasicParameters.bwt_zzfplxdm);
        int code = RequestInterface.requestInteface(body, BasicParameters.bwt_num);
        System.out.println(code);
        Assert.assertEquals(code, 0);
    }


    public static String body(String kpzdbs, String nsrsbh, String fplxdm) {
        String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<business id=\"DQFPXX\">\n" +
                "\t<body>\n" +
                "\t\t<input>\n" +
                "\t\t\t<kpzdbs>" + kpzdbs + "</kpzdbs>\n" +
                "<nsrsbh>" + nsrsbh + "</nsrsbh>\n" +
                "\t\t\t<fplxdm>" + fplxdm + "</fplxdm>\n" +
                "\t\t</input>\n" +
                "\t</body>\n" +
                "</business>\n";
        return body;
    }
}
