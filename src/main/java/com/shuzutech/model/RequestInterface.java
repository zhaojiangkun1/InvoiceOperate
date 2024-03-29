package com.shuzutech.model;

import com.shuzutech.config.InterfaceNum;
import com.shuzutech.config.Md5;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

public class RequestInterface {

    public static int requestInteface(String body, InterfaceNum num,String ... params) throws IOException, NoSuchAlgorithmException {
        String url = PostRequestAddr.postRequestAddr(num).getAddress();
        if (params.length != 0) {
            url = "http://47.103.25.205:10001/invoiceEx/zpy/commodity/aiCodingBatch";
//            url = "https://paymgmt.shuzutech.com/invoiceEx/zpy/commodity/aiCodingBatch";
        }
        System.out.println("本次POST请求的url:" + url);
        String accessToken = GetAccessToken.getToken(num);
//        String accessToken = "069b4ad39f1c7ec5215a85a167536a40";
        System.out.println("本次请求的Token：" + accessToken);
        System.out.println("本次请求的body:" + body);
        Date date = new Date();
        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(url);
        String contendMd5 = Md5.EncoderByMd5(body + date.toString() + accessToken);
        System.out.println("md5:"+contendMd5);
        StringEntity entity = new StringEntity(body, "utf-8");
        entity.setContentEncoding("UTF-8");
        if (params.length == 0) {
            entity.setContentType("application/x-www-form-urlencoded");
        }else {
            entity.setContentType("application/json");
        }
        post.setEntity(entity);
        if (num == InterfaceNum.DEV || num == InterfaceNum.PRO || num == InterfaceNum.TEST || num == InterfaceNum.DEV1 ||
                num == InterfaceNum.TEST1 || num.toString().contains("BAIWANGTONG") || num == InterfaceNum.DEVCY) {
            post.setHeader("Date", date.toString());
//            if (num.toString().contains("BAIWANGTONG")) {
//                System.out.println("version:2.0.0");
//                post.setHeader("version", "2.0.0");
//            }
        } else {
            post.setHeader("SDate", date.toString());
            System.out.println("SDate:" + date.toString());
        }
        System.out.println("本次请求的APPID：" + GetAppInfo.getAppInfo(num).getAppId());
        post.setHeader("APPID", GetAppInfo.getAppInfo(num).getAppId());
//        post.setHeader("APPID","391788ee4d28c675b2bd0da8545bea29");
        post.setHeader("Content-MD5", contendMd5);
        System.out.println("Content-MD5:" + contendMd5);
        HttpResponse response = client.execute(post);
        String result = EntityUtils.toString(response.getEntity(), "utf-8");
        System.out.println(result);
        String leftTag = "<returncode>";
        String rightTag = "</returncode>";
        int returncode = 0;
        String envNum = num.toString();
        if (envNum.contains("DEV") || envNum.contains("TEST") || envNum.contains("BAIWANGTONG") || envNum.contains("PRO")) {
            if (envNum.contains("CY")) {
                returncode = 0;
            } else {
                try {
                    String code = result.substring(result.indexOf(leftTag) + leftTag.length(), result.indexOf(rightTag));
//                System.out.println("code:"+code);
                    returncode = Integer.valueOf(code);
                } catch (StringIndexOutOfBoundsException ex) {
                    System.out.println("数组越界错误！");
                }
            }


        }
        return returncode;
    }
}
