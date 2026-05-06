package org.web;

import jakarta.xml.ws.Service;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;

public class NameAppendClient {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://localhost:9090/append?wsdl");
        QName qName = new QName("http://web.org/","NameAppendImpService");
        Service service = Service.create(url,qName);
        NameAppendInterface np=service.getPort(NameAppendInterface.class);
        System.out.println(np.name_append("Rohan"));
    }
}
