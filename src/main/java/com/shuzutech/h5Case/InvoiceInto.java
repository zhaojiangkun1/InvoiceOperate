package com.shuzutech.h5Case;

import com.shuzutech.config.Encrypt;
import com.shuzutech.config.InterfaceNum;
import com.shuzutech.model.GetAccessToken;
import com.shuzutech.model.GetAppInfo;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URLEncoder;

public class InvoiceInto {
    /**
     * 旋极业务员：13699999999
     * /bw/invoice/third/register_page
     */
    private static InterfaceNum num = InterfaceNum.DEV;
    private static String UA = "Chrome";
    private static String staffMobile = "12346776543";
    private static String companyName = "合力测试四十三";
    private static String contact = "12210010010";
    private static String mobile = "12210010010";
    private static String taxNo = "110101201607010043";
    private static String outMerchantId = "201908171107";
    private static String channelId = "";
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
        String uri = getUri(num)+"/third/invoice/registration";
        String url = PublicInvoiceRequest.invoiceRequest(uri,appId,encryptMsg_urlEncode);
        System.out.println(url);
    }

    public String getUri(InterfaceNum num){
        String string = num.toString();
        String url = "";
        if (string.contains("TEST")){
            url = "http://112.74.173.171:8082";
        }
        if (string.contains("DEV")){
            url = "http://106.14.193.154:8084";
        }
        if (string.contains("PRO")){
            url = "http://qiye.shuzutech.com/";
        }
        return url;
    }
}
