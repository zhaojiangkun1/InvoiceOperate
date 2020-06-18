package com.shuzutech.h5Case;

import com.shuzutech.bean.AppInfo;
import com.shuzutech.config.Encrypt;
import com.shuzutech.config.InterfaceNum;
import com.shuzutech.model.GetAccessToken;
import com.shuzutech.model.GetAppInfo;
import org.testng.annotations.Test;

import java.io.IOException;

public class H5InvoiceConfig {
    private static String UA = "Chrome";
    private static String shnsrsbh = "91320191MA1ML4CL25";
    private static String terminalKey = "";
    private static InterfaceNum num = InterfaceNum.DEV;

    /**
     * H5配置
     * @throws IOException
     */
    @Test
    public void h5InvoiceConfig() throws IOException {
        String ic = "UA="+UA+"&shnsrsbh="+shnsrsbh+"&terminalKey="+terminalKey;
        AppInfo appInfo = GetAppInfo.getAppInfo(num);
        String appId = appInfo.getAppId();
        String ecoderResult=java.util.Base64.getEncoder().encodeToString(new Encrypt().aesEncrypt(ic,GetAccessToken.getToken(num)).getBytes("utf-8"));
        String uri = GetRequestAddr.getRequestAddr(num)+"/invoice/h5/config";
        String url = PublicInvoiceRequest.invoiceRequest(uri,appId,ecoderResult);
        System.out.println(url);
    }
}
