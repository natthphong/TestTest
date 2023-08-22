package com.auth2.azuread.controller.rest;


import jakarta.xml.bind.annotation.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


@Component
@XmlRootElement(name = "Envelope" ,namespace = "http://schemas.xmlsoap.org/soap/envelope/")
//@XmlAccessorType(XmlAccessType.FIELD)
//@XmlJavaTypeAdapter(EnvelopeXmlAdapter.class)
//@XmlRootElement(name = "Envelope")
//@PropertySource(value = "classpath:application.yml")
@XmlType(propOrder = {"body"})
public class Envelope {

    private Body body;



    @XmlElement(name = "Body", namespace = "http://schemas.xmlsoap.org/soap/envelope/")
    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }
}

@XmlRootElement(name = "Body", namespace = "http://schemas.xmlsoap.org/soap/envelope/")
@XmlType(propOrder = {"divide"})
class Body {


    private Divide divide;

    @XmlElement(name = "Divide", namespace = "http://tempuri.org/")
    public Divide getDivide() {
        return divide;
    }

    public void setDivide(Divide divide) {
        this.divide = divide;
    }
}

@XmlRootElement(name = "Divide", namespace = "http://tempuri.org/")
@XmlType(propOrder = {"intA", "intB"})
class Divide {

    private int intA;
    private int intB;

    @XmlElement(name = "intA", namespace = "http://tempuri.org/")
    public int getIntA() {
        return intA;
    }

    public void setIntA(int intA) {
        this.intA = intA;
    }

    @XmlElement(name = "intB", namespace = "http://tempuri.org/")
    public int getIntB() {
        return intB;
    }

    public void setIntB(int intB) {
        this.intB = intB;
    }
}

@Component
class   config{

    @Value("${app.namespace}")
    public String namespace;
    public String getSomePropertyValue() {
        return namespace;
    }
    public void setSomePropertyValue(String somePropertyValue) {
        this.namespace = somePropertyValue;
    }
}