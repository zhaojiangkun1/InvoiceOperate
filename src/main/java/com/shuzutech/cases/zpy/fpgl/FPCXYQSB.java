package com.shuzutech.cases.zpy.fpgl;

import com.shuzutech.bean.BasicParameters;
import com.shuzutech.model.RequestInterface;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class FPCXYQSB {

    @Test
    public void fpcxyqsb(){
        String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?><business id=\"FPCXYQSB\"><body><input><jsbh>91410400MA44AF8559~~587013654885</jsbh><fplxdm>026</fplxdm></input></body></business>";
        int code = 0;
        try {
            code = RequestInterface.requestInteface(body, BasicParameters.num);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(code, 0);
    }
}
