package com.auth2.azuread.controller.rest;
import com.sun.xml.bind.marshaller.NamespacePrefixMapper;

import java.util.HashMap;
import java.util.Map;

public class CustomNamespacePrefixMapper extends NamespacePrefixMapper{
    private final Map<String, String> namespaceToPrefixMap = new HashMap<>();

    public void addNamespaceMapping(String namespaceUri, String prefix) {
        namespaceToPrefixMap.put(namespaceUri, prefix);
    }

    @Override
    public String getPreferredPrefix(String namespaceUri, String suggestion, boolean requirePrefix) {
        return namespaceToPrefixMap.getOrDefault(namespaceUri, suggestion);
    }

    @Override
    public String[] getPreDeclaredNamespaceUris2() {
        return namespaceToPrefixMap.keySet().toArray(new String[0]);
    }
}