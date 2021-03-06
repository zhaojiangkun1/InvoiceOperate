package com.shuzutech.model;


import com.shuzutech.bean.BasicParameters;
import org.jdom.Element;

import java.util.HashMap;

public class ZpyInputManagement {

    public static Element taxControlEquipment(String nsrsbh) {
        Element input = new Element("input");
        Element shnsrsbh = new Element("shnsrsbh");
        input.addContent(shnsrsbh.setText(nsrsbh));
        return input;
    }

    public static Element getTerminalInfo(String nsrsbh, String kpzdbs) {
        Element input = new Element("input");
        Element shnsrsbh = new Element("shnsrsbh");
        Element deviceNo = new Element("deviceNo");
        input.addContent(shnsrsbh.setText(nsrsbh));
        input.addContent(deviceNo.setText(kpzdbs));
        return input;
    }

    public static Element qyxxsz(HashMap<String, String>... maps) {
        Element kpzdbs = new Element("kpzdbs");
        Element input = new Element("input");
        HashMap<String, String> map = new HashMap<>();
        Element deviceNo = new Element("deviceNo");
//        Element kpzdbs = new Element("kpzdbs");
        Element xhdwdzdh = new Element("xhdwdzdh");
        Element xhdwyhzh = new Element("xhdwyhzh");
        input.addContent(deviceNo.setText(BasicParameters.bwt_kpzdbs));
        input.addContent(kpzdbs.setText(BasicParameters.bwt_kpzdbs));
        input.addContent(xhdwdzdh.setText(BasicParameters.xhdwdzdh));
        input.addContent(xhdwyhzh.setText(BasicParameters.xhdwyhzh));
        if (maps.length > 0)
            map = maps[0];
        if (map.containsKey("deviceNo")) deviceNo.setText(map.get("deviceNo"));
        if (map.containsKey("kpzdbs")) kpzdbs.setText(map.get("kpzdbs"));
        if (map.containsKey("xhdwdzdh")) xhdwdzdh.setText(map.get("xhdwdzdh"));
        if (map.containsKey("xhdwyhzh")) xhdwyhzh.setText(map.get("xhdwyhzh"));
        return input;
    }

    public static Element zndy(HashMap<String, String>... maps) {
        Element kpzdbs = new Element("kpzdbs");
        Element input = new Element("input");
        Element nsrsbh = new Element("nsrsbh");
        HashMap<String, String> map = new HashMap<>();
//        Element kpzdbs = new Element("kpzdbs");
//        Element nsrsbh = new Element("nsrsbh");
        Element fplxdm = new Element("fplxdm");
        Element fpqqlsh = new Element("fpqqlsh");
        Element fpdm = new Element("fpdm");
        Element fphm = new Element("fphm");
        Element dylx = new Element("dylx");
        Element dyfs = new Element("dyfs");
        Element printername = new Element("printername");
        input.addContent(kpzdbs.setText(BasicParameters.bwt_kpzdbs));
        input.addContent(nsrsbh.setText(""));
        input.addContent(fplxdm.setText(BasicParameters.bwt_zpfplxdm));
        input.addContent(fpqqlsh.setText(""));
        input.addContent(fpdm.setText(""));
        input.addContent(fphm.setText(""));
        input.addContent(dylx.setText("0"));
        input.addContent(dyfs.setText(""));
        input.addContent(printername.setText(""));
        if (maps.length > 0)
            map = maps[0];
        if (map.containsKey("kpzdbs")) kpzdbs.setText(map.get("kpzdbs"));
        if (map.containsKey("nsrsbh")) nsrsbh.setText(map.get("nsrsbh"));
        if (map.containsKey("fplxdm")) fplxdm.setText(map.get("fplxdm"));
        if (map.containsKey("fpqqlsh")) fpqqlsh.setText(map.get("fpqqlsh"));
        if (map.containsKey("fpdm")) fpdm.setText(map.get("fpdm"));
        if (map.containsKey("fphm")) fphm.setText(map.get("fphm"));
        if (map.containsKey("dylx")) dylx.setText(map.get("dylx"));
        if (map.containsKey("dyfs")) dyfs.setText(map.get("dyfs"));
        if (map.containsKey("printername")) printername.setText(map.get("printername"));
        return input;
    }

    public static Element fpdycx(HashMap<String, String>... maps) {
        Element kpzdbs = new Element("kpzdbs");
        Element input = new Element("input");
        Element cxtj = new Element("cxtj");
        Element shnsrsbh = new Element("shnsrsbh");
        input.addContent(shnsrsbh.setText(""));
        input.addContent(kpzdbs.setText(BasicParameters.bwt_kpzdbs));
        input.addContent(cxtj.setText(""));
        HashMap<String, String> map = new HashMap<>();
        if (maps.length > 0)
            map = maps[0];
        if (map.containsKey("shnsrsbh")) shnsrsbh.setText(map.get("shnsrsbh"));
        if (map.containsKey("kpzdbs")) kpzdbs.setText(map.get("kpzdbs"));
        if (map.containsKey("cxtj")) cxtj.setText(map.get("cxtj"));
        return input;
    }

    public static Element terminalManage(String snsrsbh) {
        Element input = new Element("input");
        Element nsrsbh = new Element("nsrsbh");
        input.addContent(nsrsbh.setText(snsrsbh));
        return input;
    }

    public static Element cxsbzt(HashMap<String, String> map) {
        Element input = new Element("input");
        Element jsbh = new Element("jsbh");
        Element kpzdbs = new Element("kpzdbs");
        Element nsrsbh = new Element("nsrsbh");
        input.addContent(nsrsbh.setText(""));
        if (map.containsKey("jsbh")) input.addContent(jsbh.setText(map.get("jsbh")));
        if (map.containsKey("kpzdbsh")) input.addContent(kpzdbs.setText(map.get("kpzdbs")));
        if (map.containsKey("nsrsbh")) nsrsbh.setText(map.get("nsrsbh"));
        return input;
    }

    public static Element dqfpxx(HashMap<String,String> map) {
        Element input = new Element("input");
        Element jsbh = new Element("jsbh");
        Element kpzdbs = new Element("kpzdbs");
        Element nsrsbh = new Element("nsrsbh");
        Element fplxdm = new Element("fplxdm");
        input.addContent(nsrsbh.setText(""));
        input.addContent(fplxdm.setText(""));
        if (map.containsKey("jsbh")) input.addContent(jsbh.setText(map.get("jsbh")));
        if (map.containsKey("kpzdbsh")) input.addContent(kpzdbs.setText(map.get("kpzdbs")));
        if (map.containsKey("nsrsbh")) nsrsbh.setText(map.get("nsrsbh"));
        if (map.containsKey("fplxdm")) fplxdm.setText(map.get("fplxdm"));
        return input;
    }

}
