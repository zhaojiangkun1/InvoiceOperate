package com.shuzutech.cases;

import com.shuzutech.config.InterfaceNum;
import com.shuzutech.model.RequestInterface;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class FPZF {

    /**
     * zflx:0表示空白发票作废，1表示已开具发票作废，hjje是不含税的
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */

    @Test
    public void fpzf() throws IOException, NoSuchAlgorithmException {
        String body = body("49878371","91320191MA1ML4CL25~~661826092245",
                            "007","1","-618.58",
                                "032001900104","管理员");
        int code = RequestInterface.requestInteface(body, InterfaceNum.PRO);
        Assert.assertEquals(code,0);
    }


    public String body(String fphm,String jsbh,String fplxdm,String zflx,String hjje,String fpdm,String zfr){
        String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?><business id=\"FPZF\"><body><input><fphm>"+fphm
                +"</fphm><jsbh>"+jsbh+"</jsbh><fplxdm>"+fplxdm+"</fplxdm><zflx>"+zflx+"</zflx><hjje>"+hjje+"</hjje><fpdm>"
                +fpdm+"</fpdm><zfr>"+zfr+"</zfr></input></body></business>";
        return body;
    }
}
