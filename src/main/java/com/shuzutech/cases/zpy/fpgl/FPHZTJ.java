package com.shuzutech.cases.zpy.fpgl;

import com.shuzutech.bean.BasicParameters;
import com.shuzutech.model.RequestInterface;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class FPHZTJ {

    @Test
    public void fphztj() throws IOException, NoSuchAlgorithmException {
        String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?> <business id=\"FPHZTJ\"><body><input><nsrsbh>440301999999111</nsrsbh><fplxdm>026</fplxdm><sl></sl><month>1~7</month><year>2022</year><skph>661030040546</skph></input></body></business>";
        RequestInterface.requestInteface(body, BasicParameters.num);
    }
}
