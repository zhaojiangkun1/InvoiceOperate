package com.shuzutech.cases.fpdy;

import com.shuzutech.bean.BasicParameters;
import com.shuzutech.model.RequestInterface;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class FPBD {
    /**
     * 对于税控盒子和卷票打印机，客户可以调用该接口进行发票的打印，不支持电子票的打印。打印返回成功后，调用发票打印查询接口获取打印结果。
     * 税控服务器不调这个接口
     * 税控盒子连接平推打印机
     * 110101201707010057
     * 110101201707010041
     * 91320594346148467C
     * 91320191MA1ML4CL25~~661921253676
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */

    private static String nsrsbh = BasicParameters.nsrsbh;

    /**
     * 尤其要关注一税号多盘情况，如果是一税号多盘，看看有没有问题
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    @Test(groups = {"发票补打"})
    public void fpbd() throws IOException, NoSuchAlgorithmException {
        String body = body("","007","050000000102","99129884");
        int code = RequestInterface.requestInteface(body, BasicParameters.num);
        Assert.assertEquals(code,0);
    }

    public String body(String jsbh,String fplxdm,String fpdm,String fphm){
        String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?><business id=\"FPBD\"><body><input><jsbh>"+jsbh+
                "</jsbh><nsrsbh>"+nsrsbh+"</nsrsbh><fplxdm>"+fplxdm+"</fplxdm><fpdm>"+fpdm+"</fpdm><fphm>"+fphm+"</fphm></input></body></business>";
        return body;
    }
}
