package com.shuzutech.cases;

import com.shuzutech.bean.TestEnvironment;
import com.shuzutech.model.RequestInterface;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class DZFPCF {

    /**
     * 电子发票重发接口
     */
    String fpqqlsh = "Qq26120200417143056";

    String sprsjh = "zhaokun@shuzutech.com";

    @Test
    public void dzfpcf() throws IOException, NoSuchAlgorithmException {
        String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?><business id=\"DZFPCF\"><body><input><fpqqlsh>"+fpqqlsh+"</fpqqlsh><sprsjh>"+sprsjh+"</sprsjh></input></body></business>";
        int code = RequestInterface.requestInteface(body, TestEnvironment.num);
        Assert.assertEquals(code,0);

    }
}
