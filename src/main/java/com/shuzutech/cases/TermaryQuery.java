package com.shuzutech.cases;

import com.shuzutech.bean.BasicParameters;
import com.shuzutech.model.RequestInterface;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class TermaryQuery {
    /**
     * 110101201707010064~~499000152528
     * 500102010001448
     * 91320191MA1ML4CL25
     * 110101201707010043
     * 110101201707010064
     * 91320594346148467C
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */

    @Test(groups = {"终端查询"})
    public void termaryQuery() throws IOException, NoSuchAlgorithmException {
        String nsrsbh = "91320594346148467C";
        String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?><business id=\"TERMINALMANAGE\"><body><input><nsrsbh>" + nsrsbh + "</nsrsbh></input></body></business>";
        int code = RequestInterface.requestInteface(body, BasicParameters.num);
        Assert.assertEquals(code, 0);
    }
}
