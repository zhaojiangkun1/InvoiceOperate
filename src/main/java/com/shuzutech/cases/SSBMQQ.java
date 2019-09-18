package com.shuzutech.cases;

import com.shuzutech.config.InterfaceNum;
import com.shuzutech.model.RequestInterface;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class SSBMQQ {
    /**
     * 请求获取税局商品编码信息表。
     * 获取后的文件内容比较大，需要打印到一个文件中，否则会缺失信息
     * bbh为空，返回最新版本
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */

    @Test
    public void ssbmqq() throws IOException, NoSuchAlgorithmException {
        String body = body("");
        RequestInterface.requestInteface(body, InterfaceNum.DEV);
    }

    public String body(String bbh){
        String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?><business id=\"SSBMQQ\"><body><input><bbh>"+bbh+"</bbh></input></body></business>";
        return body;
    }
}
