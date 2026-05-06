package org.web;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService
public interface Calculator_Interface {
    @WebMethod
    public int add(int a,int b);
}
