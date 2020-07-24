package com.shuzutech.cases.zpy.fpdy;

import com.shuzutech.bean.BasicParameters;
import com.shuzutech.model.RequestInterface;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class YBJSZ {
    /**
     * 110101201707010064
     * 91320594MA1MECA285
     */
    private static String jsbh="91320191MA1ML4CL25~~661921253676";
    private static String nsrsbh="";  //110101201707010064  91320191MA1ML4CL25
    private static String fplxdm="004";
    private static String top = "10";//打印上边距，可正可负  整数
    private static String left = "-20";//打印左边距，可正可负  整数

    @Test
    public void ybjsz() throws IOException, NoSuchAlgorithmException {
        int code = RequestInterface.requestInteface(body(), BasicParameters.num);
        Assert.assertEquals(code, 0);
    }

    private String body(){
        String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<business id=\"YBJSZ\">\n" +
                "\t<body>\n" +
                "\t\t<input>\n" +
                "\t\t\t<jsbh>"+jsbh+"</jsbh>\n" +
                "\t\t\t<nsrsbh>"+nsrsbh+"</nsrsbh>\n" +
                "\t\t\t<fplxdm>"+fplxdm+"</fplxdm>\n" +
                "\t\t\t<top>"+top+"</top>\n" +
                "\t\t\t<left>"+left+"</left>\n" +
                "\t\t</input>\n" +
                "\t</body>\n" +
                "</business>";
        return body;
    }
}
