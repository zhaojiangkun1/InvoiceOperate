package com.shuzutech.cases.fpsb;

import com.shuzutech.bean.BasicParameters;
import com.shuzutech.model.RequestInterface;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class TermaryQuery {
    /**
     *商客汇：91320594MA1MECA285~~537100950610
     * 110101201707010064~~499000152528
     * 500102010001448
     * 91320191MA1ML4CL25
     * 110101201707010043
     * 110101201707010064
     * 91320594346148467C
     * 110101201707010031
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */

    @Test(groups = {"终端查询"},description = "终端查询")
    public void termaryQuery() throws IOException, NoSuchAlgorithmException {
        String nsrsbh = BasicParameters.nsrsbh;
        String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?><business id=\"TERMINALMANAGE\"><body><input><nsrsbh>" + nsrsbh + "</nsrsbh></input></body></business>";
        int code = RequestInterface.requestInteface(body, BasicParameters.num);
        Assert.assertEquals(code, 0);
    }

    @Test(groups = {"终端查询"},description = "纳税人识别号为空,终端查询")
    public void nsrsbhIsNull() throws IOException, NoSuchAlgorithmException {
        String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?><business id=\"TERMINALMANAGE\"><body><input><nsrsbh>" + "" + "</nsrsbh></input></body></business>";
        int code = RequestInterface.requestInteface(body, BasicParameters.num);
        Assert.assertEquals(code, 10001);
    }
}
