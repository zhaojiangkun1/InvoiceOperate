package com.shuzutech.cases.baiwangtong.Device;

import cn.hutool.http.HttpUtil;
import com.shuzutech.bean.BasicParameters;
import com.shuzutech.config.Md5;
import com.shuzutech.model.RequestBody;
import com.shuzutech.model.RequestInterface;
import com.shuzutech.model.ZpyInputManagement;
import com.sun.deploy.net.HttpUtils;
import org.apache.http.HttpRequest;
import org.apache.http.client.HttpClient;
import org.apache.http.client.utils.HttpClientUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class TaxControlEquipment {
    private static String shnsrsbh = BasicParameters.bwt_nsrsbh;

    /**
     * 税控设备查询，封装旺企云的getTemianlDevice接口
     * 实现逻辑：看着像是先调了getTemianlDevice接口，然后又调了一遍sysTerminal接口（该接口只用于同步新增）？？？
     * 同步终端接口需要确认一下
     *
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    @Test
    public void taxControlEquipment() throws IOException, NoSuchAlgorithmException {
        String body = RequestBody.getRequestBody("TaxControlEquipment", ZpyInputManagement.taxControlEquipment(shnsrsbh), "2.0");
        int code = RequestInterface.requestInteface(body, BasicParameters.bwt_num);
        Assert.assertEquals(code, 0);
    }

    @Test
    public void testContentMd5() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        String content = "{\"nsrsbh\":\"91440400MA7KG05J24\",\"dlzh\":\"lichaochao6\",\"serviceId\":\"kj\",\"content\":{\"dlzh\":\"lichaochao6\",\"bz\":\"\",\"fjxxList\":[],\"fplxdm\":\"81\",\"fpqqlsh\":\"SZMC16787861504405088\",\"gfdz\":\"\",\"gfkhh\":\"撒旦\",\"gflxdh\":\"\",\"gfmc\":\"浙江打的好餐饮管理有限公司\",\"gfsh\":\"91330681087353019A\",\"gfyhzh\":\"大时代\",\"jbrxm\":\"\",\"jbrzjhm\":\"\",\"jrznsrsbh\":\"\",\"kjly\":\"\",\"mxList\":[{\"dj\":109,\"dw\":\"单位\",\"fphxz\":\"0\",\"ggxh\":\"规格\",\"je\":\"66.00\",\"lslbs\":\"\",\"se\":\"5.45\",\"sl\":\"0.09\",\"spbm\":\"3050300000000000000\",\"spmc\":\"修缮服务\",\"spsl\":0.60550458715596,\"yhzcbs\":\"0\",\"zxbm\":\"0001\",\"zzstsgl\":\"\",\"nsrsbh\":\"91440400MA7KG05J24\",\"spbmjc\":\"建筑服务\",\"hsdj\":109,\"kysl\":\"0.00、0.03、0.05、0.06、0.09\",\"hsbz\":\"0\",\"qbm\":\"30503000000000000000001\",\"mrz\":\"1\",\"sm\":null,\"kyslArray\":[\"0.00\",\"0.03\",\"0.05\",\"0.06\",\"0.09\"],\"uid\":\"129c7fd8-c876-4001-85e2-6204e05fc2d7\",\"slStr\":\"9%\"}],\"nsrsbh\":\"91440400MA7KG05J24\",\"spExt\":{\"hddz\":\"\",\"sjhm\":\"18169449744\",\"yxdz\":\"3232@qq.com\"},\"hsbz\":\"1\",\"xfdz\":\"珠海市横琴三塘村121号第四层\",\"xfkhh\":\"招商银行股份有限公司珠海人民路支行\",\"xflxdh\":\"18813128259\",\"xfmc\":\"九州数科（广东）信息技术有限公司\",\"xfyhzh\":\"656901063510306\",\"gfzrrbs\":\"N\",\"tdyslxdm\":\"\"}}202303141729103042daabedcac49f730e52e71003504b";
        System.out.println(Md5.EncoderByMd5(content));
    }
}
