package com.shuzutech.cases.zpy.spgl;

import com.shuzutech.config.InterfaceNum;
import com.shuzutech.model.RequestInterface;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class SPBMSZ {
    /**
     * 对商户的开票商品编码信息进行添加，修改等操作。
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */

    @Test
    public void spbmsz() throws IOException, NoSuchAlgorithmException {
        String body = body();
        int code = RequestInterface.requestInteface(body, InterfaceNum.DEV);
        Assert.assertEquals(code,0);
    }

    public String body(){
        String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<business id=\"SPBMSZ\">\n" +
                "    <body>\n" +
                "        <input>\n" +
                "            <jsbh>110101201707010041~~499000152131</jsbh>\n" +
                "            <nsrsbh></nsrsbh>\n" +
                "            <bm></bm>\n" +
                "            <pid>1010303020100000000</pid>\n" +
                "            <mc>鸡蛋</mc>\n" +
                "            <spbmjc>畜禽产品</spbmjc>\n" +
                "            <sm></sm>\n" +
                "            <zzstsgl></zzstsgl>\n" +
                "            <zzszcyj></zzszcyj>\n" +
                "            <zzstsgldm></zzstsgldm>\n" +
                "            <xfsgl></xfsgl>\n" +
                "            <xfszcyj></xfszcyj>\n" +
                "            <xfstsgldm></xfstsgldm>\n" +
                "            <gjz></gjz>\n" +
                "            <kyzt>Y</kyzt>\n" +
                "            <bb>32.0</bb>\n" +
                "            <gdqjzsj></gdqjzsj>\n" +
                "            <qysj></qysj>\n" +
                "            <gxsj></gxsj>\n" +
                "            <yhlx></yhlx>\n" +
                "            <mslx>2</mslx>\n" +
                "            <kysl>0、0.03、0.09</kysl>\n" +
                "            <sl>0</sl>\n" +
                "            <ggxh></ggxh>\n" +
                "            <jldw></jldw>\n" +
                "            <dj>20</dj>\n" +
                "            <hsbz></hsbz>\n" +
                "            <zzssl>0.09</zzssl>\n" +
                "            <hgpm></hgpm>\n" +
                "            <gmtjdm></gmtjdm>\n" +
                "        </input>\n" +
                "    </body>\n" +
                "</business>\n";

        return body;
    }
}
