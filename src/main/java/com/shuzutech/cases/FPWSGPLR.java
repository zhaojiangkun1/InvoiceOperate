package com.shuzutech.cases;

import com.shuzutech.bean.TestEnvironment;
import com.shuzutech.model.RequestInterface;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class FPWSGPLR {

    private static String nsrsbh = "110101201707010057";
    @Test
    public void fpwsgplr() throws IOException, NoSuchAlgorithmException {
        String body = body();
        RequestInterface.requestInteface(body, TestEnvironment.num);
    }

    public String body(){
        String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<business id=\"FPWSGPLR\">\n" +
                "\t<body>\n" +
                "\t\t<input>\n" +
                "\t\t\t<jsbh></jsbh>\n" +
                "\t\t\t<nsrsbh>"+nsrsbh+"</nsrsbh>"+
                "\t\t\t<fpxl>\n" +
                "\t\t\t\t<group xh=\"1\">\n" +
                "\t\t\t\t\t<fplx_dm>007</fplx_dm>\n" +
                "\t\t\t\t\t<fpdm>150001201509</fpdm>\n" +
                "\t\t\t\t\t<fphm_q>20191048</fphm_q>\n" +
                "\t\t\t\t\t<fphm_z>20191060</fphm_z>\n" +
                "\t\t\t\t\t<fs>13</fs>\n" +
                "\t\t\t\t\t<gpzt>2</gpzt>\n" +
                "\t\t\t\t</group>\n" +
                "\t\t\t</fpxl>\n" +
                "\t\t</input>\n" +
                "\t</body>\n" +
                "</business>\n";
        return body;
    }
}
