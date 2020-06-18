package com.shuzutech.cases.fpdy;

import com.shuzutech.config.InterfaceNum;
import com.shuzutech.model.RequestInterface;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class FPDYDATA {

    /**
     * 本地打印插件接口
     * 清单打印和普通打印地址不一样
     * 这是宁波的打印接口，税控服务器调此打印接口
     * fpqqlsh，在fpdm和fphm为空时必传
     *032001900104   49878372   线上的发票
     * 20192485 ZB 20192486
     * 01896725 NB
     * 清单打印 带上qdprint
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    private static String top="20";//上边距
    private static String left = "0";//左边距

    @Test
    public void printqddata() throws IOException, NoSuchAlgorithmException {
        String body = body("","050000000102","20192486","0");
        int code = RequestInterface.requestInteface(body, InterfaceNum.PRINTPRO);
        Assert.assertEquals(code,0);
    }

    /**
     * 带清单打印
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */

    @Test
    public void qdprintdata() throws IOException, NoSuchAlgorithmException {
        String body = body("","050000000102","20192496","1");
        int code = RequestInterface.requestInteface(body, InterfaceNum.PRINTQDPRO);
        Assert.assertEquals(code,0);
    }


    public String body(String fpqqlsh,String fpdm,String fphm,String qdbz){
        String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?><business id=\"FPDYDATA\"><body><input>" +
                "<fpqqlsh>"+fpqqlsh+"</fpqqlsh>" +
                "<fpdm>"+fpdm+"</fpdm>" +
                "<fphm>"+fphm+"</fphm>" +
                "<qdbz>"+qdbz+"</qdbz>" +
                "<left>" + left + "</left>" +
                "<top>" +top+ "</top>" +
                "</input></body></business>";
        return body;
    }
}
