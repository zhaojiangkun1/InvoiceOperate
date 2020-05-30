package com.shuzutech.cases;

import com.shuzutech.config.InterfaceNum;
import com.shuzutech.model.RequestInterface;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class FPDYCX {
    /**
     * 110101201707010043
     * 91320594346148467C
     * 发票打印查询接口
     * cxtj是调发票打印接口返回的打印编号
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */

    @Test
    public void fpdycx() throws IOException, NoSuchAlgorithmException {
        String body = body("91320594346148467C","","iq9jvx6zsdb1jwhmrvhtpswr3vgdxf9w");
        RequestInterface.requestInteface(body, InterfaceNum.TEST);
    }

    public String body(String shnsrsbh,String jsbh,String cxtj){
        String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?><business id=\"FPDYCX\"><body><input><shnsrsbh>"+
                shnsrsbh+"</shnsrsbh><jsbh>"+jsbh+"</jsbh><cxtj>"+cxtj+"</cxtj></input></body></business>";
        return body;
    }
}
