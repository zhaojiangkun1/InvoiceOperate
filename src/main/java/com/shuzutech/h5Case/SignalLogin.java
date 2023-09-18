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

    @Test
    public void test123() throws UnsupportedEncodingException {
        String encryptMsg = "8k5H8Zbwl0dmuzvVCuow2kP/CvPmr4IHFdz0e0eOvxi8oW67N/1MyvLPoFe7AJBI4jntCEqkfX+nfz8j3WSvZw==";
        String encryptMsg_urlEncode = URLEncoder.encode(encryptMsg, "UTF-8");
        System.out.println(encryptMsg_urlEncode);
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
    public void test2() throws UnsupportedEncodingException {
        String urlEncode = "MGZmMjZkMDUzNDJlMTZkODllODJmZjI2YjkwYzEwM2Q=";
        System.out.println(URLEncoder.encode(urlEncode, "UTF-8"));
    }

    @Test
    public void test1(){
        String encryptMsg_urlEncode = "";
        String msg = "ESHPAW9Z7wn956%2FMWVTs3MlxqOFVqnk%2FNnRCE9egI65MjZlmgRgllT9R%2BZLYpLRm";
        try {
          encryptMsg_urlEncode = URLEncoder.encode(msg, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(encryptMsg_urlEncode);
        String PrivateKey = ("MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDxG4CRbxJRE6vp\n" +
                "9XWowZ4DAyN/nBwQTZZWkcNZbwZ/Wbv4k3CC/I0Skly9DTWYL8mxG1Bg/Yd9KlSm\n" +
                "DjOK1yuyfGZAw+2K0I+ZVTRA6loQNiJukcaHHKQOtJwqjtEQsItk4r3LMb7hK/Ic\n" +
                "KCCaxXr9lbr4v+sN36O0xaxszMb30+WBhclYlvlMzXtTV/d1RffoI7Jc0ydwTcbr\n" +
                "xgDBIdYo/vQ67bApF+dJN8M+fNbdQCZmtHQa7Q+hpfHZEB02Vj2w2lTO2liLr6eh\n" +
                "W3ks/ZcOmYWnzyQ6Kcmcpy506YLuvTqg711K9qWOesPorzfKdHh+hgDv1LkUbTPK\n" +
                "PjppuELVAgMBAAECggEAVmsnH/mRtSG54reqHnyXaDj9xkVsAaPtmMXSIQIccBT3\n" +
                "vNcL4scmwVtYhiJv7UZjomlJ3BnDMGe1w3cfnkoVTXotJFWVlMXAUpMpkYLuGRVu\n" +
                "LfduEwt++g5eUxqxcKv2qohiwqvn4MlhlBoF5bOWq8G5LGONmoFoKekYLj8Pqc/F\n" +
                "NJdfqFum9z4GtxTrrGzKxibIduT2rNOH8xBDI6tP2CUerAAccYM7+66GWj+xo4NE\n" +
                "29vLVjntCO06YZhJgHqtTMIZrT17yvzpb3wvrrf7+K0yjUKnM9alH2j4ScLBfboo\n" +
                "L/ddssxtvrgsGVc+6Ga28P6QQN7hpOGTl/BA1JyOgQKBgQD+Gz6MRHx2Y3XtcmKr\n" +
                "H/1mEY7DtlhucBWQT5XJ1MgWRyG7bY5HFcy76ZF7nr/2TISSSWlC9u1hFlOMytaS\n" +
                "4GQMWclWyBy+uth+IY5JgPOiIOYcB2+mvUEh6BBSAWFBHAcBYYSjlXMJZoClexwE\n" +
                "iz2Ig4J0yAjbyy+IT0FkLJ6s0QKBgQDy53W6Uv53dWVDwi98k3Ep28vD+ewzMcLD\n" +
                "6Q/0GIyKa95/vNeoLiwX1X9qjitX2DGPHFlvEHSQEDvuGmFDcfPfm/5Uab/g0twg\n" +
                "iVo9kX6PgI2Pe2SbeX0JBrewoeHOKmGWtbYfimCe49eP/j7d5UlMGIKKyddNTQq/\n" +
                "frHZNyJmxQKBgQDuSH4O6uoL2pjrYShFcGofHLfTr1qdtV2DRh4gdfhra6imKcYR\n" +
                "ws+KJyzVz7gTLw3iYBTlRsizEkym6k7szJ8FNe0oA99wu6XoIW9cXiAZGOCvyAlb\n" +
                "Qn2hXgxv2ftpIu8uzFOlUq/dUNGyXA+Z8zhwm2HqQOqNsauRF0EqvuzNAQKBgAJI\n" +
                "eqrNrOaii9kfMiMRn7atAjVNXBL/HL2Kq0O4F1oVuXmp5L0H8hInR5NQ0sd4mL6n\n" +
                "nY+VsALKpEWQqelgYNJxPOq+M7eBQ+Bqaha6D1557tqyZjev5KT5EzDt1JmDfHdW\n" +
                "LegN/OqBab1Ivn6HcTDt6gwz6XoohzlVj4ZjJkehAoGAGsmYyfZon3W16VFAYutk\n" +
                "JRjoCmUwewdKorL4xgY9lWk6iBXjGHDOguu0b/Dl7IsASTyzXf0OWp042y3jxZ3u\n" +
                "iaQQHis/MIXUJ0zu847Vm3eNVh9J+s0Sn9r3xjQjVG9lqaTYlDGo46Li1CE8sULg\n" +
                "iVDjCi7S71KdKsbSyqbWRc4=");
        System.out.println(PrivateKey);

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
