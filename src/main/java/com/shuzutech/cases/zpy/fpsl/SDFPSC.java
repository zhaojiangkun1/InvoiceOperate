package com.shuzutech.cases.zpy.fpsl;

import com.shuzutech.bean.BasicParameters;
import com.shuzutech.model.RequestInterface;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class SDFPSC {
    private String sblx = "2";
    private String nsrsbh = "92520322MA6HQR9J11";
    private String sksbbh = "499202839926";
    private String fplxdm = "026";
    private String sclx = "1";
    private String wscfpzs = "2";

    @Test(groups = {"手动上传发票"})
    public void sdfpsc() throws IOException, NoSuchAlgorithmException {
        String body = body();
        int code = RequestInterface.requestInteface(body, BasicParameters.num);
        Assert.assertEquals(code, 0);
    }


    public String body() {
        String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?> <business id=\"SDFPSC\"><body><input><sblx>"+sblx+"</sblx><nsrsbh>"+nsrsbh+"</nsrsbh><sksbbh>"+sksbbh+"</sksbbh><fplxdm>"+fplxdm+"</fplxdm><sclx>"+sclx+"</sclx><wscfpzs>"+wscfpzs+"</wscfpzs></input></body></business>";
        return body;
    }
}
