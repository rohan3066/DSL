package org.web;

import jakarta.xml.ws.Endpoint;

public class NameAppendPublisher {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9090/append",new NameAppendImp());
        System.out.println("Name append server running....");
    }
}
