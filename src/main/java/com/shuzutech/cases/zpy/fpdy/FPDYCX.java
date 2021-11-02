package com.shuzutech.cases.zpy.fpdy;

import com.shuzutech.bean.BasicParameters;
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
     *
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */

    @Test
    public void fpdycx() throws IOException, NoSuchAlgorithmException {
        String body = body(BasicParameters.nsrsbh, "", "2020072214140459643744");
        RequestInterface.requestInteface(body, InterfaceNum.DEV);
    }

    public String body(String shnsrsbh, String jsbh, String cxtj) {
        String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?><business id=\"FPDYCX\"><body><input><shnsrsbh>" +
                shnsrsbh + "</shnsrsbh><jsbh>" + jsbh + "</jsbh><cxtj>" + cxtj + "</cxtj></input></body></business>";
        return body;
    }
}
