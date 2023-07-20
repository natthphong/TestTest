package com.auth2.azuread.controller.rest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class AnnotationSetter {
    public static <T> T setAnnotationValue(Class<T> annotationType, String value) {
        return (T) Proxy.newProxyInstance(
                annotationType.getClassLoader(),
                new Class<?>[]{annotationType},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if (method.getName().equals("namespace")) {
                            return value;
                        } else if (method.getName().equals("hashCode")) {
                            return annotationType.hashCode();
                        } else if (method.getName().equals("toString")) {
                            return annotationType.getSimpleName() + ": " + value;
                        }
                        return null;
                    }
                });
    }
}