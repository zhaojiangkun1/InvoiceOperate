package com.shuzutech.model;

import com.shuzutech.config.InterfaceNum;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Date;

public class GetAccessToken {

    public static String getAccessToken(InterfaceNum num) throws IndexOutOfBoundsException,IOException {
        String accessToken="";
        String appId = GetAppInfo.getAppInfo(num).getAppId();
        String appSecret = GetAppInfo.getAppInfo(num).getAppSecret();
        String address = GetAppInfo.getAppInfo(num).getAddress();
        String url = address + "?&appId="+appId+"&appSecret="+appSecret;
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet(url);
        HttpResponse response = client.execute(httpGet);
        String result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
        String leftTag = "<access_token>";
        String rightTag = "</access_token>";
        accessToken = result.substring(result.indexOf(leftTag)+leftTag.length(),result.indexOf(rightTag));
        return accessToken;
    }

    public static String getToken(InterfaceNum num) throws IOException {
        String access_toekn="";
        Date updateTime = GetAppInfo.getAppInfo(num).getUpdateTime();
        System.out.println("之前的时间："+updateTime);
        Date current_Time = new Date();
        System.out.println("当前的时间:"+current_Time);
        long diffSec = (current_Time.getTime()-updateTime.getTime())/1000;
        System.out.println("时间差："+diffSec);
        if (diffSec > 7200){
            access_toekn = getAccessToken(num);
            UpdateAppInfo.updateAppInfo(access_toekn,current_Time,num);
        }else {
            access_toekn = GetAppInfo.getAppInfo(num).getAccessToken();
        }
        return access_toekn;
    }

}
