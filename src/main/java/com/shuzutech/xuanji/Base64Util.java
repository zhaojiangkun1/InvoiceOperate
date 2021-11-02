package com.shuzutech.xuanji;

import java.util.Base64;

public class Base64Util {
    public static String base64Decode(String encode) {
        byte[] decoded = Base64.getDecoder().decode(encode);
        String decodeStr = new String(decoded);

        return decodeStr;
    }

    public static String base64Encode(String decode) {
        byte[] bytes = decode.getBytes();
        String encode = Base64.getEncoder().encodeToString(bytes);
        return encode;

    }


    public static void main(String[] args) {
        String encode = "PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0idXRmLTgiPz48YnVzaW5lc3MgaWQ9IkZIWFgiIGNvbW1lbnQ9Iui/lOWbnuS/oeaBryI+PGJvZHk+PHJldHVybmNvZGU+MTAwMDEyPC9yZXR1cm5jb2RlPjxyZXR1cm5tc2c+5byA56Wo5piO57uG5Lit5YyF5ZCrR0JL5peg5rOV57yW56CB5a2X56ymLOivt+ajgOafpe+8gTwvcmV0dXJubXNnPjwvYm9keT48L2J1c2luZXNzPg==";
        System.out.println("解密后的文件:" + base64Decode(encode));
    }
}
