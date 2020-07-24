package com.shuzutech.cases.baiwangtong.SPBM;

import com.shuzutech.bean.BasicParameters;
import com.shuzutech.model.CommodityCodeManagement;
import com.shuzutech.model.RequestBody;
import com.shuzutech.model.RequestInterface;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class SSBMQQ {

    @Test
    public void ssbmqq() throws IOException, NoSuchAlgorithmException {
        String body = RequestBody.getRequestBody("SSBMQQ", CommodityCodeManagement.ssbmqqInput(""));
        System.out.println(RequestInterface.requestInteface(body, BasicParameters.bwt_num));
    }
}
