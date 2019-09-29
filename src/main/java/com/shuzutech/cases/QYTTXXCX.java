package com.shuzutech.cases;

import com.shuzutech.bean.TestEnvironment;
import com.shuzutech.config.InterfaceNum;
import com.shuzutech.model.RequestInterface;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class QYTTXXCX {
    /**
     * 企业抬头信息联想接口
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    @Test(groups = {"企业抬头信息联想"})
    public void qyttxxcx() throws IOException, NoSuchAlgorithmException {
        String body = body("上海汇付数据服务有限公司");
        int code = RequestInterface.requestInteface(body, TestEnvironment.num);
        Assert.assertEquals(code,0);

    }

    public String body(String title){
        String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?><business id=\"QYTTXXCX\"><body><input><title>"+title+"</title></input></body></business>";
        return body;
    }
}
