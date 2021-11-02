package com.shuzutech.cases.zpy.fpsb;

import com.shuzutech.bean.BasicParameters;
import com.shuzutech.model.RequestInterface;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class JKSJCX {

    /**
     * sblx : 2和1   2：税控服务器,1 智能设备
     * 此接口机身编号必传，纳税人识别号可选
     *
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    private static String sblx = "0";

    @Test(groups = {"监控数据查询"}, description = "查询电子票的监控数据")
    public void eTicketJksjcx() throws IOException, NoSuchAlgorithmException {
        int code = RequestInterface.requestInteface(body(sblx,  BasicParameters.jsbh, "026"), BasicParameters.num);
        Assert.assertEquals(code, 0);
    }

    @Test(groups = {"监控数据查询"}, description = "查询普票的监控数据")
    public void puPiaoJksjcx() throws IOException, NoSuchAlgorithmException {
        int code = RequestInterface.requestInteface(body(sblx, BasicParameters.jsbh, "007"), BasicParameters.num);
        Assert.assertEquals(code, 0);
    }

    @Test(groups = {"监控数据查询"}, description = "查询专票的监控数据")
    public void zhuanPiaoJksjcx() throws IOException, NoSuchAlgorithmException {
        int code = RequestInterface.requestInteface(body(sblx,  BasicParameters.jsbh, "004"), BasicParameters.num);
        Assert.assertEquals(code, 0);
    }

    public static String body(String sblx, String jsbh, String fplxdm) {
        String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?><business id=\"JKSJCX\"><body><input><sblx>" + sblx + "</sblx>"  + "<jsbh>" + jsbh + "</jsbh><fplxdm>" + fplxdm + "</fplxdm></input></body></business>";
        return body;
    }
}
