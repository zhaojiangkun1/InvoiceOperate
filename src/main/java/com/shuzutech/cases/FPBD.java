package com.shuzutech.cases;

import com.shuzutech.config.InterfaceNum;
import com.shuzutech.model.RequestInterface;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class FPBD {

    @Test
    public void fpbd() throws IOException, NoSuchAlgorithmException {
        String body = body("110101201707010043~~A20016420000265","025","150007890501","40022137");
        int code = RequestInterface.requestInteface(body, InterfaceNum.PRO);
        Assert.assertEquals(code,0);
    }

    public String body(String jsbh,String fplxdm,String fpdm,String fphm){
        String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?><business id=\"FPBD\"><body><input><jsbh>"+jsbh+
                "</jsbh><fplxdm>"+fplxdm+"</fplxdm><fpdm>"+fpdm+"</fpdm><fphm>"+fphm+"</fphm></input></body></business>";
        return body;
    }
}
