package com.shuzutech.cases.other;

import com.shuzutech.bean.BasicParameters;
import com.shuzutech.model.RequestInterface;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class DZFPCF {

    /**
     * Af77420200518165649
     * 电子发票重发接口
     * Fv75420200518154632
     */
    String fpqqlsh = "vh65620200519152252";

    String sprsjh = "zhaokun@shuzutech.com";

    @Test
    public void dzfpcf() throws IOException, NoSuchAlgorithmException {
        String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?><business id=\"DZFPCF\"><body><input><fpqqlsh>"+fpqqlsh+"</fpqqlsh><sprsjh>"+sprsjh+"</sprsjh></input></body></business>";
        int code = RequestInterface.requestInteface(body, BasicParameters.num);
        Assert.assertEquals(code,0);

    }
}
