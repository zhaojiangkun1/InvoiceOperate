package com.shuzutech.h5Case;

import com.shuzutech.config.Encrypt;
import com.shuzutech.config.InterfaceNum;
import com.shuzutech.model.GetAccessToken;
import com.shuzutech.model.GetAppInfo;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URLEncoder;

public class InvoiceInto {
    private static InterfaceNum num = InterfaceNum.TEST;
    private static String UA = "Chrome";
    private static String staffMobile = "13599999998";
    private static String companyName = "江南2号店081701";
    private static String contact = "18672680519";
    private static String mobile = "18672680619";
    private static String taxNo = "130101201707020042";
    private static String outMerchantId = "201908171105";
    private static String channelId = "40";
    /**
     * 第三方发票进件
     */

    @Test
    public void invoiceInto() throws IOException {
        String params = "UA="+UA+"&staffMobile="+staffMobile+"&companyName="+companyName+"&contact=" +contact+
                "&mobile=" +mobile+
                "&taxNo=" +taxNo+
                "&outMerchantId=" +outMerchantId+
                "&channelId="+channelId;
        String appId = GetAppInfo.getAppInfo(num).getAppId();
        String accessToken = GetAccessToken.getToken(num);
        String returnUrl = "http://www.shuzutech.com/";
        String encryptMsg = new Encrypt().aesEncrypt(params, accessToken);
        //URLEncoder.encode()不指定编码得方法已经过时，现在使用如下方法
        String encryptMsg_urlEncode = URLEncoder.encode(encryptMsg,"UTF-8");
        String uri = GetRequestAddr.getRequestAddr(num)+"/third/invoice/registration";
        String url = PublicInvoiceRequest.invoiceRequest(uri,appId,encryptMsg_urlEncode);
        System.out.println(url);
    }
}
