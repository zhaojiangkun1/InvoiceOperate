package com.shuzutech.h5Case;

import com.shuzutech.config.Encrypt;
import com.shuzutech.config.InterfaceNum;
import com.shuzutech.model.GetAccessToken;
import com.shuzutech.model.GetAppInfo;
import org.testng.annotations.Test;

import java.io.IOException;

public class DmpZhengXin {
    private static String nsrsbh = "110101201601010075";
    private static String channelId = "40";
    private static String logo = "http://www.shuzutech.com/app/img/logo.png";
    private static InterfaceNum num = InterfaceNum.TEST;

    @Test
    public void dmpZhengXin() throws IOException {
        String param ="nsrsbh="+nsrsbh+"&channelId="+channelId+"&logo="+logo;
        String appId = GetAppInfo.getAppInfo(num).getAppId();
        String accessToken = GetAccessToken.getToken(num);
        String encryptMsg = java.util.Base64.getEncoder().encodeToString(new Encrypt().aesEncrypt(param,accessToken).getBytes("utf-8"));
        String uri = GetRequestAddr.getRequestAddr(num)+"/credit/merchant/information";
        String url = PublicInvoiceRequest.invoiceRequest(uri,appId,encryptMsg);
        System.out.println(url);
    }
}
