package org.web;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService
public interface Simple_interest_interface {
    @WebMethod
    double find_simple_interest(double p,double r,double t);
}
