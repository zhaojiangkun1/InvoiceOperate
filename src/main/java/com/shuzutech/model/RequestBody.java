package com.shuzutech.model;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.XMLOutputter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class RequestBody {
    public static String getRequestBody(String id, Element inputs,String ... version) throws IOException {
        Element business = new Element("business");
        business.setAttribute("id", id);
        if (version.length>0){
            business.setAttribute("version","2.0");
        }
        Document document = new Document(business);
        Element body = new Element("body");
        Element input = inputs;
        body.addContent(input);
        business.addContent(body);
        ByteArrayOutputStream byteRep = new ByteArrayOutputStream();
        XMLOutputter docWriter = new XMLOutputter();
        docWriter.output(document, byteRep);
        String strXml = byteRep.toString();
        return strXml;
    }
}
