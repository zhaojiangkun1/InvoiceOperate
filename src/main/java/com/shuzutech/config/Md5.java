package com.shuzutech.config;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;


public class Md5 {
    /**
     * 利用MD5进行加密
     */
    public static String EncoderByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        //确定计算方法
        MessageDigest md5 = MessageDigest.getInstance("MD5");
//        BASE64Encoder base64en = new BASE64Encoder();
//        String encodeStr=DigestUtils.md5Hex(str);
//        String newstr = base64en.encode();
        //加密后的字符串
//        String newstr= Base64.encode(md5.digest(str.getBytes("utf-8")));

        md5.update(str.getBytes("utf-8"));
        byte[] b = md5.digest();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            int v = (int) b[i];
            v = v < 0 ? 0x100 + v : v;
            String cc = Integer.toHexString(v);
            if (cc.length() == 1)
                sb.append('0');
            sb.append(cc);
        }
//            System.out.println("MD5:" + sb.toString());
        String encodeToString = Base64.getEncoder().encodeToString(sb.toString().getBytes("utf-8"));
        return encodeToString;

    }

    /**
     * 判断用户密码是否正确
     * newpasswd  用户输入的密码
     * oldpasswd  正确密码
     */
    public static boolean checkpassword(String newpasswd, String oldpasswd) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        if (EncoderByMd5(newpasswd).equals(oldpasswd))
            return true;
        else
            return false;
    }

    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        String str = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><business id=\"FPDYDATA\"><body><input><fpqqlsh></fpqqlsh><fpdm>1500000368</fpdm><top>10</top><left>0</left><fphm>00009416</fphm><qdbz>0</qdbz></input></body></business>2021-07-13 05:18:256728043eaea0a29bc4806ae2b43b63bc";
        System.out.println("加密后的文件:"+EncoderByMd5(str));
    }
}
