//package com.auth2.azuread.controller.rest;
//
//import javax.xml.bind.annotation.adapters.XmlAdapter;
//
//public class EnvelopeXmlAdapter extends XmlAdapter<Envelope, Envelope> {
//    private final String namespace;
//
//    public EnvelopeXmlAdapter(String namespace) {
//        this.namespace = namespace;
//    }
//
//    @Override
//    public Envelope marshal(Envelope envelope) throws Exception {
//        // Set the dynamic namespace for the root element
//        Envelope result = new Envelope()<>;
//        result.setBody(envelope.getBody());
//        return result;
//    }
//
//    @Override
//    public Envelope unmarshal(Envelope envelope) throws Exception {
//        // If needed, implement the unmarshalling logic here
//        return envelope;
//    }
//}
