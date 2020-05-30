package com.shuzutech.cases;

import com.shuzutech.bean.BasicParameters;
import com.shuzutech.model.RequestInterface;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class CXSL {
    private static String nsrsbh = "110101201707010057";
    private static String jsbh = "";

    @Test
    public void cxsl() throws IOException, NoSuchAlgorithmException {
        String body = body();
        RequestInterface.requestInteface(body, BasicParameters.num);
    }

    public String body(){
        String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<business id=\"CXSL\">\n" +
                "\t<body>\n" +
                "\t\t<input>\n" +
                "\t\t\t<jsbh>"+jsbh+"</jsbh>\n" +
                "\t\t\t<nsrsbh>"+nsrsbh+"</nsrsbh>\n"+
                "\t\t\t<fplxdm>007</fplxdm>\n" +
                "\t\t\t<slxh>11010120170701005720191029174369</slxh>\n" +
                "\t\t</input>\n" +
                "\t</body>\n" +
                "</business>";
        return body;
    }

}
