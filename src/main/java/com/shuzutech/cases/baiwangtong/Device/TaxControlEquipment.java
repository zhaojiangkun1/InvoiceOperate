package com.shuzutech.cases.baiwangtong.Device;

import com.shuzutech.bean.BasicParameters;
import com.shuzutech.config.Md5;
import com.shuzutech.model.RequestBody;
import com.shuzutech.model.RequestInterface;
import com.shuzutech.model.ZpyInputManagement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public class TaxControlEquipment {
    private static String shnsrsbh = BasicParameters.bwt_nsrsbh;

    /**
     * 税控设备查询，封装旺企云的getTemianlDevice接口
     * 实现逻辑：看着像是先调了getTemianlDevice接口，然后又调了一遍sysTerminal接口（该接口只用于同步新增）？？？
     * 同步终端接口需要确认一下
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    @Test
    public void taxControlEquipment() throws IOException, NoSuchAlgorithmException {
        String body = RequestBody.getRequestBody("TaxControlEquipment", ZpyInputManagement.taxControlEquipment(shnsrsbh),"2.0");
        int code = RequestInterface.requestInteface(body, BasicParameters.bwt_num);
        Assert.assertEquals(code, 0);
    }
    @Test
    public void testContentMd5(){
        String content = "<?xml version=\"1.0\" encoding=\"utf-8\"?><business id=\"TaxControlEquipment\"  version=\"2.0\"><body><input><shnsrsbh>110101201707010037 </shnsrsbh></input></body></business>2021-09-225f545c5c954cd8259f8601392de7489e";
        try {
            String contendMd5 = Md5.EncoderByMd5(content);
            System.out.println(contendMd5);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
