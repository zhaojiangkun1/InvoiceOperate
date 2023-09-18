package com.shuzutech.cases.zpy.fpgl;

import com.shuzutech.bean.BasicParameters;
import com.shuzutech.model.RequestInterface;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class FPSC {

    @Test
    public void fpsc() throws IOException, NoSuchAlgorithmException {
        String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<business id=\"FPSC\">\n" +
                "\t<body>\n" +
                "\t\t<input>\n" +
                "\t\t\t<jsbh>91610132321974201M~~661103324751</jsbh>\n" +
                "\t\t\t<fplxdm>026</fplxdm>\n" +
                "\t\t\t<fpzs>10</fpzs>\n" +
                "\t\t</input>\n" +
                "\t</body>\n" +
                "</business>";
        RequestInterface.requestInteface(body, BasicParameters.num);
    }
}
