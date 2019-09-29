package com.shuzutech.cases;

import com.shuzutech.bean.TestEnvironment;
import com.shuzutech.config.InterfaceNum;
import com.shuzutech.model.RequestInterface;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class AICODE {
    InterfaceNum num = TestEnvironment.num;
    /**
     * 用于智能获取税收编码  name是需要联想的字段，必填
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */

    @Test(groups = {"智能获取税收编码"})
    public void aicode() throws IOException, NoSuchAlgorithmException {
        String body = body("毛毯");
        int code = RequestInterface.requestInteface(body, num);
        Assert.assertEquals(code,0);
    }

    /**
     * name为空，提示参数错误（如果优化，可以提示：商品名称name不能为空）
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    @Test(groups = {"智能获取税收编码"})
    public void aicode1() throws IOException, NoSuchAlgorithmException {
        String body = body("");
        int code = RequestInterface.requestInteface(body, num);
        Assert.assertEquals(code,10001);
    }

    /**
     * 特殊字符
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    @Test(groups = {"智能获取税收编码"})
    public void aicode2() throws IOException, NoSuchAlgorithmException {
        String body = body("**%$#@=");
        RequestInterface.requestInteface(body,num);
    }

    public String body(String name){
        String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?><business id=\"AICODE\"><body><input><name>"+name+"</name></input></body></business>";
        return body;
    }
}
