package com.shuzutech.cases.spgl;

import com.shuzutech.config.InterfaceNum;
import com.shuzutech.model.RequestInterface;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class SPBMSC {
    /**
     * 客户调用此接口删除自行编码
     * 机身编号和税号二选一
     *
     * 1）bm为空
     * 2）jsbh和税号为空
     * 3）jsbh为空
     * 4）税号为空
     * 5）税号或者jsbh错误
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */

    @Test
    public void spbmsc() throws IOException, NoSuchAlgorithmException {
        String body = body("107020201010000000001","","110101201707010057");
        int code = RequestInterface.requestInteface(body, InterfaceNum.DEV);
        Assert.assertEquals(code,0);
    }

    public String body(String bm,String jsbh,String nsrsbh){
        String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?><business id=\"SPBMSC\"><body><input><bm>"+bm+"</bm><jsbh>"+jsbh+"</jsbh><nsrsbh>"+nsrsbh+"</nsrsbh></input></body></business>";
        return body;
    }
}
