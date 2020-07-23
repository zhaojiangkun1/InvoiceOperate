package com.shuzutech.cases.baiwangtong;

import com.shuzutech.bean.BasicParameters;
import com.shuzutech.model.RequestInterface;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class DZFPCF {

    private static String fpqqlsh = "Hw74620200714173112";
    private static String sprsjh = "13701476279";

    /**
     * 当Url为空时，调用重发提示
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */

    @Test(groups = {"电子发票重发"},description = "电子发票重发到手机号")
    public void dzfpcfPhone() throws IOException, NoSuchAlgorithmException {
        int code = RequestInterface.requestInteface(body(fpqqlsh,sprsjh), BasicParameters.bwt_num);
        Assert.assertEquals(code,0);
    }
    @Test(groups = {"电子发票重发"},description = "电子发票重发到邮箱")
    public void dzfpcfEmail() throws IOException, NoSuchAlgorithmException {
        int code = RequestInterface.requestInteface(body(fpqqlsh,"zhaokun@shuzutech.com"), BasicParameters.bwt_num);
        Assert.assertEquals(code,0);
    }


    private static String body(String fpqqlsh,String sprsjh){
        String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<business id=\"DZFPCF\">\n" +
                "\t<body>\n" +
                "\t\t<input>\n" +
                "\t\t\t<fpqqlsh>"+fpqqlsh+"</fpqqlsh>\n" +
                "\t\t\t<sprsjh>"+sprsjh+"</sprsjh>\n" +
                "\t\t</input>\n" +
                "\t</body>\n" +
                "</business>";
        return body;
    }
}
