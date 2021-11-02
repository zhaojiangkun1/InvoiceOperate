package com.shuzutech.cases.baiwangtong.Device;

import com.shuzutech.bean.BasicParameters;
import com.shuzutech.model.RequestBody;
import com.shuzutech.model.RequestInterface;
import com.shuzutech.model.ZpyInputManagement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class QYXXCX {
    private static String jqbh = "661921253676";
    private static String nsrsbh = BasicParameters.bwt_nsrsbh;

    /**
     * QYXXCX 调的还是getTerminal接口
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */

    @Test
    public void qyxxcx() throws IOException, NoSuchAlgorithmException {
        String body = RequestBody.getRequestBody("QYXXCX", ZpyInputManagement.qyxxcx(jqbh,nsrsbh));
        int code = RequestInterface.requestInteface(body, BasicParameters.bwt_num);
        Assert.assertEquals(code, 0);
    }
}
