package com.shuzutech.h5Case;

import com.shuzutech.bean.AppInfo;
import com.shuzutech.bean.BasicParameters;
import com.shuzutech.config.Encrypt;
import com.shuzutech.config.InterfaceNum;
import com.shuzutech.model.GetAccessToken;
import com.shuzutech.model.GetAppInfo;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class H5InvoiceConfig {
    private static String UA = "Chrome";
    private static String shnsrsbh = BasicParameters.nsrsbh;
    private static String terminalKey = "";
    private static InterfaceNum num = InterfaceNum.DEV;

    /**
     * H5配置
     *
     * @throws IOException
     */
    @Test
    public void h5InvoiceConfig() throws IOException {
        String ic = "UA=" + UA + "&shnsrsbh=" + shnsrsbh + "&terminalKey=" + terminalKey;
        AppInfo appInfo = GetAppInfo.getAppInfo(num);
        String appId = appInfo.getAppId();
        System.out.println("加密字符串:"+ic);
        String token = GetAccessToken.getToken(num);
        System.out.println("加密的token:"+token);
        String ecoderResult = java.util.Base64.getEncoder().encodeToString(new Encrypt().aesEncrypt(ic, token).getBytes("utf-8"));
        System.out.println("加密后的encryptMsg："+ecoderResult);
        String uri = GetRequestAddr.getRequestAddr(num) + "/invoice/h5/config";
        String url = PublicInvoiceRequest.invoiceRequest(uri, appId, ecoderResult);
        System.out.println(url);
    }

    @Test
    public void test12() throws UnsupportedEncodingException {
        String ic = "&type=3&UA=Chrome&fpqqlsh=SS196054744476958720";
        String token = "d2b1f0ee8760bb1c1b2b811161d4a333";
        System.out.println(new Encrypt().aesEncrypt(ic, token).getBytes("utf-8"));
        String ecoderResult = java.util.Base64.getEncoder().encodeToString(new Encrypt().aesEncrypt(ic, token).getBytes("utf-8"));
        System.out.println(ecoderResult);
    }
}
