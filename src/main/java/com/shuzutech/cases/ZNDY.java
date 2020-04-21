package com.shuzutech.cases;

import com.shuzutech.config.InterfaceNum;
import com.shuzutech.model.RequestInterface;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class ZNDY {

    /**
     * 根据发票请求流水号打印
     * 智能打印，对于在PC助手上开具发票，电脑连接平推打印机。
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    private static String nsrsbh = "110101201707010064";

    @Test
    public void zndy() throws IOException, NoSuchAlgorithmException {
        String body = body("","007","","050000000102","99129846");
        RequestInterface.requestInteface(body, InterfaceNum.DEV);
    }


    public String body(String jsbh,String fplxdm,String fpqqlsh,String fpdm,String fphm){
        String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?><business id=\"ZNDY\"><body><input><jsbh>"
                +jsbh+"</jsbh><nsrsbh>"+nsrsbh+"</nsrsbh><fplxdm>"+fplxdm+"</fplxdm><fpqqlsh>"+fpqqlsh+"</fpqqlsh><fpdm>"+fpdm+"</fpdm><fphm>"
                +fphm+"</fphm><dylx>1</dylx><dyfs>1</dyfs><printername></printername></input></body></business>";
        return body;
    }
}
