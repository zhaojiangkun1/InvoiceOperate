package com.shuzutech.model;

import com.shuzutech.bean.SaveAddr;
import com.shuzutech.config.DataBaseUtil;
import com.shuzutech.config.InterfaceNum;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

public class PostRequestAddr {

    public static SaveAddr postRequestAddr(InterfaceNum num) throws IOException {
        SqlSession session = DataBaseUtil.getSqlSession();
        SaveAddr addr = new SaveAddr();
        if (num == InterfaceNum.TEST || num == InterfaceNum.TEST1 ){
            addr = session.selectOne("postAddr",2);
        }
        if (num == InterfaceNum.PRO){
            addr = session.selectOne("postAddr",1);
        }
        if (num == InterfaceNum.DEV || num == InterfaceNum.DEV1){
            addr = session.selectOne("postAddr",3);
        }
        if (num == InterfaceNum.PRINTDEV||num == InterfaceNum.PRINTPRO||num ==InterfaceNum.PRINTTEST){
            addr = session.selectOne("postAddr",4);
        }
        if (num == InterfaceNum.PRINTQDDEV||num == InterfaceNum.PRINTQDPRO||num==InterfaceNum.PRINTQDTEST){
            addr = session.selectOne("postAddr",5);
        }
        return addr;
    }
}
