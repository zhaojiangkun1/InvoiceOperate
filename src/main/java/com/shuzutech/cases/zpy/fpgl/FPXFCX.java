package com.shuzutech.cases.zpy.fpgl;

import com.shuzutech.bean.BasicParameters;
import com.shuzutech.model.RequestInterface;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class FPXFCX {
    private static String jsbh = BasicParameters.jsbh;
    private static String taskId = "2022031062299a89607a0";

    @Test
    public void fpxfcx() throws IOException, NoSuchAlgorithmException {
        String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?><business id=\"FPXFCX\"><body><input><jsbh>"+jsbh+"</jsbh><taskId>"+taskId+"</taskId></input></body></business>";
        RequestInterface.requestInteface(body, BasicParameters.num);
    }
}
