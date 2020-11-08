package com.thoughtworks.capability.demospringioccontainer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Bar {

    @Autowired
    private Foo foo;


    public void hi() {
        System.out.println("Hi, " + foo.name());
    }

    public String name() {
        return "Bar";
    }
}
