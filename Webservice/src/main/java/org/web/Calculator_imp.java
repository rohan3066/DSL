package org.web;

import jakarta.jws.WebService;

@WebService(endpointInterface = "org.web.Calculator_Interface")
public class Calculator_imp implements  Calculator_Interface {
    @Override
    public int add(int a, int b) {
        return a+b;
    }
}
