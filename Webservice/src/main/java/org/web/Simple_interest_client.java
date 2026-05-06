package org.web;

import jakarta.xml.ws.Service;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;

public class Simple_interest_client {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://localhost:5050/interest?wsdl");
        QName qName = new QName("http://web.org/","SimpleInterestService");
        Service service =Service.create(url, qName);
        Simple_interest_interface sn=service.getPort(Simple_interest_interface.class);
        System.out.println(sn.find_simple_interest(10000,1.2,2));

    }



}
