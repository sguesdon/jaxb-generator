package org.sguesdon.jaxbgenerator;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class TestAdapter {
    public static Object unmarshal(String v) {
        return new Object();
    }
    public static String marshal(Object v) {
        try {
            XmlMapper mapper = new XmlMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            return mapper.writeValueAsString(v);
        } catch(Exception err) {

        }
        return "";
    }
}
