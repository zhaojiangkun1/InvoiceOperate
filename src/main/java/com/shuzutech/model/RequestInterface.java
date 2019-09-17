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

    public static int requestInteface(String body,InterfaceNum num) throws IOException, NoSuchAlgorithmException {
        String url = PostRequestAddr.postRequestAddr(num).getAddress();
        System.out.println("本次POST请求的url:"+url);
        String accessToken = GetAccessToken.getToken(num);
        System.out.println("本次请求的Token："+accessToken);
        System.out.println("本次请求的body:"+body);
        Date date = new Date();
        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(url);
        String contendMd5 = Md5.EncoderByMd5(body+date.toString()+accessToken);
        StringEntity entity = new StringEntity(body,"utf-8");
        entity.setContentEncoding("UTF-8");
        entity.setContentType("application/x-www-form-urlencoded");
        post.setEntity(entity);
        if (num == InterfaceNum.DEV||num==InterfaceNum.PRO||num==InterfaceNum.TEST){
            post.setHeader("Date",date.toString());
        }else {
            post.setHeader("SDate",date.toString());
        }
        post.setHeader("APPID",GetAppInfo.getAppInfo(num).getAppId());
        post.setHeader("Content-MD5",contendMd5);
        HttpResponse response = client.execute(post);
        String result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
        String leftTag = "<returncode>";
        String rightTag = "</returncode>";
        int returncode = 0;
        if (num == InterfaceNum.DEV||num==InterfaceNum.PRO||num==InterfaceNum.TEST){
            String code = result.substring(result.indexOf(leftTag)+leftTag.length(),result.indexOf(rightTag));
            returncode = Integer.valueOf(code);
        }
        return returncode;
    }
}
