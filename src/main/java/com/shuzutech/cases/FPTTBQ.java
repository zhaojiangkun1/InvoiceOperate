package com.shuzutech.cases;

import com.shuzutech.config.InterfaceNum;
import com.shuzutech.model.RequestInterface;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class FPTTBQ {

    /**
     * 用于纸质发票自助开具时，补充提交购方的发票抬头。
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    @Test
    public void fpttbq() throws IOException, NoSuchAlgorithmException {
        String body = body();
        RequestInterface.requestInteface(body, InterfaceNum.TEST);
    }

    public String body(){
        String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<business id=\"FPTTBQ\">\n" +
                "    <body>\n" +
                "        <input>\n" +
                "            <fpqqlsh>F100000000000009</fpqqlsh>\n" +
                "            <ghdwsbh></ghdwsbh>\n" +
                "            <ghdwmc>南京阿有料网络科技有限公司</ghdwmc>\n" +
                "            <ghdwdzdh></ghdwdzdh>\n" +
                "            <ghdwyhzh></ghdwyhzh>\n" +
                "        </input>\n" +
                "    </body>\n" +
                "</business>";
        return body;
    }
}
