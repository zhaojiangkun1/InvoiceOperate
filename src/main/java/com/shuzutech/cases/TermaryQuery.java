package com.shuzutech.cases;

import com.shuzutech.config.InterfaceNum;
import com.shuzutech.model.RequestInterface;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class TermaryQuery {

    @Test(groups = {"终端查询"})
    public void termaryQuery() throws IOException, NoSuchAlgorithmException {
        String nsrsbh = "91320191MA1ML4CL25";
        String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?><business id=\"TERMINALMANAGE\"><body><input><nsrsbh>"+nsrsbh+"</nsrsbh></input></body></business>";
        int code = RequestInterface.requestInteface(body, InterfaceNum.TEST);
        Assert.assertEquals(code,0);
    }
}
