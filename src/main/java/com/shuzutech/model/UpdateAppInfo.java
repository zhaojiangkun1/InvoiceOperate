package com.shuzutech.model;

import com.shuzutech.bean.AppInfo;
import com.shuzutech.config.DataBaseUtil;
import com.shuzutech.config.InterfaceNum;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.Date;

public class UpdateAppInfo {

    public static void updateAppInfo(String accessToken, Date date, InterfaceNum num) throws IOException {
        SqlSession session = DataBaseUtil.getSqlSession();
        AppInfo appInfo = new AppInfo();
        appInfo.setAccessToken(accessToken);
        appInfo.setUpdateTime(date);
        if (num == InterfaceNum.DEV) {
            appInfo.setId(3);
        }
        if (num == InterfaceNum.PRO) {
            appInfo.setId(1);
        }
        if (num == InterfaceNum.TEST) {
            appInfo.setId(2);
        }
        if (num == InterfaceNum.DEV1) {
            appInfo.setId(6);
        }
        if (num == InterfaceNum.TEST1) {
            appInfo.setId(4);
        }
        session.update("updateAppInfo", appInfo);
        session.commit();
    }

}
