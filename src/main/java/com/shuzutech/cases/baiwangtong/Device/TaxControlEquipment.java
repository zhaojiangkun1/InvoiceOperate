package com.shuzutech.cases.baiwangtong.Device;

import com.shuzutech.bean.BasicParameters;
import com.shuzutech.model.RequestBody;
import com.shuzutech.model.RequestInterface;
import com.shuzutech.model.ZpyInputManagement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class TaxControlEquipment {
    private static String shnsrsbh = BasicParameters.bwt_nsrsbh;

    /**
     * 税控设备查询
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    @Test
    public void taxControlEquipment() throws IOException, NoSuchAlgorithmException {
        String body = RequestBody.getRequestBody("TaxControlEquipment", ZpyInputManagement.taxControlEquipment(shnsrsbh));
        int code = RequestInterface.requestInteface(body, BasicParameters.bwt_num);
        Assert.assertEquals(code,0);
    }
}
