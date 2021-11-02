package com.shuzutech.bean;

import java.util.Date;
import java.util.Objects;


public class AppInfo {
    private int id;
    private String appId;
    private String appSecret;
    private String accessToken;
    private Date updateTime;
    private String address;
    private String env;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppInfo appInfo = (AppInfo) o;
        return id == appInfo.id &&
                Objects.equals(appId, appInfo.appId) &&
                Objects.equals(appSecret, appInfo.appSecret) &&
                Objects.equals(accessToken, appInfo.accessToken) &&
                Objects.equals(updateTime, appInfo.updateTime) &&
                Objects.equals(address, appInfo.address) &&
                Objects.equals(env, appInfo.env);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, appId, appSecret, accessToken, updateTime, address, env);
    }

    @Override
    public String toString() {
        return "AppInfo{" +
                "id=" + id +
                ", appId='" + appId + '\'' +
                ", appSecret='" + appSecret + '\'' +
                ", accessToken='" + accessToken + '\'' +
                ", updateTime=" + updateTime +
                ", address='" + address + '\'' +
                ", env='" + env + '\'' +
                '}';
    }
}
