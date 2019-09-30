package com.shuzutech.cases;

import com.shuzutech.bean.TestEnvironment;
import com.shuzutech.model.RequestInterface;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class QYXXCX {
    /**
     * 用于查询开票企业
     * 110101201601010075~~A20017260026921
     * 91320191MA1ML4CL25~~661826092245
     * 110101201707010037~~499000152093
     * 上海市罗山路88268100
     * 中国银行78884567866464
     * 110101201707010037~~A10016420000196
     * 南京市雨花台区软件大道168号润和创智中心3栋309室18061495423
     * 南京市工商银行3201000323459889
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */

    @Test(groups = {"企业信息查询"})
    public void qyxxcx() throws IOException, NoSuchAlgorithmException {
        String body = body("110101201707010057~~499000152456");
        int code = RequestInterface.requestInteface(body, TestEnvironment.num);
        Assert.assertEquals(code,0);
    }

    /**
     * 机身编号不存在
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */

    @Test(groups = {"企业信息查询"})
    public void qyxxcx1() throws IOException, NoSuchAlgorithmException {
        String body = body("110101201707010057~~499000152009");
        int code = RequestInterface.requestInteface(body,TestEnvironment.num);
        Assert.assertEquals(code,300002);
    }

    /**
     * 税号不存在
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    @Test(groups = {"企业信息查询"})
    public void qyxxcx2() throws IOException, NoSuchAlgorithmException {
        String body = body("110101201707011157~~499000152456");
        int code = RequestInterface.requestInteface(body,TestEnvironment.num);
        Assert.assertEquals(code,1000009);
    }


    public String body(String jsbh){
        String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?><business id=\"QYXXCX\"><body><input><jsbh>"+jsbh+"</jsbh></input></body></business>";
        return body;
    }

}
