package com.shuzutech.cases;

import com.shuzutech.config.InterfaceNum;
import com.shuzutech.model.RequestInterface;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class FPZF {

    /**
     *
     *110101201707010057~~499000152456
     *91320191MA1ML4CL25~~661826092245
     * zflx:0表示空白发票作废，1表示已开具发票作废，hjje是不含税的
     * 空白发票作废，hjje字段不传(共享2型打印机，此节点可不存在)
     * @throws IOException
     * @throws NoSuchAlgorithmException
     *
     */

    @Test
    public void fpzf() throws IOException, NoSuchAlgorithmException {
        String body = body("49878373","91320191MA1ML4CL25~~661826092245",
                            "007","1","-618.58",
                                "032001900104","管理员");
        int code = RequestInterface.requestInteface(body, InterfaceNum.PRO);
        Assert.assertEquals(code,0);
    }

    /**
     * 空白发票作废，专票空白发票作废可以
     *
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */

    @Test
    public void fpzf1() throws IOException, NoSuchAlgorithmException {
        String body = body1("49878372","91320191MA1ML4CL25~~661826092245",
                "007","0","032001900104",
                "管理员");
        int code = RequestInterface.requestInteface(body, InterfaceNum.PRO);
        Assert.assertEquals(code,0);
    }


    public String body(String fphm,String jsbh,String fplxdm,String zflx,String hjje,String fpdm,String zfr){
        String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?><business id=\"FPZF\"><body><input><fphm>"+fphm
                +"</fphm><jsbh>"+jsbh+"</jsbh><fplxdm>"+fplxdm+"</fplxdm><zflx>"+zflx+"</zflx><hjje>"+hjje+"</hjje><fpdm>"
                +fpdm+"</fpdm><zfr>"+zfr+"</zfr></input></body></business>";
        return body;
    }

    public String body1(String fphm,String jsbh,String fplxdm,String zflx,String fpdm,String zfr){
        String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?><business id=\"FPZF\"><body><input><fphm>"+fphm
                +"</fphm><jsbh>"+jsbh+"</jsbh><fplxdm>"+fplxdm+"</fplxdm><zflx>"+zflx+"</zflx><fpdm>"
                +fpdm+"</fpdm><zfr>"+zfr+"</zfr></input></body></business>";
        return body;
    }



}
