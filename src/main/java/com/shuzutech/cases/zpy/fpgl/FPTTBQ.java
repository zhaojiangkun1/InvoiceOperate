package com.shuzutech.cases.zpy.fpgl;

import com.shuzutech.bean.BasicParameters;
import com.shuzutech.model.RequestInterface;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class FPTTBQ {

    private String shnrssbh = BasicParameters.nsrsbh;//
    private String fpqqlsh = "SZZPY2021040213552266612";
    private String ghdwsbh = "91320191MA1PB97F3A";
    private String ghdwmc = "南京优悦臻鲜信息科技有限公司123";
    private String ghdwdzdh = "南京市高新开发区星火路11号动漫大厦B座2层18号 13815871685";
    private String ghdwyhzh = "招商银行股份有限公司南京城东支行 125908266310201";

    /**
     * 发票抬头提交，提交之后，立即开票
     * @throws IOException
     * @throws NoSuchAlgorithmException
     * FPTTTJ 是云票助手2.0 闪电开票选择对应抬头
     * FPTTBQ 是纸质自助开票，shnsrsbh
     */

    @Test
    public void fptttj() throws IOException, NoSuchAlgorithmException {
        String body = fpttBody();
        int code = RequestInterface.requestInteface(body, BasicParameters.num);
        Assert.assertEquals(code, 0);
    }

    public String fpttBody(){
        String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<business id=\"FPTTTJ\">\n" +
                "\t<body>\n" +
                "\t\t<input>\n" +
                "\t\t\t<nsrsbh>"+shnrssbh+"</nsrsbh>\n" +
                "\t\t\t<fpqqlsh>"+fpqqlsh+"</fpqqlsh>\n" +
                "\t\t\t<ghdwsbh>"+ghdwsbh+"</ghdwsbh>\n" +
                "\t\t\t<ghdwmc>"+ghdwmc+"</ghdwmc>\n" +
                "\t\t\t<ghdwdzdh>"+ghdwdzdh+"</ghdwdzdh>\n" +
                "\t\t\t<ghdwyhzh>"+ghdwyhzh+"</ghdwyhzh>\n" +
                "\t\t</input>\n" +
                "\t</body>\n" +
                "</business>\n";
        return body;
    }

}
