package com.shuzutech.cases.fpsb;

import com.shuzutech.bean.BasicParameters;
import com.shuzutech.config.InterfaceNum;
import com.shuzutech.model.RequestInterface;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class GPXXCX {

    /**
     * jsbh:非必填，税控服务器此字段为空
     * fplxdm:必填
     * sblx:设备类型，1:云票打印机；2，税控服务器；为空时默认云票打印机
     * fpzt:发票状态，税控服务器必传，云票打印机无此字段，0：未分发，1：已分发（默认）
     * nsrsbh:非必填，纳税人识别号，税控服务器必传
     * qtzd:其它字段，fpzt:0时核心板号，为1开票终端标识
     * lgqxx:领购全信息，云票打印机无此字段
     *
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    private static String nsrsbh = BasicParameters.nsrsbh;
    private static String qtzd = BasicParameters.skph;
    private static String fpzt = "1";

    @Test(groups = {"购票信息查询"},description = "机身编号和纳税人识别号同时为空，查询购票信息")
    public void jsbhAndNsrsbhIsNullGpxxcx() throws IOException, NoSuchAlgorithmException {
        String body = body("","026","",fpzt,"","","");
        int code = RequestInterface.requestInteface(body, BasicParameters.num);
        Assert.assertEquals(code,1000009);//纳税人识别号对应商户不存在
    }

    @Test(groups = {"购票信息查询"},description = "机身编号为空，根据纳税人识别号查询购票信息")
    public void byNsrsbhGpxxcx() throws IOException, NoSuchAlgorithmException {
        String body = body(BasicParameters.jsbh,"026","2",fpzt,nsrsbh,qtzd,"");
        int code = RequestInterface.requestInteface(body, BasicParameters.num);
        Assert.assertEquals(code,0);
    }
    @Test(groups = {"购票信息查询"},description = "纳税人识别号为空，根据机身编号查询购票信息")
    public void byJsbhGpxxcx() throws IOException, NoSuchAlgorithmException {
        String body = body(BasicParameters.jsbh,"026","2",fpzt,"",qtzd,"");
        int code = RequestInterface.requestInteface(body, BasicParameters.num);
        Assert.assertEquals(code,300000);
    }

    @Test(groups = {"购票信息查询"},description = "查询普票的购票信息")
    public void queryPuPiaoGpxxcx() throws IOException, NoSuchAlgorithmException {
        String body = body(BasicParameters.jsbh,"007","2",fpzt,nsrsbh,qtzd,"");
        int code = RequestInterface.requestInteface(body, BasicParameters.num);
        Assert.assertEquals(code,0);
    }

    @Test(groups = {"购票信息查询"},description = "查询专票的购票信息")
    public void queryZhuanPiaoGpxxcx() throws IOException, NoSuchAlgorithmException {
        String body = body(BasicParameters.jsbh,"004","2",fpzt,nsrsbh,qtzd,"");
        int code = RequestInterface.requestInteface(body, BasicParameters.num);
        Assert.assertEquals(code,0);
    }


    public String body(String jsbh,String fplxdm,String sblx,String fpzt,String nsrsbh,String qtzd,String lgqxx){
        String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?><business id=\"GPXXCX\"><body><input><jsbh>"
                +jsbh+"</jsbh><fplxdm>"+fplxdm+"</fplxdm><sblx>"+sblx+"</sblx><fpzt>"+fpzt+"</fpzt><nsrsbh>"+nsrsbh
                +"</nsrsbh><qtzd>"+qtzd+"</qtzd><lgqxx>"+lgqxx+"</lgqxx></input></body></business>";
        return body;
    }
}
