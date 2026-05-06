package org.web;

import jakarta.jws.WebService;

@WebService(endpointInterface = "org.web.Simple_interest_interface")
public class SimpleInterest implements Simple_interest_interface {
    @Override
    public double find_simple_interest(double p, double r, double t) {
        return (p*r*t)/100;
    }
}
