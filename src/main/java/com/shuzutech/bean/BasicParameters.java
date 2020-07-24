package com.shuzutech.bean;

import com.shuzutech.config.InterfaceNum;

import java.util.HashMap;

public class BasicParameters {

    public static InterfaceNum num = InterfaceNum.DEV;
    public static InterfaceNum bwt_num = InterfaceNum.BAIWANGTONGTEST;
    /**
     * 110101201707010064~~499000152528
     * 110101201601010075~~A20017260026921
     * 110101201707010037~~A10016420000196
     * 500102010001448
     * 110101201707010043
     * 110101201707010064
     * 91320594346148467C
     * 110101201707010057~~499000152456
     * 商客汇Ukey：91320594MA1MECA285~~537100950610
     * 91320191MA1ML4CL25~~661826092245  主盘
     * 91320191MA1ML4CL25~~661921253676  分盘
     * 增加了nsrsbh   110101201707010043   91510107690912532D
     * 110101201707010031~~499000152034
     * 110101201707010041~~499000152131
     * 110101201707010041~~A10016420000196
     * 110101201701010023~~499000150987
     * 110101201707010043~~499000152157
     * 661921253676
     */
    public static String jsbh = "110101201707010043~~499000152157";
    public static String nsrsbh = "110101201707010043";
    public static String skph = "499000152157";

    public static String bwt_nsrsbh = "110101201707010041";
    public static String bwt_kpzdbs = "499000152131";
    public static String bwt_dzfplxdm = "026";
    public static String bwt_zpfplxdm = "007";
    public static String bwt_jpfplxdm = "025";
    public static String bwt_zzfplxdm = "004";

    public static String xhdwdzdh = "南京市江北新区新科二路2号南大软件学院222D室 02558801191";
    public static String xhdwyhzh = "中国农业银行股份有限公司南京茶亭东街支行 10107501040008319";

    public static HashMap<String,String> hashMap(){
        HashMap<String,String> map = new HashMap<>();
        map.put("jsbh",jsbh);
        map.put("nsrsbh",nsrsbh);
        return map;
    }

}
