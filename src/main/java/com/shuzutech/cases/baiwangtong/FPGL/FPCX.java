package com.shuzutech.cases.baiwangtong;

import com.shuzutech.bean.BasicParameters;
import com.shuzutech.model.RequestInterface;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class FPCX {
    private static String fplxdm = "026";
    private static String nsrsbh = BasicParameters.bwt_nsrsbh;
    private static String kpzdbs = BasicParameters.bwt_kpzdbs;
    private static String fpqqlsh = "zI76520200714172904";
    private static String fpdm = "050003521107";
    private static String fphm ="20191634";

    /**
     * cxfs:0  是按照发票号码查询（臻票云原有接口是根据发票代码+发票号码查询，不确定是否保持一致）
     * 1 请求流水号
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    @Test(groups = {"发票查询"}, description = "开票终端标识和纳税人识别号均为空")
    public void kpzdbsAndNsrsbhIsNull() throws IOException, NoSuchAlgorithmException {
        String body = body("", "", fplxdm, "0", fpdm+fphm);
        int code = RequestInterface.requestInteface(body, BasicParameters.bwt_num);
        Assert.assertEquals(code, 10001);
    }

    @Test(groups = {"发票查询"}, description = "按照开票终端标识查询")
    public void kpzdbsFpcx() throws IOException, NoSuchAlgorithmException {
        String body = body(kpzdbs, "", fplxdm, "1", fpqqlsh);
        int code = RequestInterface.requestInteface(body, BasicParameters.bwt_num);
        Assert.assertEquals(code, 0);
    }

    @Test(groups = {"发票查询"}, description = "根据纳税人识别号查询")
    public void nsrsbhFpcx() throws IOException, NoSuchAlgorithmException {
        String body = body("", nsrsbh, fplxdm, "0", fpdm+fphm);
        int code = RequestInterface.requestInteface(body, BasicParameters.bwt_num);
        Assert.assertEquals(code, 0);

    }

    @Test(groups = {"发票查询"}, description = "发票类型代码为空")
    public void fplxdmIsNull() throws IOException, NoSuchAlgorithmException {
        String body = body(kpzdbs, "", "", "0", fpdm+fphm);
        int code = RequestInterface.requestInteface(body, BasicParameters.bwt_num);
        Assert.assertEquals(code, 10001);
    }

    @Test(groups = {"发票查询"}, description = "查询方式为空")
    public void cxfsIsNull() throws IOException, NoSuchAlgorithmException {
        String body = body(kpzdbs, "", fplxdm, "", fpqqlsh);
        int code = RequestInterface.requestInteface(body, BasicParameters.bwt_num);
        Assert.assertEquals(code, 10001);
    }
    @Test(groups = {"发票查询"}, description = "查询条件为空")
    public void cxtjIsNull() throws IOException, NoSuchAlgorithmException {
        String body = body(kpzdbs, "", fplxdm, "0", "");
        int code = RequestInterface.requestInteface(body, BasicParameters.bwt_num);
        Assert.assertEquals(code, 10001);
    }
    @Test(groups = {"发票查询"}, description = "查询的纳税人识别号不存在")
    public void nsrsbhIsNotExist() throws IOException, NoSuchAlgorithmException {
        String body = body("", "23423423424", fplxdm, "0", fpqqlsh);
        int code = RequestInterface.requestInteface(body, BasicParameters.bwt_num);
        Assert.assertEquals(code, 1000009);
    }

    public static String body(String kpzdbs, String nsrsbh, String fplxdm, String cxfs, String cxtj) {
        String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<business id=\"FPCX\">\n" +
                "<body>\n" +
                "\t<input>\n" +
                "\t\t<kpzdbs>" + kpzdbs + "</kpzdbs>\n" +
                "\t\t<nsrsbh>" + nsrsbh + "</nsrsbh>\n" +
                "\t\t<fplxdm>" + fplxdm + "</fplxdm>\n" +
                "\t\t<cxfs>" + cxfs + "</cxfs>\n" +
                "\t\t<cxtj>" + cxtj + "</cxtj>\n" +
                "\t</input>\n" +
                "</body>\n" +
                "</business>\n";
        return body;
    }
}
