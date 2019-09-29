package com.shuzutech.cases;

import com.shuzutech.config.InterfaceNum;
import com.shuzutech.model.RequestInterface;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class TJXXCX {

    private String jsbh = "91320191MA1ML4CL25~~661826092245";

    /**
     *110101201707010057~~499000152456
     * 91320191MA1ML4CL25~~661826092245  统计电子票
     * 500102010001459~~499000115698 宁波
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    @Test
    public void tjxxcx() throws IOException, NoSuchAlgorithmException {
        String body = body(jsbh,"026","20190905","20190905");
        int code = RequestInterface.requestInteface(body, InterfaceNum.PRO);
        Assert.assertEquals(code,0);
    }

    /**
     * 统计卷票
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */

    @Test
    public void tjxxcx2() throws IOException, NoSuchAlgorithmException {
        String body = body(jsbh,"025","20190901","20190919");
        int code = RequestInterface.requestInteface(body, InterfaceNum.DEV);
        Assert.assertEquals(code,0);
    }

    /**
     * 统计普票
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */

    @Test
    public void tjxxcx3() throws IOException, NoSuchAlgorithmException {
        String body = body(jsbh,"007","20190901","20190919");
        int code = RequestInterface.requestInteface(body, InterfaceNum.DEV);
        Assert.assertEquals(code,0);
    }

    /**
     * 统计专票
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */

    @Test
    public void tjxxcx4() throws IOException, NoSuchAlgorithmException {
        String body = body(jsbh,"004","20190901","20190926");
        int code = RequestInterface.requestInteface(body, InterfaceNum.PRO);
        Assert.assertEquals(code,0);
    }




    public String body(String jsbh,String fplxdm,String qsrq,String zzrq){
        String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?><business id=\"TJXXCX\"><body><input><jsbh>"+jsbh+"</jsbh><fplxdm>"+fplxdm+
                "</fplxdm><qsrq>"+qsrq+"</qsrq><zzrq>"+zzrq+"</zzrq></input></body></business>";
        return body;
    }

}
