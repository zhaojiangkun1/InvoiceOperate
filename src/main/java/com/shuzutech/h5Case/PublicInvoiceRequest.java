package com.shuzutech.h5Case;

public class PublicInvoiceRequest {

    public static String invoiceRequest(String uri,String appId,String encryptMsg){
        String url="";
        url = uri + "?appId="+appId+"&encryptMsg="+encryptMsg+"&returnURL=http://www.shuzutech.com/";
        return url;
    }
}
