package com.shuzutech.cases;

import com.shuzutech.bean.BasicParameters;
import com.shuzutech.model.RequestInterface;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class ZZPJSQR {

    @Test
    public void zzpjsqr() throws IOException, NoSuchAlgorithmException {
        String body = body();
        RequestInterface.requestInteface(body, BasicParameters.num);
    }


    public String body(){
        String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<business id=\"ZZPJSQR\">\n" +
                "\t<body>\n" +
                "\t\t<input>\n" +
                "\t\t\t<jsbh></jsbh>\n" +
                "\t\t\t<nsrsbh>"+"110101201707010057"+"</nsrsbh>"+
                "\t\t\t<slxh>110101201707010057201910292639</slxh>\n" +
                "\t\t\t<fplxdm>007</fplxdm>\n" +
                "\t\t\t<qrxx count=\"1\">\n" +
                "\t\t\t\t<group xh=\"1\">\n" +
                "\t\t\t\t\t<fpdm>150001201509</fpdm>\n" +
                "\t\t\t\t\t<qshm>20191049</qshm>\n" +
                "\t\t\t\t\t<zzhm>20191069</zzhm>\n" +
                "\t\t\t\t\t<fs>23</fs>\n" +
                "\t\t\t\t</group>\n" +
                "\t\t\t</qrxx>\n" +
                "\t\t</input>\n" +
                "\t</body>\n" +
                "</business>\n";
        return body;
    }
}
