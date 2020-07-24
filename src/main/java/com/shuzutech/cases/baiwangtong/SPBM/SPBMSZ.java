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

public class SPBMSZ {
    HashMap<String,String> map = new HashMap<>();
    /**
     * 商品编码设置
     *
     * @throws IOException
     * @throws NoSuchAlgorithmException
     * 商品的添加
     * 1）商品正常税率的添加
     * 2）带有优惠政策类型的商品添加
     * 3）含税与不含税商品
     */
    @Test(groups = {"百旺通商品编码设置"},description = "百旺通平台，纳税人识别号为空，根据开票终端标识添加一条默认商品")
    public void spbmsz() throws IOException, NoSuchAlgorithmException {
        int code = RequestInterface.requestInteface(body(),BasicParameters.bwt_num);
        Assert.assertEquals(code,0);
    }

    @Test
    public void spbmsz1() throws IOException, NoSuchAlgorithmException {
        map.put("bm","10403010000000000000002");
        map.put("pid","1040301000000000000");
        map.put("spbmjc","皮革毛皮制品");
        map.put("mc","真皮皮带");
        map.put("dj","560");
        map.put("kysl","0.13、0.05、0.03、0.01、0");
        map.put("sl","0.13");
        map.put("sm","指经脱毛和鞣制等物理");
        map.put("hsbz","Y");
        map.put("zzssl","0.13");
        int code = RequestInterface.requestInteface(body(map),BasicParameters.bwt_num);
        Assert.assertEquals(code,0);
    }

    /**
     * mslx
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    @Test
    public void spbmsz2() throws IOException, NoSuchAlgorithmException {
        map.put("bm","");
        map.put("pid","3040203000000000000");
        map.put("spbmjc","信息技术服务");
        map.put("mc","信息服务费");
        map.put("dj","");
        map.put("kyzt","N");
        map.put("kysl","0.13、0.06、0.03、0.01、0");
        map.put("sl","0.03");
        map.put("sm","");
        map.put("hsbz","N");
        map.put("zzssl","0.13");
        int code = RequestInterface.requestInteface(body(map),BasicParameters.bwt_num);
        Assert.assertEquals(code,0);
    }

    public static String body(HashMap<String,String>... map) throws IOException {
        return RequestBody.getRequestBody("SPBMSZ",CommodityCodeManagement.spbmszInput(map));
    }
}
