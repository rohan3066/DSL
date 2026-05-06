package org.web;

import jakarta.xml.ws.Endpoint;

public class CalculatorPublisher {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/calculator",new Calculator_imp());
        System.out.println("Web service started..............");
    }

}
