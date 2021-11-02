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

public class SPBMSC {
    HashMap<String, String> map = new HashMap<>();
    private static String bm = "10403010000000000000001";//商品编码
    private static String kpzdbs = BasicParameters.bwt_kpzdbs;//开票终端标识
    private static String nsrsbh = "";//纳税人识别号，和开票终端标识二选一

    @Test(groups = {"商品编码删除"}, description = "根据终端标识删除一条商品记录")
    public void spbmsc() throws IOException, NoSuchAlgorithmException {
        map.put("bm", "10403010000000000000001");
        String body = RequestBody.getRequestBody("SPBMSC", CommodityCodeManagement.spbmscAndSpbmmrzInput(map));
        int code = RequestInterface.requestInteface(body, BasicParameters.bwt_num);
        Assert.assertEquals(code, 0);
    }

    @Test(groups = {"商品编码删除"}, description = "根据纳税人识别号删除一条商品记录")
    public void spbmsc1() throws IOException, NoSuchAlgorithmException {
        map.put("bm", "10403010000000000000001");
        map.put("nsrsbh", nsrsbh);
        map.put("kpzdbs", "");
        String body = RequestBody.getRequestBody("SPBMSC", CommodityCodeManagement.spbmscAndSpbmmrzInput(map));
        int code = RequestInterface.requestInteface(body, BasicParameters.bwt_num);
        Assert.assertEquals(code, 0);
    }

    @Test(groups = {"商品编码删除"}, description = "纳税人识别号和开票终端标识为空")
    public void spbmsc2() throws IOException, NoSuchAlgorithmException {
        map.put("bm", "10403010000000000000001");
        map.put("nsrsbh", "");
        map.put("kpzdbs", "");
        String body = RequestBody.getRequestBody("SPBMSC", CommodityCodeManagement.spbmscAndSpbmmrzInput(map));
        int code = RequestInterface.requestInteface(body, BasicParameters.bwt_num);
        Assert.assertEquals(code, 0);
    }

    @Test(groups = {"商品编码删除"}, description = "商品编码删除，bm为空")
    public void spbmsc3() throws IOException, NoSuchAlgorithmException {
        map.put("bm", "");
        String body = RequestBody.getRequestBody("SPBMSC", CommodityCodeManagement.spbmscAndSpbmmrzInput(map));
        int code = RequestInterface.requestInteface(body, BasicParameters.bwt_num);
        Assert.assertEquals(code, 0);
    }
}
