package com.shuzutech.h5Case;

import com.shuzutech.bean.AppInfo;
import com.shuzutech.config.Encrypt;
import com.shuzutech.config.InterfaceNum;
import com.shuzutech.model.GetAccessToken;
import com.shuzutech.model.GetAppInfo;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class H5MakeInvoice {

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyymmddHHMMss");
    String date = simpleDateFormat.format(new Date());
    private static InterfaceNum num = InterfaceNum.PRO;
    private static String UA = "PC";
    private static String kplx = "0";
    private static String fplxdm = "026";
    private static String shnsrsbh = "110101201707010057";
    private static String operator = "操作人";
    private static String terminalKey = "";
    private static String yfpdm = "";
    private static String yfphm = "";
    /**
     *H5页面开票
     */
    @Test
    public void makeInvoice() throws IOException {
        String fpqqlsh = "SZ"+date;
        System.out.println("本次请求的发票请求流水号:"+fpqqlsh);
        String inRe = "UA="+UA+"&"+"fpqqlsh="+fpqqlsh+"&"+"kplx="+kplx+"&"+"fplxdm="+fplxdm+"&"+"shnsrsbh="+shnsrsbh+"&"+"operator="+operator+"&"+"terminalKey="+terminalKey+
                "&"+"yfpdm="+yfpdm+"&"+"yfphm="+yfphm;
        String accessToken = GetAccessToken.getToken(num);
        AppInfo appInfo = GetAppInfo.getAppInfo(num);
        String appId = appInfo.getAppId();
        String ecoderResult = java.util.Base64.getEncoder().encodeToString(new Encrypt().aesEncrypt(inRe,accessToken).getBytes("utf-8"));
        String uri = GetRequestAddr.getRequestAddr(num)+"/invoice/h5/invoice";
        String url = PublicInvoiceRequest.invoiceRequest(uri,appId,ecoderResult);
        System.out.println(url);
    }


}
