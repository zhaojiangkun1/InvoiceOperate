package com.shuzutech.cases;

import com.shuzutech.config.InterfaceNum;
import com.shuzutech.model.RequestInterface;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class CXSBZT {

    @Test(groups = {"查询设备状态"})
    public void cxsbzt() throws IOException, NoSuchAlgorithmException {
        String body = body("91320191MA1ML4CL25~~661826092245");
        int code = RequestInterface.requestInteface(body, InterfaceNum.PRO);
        Assert.assertEquals(code,0);
    }

    public String body(String jsbh){
        String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?><business id=\"CXSBZT\"><body><input><jsbh>"+jsbh+"</jsbh></input></body></business>";
        return body;
    }
}
