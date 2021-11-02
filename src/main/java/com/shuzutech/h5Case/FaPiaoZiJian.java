package com.shuzutech.h5Case;

import com.shuzutech.config.Encrypt;
import com.shuzutech.config.InterfaceNum;
import com.shuzutech.model.GetAccessToken;
import com.shuzutech.model.GetAppInfo;
import org.testng.annotations.Test;

import java.io.IOException;

public class FaPiaoZiJian {
    /**
     * 发票自检
     */
    private static String UA = "Chrome";
    private static String shnsrsbh = "110101201707010031";
    private static String jsbh = "110101201707010031~~499000152034";
    private static InterfaceNum num = InterfaceNum.PRO;

    @Test
    public void invoiceSelfInSpection() throws IOException {
        String params = "UA=" + UA + "&shnsrsbh=" + shnsrsbh + "&jsbh=" + jsbh;
        String accessToken = GetAccessToken.getToken(num);
        String appId = GetAppInfo.getAppInfo(num).getAppId();
        String ecoderResult = java.util.Base64.getEncoder().encodeToString(new Encrypt().aesEncrypt(params, accessToken).getBytes("utf-8"));
        String uri = GetRequestAddr.getRequestAddr(num) + "/invoice/h5/self_test";
        String url = PublicInvoiceRequest.invoiceRequest(uri, appId, ecoderResult);
        System.out.println(url);
    }
}
