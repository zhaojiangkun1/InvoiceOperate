package com.shuzutech.cases.zpy.fpsl;

import com.shuzutech.bean.BasicParameters;
import com.shuzutech.model.RequestInterface;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class FPSLZTCX {

    private static String nsrsbh = "110101201707010057";
    @Test
    public void fpslztcx() throws IOException, NoSuchAlgorithmException {
        String body = body();
        RequestInterface.requestInteface(body, BasicParameters.num);
    }

    public String body(){
        String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<business id=\"FPSLZTCX\">\n" +
                "<body>\n" +
                "<input>\n" +
                "<jsbh></jsbh>\n" +
                "<nsrsbh>"+nsrsbh+"</nsrsbh>"+
                "<fplxdm>026</fplxdm>\n" +
                "<slqssj>20190901</slqssj>\n" +
                "<sljzsj>20191029</sljzsj>\n" +
                "<slxh>110101201707010057201910292563</slxh>\n" +
                "<clzt>1</clzt>\n" +
                "</input>\n" +
                "</body>\n" +
                "</business>\n";

        return body;
    }

}
