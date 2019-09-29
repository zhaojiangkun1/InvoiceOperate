package com.shuzutech.cases;

import com.shuzutech.config.InterfaceNum;
import com.shuzutech.model.RequestInterface;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class FPDYDATA {

    /**
     *
     * 清单打印和普通打印地址不一样
     * 这是宁波的打印接口，税控服务器调此打印接口
     * fpqqlsh，在fpdm和fphm为空时必传
     *
     * 清单打印 带上qdprint
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    @Test
    public void printqddata() throws IOException, NoSuchAlgorithmException {
        String body = body("","032001900104","49878372","0");
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
        String body = body("70720190918153425","","","1");
        int code = RequestInterface.requestInteface(body, InterfaceNum.PRINTQDDEV);
        Assert.assertEquals(code,0);
    }


    public String body(String fpqqlsh,String fpdm,String fphm,String qdbz){
        String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?><business id=\"FPDYDATA\"><body><input><fpqqlsh>"+fpqqlsh+"</fpqqlsh><fpdm>"+fpdm+"</fpdm><fphm>"+fphm+"</fphm><qdbz>"+qdbz+"</qdbz><left>2</left><top>4</top></input></body></business>";
        return body;
    }
}
