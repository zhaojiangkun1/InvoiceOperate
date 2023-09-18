package com.shuzutech.cases;

import com.shuzutech.config.Md5;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5String {


    public static String getMD5Str(String str) {
        byte[] digest = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("md5");
            digest = md5.digest(str.getBytes("utf-8"));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //16是表示转换为16进制数
        String md5Str = new BigInteger(1, digest).toString(16);
        return md5Str;
    }

    public static void main(String[] args) {
        String str = "[{\"billDetails\":[{\"addTaxManager\":\"\",\"favourableFlag\":\"0\",\"goodsCode\":\"3049900000000000000\",\"goodsCodeSelf\":\"zxbm\",\"goodsModel\":\"\",\"goodsName\":\"*现代服务*代理费\",\"goodsNum\":\"1\",\"goodsPrice\":\"4431.00\",\"goodsTax\":\"spsm\",\"goodsUnit\":\"\",\"sendBillCompanyProperty\":\"0\",\"sumPrice\":\"4431.00\",\"taxPrice\":\"250.81\",\"taxRate\":\"0.06\",\"taxRateFlag\":\"\"}],\"billNote\":\"7-9月前返\",\"billType\":\"0\",\"billTypeCode\":\"004\",\"buyCompanyAdrTel\":\"厦门市湖里区花屿路3号厦航新生产基地机务工程大楼2层2250592-7308218\",\"buyCompanyBankCode\":\"中国银行厦门机场支行426058368730\",\"buyCompanyCode\":\"9135020015499233XE\",\"buyCompanyName\":\"厦门航空有限公司\",\"oldSerialNum\":\"FP202111161008423328\",\"originalOrderNum\":\"FP202111161008423328\",\"phoneSk\":\"18112996615\",\"shnsrsbh\":\"913201136673802400\",\"storeCode\":\"\"}]20211116151431c440f117c85dc0e8fb4fb9eddd44b4d8";
        try {
            String contendMd5 = Md5.EncoderByMd5(str);
            System.out.println(contendMd5);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }


}
