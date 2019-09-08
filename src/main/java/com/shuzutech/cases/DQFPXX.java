package com.shuzutech.cases;

import com.shuzutech.config.InterfaceNum;
import com.shuzutech.model.RequestInterface;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class DQFPXX {


    @Test(groups = {"当前未开票号码查询"})
    public void dqfpxx() throws IOException, NoSuchAlgorithmException {
        String body = body("91320191MA1ML4CL25~~661826092245","026");
        int code = RequestInterface.requestInteface(body, InterfaceNum.PRO);
        Assert.assertEquals(code,0);
    }

    public String body(String jsbh,String fplxdm){
        String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?><business id=\"DQFPXX\"><body><input><jsbh>"+jsbh+"</jsbh><fplxdm>"+
                fplxdm+"</fplxdm></input></body></business>";
        return body;
    }
}
