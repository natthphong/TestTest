package com.auth2.azuread.controller.rest;

import com.sun.xml.bind.marshaller.NamespacePrefixMapper;

public class CustomNamespacePrefixMapper extends NamespacePrefixMapper {
    private final String namespace;
    public CustomNamespacePrefixMapper(String namespace) {
        this.namespace = namespace;
    }
    @Override
    public String getPreferredPrefix(String namespaceUri, String suggestion, boolean requirePrefix) {

        return namespace;
    }
}