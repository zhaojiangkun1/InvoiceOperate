package com.shuzutech.model;

import com.shuzutech.config.InterfaceNum;
import com.shuzutech.config.Md5;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

public class SsbmRequest {

    public static String requestInteface(String body, InterfaceNum num) throws IOException, NoSuchAlgorithmException {
        String url = PostRequestAddr.postRequestAddr(num).getAddress();
        System.out.println("本次POST请求的url:" + url);
        String accessToken = GetAccessToken.getToken(num);
        System.out.println("本次请求的Token：" + accessToken);
        System.out.println("本次请求的body:" + body);
        Date date = new Date();
        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(url);
        String contendMd5 = Md5.EncoderByMd5(body + date.toString() + accessToken);
        StringEntity entity = new StringEntity(body, "utf-8");
        entity.setContentEncoding("UTF-8");
        entity.setContentType("application/x-www-form-urlencoded");
        post.setEntity(entity);
        if (num == InterfaceNum.DEV || num == InterfaceNum.PRO || num == InterfaceNum.TEST || num == InterfaceNum.DEV1) {
            post.setHeader("Date", date.toString());
        } else {
            post.setHeader("SDate", date.toString());
        }
        System.out.println("本次请求的APPID：" + GetAppInfo.getAppInfo(num).getAppId());
        post.setHeader("APPID", GetAppInfo.getAppInfo(num).getAppId());
        post.setHeader("Content-MD5", contendMd5);
        HttpResponse response = client.execute(post);
        String result = EntityUtils.toString(response.getEntity(), "utf-8");
        write(result);
        return result;
    }

    public static void write(String result) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\IdeaProjects\\InvoiceOperter\\src\\main\\resources\\ssbqq.xml"));
        bw.write(result);
        bw.newLine();
        bw.close();
        System.out.println("写入成功");
    }

}
