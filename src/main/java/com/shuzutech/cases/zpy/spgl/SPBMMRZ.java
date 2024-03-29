package com.shuzutech.cases.zpy.spgl;

import com.shuzutech.bean.BasicParameters;
import com.shuzutech.config.InterfaceNum;
import com.shuzutech.model.RequestInterface;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class SPBMMRZ {

    /**
     * 商户默认商品设置
     * 机身编号和纳税人识别号二选一，bm必填（这个是自行编码）
     *
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    @Test
    public void spbmmrz() throws IOException, NoSuchAlgorithmException {
        String body = body("304050202020000000001", "", BasicParameters.nsrsbh);
        int code = RequestInterface.requestInteface(body, BasicParameters.num);
        Assert.assertEquals(code, 0);
    }


    public String body(String bm, String jsbh, String nsrsbh) {
        String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?><business id=\"SPBMMRZ\"><body><input><bm>" + bm + "</bm><jsbh>" + jsbh + "</jsbh><nsrsbh>" + nsrsbh + "</nsrsbh></input></body></business>";
        return body;
    }
}
