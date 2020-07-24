package com.shuzutech.model;

import com.shuzutech.bean.AppInfo;
import com.shuzutech.config.DataBaseUtil;
import com.shuzutech.config.InterfaceNum;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GetAppInfo {


    public static AppInfo getAppInfo(InterfaceNum num) throws IOException {
        SqlSession session = DataBaseUtil.getSqlSession();
        AppInfo appInfo = new AppInfo();
        if (num.toString().contains("TEST")) {
            if (num == InterfaceNum.TEST1) {
                appInfo = session.selectOne("getAppInfo", 4);
            } else {
                appInfo = session.selectOne("getAppInfo", 2);
            }
        }
        if (num.toString().contains("PRO")) {
            appInfo = session.selectOne("getAppInfo", 1);
        }
        if (num.toString().contains("DEV")) {
            if (num == InterfaceNum.DEV1) {
                appInfo = session.selectOne("getAppInfo", 6);
            } else {
                appInfo = session.selectOne("getAppInfo", 3);
            }
        }
        return appInfo;
    }

    @Test
    public void test() throws IOException, ParseException {
        AppInfo appInfo = getAppInfo(InterfaceNum.PRINTPRO);
        System.out.println("appid:" + appInfo.getAppId());
        System.out.println("appSecrest:" + appInfo.getAccessToken());
        System.out.println("updateTime:" + appInfo.getUpdateTime());
        System.out.println("address:" + appInfo.getAddress());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(simpleDateFormat.format(new Date()));
        System.out.println("当前时间为：" + date);
        System.out.println("当前时间为：" + new Date().toString());
        System.out.println("更新后的accessToken：" + GetAccessToken.getToken(InterfaceNum.PRINTPRO));
        System.out.println("accessToken:" + appInfo.getAccessToken());
    }


}
