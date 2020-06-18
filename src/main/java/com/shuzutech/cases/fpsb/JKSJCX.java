package com.shuzutech.cases.fpsb;

import com.shuzutech.bean.BasicParameters;
import com.shuzutech.model.RequestInterface;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class JKSJCX {

    private static String sblx = "1";
    private static String nsrsbh = BasicParameters.nsrsbh;
    private static String jsbh = BasicParameters.jsbh;
    private static String fplxdm = "026";

    @Test
    public void jksjcx() throws IOException, NoSuchAlgorithmException {
        int code = RequestInterface.requestInteface(body(), BasicParameters.num);
        Assert.assertEquals(code, 0);
    }

    public static String body() {
        String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?><business id=\"JKSJCX\"><body><input><sblx>" + sblx + "</sblx><nsrsbh>" + nsrsbh + "</nsrsbh><jsbh>" + jsbh + "</jsbh><fplxdm>" + fplxdm + "</fplxdm></input></body></business>";
        return body;
    }
}
