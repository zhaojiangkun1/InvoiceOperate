package com.shuzutech.cases.zpy.spgl;

import com.shuzutech.bean.BasicParameters;
import com.shuzutech.config.InterfaceNum;
import com.shuzutech.model.RequestInterface;
import org.apache.http.conn.HttpHostConnectException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class SPBMSC {
    /**
     * 客户调用此接口删除自行编码
     * 机身编号和税号二选一
     * <p>
     * 1）bm为空
     * 2）jsbh和税号为空
     * 3）jsbh为空
     * 4）税号为空
     * 5）税号或者jsbh错误
     *
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */

    @Test
    public void spbmsc() throws IOException, NoSuchAlgorithmException {
        String[] bm = {"10604020200000000003596254"};
        for (int i=0;i<bm.length;i++){
            String body = body(bm[i], "", BasicParameters.nsrsbh);
            try{
                int code = RequestInterface.requestInteface(body, InterfaceNum.DEV);
                Assert.assertEquals(code, 0);
            }catch (HttpHostConnectException e){
                e.printStackTrace();
            }

        }


    }

    public String body(String bm, String jsbh, String nsrsbh) {
        String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?><business id=\"SPBMSC\"><body><input><bm>" + bm + "</bm><jsbh>" + jsbh + "</jsbh><nsrsbh>" + nsrsbh + "</nsrsbh></input></body></business>";
        return body;
    }
}
