package com.shuzutech.cases;

import com.shuzutech.bean.BasicParameters;
import com.shuzutech.config.InterfaceNum;
import com.shuzutech.model.RequestInterface;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class TJXXCX {

    private String jsbh = "";
    private static String nsrsbh = "91320594346148467C";
    private InterfaceNum num = BasicParameters.num;

    /**
     * 110101201707010064
     *qsrq:后期会作废掉，zzrq：要查询的当前日期
     *Ukey: 91320594MA1MECA285~~537100950610
     *Ukey：91320594346148467C~~537100951479
     * 91320191MA1ML4CL25~~661921253676
     * 110101201707010041
     * 110101201601010075~~499000153838
     *110101201707010057~~499000152456
     * 91320191MA1ML4CL25~~661826092245  统计电子票
     * 500102010001459~~499000115698 宁波
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    @Test(groups = {"统计信息查询"})
    public void tjxxcx() throws IOException, NoSuchAlgorithmException {
        String body = body("026","20200301","20200420");
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
        String body = body("025","","20200103");
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
        String body = body("007","20200401","20200515");
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
        String body = body("004","20200503","20200503");
        int code = RequestInterface.requestInteface(body, num);
        Assert.assertEquals(code,0);
    }




    public String body(String fplxdm,String qsrq,String zzrq){
        String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?><business id=\"TJXXCX\"><body><input><jsbh>"+jsbh+"</jsbh><nsrsbh>"+nsrsbh+"</nsrsbh><fplxdm>"+fplxdm+
                "</fplxdm><qsrq>"+qsrq+"</qsrq><zzrq>"+zzrq+"</zzrq></input></body></business>";
        return body;
    }

}
