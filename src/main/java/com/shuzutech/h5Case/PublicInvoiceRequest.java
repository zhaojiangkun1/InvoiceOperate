package com.shuzutech.h5Case;

public class PublicInvoiceRequest {

    public static String invoiceRequest(String uri, String appId, String encryptMsg) {
        String url = "";
        url = uri + "?appId=" + appId + "&encryptMsg=" + encryptMsg + "&version=1.0.0"+"&returnURL=https://www.shuzutech.com/pc/";
        return url;
    }
}
