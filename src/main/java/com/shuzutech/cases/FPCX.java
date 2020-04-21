package com.shuzutech.cases;

import com.shuzutech.bean.TestEnvironment;
import com.shuzutech.model.RequestInterface;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class FPCX {

    /**
    private String jsbh;
    private String fplxdm;//非必填
    private String nsrsbh;//jsbh和纳税人识别号至少填一个
    private int cxfs;//0:按照发票号码查询
    private String cxtj;//1：按照请求流水号查询
     */

    /**
     * 按照纳税人识别号查询
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */


    @Test(groups = {"发票查询"},description = "根据纳税人识别号查询")
    public void fpcx() throws IOException, NoSuchAlgorithmException {
        String body = requestBody("","110101201707010057","026",1,"GH78620200403104208");
        int code = RequestInterface.requestInteface(body, TestEnvironment.num);
        Assert.assertEquals(code,0);
    }

    /**
     * 按照机身编号查询
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */

    @Test(groups = {"发票查询"})
    public void fpcx1() throws IOException, NoSuchAlgorithmException {
        String body = requestBody("110101201707010057~~499000152456","","026",1,"93620200402180116");
        int code = RequestInterface.requestInteface(body,TestEnvironment.num);
        Assert.assertEquals(code,0);
    }

    /**
     * 纳税人识别号和机身编号都同时存在（这种方式是肯定能查出来的，稍微有点冗余）
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    @Test(groups = {"发票查询"})
    public void fpcx2() throws IOException, NoSuchAlgorithmException {
        String body = requestBody("110101201707010057~~499000152456","","026",0,"iW71220200402175438");
        int code = RequestInterface.requestInteface(body,TestEnvironment.num);
        Assert.assertEquals(code,0);
    }

    /**
     * 按照机身编号、发票代码、发票号码查询
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    @Test(groups = {"发票查询"})
    public void fpcx3() throws IOException, NoSuchAlgorithmException {
        String body = requestBody("91320191MA1ML4CL25~~661826092245","","004",0,"320019113044738271");
        int code = RequestInterface.requestInteface(body,TestEnvironment.num);
        Assert.assertEquals(code,0);
    }

    /**
     * 纳税人识别号、发票代码、发票号码查询
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    @Test(groups = {"发票查询"})
    public void fpcx4() throws IOException, NoSuchAlgorithmException {
        String body = requestBody("","91320191MA1ML4CL25","026",0,"GH78620200403104208");
        int code = RequestInterface.requestInteface(body,TestEnvironment.num);
        Assert.assertEquals(code,0);
    }


    /**
     * 机身编码和纳税人识别号都为空，错误码：10001；returnmsg：jsbh,nsrsbh:参数错误
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    @Test(groups = {"发票查询"})
    public void fpcx5() throws IOException, NoSuchAlgorithmException {
        String body = requestBody("","","026",1,"28820190906110002");
        int code = RequestInterface.requestInteface(body,TestEnvironment.num);
        Assert.assertEquals(code,10001);
    }

    /**
     * jsbh错误（是指jsbh不存在，如果是机身编号的~~前的纳税人识别号正确，则是能够查出来的，如果该纳税人识别号不存在则无法查询到结果），纳税人识别号为空
     * 以下案例是jsbh前的纳税人识别号不存在
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */

    @Test(groups = {"发票查询"})
    public void fpcx6() throws IOException, NoSuchAlgorithmException {
        String body = requestBody("91320191MA1ML4CL35~~12345623423","","026",1,"28820190906110002");
        int code = RequestInterface.requestInteface(body,TestEnvironment.num);
        Assert.assertEquals(code,1000009);
    }


    public static String requestBody(String jsbh,String nsrsbh,String fplxdm,int cxfs,String cxtj){
        String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?><business id=\"FPCX\"><body><input><jsbh>"+jsbh+"</jsbh><nsrsbh>"
                +nsrsbh+"</nsrsbh><fplxdm>"+fplxdm+"</fplxdm><cxfs>"+cxfs+"</cxfs><cxtj>"+cxtj+"</cxtj></input></body></business>";
        return body;
    }


}
