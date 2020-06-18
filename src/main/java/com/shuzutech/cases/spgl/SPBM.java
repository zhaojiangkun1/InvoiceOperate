package com.shuzutech.cases.spgl;

import com.shuzutech.bean.BasicParameters;
import com.shuzutech.model.RequestInterface;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class SPBM {

    /**
     * 91320594MA1MECA285
     * 110101201707010064
     * 1:按照税号维护 非必填
     * 其他:(税控服务器:按照税号维护,智能设备:税号和机身编号),
     * 默认按其他处理
     * 税号和机身编号二选一，目前机身编号不能为空，否则报错
     */

    @Test(groups = {"获取商品列表"})
    public void getSpList() throws IOException, NoSuchAlgorithmException {
        String body = body("110101201707010041","","");
        int code = RequestInterface.requestInteface(body, BasicParameters.num);
        Assert.assertEquals(code,0);
    }


    public String body(String nsrsbh,String jsbh,String whbz){
        String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?><business id=\"SPBM\"><body><input><nsrsbh>"+nsrsbh+"</nsrsbh><jsbh>"+jsbh+"</jsbh><whbz>"+whbz+"</whbz></input></body></business>";
        return body;
    }

}
