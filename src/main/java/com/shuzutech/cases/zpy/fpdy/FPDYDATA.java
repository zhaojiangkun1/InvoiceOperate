package com.shuzutech.cases.zpy.fpdy;

import com.shuzutech.config.InterfaceNum;
import com.shuzutech.model.RequestInterface;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class FPDYDATA {

    /**
     * 本地打印插件接口
     * 清单打印和普通打印地址不一样
     * 这是宁波的打印接口，税控服务器调此打印接口
     * fpqqlsh，在fpdm和fphm为空时必传
     * 032001900104   49878372   线上的发票
     * 20192485 ZB 20192486
     * 01896725 NB
     * 清单打印 带上qdprint
     *
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    private static String top = "0";//上边距
    private static String left = "0";//左边距

    /**
     * 直接传打印数据
     * 打印清单： http://localhost:23333/printQD
     * 打印：http://localhost:23333/printZPP
     *
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    @Test
    public void localPrintData() throws IOException, NoSuchAlgorithmException {
//        String body = "{\"bz\":\"\",\"caId\":\"81\",\"chzt\":\"0\",\"del\":\"0\",\"fpdm\":\"050000000102\",\"fphm\":\"55504205\",\"fplx\":\"0\",\"fplxdm\":\"007\",\"fpqqlsh\":\"SZ202010130000000081\",\"fpzt\":\"0\",\"ghdwmc\":\"上海融族网络科技有限公司\",\"ghdwdzdh\":\"上海市浦东新区康威路1500号3幢1层103室02158958286\",\"ghdwsbh\":\"91310114MA1GU3NU72\",\"ghdwyhzh\":\"中国建设银行股份有限公司上海张江支行31050161393600001918\",\"hjje\":\"￥282.08\",\"hjse\":\"￥16.92\",\"jshj\":\"￥299.00\",\"jshjCN\":\"贰佰玖拾玖圆整\",\"id\":\"\",\"jqbh\":\"499000152157\",\"jqbm\":\"499000152157 成品油\",\"jym\":\"10555241786722868079\",\"kpfs\":\"0\",\"kpr\":\"管理员\",\"kprq\":\"2020年10月13日\",\"kprq2\":\"2020-10-13\",\"kprqstr\":\"2020-10-13 13:30:46\",\"phone\":\"0\",\"qdbz\":\"0\",\"skm\":\"034-526<9>\\/\\/34<089+3<1\\/4>26274-684\\/>54270>5*1>5+<73->9+30+*669-<\\/<+2727*-9>-8\\/->354\\/73-\\/\\/<*26001327\\/069\\/32*37<81\",\"skr\":\"\",\"success\":\"\",\"taxServer\":\"\",\"tspz\":\"\",\"x\":\"-15\",\"xfid\":\"125\",\"xhdwmc\":\"云票测试四十三\",\"xhdwsbh\":\"110101201707010043\",\"xhdwyhzh\":\"南京市工商银行 3201000323459889\",\"xhdwdzdh\":\"南京市高新技术产业开发区星火路11号动漫大厦B座2楼C-1室 025-68959525\",\"xs\":\"机器编码\",\"y\":\"20\",\"zfzt\":\"0\",\"zsfs\":\"0\",\"zyspmc\":\"服务费\",\"ewm\":\"iVBORw0KGgoAAAANSUhEUgAAAMgAAADICAIAAAAiOjnJAAAACXBIWXMAAA7EAAAOxAGVKw4bAAAEZklEQVR4nO3dwYqdMABA0Xbo\\/3\\/y0K2bgJJcjXLOsjjOY7ikIebFv7+\\/v39gtZ+nPwDfJCwSwiIhLBLCIiEsEsIiISwSwiIhLBLCIiEsEsIiISwSwiIhLBLCIiEsEsIiISwSwiIhLBLCIiEsEsIiISwSwiIhLBLCIiEsEsIiISwSwiLx755f8\\/OzvuAzZxEef+\\/x+qv\\/Prrnqs82+tmn\\/m7zjFgkhEVCWCRummMdzfwfP5pznJkbjT7D1XvOzJ9Gn+GM4u\\/WMWKREBYJYZF4YI51tGouMrrmzFrUzHrV1bWoVWtIxRxuLSMWCWGREBaJh+dYq8zMOc6sV129fzGvehcjFglhkRAWiY\\/Msa7Ob0bXr3o+OLOn6htzMiMWCWGREBaJh+dYdz47O\\/Ncb3T91WuurmN9bx5mxCIhLBLCIvHAHKvef331+4NHq+ZMIzP3uX\\/f+ow3fVZeRFgkhEXi7\\/4rIlftth98Zj3svYxYJIRFQlgkXnA+1qq9TTNrVzO\\/a+YsieLf72HEIiEsEsIi8fD5WDNnHxT7pVY9y5s5D6K4\\/v75lhGLhLBICIvERs8KZ+YoxTO4Vc\\/4drvmHkYsEsIiISwSLziD9GjVmQtXz3co7LPmVDBikRAWCWGR2HQd62jm2WJxzcide6H2n4cZsUgIi4SwSGx6Bumq9zQX79gZWbV3\\/oyZ8ynsx+LFhEVCWCQeWMea2VM1ur7Ybz4yc+b7zPX2Y4GwaAiLxKbfKxxdfzSzblTcc3T\\/HfZ+3c+IRUJYJIRF4gXnY83cpzgfa9W62lXFnrOOEYuEsEgIi8TD61hHM2dZje6\\/6l06Z9TvKDyq1+HmGbFICIuEsEhstB\\/raNXe9hnFWlRxnurVa+5hxCIhLBLCIvHw9wpX7aM6Ks6Ov3N9a\\/SzV3mXDh8kLBLCInHTOtaq79mtOsfhS+djjT7Ds4xYJIRFQlgkHp5jrXrn4NGd60xn7lPs0191\\/44Ri4SwSAiLxKZnkB6t2rtdfxdv1TV3nuPVMWKREBYJYZF4wX6sq+8fvPp7r36ekVXrYcUz0Pvt8jn4GGGREBaJTfdjjX52ZGbuNXPWw9X7jHxj7erIiEVCWCSERWKjd0LPKN5dU3yG4ruTxXcz5xmxSAiLhLBIvOyc96M7v693RnEu6Mxc0H4sPkhYJIRFYqNz3s+YeZ\\/0zJ704vz0+r03zsfig4RFQlgkHt7zXj87W3W21sw19bmj+7w\\/58iIRUJYJIRF4gVnN1x1Zr41uv7oqfcV1me03sOIRUJYJIRF4oNzrFXnJlydA606V6Je27uHEYuEsEgIi8RG52MVVq33rFoDW\\/XOxDOsY\\/FBwiIhLBIPzLGe2ic0sx+rOB+rOL9+n+eGRiwSwiIhLBIfOR+L3RixSAiLhLBICIuEsEgIi4SwSAiLhLBICIuEsEgIi4SwSAiLhLBICIuEsEgIi4SwSAiLhLBICIuEsEgIi4SwSAiLhLBICIuEsEgIi4SwSAiLhLBI\\/AfnpeNcMQwxNwAAAABJRU5ErkJggg==\",\"fhr\":\"\",\"fpMxList\":[{\"commodityId\":\"\",\"dj\":\"282.075472\",\"fphxz\":\"0\",\"hsbz\":\"\",\"id\":\"\",\"je\":\"282.08\",\"qdbz\":\"0\",\"se\":\"16.92\",\"ggxh\":\"\",\"dw\":\"\",\"sl\":\"6%\",\"spbm\":\"3040201040000000000\",\"spbmjc\":\"\",\"spmc\":\"*信息技术服务*服务费\",\"spsl\":\"1\",\"spsm\":\"\",\"yhzcbs\":\"0\",\"zzszyfpId\":\"\"}]}";
//        String body = "{\"bz\":\"\",\"caId\":\"81\",\"chzt\":\"0\",\"del\":\"0\",\"fpdm\":\"050000000011\",\"fphm\":\"49955147\",\"fplx\":\"0\",\"fplxdm\":\"007\",\"fpqqlsh\":\"SZ202101050000001459\",\"fpzt\":\"0\",\"hjje\":\"￥8.67\",\"hjse\":\"***\",\"jshj\":\"￥8.67\",\"jshjCN\":\"捌圆陆角柒分\",\"id\":\"\",\"jqbh\":\"499000152034\",\"jqbm\":\"499000152034\",\"jym\":\"14265 27436 10820 47934\",\"kpfs\":\"0\",\"kpr\":\"测试打印1\",\"kprq\":\"2021年01月05日\",\"kprq2\":\"2021-01-05\",\"kprqstr\":\"2021-01-05 14:23:41\",\"phone\":\"0\",\"qdbz\":\"0\",\"skm\":\"035*-8712<0086*9129>3190++36<43917*3-<>*8-+38>74+9<5*9><>7\\/2\\/+<4>22*975\\/801967\\/920\\/3\\/70477\\/-170103430632<7822-65\",\"skr\":\"测试打印3\",\"success\":\"\",\"taxServer\":\"\",\"tspz\":\"02\",\"x\":\"-20\",\"xfid\":\"125\",\"ghdwmc\":\"云票测试三十一\",\"ghdwdzdh\":\"南京市高新技术产业开发区星火路11号动漫大厦B座2楼C-1室 025-68959525\",\"ghdwsbh\":\"110101201707010031\",\"ghdwyhzh\":\"南京工商银行 3201000323459889\",\"xhdwmc\":\"南京大数据集团有限公司\",\"xhdwsbh\":\"91320100MA21QWGC0J\",\"xhdwyhzh\":\"\",\"xhdwdzdh\":\"\",\"xs\":\"机器编码\",\"y\":\"0\",\"zfzt\":\"0\",\"zsfs\":\"0\",\"zyspmc\":\"蛋糕\",\"ewm\":\"iVBORw0KGgoAAAANSUhEUgAAAMgAAADICAIAAAAiOjnJAAAACXBIWXMAAA7EAAAOxAGVKw4bAAAEh0lEQVR4nO3dwY7cKhRF0aT1\\/v+TW5nWxBI82DZlrTUsuW0rOiJXgC9\\/f39\\/\\/8BuP0+\\/AO8kWCQEi4RgkRAsEoJFQrBICBYJwSIhWCQEi4RgkRAsEoJFQrBICBYJwSIhWCQEi4RgkRAsEoJFQrBICBYJwSIhWCQEi4RgkRAsEoJFQrBICBYJwSLx3z2P+fnZn+CRXoSfz\\/28fuR9ZnsdXj1r5Pqr5z7177bOiEVCsEgIFombaqxPK\\/\\/HX9Ucs\\/XNrhro6veihiv+3TpGLBKCRUKwSDxQY33aVYuM1D1Xz72qjUZqpqvrZ++5Mmd25dkzR4xYJASLhGCReLjG2mWl5lipq0beZ7b+ewcjFgnBIiFYJF5SY83OD83WWyNG\\/vb8+addjFgkBIuEYJF4uMbaVU\\/Mzi1dWVk3XKnbZvdLnV+HGbFICBYJwSLxQI1V779e2QtV79Oq92Cd45velS8iWCQEi8Tf82dEZu3amzXyt7vmut7HiEVCsEgIFombaqyVOZiVflHFHNXsc2fVc2\\/3MGKRECwSgkXioHmsYu7nzrpkVw\\/SEbvqzo4Ri4RgkRAsEg\\/0eV\\/p4blrbmZXj\\/gTemKdM3f1yYhFQrBICBaJL9vzPrvnafZbv9n7z34zWPSMOJMRi4RgkRAsEg+fpbPSB6G4567eCiPPXblmpEZ8lhGLhGCRECwSh\\/bH2nVe8sq65K79WPW5zmd+22jEIiFYJASLxMN73lf2ie86G+fOuuTOPvL2Y\\/FCgkVCsEi8ZB5r5T4jv68o6sjzGbFICBYJwSLxBf2xrhT9C4r9+HXdNvIOV9d0jFgkBIuEYJH4grXClX1Od66pPbUfa\\/Yd1Fh8McEiIVgkHl4rvDLSH+vTVT0x+\\/3drvmh084r1OedlxAsEoJF4qAepCvzUrPXFP2xZq+ZfbdZztLhhQSLhGCRuKnGKtbjru6\\/sg9p13rfSn1zZ7+JjhGLhGCRECwSD+95X1lHe+rbw5H3Kd5\\/9por9mPxxQSLhGCROLTP+6ddveBn1yJXzisceW7xbePI\\/e9hxCIhWCQEi8RB\\/bF2rfGN3L8+T3r2b3fNtxXfMP4\\/p7wHLyNYJASLxJd9Vzhi1z7xkd+vnrtSMxVze\\/czYpEQLBKCReLh\\/li7rNRAI9fPvkO9X6roGbaXEYuEYJEQLBIP9G7YZeU8nF3rj1e\\/7+pVUXyfeA8jFgnBIiFYJB7e8z6r+JZwZU\\/YbJ+tlV5cs5ylwwsJFgnBIvHwfqxda1sje5uKemXk+rqf+5lnSBuxSAgWCcEiceie9xWza4V1f6yn9mNZK+SFBIuEYJF4YY1VrwOu1GQrc3Ir93GWDi8hWCQEi8RB\\/bHuvOfKXNdKj6vZ68\\/v537FiEVCsEgIFokHaqy6T+auemi2f9VsTbZrje\\/MdUMjFgnBIiFYJF7SH4vTGLFICBYJwSIhWCQEi4RgkRAsEoJFQrBICBYJwSIhWCQEi4RgkRAsEoJFQrBICBYJwSIhWCQEi4RgkRAsEoJFQrBICBYJwSIhWCQEi4RgkRAsEoJFQrBI\\/AOFvQcOCMNL9AAAAABJRU5ErkJggg==\",\"fhr\":\"测试打印2\",\"fpMxList\":[{\"commodityId\":\"\",\"dj\":\"8.67\",\"fphxz\":\"0\",\"hsbz\":\"\",\"id\":\"\",\"je\":\"8.67\",\"qdbz\":\"0\",\"se\":\"***\",\"ggxh\":\"\",\"dw\":\"1\",\"sl\":\"免税\",\"spbm\":\"1030299000000000000\",\"spbmjc\":\"\",\"spmc\":\"*其他食品*蛋糕\",\"spsl\":\"1\",\"spsm\":\"\",\"yhzcbs\":\"Y\",\"zzszyfpId\":\"\"}]}";
        //以下是打印清单的报文
//        String body = "{\"Fpdm\":\"050000000004\",\"Fphm\":\"99211302\",\"Fplxdm\":\"004\",\"Ghfmc\":\"龙岩鹭燕大药房有限公司九一分店\",\"Kprq\":\"2020年11月23日\",\"Xsfmc\":\"云票测试四十一\",\"list\":[{\"Dj\":\"100.000000\",\"Dw\":\"个\",\"Ggxh\":\"个\",\"Je\":100,\"Name\":\"*商用设备*餐饮服务用机械\",\"Num\":\"1\",\"Se\":0,\"Sl\":0},{\"Dj\":\"100.000000\",\"Dw\":\"个\",\"Ggxh\":\"个\",\"Je\":100,\"Name\":\"*商用设备*餐饮服务用机械\",\"Num\":\"1\",\"Se\":0,\"Sl\":0},{\"Dj\":\"100.000000\",\"Dw\":\"个\",\"Ggxh\":\"个\",\"Je\":100,\"Name\":\"*商用设备*餐饮服务用机械\",\"Num\":\"1\",\"Se\":0,\"Sl\":0},{\"Dj\":\"100.000000\",\"Dw\":\"个\",\"Ggxh\":\"个\",\"Je\":100,\"Name\":\"*商用设备*餐饮服务用机械\",\"Num\":\"1\",\"Se\":0,\"Sl\":0},{\"Dj\":\"100.000000\",\"Dw\":\"个\",\"Ggxh\":\"个\",\"Je\":100,\"Name\":\"*商用设备*餐饮服务用机械\",\"Num\":\"1\",\"Se\":0,\"Sl\":0},{\"Dj\":\"100.000000\",\"Dw\":\"个\",\"Ggxh\":\"个\",\"Je\":100,\"Name\":\"*商用设备*餐饮服务用机械\",\"Num\":\"1\",\"Se\":0,\"Sl\":0},{\"Dj\":\"100.000000\",\"Dw\":\"个\",\"Ggxh\":\"个\",\"Je\":100,\"Name\":\"*商用设备*餐饮服务用机械\",\"Num\":\"1\",\"Se\":0,\"Sl\":0},{\"Dj\":\"100.000000\",\"Dw\":\"个\",\"Ggxh\":\"个\",\"Je\":100,\"Name\":\"*商用设备*餐饮服务用机械\",\"Num\":\"1\",\"Se\":0,\"Sl\":0},{\"Dj\":\"100.000000\",\"Dw\":\"个\",\"Ggxh\":\"个\",\"Je\":100,\"Name\":\"*商用设备*餐饮服务用机械\",\"Num\":\"1\",\"Se\":0,\"Sl\":0},{\"Dj\":\"100.000000\",\"Dw\":\"个\",\"Ggxh\":\"个\",\"Je\":100,\"Name\":\"*商用设备*餐饮服务用机械\",\"Num\":\"1\",\"Se\":0,\"Sl\":0}]}";
        String body = "{\"Fpdm\":\"1200211130\",\"Fphm\":\"15222961\",\"Fplxdm\":true,\"Ghfmc\":\"天津大沽贸易有限公司\",\"Kprq\":\"2021年06月29日\",\"Xsfmc\":\"天津渤化物产商贸有限公司\",\"x\":\"-2\",\"y\":\"0\",\"list\":[{\"Dj\":\"1606.19469027\",\"Dw\":\"\",\"Ggxh\":\"0.49\",\"Je\":\"361435.57\",\"Name\":\"*无机化学原料*液碱\",\"Num\":\"225.026\",\"Se\":\"46986.62\",\"Sl\":\"13%\"},{\"Dj\":\"1606.19469027\",\"Dw\":\"\",\"Ggxh\":\"0.49\",\"Je\":\"359079.28\",\"Name\":\"*无机化学原料*液碱\",\"Num\":\"223.559\",\"Se\":\"46680.31\",\"Sl\":\"13%\"},{\"Dj\":\"1606.19469027\",\"Dw\":\"\",\"Ggxh\":\"0.49\",\"Je\":\"357095.63\",\"Name\":\"*无机化学原料*液碱\",\"Num\":\"222.324\",\"Se\":\"46422.43\",\"Sl\":\"13%\"},{\"Dj\":\"1606.19469027\",\"Dw\":\"\",\"Ggxh\":\"0.49\",\"Je\":\"336729.08\",\"Name\":\"*无机化学原料*液碱\",\"Num\":\"209.644\",\"Se\":\"43774.78\",\"Sl\":\"13%\"},{\"Dj\":\"1606.19469027\",\"Dw\":\"\",\"Ggxh\":\"0.49\",\"Je\":\"192492.80\",\"Name\":\"*无机化学原料*液碱\",\"Num\":\"119.844\",\"Se\":\"25024.06\",\"Sl\":\"13%\"},{\"Dj\":\"1606.19469027\",\"Dw\":\"\",\"Ggxh\":\"0.49\",\"Je\":\"434480.49\",\"Name\":\"*无机化学原料*液碱\",\"Num\":\"270.503\",\"Se\":\"56482.46\",\"Sl\":\"13%\"},{\"Dj\":\"1606.19469027\",\"Dw\":\"\",\"Ggxh\":\"0.49\",\"Je\":\"432765.07\",\"Name\":\"*无机化学原料*液碱\",\"Num\":\"269.435\",\"Se\":\"56259.46\",\"Sl\":\"13%\"},{\"Dj\":\"1606.19469027\",\"Dw\":\"\",\"Ggxh\":\"0.49\",\"Je\":\"433720.75\",\"Name\":\"*无机化学原料*液碱\",\"Num\":\"270.03\",\"Se\":\"56383.70\",\"Sl\":\"13%\"},{\"Dj\":\"1606.19460504\",\"Dw\":\"\",\"Ggxh\":\"0.49\",\"Je\":\"288612.29\",\"Name\":\"*无机化学原料*液碱\",\"Num\":\"179.687\",\"Se\":\"37519.60\",\"Sl\":\"13%\"}]}";
        System.out.println(body);
        String url = "http://localhost:23333/printQD";
        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(url);
        StringEntity entity = new StringEntity(body, "utf-8");
        entity.setContentEncoding("UTF-8");
        entity.setContentType("application/json");
        post.setEntity(entity);
        HttpResponse response = client.execute(post);
        String result = EntityUtils.toString(response.getEntity(), "utf-8");
        System.out.println(result);
    }

    @Test
    public void printdata() throws IOException, NoSuchAlgorithmException {
        String body = body("", "051002100205", "02945976", "0");
        int code = RequestInterface.requestInteface(body, InterfaceNum.PRINTPRO);
        Assert.assertEquals(code, 0);
    }

    /**
     * 带清单打印
     *
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */

    @Test
    public void qdprintdata() throws IOException, NoSuchAlgorithmException {
        String body = body("", "033001850204", "22160071", "1");
        int code = RequestInterface.requestInteface(body, InterfaceNum.PRINTQDDEV);
        Assert.assertEquals(code, 0);
    }


    public String body(String fpqqlsh, String fpdm, String fphm, String qdbz) {
        String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?><business id=\"FPDYDATA\"><body><input>" +
                "<fpqqlsh>" + fpqqlsh + "</fpqqlsh>" +
                "<fpdm>" + fpdm + "</fpdm>" +
                "<fphm>" + fphm + "</fphm>" +
                "<qdbz>" + qdbz + "</qdbz>" +
                "<left>" + left + "</left>" +
                "<top>" + top + "</top>" +
                "</input></body></business>";
        return body;
    }
}
