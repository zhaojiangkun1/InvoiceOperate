package com.shuzutech.cases;

import com.shuzutech.config.InterfaceNum;
import com.shuzutech.model.RequestInterface;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class CXSBZT {
    /**
     * 该接口封装了宁波的CXSBXX接口
     * 根据平台连接方式去判断，如果是宁波间连就是走之前接口，如果是宁波直连则走CXSBXX接口
     * @throws IOException
     * @throws NoSuchAlgorithmException
     * 91320191MA1ML4CL25~~661826092245
     * 91320191MA1ML4CL25~~91320191MA1ML4CL25
     */

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
