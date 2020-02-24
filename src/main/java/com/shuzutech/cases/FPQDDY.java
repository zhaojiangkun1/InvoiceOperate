package com.shuzutech.cases;

import com.shuzutech.config.InterfaceNum;
import com.shuzutech.model.RequestInterface;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class FPQDDY {

    /**
     * 能打印成功，但是百旺获取不到打印结果，返回失败
     * <?xml version="1.0" encoding="utf-8"?><business id="FPQDDY"><body><returncode>300004</returncode><returnmsg>获取操作结果失败，请调用相应接口查询当前操作结果或稍后查询</returnmsg></body></business>
     * <p>
     * 如果是没有清单的发票，不能调这个接口，调这个接口不会给打印机发请求
     *
     * 110101201707010043~~A20016420000265
     *
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    private static String nsrsbh = "110101201707010043";
    private static String jsbh = "";

    @Test
    public void fpqddy() throws IOException, NoSuchAlgorithmException {
        String body = body("007", "050000000011", "59952032");
        RequestInterface.requestInteface(body, InterfaceNum.DEV);
    }


    public String body( String fplxdm, String fpdm, String fphm) {
        String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?><business id=\"FPQDDY\"><body><input><jsbh>" + jsbh + "</jsbh><nsrsbh>"+nsrsbh+"</nsrsbh><fplxdm>" + fplxdm + "</fplxdm><fpdm>" + fpdm + "</fpdm><fphm>" + fphm + "</fphm></input></body></business>\n";
        return body;
    }
}