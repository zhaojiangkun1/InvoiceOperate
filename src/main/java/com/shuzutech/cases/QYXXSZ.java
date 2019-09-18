package com.shuzutech.cases;

import com.shuzutech.config.InterfaceNum;
import com.shuzutech.model.RequestInterface;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class QYXXSZ {
    @Test
    public void qyxxsz() throws IOException, NoSuchAlgorithmException {
        String body = body("","","","","");
        int code = RequestInterface.requestInteface(body, InterfaceNum.TEST);
        Assert.assertEquals(code,0);
    }

    public String body(String jsbh,String dz,String dh,String yh,String zh){
        String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?><business id=\"QYXXSZ\"><body><input><jsbh>"+
                jsbh+"</jsbh><dz>"+dz+"</dz><dh>"+dh+"</dh><yh>"+yh+"</yh><zh>"+zh+"</zh></input></body></business>";
        return body;
    }
}