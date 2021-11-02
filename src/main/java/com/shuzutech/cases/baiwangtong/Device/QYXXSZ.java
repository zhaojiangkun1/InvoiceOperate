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
    private static String xhdwdzdh = "南京市江北新区新科二路2号南大软件学院223D室02558801192";
    private static String xhdwyhzh = "中国农业银行股份有限公司南京茶亭东街支行101075010400083192";

    /**
     * dz
     * dh
     * <p>
     * 企业信息设置，先以这个为准
     * 销方信息需要保存在数族侧
     * 先调getTerminal查一遍，后又再调terminalManage设置
     *
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    @Test
    public void qyxxsz() throws IOException, NoSuchAlgorithmException {
        HashMap<String, String> map = new HashMap<>();
        map.put("xhdwdzdh", xhdwdzdh);
        map.put("xhdwyhzh", xhdwyhzh);
        map.put("kpzdbs", BasicParameters.bwt_kpzdbs);
        map.put("jqbh", BasicParameters.bwt_kpzdbs);
        String body = RequestBody.getRequestBody("QYXXSZ", ZpyInputManagement.qyxxsz(map));
        int code = RequestInterface.requestInteface(body, BasicParameters.bwt_num);
        Assert.assertEquals(code, 0);
    }
}
