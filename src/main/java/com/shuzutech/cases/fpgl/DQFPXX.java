package com.shuzutech.cases.fpgl;

import com.shuzutech.bean.BasicParameters;
import com.shuzutech.model.RequestInterface;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class DQFPXX {

    private String jsbh = BasicParameters.jsbh;
    private String nsrsbh = BasicParameters.nsrsbh;

    /**
     * 91320594MA1MECA285
     * 智能设备：发票请求流水号：32位；税控服务器是20位
     *110101201601010075~~A20017260026921
     * 110101201707010057~~499000152456
     * 91320191MA1ML4CL25~~661826092245  需要去盘里读取数据，盘不在，读取不了数据。
     * 91320191MA1ML4CL25~~661921253676
     * @throws IOException
     * @throws NoSuchAlgorithmException
     * 查询电子票
     */
    @Test(groups = {"当前发票信息"})
    public void dqfpxx() throws IOException, NoSuchAlgorithmException {
        String body = body(jsbh,"026");
        int code = RequestInterface.requestInteface(body, BasicParameters.num);
        Assert.assertEquals(code,0);
    }

    /**
     * 查询卷票
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
//    @Test(groups = {"当前发票信息"})
//    public void dqfpxx2() throws IOException, NoSuchAlgorithmException {
//        String body = body(jsbh,"025");
//        int code = RequestInterface.requestInteface(body, TestEnvironment.num);
//        Assert.assertEquals(code,0);
//    }

    /**
     * 查询普票
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    @Test(groups = {"当前发票信息"})
    public void dqfpxx3() throws IOException, NoSuchAlgorithmException {
        String body = body(jsbh,"007");
        int code = RequestInterface.requestInteface(body, BasicParameters.num);
        Assert.assertEquals(code,0);
    }

    /**
     * 查询专票
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */

    @Test(groups = {"当前发票信息"})
    public void dqfpxx4() throws IOException, NoSuchAlgorithmException {
        String body = body(jsbh,"004");
        int code = RequestInterface.requestInteface(body, BasicParameters.num);
        Assert.assertEquals(code,0);
    }



    public String body(String jsbh,String fplxdm){
        String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?><business id=\"DQFPXX\"><body><input><jsbh>"+jsbh+"</jsbh><nsrsbh>"+nsrsbh+"</nsrsbh><fplxdm>"+
                fplxdm+"</fplxdm></input></body></business>";
        return body;
    }
}
