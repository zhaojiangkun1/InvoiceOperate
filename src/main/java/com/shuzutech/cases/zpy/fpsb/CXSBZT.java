package com.shuzutech.cases.zpy.fpsb;

import com.shuzutech.bean.BasicParameters;
import com.shuzutech.model.RequestBody;
import com.shuzutech.model.RequestInterface;
import com.shuzutech.model.ZpyInputManagement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class CXSBZT {
    /**
     * 该接口封装了宁波的CXSBXX接口
     * 根据平台连接方式去判断，如果是宁波间连就是走之前接口，如果是宁波直连则走CXSBXX接口
     *
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    HashMap<String, String> map = new HashMap<>();

    @Test(groups = {"查询设备状态"}, description = "纳税人识别号为空，根据机身编号查设备状态")
    public void byJsbhCxsbzt() throws IOException, NoSuchAlgorithmException {
        map.put("jsbh", BasicParameters.jsbh);
        map.put("nsrsbh", "");
        String body = RequestBody.getRequestBody("CXSBZT", ZpyInputManagement.cxsbzt(map));
        int code = RequestInterface.requestInteface(body, BasicParameters.num);
        Assert.assertEquals(code, 0);
    }

    @Test(groups = {"查询设备状态"}, description = "机身编号为空，根据纳税人识别号查询设备状态")
    public void byNsrsbhCxsbzt() throws IOException, NoSuchAlgorithmException {
        map.put("jsbh", "");
        map.put("nsrsbh", BasicParameters.nsrsbh);
        String body = RequestBody.getRequestBody("CXSBZT", ZpyInputManagement.cxsbzt(map));
        int code = RequestInterface.requestInteface(body, BasicParameters.num);
        Assert.assertEquals(code, 0);
    }

}
