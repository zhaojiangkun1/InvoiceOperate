package com.shuzutech.cases;

import com.shuzutech.bean.TestEnvironment;
import com.shuzutech.config.InterfaceNum;
import com.shuzutech.model.RequestInterface;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class TJXXCX {

    private String jsbh = "91320191MA1ML4CL25~~661921253676";
    private static String nsrsbh = "";
    private InterfaceNum num = TestEnvironment.num;

    /**
     * 110101201601010075~~499000153838
     *110101201707010057~~499000152456
     * 91320191MA1ML4CL25~~661826092245  统计电子票
     * 500102010001459~~499000115698 宁波
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    @Test(groups = {"统计信息查询"})
    public void tjxxcx() throws IOException, NoSuchAlgorithmException {
        String body = body("026","20100201","20200228");
        int code = RequestInterface.requestInteface(body, num);
        Assert.assertEquals(code,0);
    }

    /**
     * 统计卷票
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */

    @Test(groups = {"统计信息查询"})
    public void tjxxcx2() throws IOException, NoSuchAlgorithmException {
        String body = body("025","20200101","20200103");
        int code = RequestInterface.requestInteface(body, num);
        Assert.assertEquals(code,0);
    }

    /**
     * 统计普票
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */

    @Test(groups = {"统计信息查询"})
    public void tjxxcx3() throws IOException, NoSuchAlgorithmException {
        String body = body("007","20200101","20200103");
        int code = RequestInterface.requestInteface(body, num);
        Assert.assertEquals(code,0);
    }

    /**
     * 统计专票
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */

    @Test(groups = {"统计信息查询"})
    public void tjxxcx4() throws IOException, NoSuchAlgorithmException {
        String body = body("004","20200101","20200103");
        int code = RequestInterface.requestInteface(body, num);
        Assert.assertEquals(code,0);
    }




    public String body(String fplxdm,String qsrq,String zzrq){
        String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?><business id=\"TJXXCX\"><body><input><jsbh>"+jsbh+"</jsbh><nsrsbh>"+nsrsbh+"</nsrsbh><fplxdm>"+fplxdm+
                "</fplxdm><qsrq>"+qsrq+"</qsrq><zzrq>"+zzrq+"</zzrq></input></body></business>";
        return body;
    }

}
