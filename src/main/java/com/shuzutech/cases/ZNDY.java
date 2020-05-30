package com.shuzutech.cases;

import com.shuzutech.config.InterfaceNum;
import com.shuzutech.model.RequestInterface;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class ZNDY {

    /**
     * 20192447
     * 110101201707010057
     * 110101201707010041
     * 110101201707010064
     * 91320191MA1ML4CL25
     * 91320594346148467C
     * 91320594MA1MECA285
     * 根据发票请求流水号打印
     * 智能打印，对于在PC助手上开具发票，电脑连接平推打印机。
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    private static String nsrsbh = "110101201707010064";
    private static String dylx = "1";//0：发票打印，1：清单打印
    private static String dyfs = "1";

    @Test
    public void zndy() throws IOException, NoSuchAlgorithmException {
        String body = body("","007","","050000000102","99129884");
        RequestInterface.requestInteface(body, InterfaceNum.DEV);
    }


    public String body(String jsbh,String fplxdm,String fpqqlsh,String fpdm,String fphm){
        String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?><business id=\"ZNDY\"><body><input><jsbh>"
                +jsbh+"</jsbh><nsrsbh>"+nsrsbh+"</nsrsbh><fplxdm>"+fplxdm+"</fplxdm><fpqqlsh>"+fpqqlsh+"</fpqqlsh><fpdm>"+fpdm+"</fpdm><fphm>"
                +fphm+"</fphm><dylx>"+dylx+"</dylx><dyfs>"+dyfs+"</dyfs><printername></printername></input></body></business>";
        return body;
    }
}
