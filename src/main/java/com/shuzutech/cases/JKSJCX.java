package com.shuzutech.cases;

import com.shuzutech.bean.BasicParameters;
import com.shuzutech.model.RequestInterface;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class JKSJCX {

    private static String sblx = "2";
    private static String nsrsbh = "";
    private static String jsbh = "110101201707010057~~499000152456";
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
