package com.shuzutech.cases.baiwangtong;

import com.shuzutech.bean.BasicParameters;
import com.shuzutech.model.RequestInterface;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class TaxControlEquipment {
    private static String shnsrsbh = BasicParameters.bwt_nsrsbh;

    /**
     * 税控设备查询
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    @Test
    public void taxControlEquipment() throws IOException, NoSuchAlgorithmException {
        int code = RequestInterface.requestInteface(body(), BasicParameters.bwt_num);
        Assert.assertEquals(code,0);
    }

    public static String body(){
        String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<business id=\"TaxControlEquipment\">\n" +
                "\t<body>\n" +
                "\t\t<input>\n" +
                "\t\t\t<shnsrsbh>"+shnsrsbh+"</shnsrsbh>\n" +
                "\t\t</input>\n" +
                "\t</body>\n" +
                "</business>";
        return body;
    }
}
