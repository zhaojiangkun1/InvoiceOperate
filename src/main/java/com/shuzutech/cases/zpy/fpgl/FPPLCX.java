package com.shuzutech.cases.zpy.fpgl;

import com.shuzutech.bean.BasicParameters;
import com.shuzutech.model.RequestBody;
import com.shuzutech.model.RequestInterface;
import com.shuzutech.model.ZpyInputManagement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class FPPLCX {

    /**
     *
     * 发票列表查询,一次最多查询100条；即pagesize最大值100
     * 文档中：一次最多查三个月；实际上开始时间和结束时间没有做限制
     * 返回报文之后没有storeid；按storeid查询无用。
     */

    @Test
    public void fpplcx(){
        HashMap<String,String> map = new HashMap<>();
        map.put("nsrsbh", BasicParameters.nsrsbh);
        map.put("storeid", "1002448");
        map.put("start_date","2021-08-16");
        map.put("end_date","2021-08-16");
        map.put("page","1");
        map.put("pagesize","100");
        String body = null;
        try {
            body = RequestBody.getRequestBody("FPPLCX", ZpyInputManagement.fpplcx(map));
        } catch (IOException e) {
            e.printStackTrace();
        }
        int code = 0;
        try {
            code = RequestInterface.requestInteface(body, BasicParameters.num);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(code, 0);
    }

}
