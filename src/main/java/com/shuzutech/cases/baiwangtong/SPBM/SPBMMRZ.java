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

public class SPBMMRZ {
    /**
     *
     *返回bm:参数错误
     *
     */
    HashMap<String,String> map = new HashMap<>();

    @Test(groups = {"商品默认值"},description = "只传开票终端标识，设置一条默认商品")
    public void spbmmrz() throws IOException, NoSuchAlgorithmException {
        map.put("bm","30402030000000000000001");
        String body = RequestBody.getRequestBody("SPBMMRZ", CommodityCodeManagement.spbmscAndSpbmmrzInput(map));
        int code = RequestInterface.requestInteface(body, BasicParameters.bwt_num);
        Assert.assertEquals(code,0);
    }

    @Test(groups = {"商品默认值"},description = "只传纳税人识别号，设置一条默认商品")
    public void spbmmrz1() throws IOException, NoSuchAlgorithmException {
        map.put("bm","30402030000000000000001");
        map.put("kpzdbs","");
        map.put("nsrsbh",BasicParameters.bwt_nsrsbh);
        String body = RequestBody.getRequestBody("SPBMMRZ", CommodityCodeManagement.spbmscAndSpbmmrzInput(map));
        int code = RequestInterface.requestInteface(body, BasicParameters.bwt_num);
        Assert.assertEquals(code,0);
    }
}
