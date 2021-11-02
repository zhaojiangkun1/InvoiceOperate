package com.shuzutech.cases.baiwangtong.Device;

import com.shuzutech.bean.BasicParameters;
import com.shuzutech.config.InterfaceNum;
import com.shuzutech.model.RequestBody;
import com.shuzutech.model.RequestInterface;
import com.shuzutech.model.ZpyInputManagement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class CXSBZT {
    private static String kpzdbs = BasicParameters.bwt_kpzdbs;
    private static String nsrsbh = BasicParameters.bwt_nsrsbh;
    private static InterfaceNum num = BasicParameters.bwt_num;

    HashMap<String, String> map = new HashMap<>();

    /**
     * 新接口文档，无此接口说明，但是可以调用
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */

    @Test(groups = {"查询设备状态"}, description = "根据开票终端标识去查询设备状态")
    public void byKpzdbsCxsbzt() throws IOException, NoSuchAlgorithmException {
        map.put("kpzdbs", kpzdbs);
        map.put("nsrsbh", "");
        String body = RequestBody.getRequestBody("CXSBZT", ZpyInputManagement.cxsbzt(map));
        int code = RequestInterface.requestInteface(body, num);
        Assert.assertEquals(code, 0);
    }

    @Test(groups = {"查询设备状态"}, description = "根据纳税人识别号查询设备状态")
    public void byNsrsbhCxsbzt() throws IOException, NoSuchAlgorithmException {
        map.put("nsrsbh", nsrsbh);
        map.put("kpzdbs", "");
        String body = RequestBody.getRequestBody("CXSBZT", ZpyInputManagement.cxsbzt(map));
        int code = RequestInterface.requestInteface(body, num);
        Assert.assertEquals(code, 0);
    }

}


