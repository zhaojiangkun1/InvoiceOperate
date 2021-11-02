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
import java.text.SimpleDateFormat;
import java.util.Date;

public class H5MakeInvoice {
    /**
     * 110101201707010041~~499000152131
     */

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyymmddHHMMss");
    String date = simpleDateFormat.format(new Date());
    private static InterfaceNum num = InterfaceNum.PRO;
    private static String type = "2";
    private static String UA = "PC"; //PC端  其他是手机端
    private static String kplx = "0";
    private static String fplxdm = "026";
    private static String shnsrsbh = BasicParameters.nsrsbh;
    private static String je="50";
    private static String operator = "操作人";
    private static String terminalKey = "";
    private static String yfpdm = "";
    private static String yfphm = "";

    /**
     * H5页面开票
     */
    @Test
    public void makeInvoice() throws IOException {
        String fpqqlsh = "SZ" + date;
        System.out.println("本次请求的发票请求流水号:" + fpqqlsh);
        String inRe = "type="+type+"&"+"UA=" + UA + "&" + "fpqqlsh=" + fpqqlsh + "&" + "kplx=" + kplx + "&" + "fplxdm=" + fplxdm + "&" + "shnsrsbh=" + shnsrsbh + "&" + "operator=" + operator + "&" + "terminalKey=" + terminalKey +
                "&" + "yfpdm=" + yfpdm + "&" + "yfphm=" + yfphm+"&"+"je="+je;
        String accessToken = GetAccessToken.getToken(num);
        AppInfo appInfo = GetAppInfo.getAppInfo(num);
        String appId = appInfo.getAppId();
        String encodeResult = java.util.Base64.getEncoder().encodeToString(new Encrypt().aesEncrypt(inRe, accessToken).getBytes("utf-8"));
        String uri = GetRequestAddr.getRequestAddr(num) + "/invoice/h5/invoice";
        String url = PublicInvoiceRequest.invoiceRequest(uri, appId, encodeResult);
        System.out.println(url);
    }

    /**
     * 离线自助开票
     * base64_encode(aes(明文，secrt前32位做密钥))
     * AES-ECB加密算法
     * @throws IOException
     */
    @Test
    public void h5SelfOfflineInvoice() throws IOException {
        String uri = GetRequestAddr.getRequestAddr(num) + "/invoice/h5/selfService";
//        String fpqqlsh = "SZ" + date;
        String fpqqlsh = "LSKP0062202012280001";
        System.out.println("fpqqlsh:" + fpqqlsh);
        String inRe = "&type=" + "2" + "&" + "UA=" + UA + "&" + "fpqqlsh=" + fpqqlsh;
//        String accessToken = GetAccessToken.getToken(num);
        AppInfo appInfo = GetAppInfo.getAppInfo(num);
//        String appId = appInfo.getAppId();
        String appId = "db8e8051a01c22183564b97984977f04";
//        String appSecret = appInfo.getAppSecret();
        String appSecret = "e6169f9e95cf4446c21c11d4e4c611100ab2473d";
//        System.out.println("++++++"+appSecret);
        System.out.println("===="+appSecret.substring(0,32));
        System.out.println("待加密的data："+inRe);
        String encodeResult = java.util.Base64.getEncoder().encodeToString(new Encrypt().aesEncrypt(inRe, appSecret.substring(0,32)).getBytes("utf-8"));
        System.out.println("加密后的内容:"+encodeResult);
        String url = PublicInvoiceRequest.invoiceRequest(uri, appId, encodeResult);
        System.out.println(url);
    }

    @Test
    public void test1() throws UnsupportedEncodingException {
        String data = "type=2&UA=Chrome&fpqqlsh=LSKP0062202012280001";
        String appSecret = "e6169f9e95cf4446c21c11d4e4c611100ab2473d";
        System.out.println(appSecret.substring(0,32));
        String encodeResult = java.util.Base64.getEncoder().encodeToString(new Encrypt().aesEncrypt(data, appSecret.substring(0,32)).getBytes("utf-8"));
        System.out.println("加密后的数据:"+encodeResult);
    }


}
