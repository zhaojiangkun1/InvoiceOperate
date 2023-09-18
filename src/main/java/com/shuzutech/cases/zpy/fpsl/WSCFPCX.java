package com.shuzutech.cases.zpy.fpsl;

import com.shuzutech.bean.BasicParameters;
import com.shuzutech.model.RequestInterface;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class WSCFPCX {

    private String jsbh = "91320191MA1ML4CL25~~661921253676";
    private String fplxdm = "026";
    @Test(groups = {"未上传发票查询"})
    public void wscfpcx() throws IOException, NoSuchAlgorithmException {
        String body = body();
        int code = RequestInterface.requestInteface(body, BasicParameters.num);
        Assert.assertEquals(code, 0);
    }


    public String body() {
        String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?> <business id=\"WSCFPCX\"><body><input><jsbh>"+jsbh+"</jsbh><fplxdm>"+fplxdm+"</fplxdm></input></body></business> ";
        return body;
    }
}
