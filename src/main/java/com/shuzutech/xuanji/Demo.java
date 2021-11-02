package com.shuzutech.xuanji;

import javax.net.ssl.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.security.cert.X509Certificate;

public class Demo {
    public static void main(String[] args) {
        String str = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<business id=\"SBBD\">\n" +
                "\t<body>\n" +
                "\t\t<input>\n" +
                "\t\t\t<sqm>TFnjzxtsmjJEwxcS7+LJIRt2t7gMJx3NirVLLZxxhD1zRXrm+nyJsQ==</sqm>\n" +
                "\t\t\t<czlx>1</czlx>\n" +
                "\t\t\t<shsh  count='1'>\n" +
                "\t\t\t\t<group xh='1'>\n" +
                "\t\t\t\t\t<nsrsbh>462836160575319554</nsrsbh>\n" +
                "\t\t\t\t</group>\n" +
                "\t\t\t</shsh>\n" +
                "\t\t</input>\n" +
                "\t</body>\n" +
                "</business>";
        String b = sendHtpps(str);
        System.out.println(Base64Util.base64Decode(b));
    }

    private final static HostnameVerifier DO_NOT_VERIFY = new HostnameVerifier() {
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    };

    private static void trustAllHosts() {
        // Create a trust manager that does not validate certificate chains
        TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return new java.security.cert.X509Certificate[]{};
            }

            public void checkClientTrusted(X509Certificate[] chain, String authType) {
            }

            public void checkServerTrusted(X509Certificate[] chain, String authType) {
            }
        }};
        // Install the all-trusting trust manager
        try {
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String sendHtpps(String a) {
        String result = "";
        PrintWriter out = null;
        BufferedReader in = null;
        try {
            trustAllHosts();
            URL realUrl = new URL("https://api.yunpiao.net/openNozzle");
            HttpsURLConnection conn = (HttpsURLConnection) realUrl.openConnection();
            conn.setHostnameVerifier(DO_NOT_VERIFY);
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            conn.setRequestProperty("Content-Type", "text/plain;charset=utf-8");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(a);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {// 使用finally块来关闭输出流、输入流
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }
}
