package com.shuzutech.cases;

import com.shuzutech.config.InterfaceNum;
import com.shuzutech.model.RequestInterface;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class AICODE {
    /**
     * 用于智能获取税收编码
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */

    @Test
    public void aicode() throws IOException, NoSuchAlgorithmException {
        String body = body("毛毯");
        RequestInterface.requestInteface(body, InterfaceNum.PRO);
    }

    public String body(String name){
        String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?><business id=\"AICODE\"><body><input><name>"+name+"</name></input></body></business>";
        return body;
    }
}
