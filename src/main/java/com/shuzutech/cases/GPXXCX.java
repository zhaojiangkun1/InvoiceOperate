package com.shuzutech.cases;

import com.shuzutech.config.InterfaceNum;
import com.shuzutech.model.RequestInterface;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class GPXXCX {

    /**
     * jsbh:非必填，税控服务器此字段为空
     * fplxdm:必填
     * sblx:设备类型，
     * fpzt:发票状态，税控服务器必传，云票打印机无此字段，0：未分发，1：已分发（默认）
     * nsrsbh:非必填，纳税人识别号，税控服务器必传
     * qtzd:其它字段，fpzt:0时核心板号，为1开票终端标识
     * lgqxx:领购全信息，云票打印机无此字段
     *
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */

    @Test
    public void gpxxcx() throws IOException, NoSuchAlgorithmException {
        String body = body("91320191MA1ML4CL25~~661826092245","026","2","1","91320191MA1ML4CL25","661826092245","");
        int code = RequestInterface.requestInteface(body, InterfaceNum.PRO);
        Assert.assertEquals(code,0);
    }

    public String body(String jsbh,String fplxdm,String sblx,String fpzt,String nsrsbh,String qtzd,String lgqxx){
        String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?><business id=\"GPXXCX\"><body><input><jsbh>"
                +jsbh+"</jsbh><fplxdm>"+fplxdm+"</fplxdm><sblx>"+sblx+"</sblx><fpzt>"+fpzt+"</fpzt><nsrsbh>"+nsrsbh
                +"</nsrsbh><qtzd>"+qtzd+"</qtzd><lgqxx>"+lgqxx+"</lgqxx></input></body></business>";
        return body;
    }
}
