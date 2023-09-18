package com.shuzutech.cases.zpy.fpgl;

import com.shuzutech.bean.BasicParameters;
import com.shuzutech.model.RequestInterface;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class YQSBZF {
    private static String jsbh = BasicParameters.jsbh;
    @Test
    public void yqsbzf(){
        String body = body();

        int code = 0;
        try {
            code = RequestInterface.requestInteface(body, BasicParameters.num);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(code, 0);
    }

    public String body(){
        String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<business id=\"YQSBZF\">\n" +
                "\t<body>\n" +
                "\t\t<input>\n" +
                "\t\t\t<jsbh>"+jsbh+"</jsbh>\n" +
                "\t\t\t<nsrsbh></nsrsbh>\n" +
                "\t\t\t<fplxdm>"+"004"+"</fplxdm>\n" +
                "\t\t</input>\n" +
                "\t</body>\n" +
                "</business>";

        return body;
    }
}
