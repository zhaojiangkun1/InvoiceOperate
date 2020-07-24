package com.shuzutech.cases.baiwangtong.Device;

import com.shuzutech.bean.BasicParameters;
import com.shuzutech.model.RequestBody;
import com.shuzutech.model.RequestInterface;
import com.shuzutech.model.ZpyInputManagement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class QYXXSZ {
    private static String deviceNo = BasicParameters.bwt_kpzdbs;
    private static String xhdwdzdh = "南京市江北新区新科二路2号南大软件学院222D室 02558801191";
    private static String xhdwyhzh = "中国农业银行股份有限公司南京茶亭东街支行 10107501040008319";

    /**
     * 企业信息设置，先以这个为准
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    @Test
    public void qyxxsz() throws IOException, NoSuchAlgorithmException {
        HashMap<String,String> map = new HashMap<>();
        map.put("xhdwdzdh",xhdwdzdh);
        map.put("xhdwyhzh",xhdwyhzh);
        String body = RequestBody.getRequestBody("QYXXSZ", ZpyInputManagement.qyxxsz(map));
        int code = RequestInterface.requestInteface(body, BasicParameters.bwt_num);
        Assert.assertEquals(code,0);
    }
}
