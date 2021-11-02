package com.shuzutech.cases.zpy.fpgl;

import com.shuzutech.bean.BasicParameters;
import com.shuzutech.model.RequestInterface;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class FPZF {

    /**
     * 110101201707010057~~499000152456
     * 91320191MA1ML4CL25~~661826092245
     * 91320594346148467C~~537100951479
     * zflx:0表示空白发票作废，1表示已开具发票作废，hjje是不含税的
     * 空白发票作废，hjje字段不传(共享2型打印机，此节点可不存在)
     * 发票作废：hjje 是原发票的hjje；hjje是传正值\
     *
     *
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    private static String nsrsbh = BasicParameters.nsrsbh;
    private static String fpqqlsh = "SZZPY20210323093849";

    @Test(groups = {"发票作废"}, description = "已开具发票作废")
    public void fpzf() throws IOException, NoSuchAlgorithmException {
        String body = body("49955195", "",
                "007", "1", "282.64",
                "050000000011", "赵坤");
        int code = RequestInterface.requestInteface(body, BasicParameters.num);
        Assert.assertEquals(code, 0);
    }

    /**
     * 空白发票作废，专票空白发票作废可以
     *
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */

    @Test(groups = {"发票作废"}, description = "空白发票作废")
    public void fpzf1() throws IOException, NoSuchAlgorithmException {
        String body = body1("90335182", "",
                "007", "0", "050000000004",
                "管理员");
        int code = RequestInterface.requestInteface(body, BasicParameters.num);
        Assert.assertEquals(code, 0);
    }

    /**
     * 自助开票申请作废
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */

    @Test
    public void fpzf2() throws IOException, NoSuchAlgorithmException {
        String body = ziZhuZf(BasicParameters.jsbh,fpqqlsh);
        int code = RequestInterface.requestInteface(body, BasicParameters.num);
        Assert.assertEquals(code, 0);
    }

    public String ziZhuZf(String jsbh,String fpqqlsh){
        String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?><business id=\"FPZF\"><body><input><fphm>" + ""
                + "</fphm><jsbh>" + jsbh + "</jsbh><nsrsbh>" + "" + "</nsrsbh><fplxdm>" + "026" + "</fplxdm><zflx>" + "1" + "</zflx><hjje>" + "282.08" + "</hjje><fpdm>"
                + "" + "</fpdm><zfr>" + "zfr" + "</zfr><fpqqlsh>"+fpqqlsh+"</fpqqlsh></input></body></business>";
        return body;
    }


    public String body(String fphm, String jsbh, String fplxdm, String zflx, String hjje, String fpdm, String zfr) {
        String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?><business id=\"FPZF\"><body><input><fphm>" + fphm
                + "</fphm><jsbh>" + jsbh + "</jsbh><nsrsbh>" + nsrsbh + "</nsrsbh><fplxdm>" + fplxdm + "</fplxdm><zflx>" + zflx + "</zflx><hjje>" + hjje + "</hjje><fpdm>"
                + fpdm + "</fpdm><zfr>" + zfr + "</zfr></input></body></business>";
        return body;
    }

    public String body1(String fphm, String jsbh, String fplxdm, String zflx, String fpdm, String zfr) {
        String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?><business id=\"FPZF\"><body><input><fphm>" + fphm
                + "</fphm><jsbh>" + jsbh + "</jsbh><nsrsbh>" + nsrsbh + "</nsrsbh><fplxdm>" + fplxdm + "</fplxdm><zflx>" + zflx + "</zflx><fpdm>"
                + fpdm + "</fpdm><zfr>" + zfr + "</zfr>"+"</input></body></business>";
        return body;
    }


}
