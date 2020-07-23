package com.shuzutech.cases.baiwangtong;

import com.shuzutech.bean.BasicParameters;
import com.shuzutech.model.RequestInterface;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class QYXXSZ {
    private static String deviceNo = BasicParameters.bwt_kpzdbs;
    private static String xhdwdzdh = "南京市江北新区新科二路2号南大软件学院222D室 02558801191";
    private static String xhdwyhzh = "中国农业银行股份有限公司南京茶亭东街支行 10107501040008319";
//    private static String fplxdm = "026";

    /**
     * 企业信息设置，先以这个为准
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    @Test
    public void qyxxsz() throws IOException, NoSuchAlgorithmException {
        int code = RequestInterface.requestInteface(body(), BasicParameters.bwt_num);
        Assert.assertEquals(code,0);
    }

    public static String body(){
        String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<business id=\"QYXXSZ\">\n" +
                "<body>\n" +
                "<input>\n" +
                "<deviceNo>"+deviceNo+"</deviceNo>\n" +
                "<kpzdbs>"+deviceNo+"</kpzdbs>\n" +
                "<xhdwdzdh>"+xhdwdzdh+"</xhdwdzdh>\n" +
                "<xhdwyhzh>"+xhdwyhzh+"</xhdwyhzh>\n" +
                "</input>\n" +
                "</body>\n" +
                "</business>\n";
        return body;
    }
}
