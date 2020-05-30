package com.shuzutech.cases;

import com.shuzutech.bean.BasicParameters;
import com.shuzutech.model.RequestInterface;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class FPLGXXTBCX {

    private static String nsrsbh = "110101201707010057";
    private static String jsbh = "";

    @Test
    public void fplgxxtbcx() throws IOException, NoSuchAlgorithmException {
        String body = body();
        RequestInterface.requestInteface(body, BasicParameters.num);
    }

    public String body(){
        String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<business id=\"FPLGXXTBCX\">\n" +
                "<body>\n" +
                "<input>\n" +
                "\t<jsbh>"+jsbh+"</jsbh>\n" +
                "\t<nsrsbh>"+nsrsbh+"</nsrsbh>\n"+
                "</input>\n" +
                "</body>\n" +
                "</business>\n";
        return body;
    }
}
