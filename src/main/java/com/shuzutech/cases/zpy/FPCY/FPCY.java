package com.shuzutech.cases.zpy.FPCY;

import com.shuzutech.config.InterfaceNum;
import com.shuzutech.model.RequestInterface;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class FPCY {

    @Test
    public void testFPCY(){
        String json = "{\n" +
                "\t\"serviceId\": \"FPCY\",\n" +
                "    \"fplx\": \"10\",\n" +
                "   \"fphm\": \"67962584\",\n" +
                "    \"fpdm\": \"045001900121\",\n" +
                "    \"kprq\": \"20210235\",\n" +
                "    \"jym\": \"155789\",\n" +
                "    \"fpje\": 50.78\n" +
                "}\n";
        try {
            RequestInterface.requestInteface(json, InterfaceNum.DEVCY);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

    }
}
