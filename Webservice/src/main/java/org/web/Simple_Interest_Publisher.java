package org.web;


import jakarta.xml.ws.Endpoint;

public class Simple_Interest_Publisher {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:5050/interest",new SimpleInterest());
        System.out.println("Simple Interest web service created.....");

    }


}
