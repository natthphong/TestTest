package com.auth2.azuread.controller.rest;
//
//import jakarta.xml.bind.annotation.XmlAccessType;
//import jakarta.xml.bind.annotation.XmlAccessorType;
//import jakarta.xml.bind.annotation.XmlElement;
//import jakarta.xml.bind.annotation.XmlRootElement;
//
//@XmlRootElement(name = "Envelope", namespace = "http://schemas.xmlsoap.org/soap/envelope/")
//@XmlAccessorType(XmlAccessType.FIELD)
//public class EnvelopeResponse {
//
//    @XmlElement(name = "Body", namespace = "http://schemas.xmlsoap.org/soap/envelope/")
//    private BodyResponse body;
//
//    // Add getters and setters for 'body' if needed
//
//    public BodyResponse getBody() {
//        return body;
//    }
//
//    public void setBody(BodyResponse body) {
//        this.body = body;
//    }
//}
//
//@XmlRootElement(name = "DivideResponse", namespace = "http://tempuri.org/")
//@XmlAccessorType(XmlAccessType.FIELD)
//class BodyResponse {
//
//    @XmlElement(name = "DivideResponse", namespace = "http://tempuri.org/")
//    private DivideResponse divideResponse;
//
//    // Add getters and setters for 'divideResponse' if needed
//
//    public DivideResponse getDivideResponse() {
//        return divideResponse;
//    }
//
//    public void setDivideResponse(DivideResponse divideResponse) {
//        this.divideResponse = divideResponse;
//    }
//}
//
//@XmlRootElement(name = "DivideResponse", namespace = "http://tempuri.org/")
//@XmlAccessorType(XmlAccessType.FIELD)
//class DivideResponse {
//
//    @XmlElement(name = "DivideResult", namespace = "http://tempuri.org/")
//    private int divideResult;
//
//    // Add getters and setters for 'divideResult' if needed
//
//    public int getDivideResult() {
//        return divideResult;
//    }
//
//    public void setDivideResult(int divideResult) {
//        this.divideResult = divideResult;
//    }
//}

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "Envelope", namespace = "http://schemas.xmlsoap.org/soap/envelope/")
public class EnvelopeResponse {

    @JacksonXmlProperty(localName = "Body", namespace = "http://schemas.xmlsoap.org/soap/envelope/")
    private BodyResponse body;

    // Add getters and setters for 'body' if needed

    public BodyResponse getBody() {
        return body;
    }

    public void setBody(BodyResponse body) {
        this.body = body;
    }
}

//@JacksonXmlRootElement(localName = "DivideResponse", namespace = "http://tempuri.org/")
class BodyResponse {

    @JacksonXmlProperty(localName = "DivideResponse", namespace = "http://tempuri.org/")
    private DivideResponse divideResponse;

    // Add getters and setters for 'divideResponse' if needed

    public DivideResponse getDivideResponse() {
        return divideResponse;
    }

    public void setDivideResponse(DivideResponse divideResponse) {
        this.divideResponse = divideResponse;
    }
}

//@JacksonXmlRootElement(localName = "DivideResponse", namespace = "http://tempuri.org/")
class DivideResponse {

    @JacksonXmlProperty(localName = "DivideResult", namespace = "http://tempuri.org/")
    private int divideResult;

    // Add getters and setters for 'divideResult' if needed

    public int getDivideResult() {
        return divideResult;
    }

    public void setDivideResult(int divideResult) {
        this.divideResult = divideResult;
    }
}
