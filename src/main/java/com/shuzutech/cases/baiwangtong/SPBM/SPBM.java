package com.shuzutech.cases.baiwangtong.SPBM;

import com.shuzutech.bean.BasicParameters;
import com.shuzutech.model.CommodityCodeManagement;
import com.shuzutech.model.RequestBody;
import com.shuzutech.model.RequestInterface;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class SPBM {
    HashMap<String,String> map = new HashMap<>();

    @Test(groups = {"商品编码"},description = "根据kpzdbs查询添加的商品编码")
    public void spbm() throws IOException, NoSuchAlgorithmException {
        String body = RequestBody.getRequestBody("SPBM", CommodityCodeManagement.spbmInput());
        int code = RequestInterface.requestInteface(body, BasicParameters.bwt_num);
        Assert.assertEquals(code,0);
    }

    @Test(groups = {"商品编码"},description = "根据纳税人识别号查询添加的商品编码")
    public void spbm1() throws IOException, NoSuchAlgorithmException {
        map.put("nsrsbh",BasicParameters.bwt_nsrsbh);
        map.put("kpzdbs","");
        String body = RequestBody.getRequestBody("SPBM",CommodityCodeManagement.spbmInput(map));
        int code = RequestInterface.requestInteface(body, BasicParameters.bwt_num);
        Assert.assertEquals(code,0);
    }
    @Test(groups = {"商品编码"},description = "纳税人识别号和开票终端标识同时为空，查询添加的商品编码")
    public void spbm2() throws IOException, NoSuchAlgorithmException {
        map.put("nsrsbh","");
        map.put("kpzdbs","");
        String body = RequestBody.getRequestBody("SPBM",CommodityCodeManagement.spbmInput(map));
        int code = RequestInterface.requestInteface(body, BasicParameters.bwt_num);
        Assert.assertEquals(code,10001);
    }



}
