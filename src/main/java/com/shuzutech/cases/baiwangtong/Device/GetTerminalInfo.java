package com.shuzutech.cases.baiwangtong.Device;

import com.shuzutech.bean.BasicParameters;
import com.shuzutech.model.RequestInterface;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class GetTerminalInfo {
    /**
     * 百望通开票终端信息查询接口，可以查询到销方信息
     * 封装的是getTerminal接口，每次查询如果存在更新，会更新到baiwang_invoice_skp_bindings表
     * ===》要改成取baiwang_invoice_skp_bindings表数据
     */
    private static String shnsrsbh = BasicParameters.bwt_nsrsbh;//必传

    @Test(groups = {"开票终端信息查询"}, description = "商户存在，开票终端信息查询")
    public void getTerminalInfo() throws IOException, NoSuchAlgorithmException {
        int code = RequestInterface.requestInteface(body(shnsrsbh), BasicParameters.bwt_num);
        System.out.println(code);
        Assert.assertEquals(code, 0);
    }

    @Test(groups = {"开票终端信息查询"}, description = "shnsrsbh为空，开票终端信息查询")
    public void getTermianlInfo1() throws IOException, NoSuchAlgorithmException {
        int code = RequestInterface.requestInteface(body(""), BasicParameters.bwt_num);
        System.out.println(code);
        Assert.assertEquals(code, 10001);
    }

    @Test(groups = {"开票终端信息查询"}, description = "shnsrsbh不存在，开票终端信息查询")
    public void getTermianlInfo2() throws IOException, NoSuchAlgorithmException {
        int code = RequestInterface.requestInteface(body("110101202006010041"), BasicParameters.bwt_num);
        Assert.assertEquals(code, 1000009);
    }

    public static String body(String shnsrsbh) {
        String body = "<business id=\"GetTerminalInfo\" version=\"2.0\">\n" +
                "\t<body>\n" +
                "\t\t<input>\n" +
                "\t\t\t<shnsrsbh>"+shnsrsbh+"</shnsrsbh>\n" +
                "\t\t</input>\n" +
                "\t</body>\n" +
                "</business>";
        return body;
    }
}
