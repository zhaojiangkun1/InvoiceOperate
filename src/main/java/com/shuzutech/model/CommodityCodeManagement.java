package com.shuzutech.model;

import com.shuzutech.bean.BasicParameters;
import org.jdom.Element;
import java.util.HashMap;

public class CommodityCodeManagement {
    public static Element input = new Element("input");

    public static Element ssbmqqInput(String bh){
        Element bbh = new Element("bbh");
        input.addContent(bbh.setText(bh));
        return input;
    }

    public static Element spbmscAndSpbmmrzInput(HashMap<String,String>... maps){
        HashMap<String,String> map = new HashMap<>();
        if (maps.length == 1)
            map=maps[0];
        Element bm = new Element("bm");
        Element kpzdbs = new Element("kpzdbs");
        Element nsrsbh = new Element("nsrsbh");
        input.addContent(bm.setText(""));
        input.addContent(kpzdbs.setText(BasicParameters.bwt_kpzdbs));
        input.addContent(nsrsbh.setText(""));
        if (map.containsKey("bm")) bm.setText(map.get("bm"));
        if (map.containsKey("kpzdbs")) kpzdbs.setText(map.get("kpzdbs"));
        if (map.containsKey("nsrsbh")) nsrsbh.setText(map.get("nsrsbh"));
        return input;
    }

    public static Element spbmInput(HashMap<String, String>... maps){
        HashMap<String,String> map = new HashMap<>();
        if (maps.length == 1)
            map=maps[0];
        Element nsrsbh = new Element("nsrsbh");
        Element kpzdbs = new Element("kpzdbs");
        Element whbz = new Element("whbz");
        input.addContent(nsrsbh.setText(""));
        input.addContent(kpzdbs.setText(BasicParameters.bwt_kpzdbs));
        input.addContent(whbz.setText(""));
        if (map.containsKey("nsrsbh")) nsrsbh.setText(map.get("nsrsbh"));
        if (map.containsKey("kpzdbs")) kpzdbs.setText(map.get("kpzdbs"));
        if (map.containsKey("whbz")) whbz.setText(map.get("whbz"));
        return input;
    }

    public static Element spbmszInput(HashMap<String, String>... maps) {
        HashMap<String,String> map = new HashMap<>();
        if (maps.length == 1)
            map=maps[0];
        Element kpzdbs = new Element("kpzdbs");
        input.addContent(kpzdbs.setText(BasicParameters.bwt_kpzdbs));

        if (map.containsKey("kpzdbs")) kpzdbs.setText(map.get("kpzdbs"));

        Element nsrsbh = new Element("nsrsbh");
        input.addContent(nsrsbh.setText(""));
        if (map.containsKey("nsrsbh")) nsrsbh.setText(map.get("nsrsbh"));

        Element bm = new Element("bm");
        input.addContent(bm.setText(""));//bm为空，是创建，bm传之前的值为修改
        if (map.containsKey("bm")) bm.setText(map.get("bm"));

        Element pid = new Element("pid");
        input.addContent(pid.setText("1010303020100000000"));
        if (map.containsKey("pid")) pid.setText(map.get("pid"));

        Element mc = new Element("mc");
        input.addContent(mc.setText("鹅蛋"));
        if (map.containsKey("mc")) mc.setText(map.get("mc"));

        Element spbmjc = new Element("spbmjc");
        input.addContent(spbmjc.setText("畜禽产品"));
        if (map.containsKey("spbmjc")) spbmjc.setText(map.get("spbmjc"));

        Element sm = new Element("sm");
        input.addContent(sm.setText(""));//说明
        if (map.containsKey("sm")) sm.setText(map.get("sm"));

        Element zzstsgl = new Element("zzstsgl");
        input.addContent(zzstsgl.setText(""));
        if (map.containsKey("zzstsgl")) zzstsgl.setText(map.get("zzstsgl"));

        Element zzszcyj = new Element("zzszcyj");//增值税政策依据
        input.addContent(zzszcyj.setText(""));
        if (map.containsKey("zzszcyj")) zzszcyj.setText(map.get("zzszcyj"));

        Element zzstsgldm = new Element("zzstsgldm");//增值税特殊内容代码
        input.addContent(zzstsgldm.setText(""));
        if (map.containsKey("zzstsgldm")) zzstsgldm.setText(map.get("zzstsgldm"));

        Element xfsgl = new Element("xfsgl");
        input.addContent(xfsgl.setText(""));//消费税管理
        if (map.containsKey("xfsgl")) xfsgl.setText(map.get("xfsgl"));

        Element xfszcyj = new Element("xfszcyj");//消费税政策依据
        input.addContent(xfszcyj.setText(""));
        if (map.containsKey("xfszcyj")) xfszcyj.setText(map.get("xfszcyj"));

        Element xfstsgldm = new Element("xfstsgldm");//消费税特殊内容代码
        input.addContent(xfstsgldm.setText(""));
        if (map.containsKey("xfstsgldm")) xfstsgldm.setText(map.get("xfstsgldm"));

        Element gjz = new Element("gjz");//关键字
        input.addContent(gjz.setText(""));
        if (map.containsKey("gjz")) gjz.setText(map.get("gjz"));

        Element kyzt = new Element("kyzt");
        input.addContent(kyzt.setText("Y"));//可用状态，Y可用，N不可用
        if (map.containsKey("kyzt")) kyzt.setText(map.get("kyzt"));

        Element bb = new Element("bb");
        input.addContent(bb.setText(""));
        if (map.containsKey("bb")) bb.setText(map.get("bb"));

        Element gdqjzsj = new Element("gdqjzsj");//过渡期截至日期
        input.addContent(gdqjzsj.setText(""));
        if (map.containsKey("gdqjzsj")) gdqjzsj.setText(map.get("gdqjzsj"));

        Element qysj = new Element("qysj");//商品编码或商品编码表的启用时间
        input.addContent(qysj.setText(""));
        if (map.containsKey("qysj")) qysj.setText(map.get("qysj"));

        Element gxsj = new Element("gxsj");
        input.addContent(gxsj.setText(""));
        if (map.containsKey("gxsj")) gxsj.setText(map.get("gxsj"));

        Element yhlx = new Element("yhlx");
        input.addContent(yhlx.setText(""));
        if (map.containsKey("yhlx")) yhlx.setText(map.get("yhlx"));

        Element mslx = new Element("mslx");
        input.addContent(mslx.setText(""));
        if (map.containsKey("mslx")) mslx.setText(map.get("mslx"));

        Element kysl = new Element("kysl");
        input.addContent(kysl.setText("0、0.03、0.09"));
        if (map.containsKey("kysl")) kysl.setText(map.get("kysl"));

        Element sl = new Element("sl");
        input.addContent(sl.setText("0.03"));
        if (map.containsKey("sl")) sl.setText(map.get("sl"));

        Element ggxh = new Element("ggxh");
        input.addContent(ggxh.setText(""));
        if (map.containsKey("ggxh")) ggxh.setText(map.get("ggxh"));

        Element jldw = new Element("jldw");//计量单位
        input.addContent(jldw.setText(""));
        if (map.containsKey("jldw")) jldw.setText(map.get("jldw"));

        Element dj = new Element("dj");
        input.addContent(dj.setText("20"));
        if (map.containsKey("dj")) dj.setText(map.get("dj"));

        Element hsbz = new Element("hsbz");
        input.addContent(hsbz.setText(""));
        if (map.containsKey("hsbz")) hsbz.setText(map.get("hsbz"));

        Element zzssl = new Element("zzssl");
        input.addContent(zzssl.setText("0.09"));
        if (map.containsKey("zzssl")) zzssl.setText(map.get("zzssl"));

        Element hgpm = new Element("hgpm");//海关进出口商品品目
        input.addContent(hgpm.setText(""));
        if (map.containsKey("hgpm")) hgpm.setText(map.get("hgpm"));

        Element gmtjdm = new Element("gmtjdm");
        input.addContent(gmtjdm.setText(""));//国民统计代码
        if (map.containsKey("gmtjdm")) gmtjdm.setText(map.get("gmtjdm"));
        return input;
    }

}
