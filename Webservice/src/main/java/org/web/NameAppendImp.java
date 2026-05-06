package org.web;

import jakarta.jws.WebService;

@WebService(endpointInterface = "org.web.NameAppendInterface")
public class NameAppendImp implements NameAppendInterface{
    @Override
    public String name_append(String name) {
        return "Hello "+name;
    }
}
