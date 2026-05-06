package org.web;



import jakarta.xml.ws.Service;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;

public class Calculator_Client {

    public static void main(String[] args) throws MalformedURLException {
        URL url=new URL("http://localhost:8080/calculator?wsdl");
        QName qName = new QName("http://web.org/",
                "Calculator_impService");
        Service service= Service.create(url,qName);
        Calculator_Interface cal= service.getPort(Calculator_Interface.class);
        System.out.println(cal.add(45,20));
    }
}
