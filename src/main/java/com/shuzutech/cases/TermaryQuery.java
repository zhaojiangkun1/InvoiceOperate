package com.shuzutech.cases;

import com.shuzutech.bean.TestEnvironment;
import com.shuzutech.model.RequestInterface;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class TermaryQuery {

    @Test(groups = {"终端查询"})
    public void termaryQuery() throws IOException, NoSuchAlgorithmException {
        String nsrsbh = "110101201707010064";
        String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?><business id=\"TERMINALMANAGE\"><body><input><nsrsbh>" + nsrsbh + "</nsrsbh></input></body></business>";
        int code = RequestInterface.requestInteface(body, TestEnvironment.num);
        Assert.assertEquals(code, 0);
    }
}
