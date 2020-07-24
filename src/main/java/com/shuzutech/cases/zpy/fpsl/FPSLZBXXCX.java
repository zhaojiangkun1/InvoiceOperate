package com.shuzutech.cases.zpy.fpsl;

import com.shuzutech.bean.BasicParameters;
import com.shuzutech.model.RequestInterface;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class FPSLZBXXCX {

    /**
     * 110101201707010057~~499000152456
     */
    private static String jsbh = "";
    private static String nsrsbh = "110101201707010057";
    @Test
    public void fpslzbxxcx() throws IOException, NoSuchAlgorithmException {
        String body = body("");
        RequestInterface.requestInteface(body, BasicParameters.num);
    }

    public String body(String jsbh){
        String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?><business id=\"FPSLZBXXCX\"><body><input><jsbh>"+jsbh+"</jsbh><nsrsbh>"+nsrsbh+"</nsrsbh></input></body></business>";
        return body;
    }

}
