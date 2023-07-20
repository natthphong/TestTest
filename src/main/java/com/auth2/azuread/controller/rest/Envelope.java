package com.auth2.azuread.controller.rest;


import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;



@XmlRootElement(name = "Envelope")
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