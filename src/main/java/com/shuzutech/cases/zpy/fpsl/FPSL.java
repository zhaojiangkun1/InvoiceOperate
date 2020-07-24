package com.shuzutech.cases.zpy.fpsl;

import com.shuzutech.bean.BasicParameters;
import com.shuzutech.model.RequestInterface;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class FPSL {

    /**
     * 110101201707010057~~499000152456
     */
    private static String jsbh = "";
    private static String nsrsbh = "110101201707010057";

    @Test
    public void fpsl() throws IOException, NoSuchAlgorithmException {
        String body = body();
        RequestInterface.requestInteface(body, BasicParameters.num);
    }
    //证件类型zjlx 取值判断

    public String body(){
        String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<business id=\"FPSL\">\n" +
                "\t<body>\n" +
                "\t\t<input>\n" +
                "\t\t\t<jsbh>"+jsbh+"</jsbh>\n" +
                "\t\t\t<nsrsbh>"+nsrsbh+"</nsrsbh>\n"+
                "\t\t\t<fplxdm>007</fplxdm>\n" +
                "\t\t\t<fpzldm>0</fpzldm>\n" +
                "\t\t\t<slsl>40</slsl>\n" +
                "\t\t\t<slsj>20191130132456</slsj>\n" +
                "\t\t\t<zjlx>01</zjlx>\n" +
                "\t\t\t<zjhm>342224199203080886</zjhm>\n" +
                "\t\t\t<jbrxm>江南</jbrxm>\n" +
                "\t\t\t<slfs>2</slfs>\n" +
                "\t\t\t<slsm>缺少发票</slsm>\n" +
                "\t\t\t<psxx>\n" +
                "\t\t\t\t<sjrxm></sjrxm>\n" +
                "\t\t\t\t<sjrdz></sjrdz>\n" +
                "\t\t\t\t<yddh></yddh>\n" +
                "\t\t\t\t<gddh></gddh>\n" +
                "\t\t\t\t<yb></yb>\n" +
                "\t\t\t\t<bz></bz>\n" +
                "\t\t\t</psxx>\n" +
                "\t\t</input>\n" +
                "\t</body>\n" +
                "</business>";
        return body;
    }
}
