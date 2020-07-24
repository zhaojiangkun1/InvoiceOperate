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

public class DQFPXX {

    private String jsbh = BasicParameters.jsbh;
    private String nsrsbh = "";
    HashMap<String, String> map = new HashMap<>();

    /**
     * 91320594MA1MECA285
     * 智能设备：发票请求流水号：32位；税控服务器是20位
     * 110101201601010075~~A20017260026921
     * 110101201707010057~~499000152456
     * 91320191MA1ML4CL25~~661826092245  需要去盘里读取数据，盘不在，读取不了数据。
     * 91320191MA1ML4CL25~~661921253676
     *
     * @throws IOException
     * @throws NoSuchAlgorithmException 查询电子票
     */
    @Test(groups = {"当前发票信息"}, description = "查询当前电子发票的发票代码和发票号码")
    public void dqfpxx() throws IOException, NoSuchAlgorithmException {
        map.put("jsbh", jsbh);
        map.put("nsrsbh", "");
        map.put("fplxdm", "026");
        String body = RequestBody.getRequestBody("DQFPXX", ZpyInputManagement.dqfpxx(map));
        int code = RequestInterface.requestInteface(body, BasicParameters.num);
        Assert.assertEquals(code, 0);
    }

    /**
     * 查询卷票
     *
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    @Test(groups = {"当前发票信息"}, description = "查询当前卷票的发票代码和发票号码")
    public void dqfpxx2() throws IOException, NoSuchAlgorithmException {
        map.put("jsbh", jsbh);
        map.put("nsrsbh", "");
        map.put("fplxdm", "025");
        String body = RequestBody.getRequestBody("DQFPXX", ZpyInputManagement.dqfpxx(map));
        int code = RequestInterface.requestInteface(body, BasicParameters.num);
        Assert.assertEquals(code, 0);
    }

    /**
     * 查询普票
     *
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    @Test(groups = {"当前发票信息"}, description = "查询当前普票的发票代码和发票号码")
    public void dqfpxx3() throws IOException, NoSuchAlgorithmException {
        map.put("jsbh", jsbh);
        map.put("nsrsbh", "");
        map.put("fplxdm", "007");
        String body = RequestBody.getRequestBody("DQFPXX", ZpyInputManagement.dqfpxx(map));
        int code = RequestInterface.requestInteface(body, BasicParameters.num);
        Assert.assertEquals(code, 0);
    }

    /**
     * 查询专票
     *
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */

    @Test(groups = {"当前发票信息"}, description = "查询当前专票的发票代码和发票号码")
    public void dqfpxx4() throws IOException, NoSuchAlgorithmException {
        map.put("jsbh", jsbh);
        map.put("nsrsbh", "");
        map.put("fplxdm", "004");
        String body = RequestBody.getRequestBody("DQFPXX", ZpyInputManagement.dqfpxx(map));
        int code = RequestInterface.requestInteface(body, BasicParameters.num);
        Assert.assertEquals(code, 0);
    }

    @Test(groups = {"当前发票信息"}, description = "机身编号为空，根据纳税人识别号查询当前的发票代码和发票号码")
    public void byNsrsbhDqfpxx() throws IOException, NoSuchAlgorithmException {
        map.put("jsbh", "");
        map.put("nsrsbh", BasicParameters.nsrsbh);
        map.put("fplxdm", "004");
        String body = RequestBody.getRequestBody("DQFPXX", ZpyInputManagement.dqfpxx(map));
        int code = RequestInterface.requestInteface(body, BasicParameters.num);
        Assert.assertEquals(code, 0);
    }

}
