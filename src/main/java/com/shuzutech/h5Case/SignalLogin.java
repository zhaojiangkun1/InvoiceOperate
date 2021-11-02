package com.shuzutech.h5Case;

import com.shuzutech.config.Encrypt;
import com.shuzutech.config.InterfaceNum;
import com.shuzutech.model.GetAccessToken;
import com.shuzutech.model.GetAppInfo;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class SignalLogin {
    /**
     * 旋极业务员：13699999999
     * /bw/invoice/third/register_page
     *
     * 110101201707010043
     * 110101201707010057
     * 110101201707010037
     * 110101201707010041
     * 110101201707010031
     *
     */
    private static InterfaceNum num = InterfaceNum.PRO;
    private static String type = "1";
    private static String store = "1008782";
    private static String Service = "1";
    private static String shnsrsbh = "110101201707010031";
    private static String algorithm = "AES128-ECB";




    @Test
    public void signalByAppLogin() throws IOException {
        String params = "type=" + type + "&store=" + store + "&Service=" + Service + "&shnsrsbh=" + shnsrsbh +
                "&algorithm=" + algorithm;
        String appId = GetAppInfo.getAppInfo(num).getAppId();
        String accessToken = GetAccessToken.getToken(num);
        String encryptMsg = new Encrypt().aesEncrypt(params, accessToken);
        //URLEncoder.encode()不指定编码得方法已经过时，现在使用如下方法
        String encryptMsg_urlEncode = URLEncoder.encode(encryptMsg, "UTF-8");
        String uri = getUri(num) + "/third/h5/login";
        String url = PublicInvoiceRequest.invoiceRequest(uri, appId, encryptMsg_urlEncode);
        System.out.println(url);
    }


    public static void main(String[] args){
        String encryptMsg_urlEncode = "";
        String params = "type=1&shnsrsbh=91320902MA1UY6EE2Y";
        String accessToken = "31ca5801c7af5ea21d44072d86018e94";
        String encryptMsg = new Encrypt().aesEncrypt(params, accessToken);
        try {
            encryptMsg_urlEncode = URLEncoder.encode(encryptMsg, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(encryptMsg_urlEncode);
        String uri = new SignalLogin().getUri(num) + "/third/h5/login";
        String appId = "06939b789e64da9b686d425274a7a37b";
        String url = PublicInvoiceRequest.invoiceRequest(uri, appId, encryptMsg_urlEncode);
        System.out.println(url);
    }
    @Test
    public void test1(){
        String encryptMsg_urlEncode = "";
        String msg = "y/QJapGPZxZdJEVBy3dCnPQ6bLM+BQ24ldRMSEzUKCu8svrYbVAYt0cLdN58yAV7";
        try {
          encryptMsg_urlEncode = URLEncoder.encode(msg, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(encryptMsg_urlEncode);

    }


    public String getUri(InterfaceNum num) {
        String string = num.toString();
        String url = "";
        if (string.contains("TEST")) {
            url = "http://112.74.173.171:8082";
        }
        if (string.contains("DEV")) {
            url = "http://yunying.dev.shuzutech.com";
        }
        if (string.contains("PRO")) {
            url = "https://shanghu.shuzutech.com";
        }
        return url;
    }
}
