package com.shuzutech.cases;

import com.shuzutech.bean.BasicParameters;
import com.shuzutech.model.RequestInterface;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class JBRCX {
    private static String nsrsbh = "110101201707010057";

    @Test
    public void jbrcx() throws IOException, NoSuchAlgorithmException {
        String body = body("026","","1");
        RequestInterface.requestInteface(body, BasicParameters.num);
    }

    public String body(String fplxdm,String jsbh,String flag){
        String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?><business id=\"JBRCX\"><body><input><fplxdm>"+fplxdm+"</fplxdm><jsbh>"+jsbh+"</jsbh><nsrsbh>"+nsrsbh+"</nsrsbh><flag>"+flag+"</flag></input></body></business>";
        return body;
    }

}
