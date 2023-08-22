package com.auth2.azuread.controller.rest;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.util.Assert;

import javax.swing.text.DateFormatter;
import java.lang.annotation.Annotation;
import java.lang.instrument.ClassDefinition;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.lang.reflect.Field;
import java.lang.reflect.Proxy;
import java.security.ProtectionDomain;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Function;


@Configuration
@Slf4j
public class Constant {

    public static Function<Object, String> dateToString = date -> {
         DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
         log.info("{}",date.getClass().getName());
        if (Objects.isNull(date)){
            return null;
        }else if (date instanceof LocalDateTime) {
            return ((LocalDateTime) date).format(DATE_TIME_FORMATTER);
        } else if (date instanceof LocalDate) {
            DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            return ((LocalDate) date).format(DATE_TIME_FORMATTER);
        } else if (date instanceof Instant) {
            return ((Instant) date).atZone(ZoneId.systemDefault()).format(DATE_TIME_FORMATTER);
        } else if (date instanceof Timestamp) {
            return ((Timestamp) date).toLocalDateTime().format(DATE_TIME_FORMATTER);
        }else if (date instanceof Date){
            DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            return ((Date)date).toInstant().atZone(ZoneId.systemDefault()).format(DATE_TIME_FORMATTER);
        }
        return "NOT TYPE SUPPORT";
    };

    public static Function<Map<String,Object>, Object> StringToDate = element -> {
        DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        if (!element.containsKey("date")
                || !element.containsKey("haveTime")
                || !element.containsKey("type")){
            return null;
        }
        String date = (String) element.get("date");
        Boolean haveTime = (Boolean) element.get("haveTime");
        Class<?> type =(Class<?>) element.get("type");
        if (Objects.isNull(type)){
            return null;
        }

            return date;

    };

    @Value("${app.namespace}")
    public static String namespace;

    public static String getNameSpace() {
        return namespace;
    }

    public static class AnnotationTransformer implements ClassFileTransformer {
        @Override
        public byte[] transform(
                ClassLoader loader,
                String className,
                Class<?> classBeingRedefined,
                ProtectionDomain protectionDomain,
                byte[] classfileBuffer) throws IllegalClassFormatException {
            if ("Envelope".equals(className)) {
                try {
                    Class<?> oldClass = Class.forName(className);
                    Annotation oldAnnotation = oldClass.getAnnotation(XmlRootElement.class);
                    if (oldAnnotation != null) {
                        Annotation newAnnotation = (Annotation) Proxy.newProxyInstance(
                                oldAnnotation.getClass().getClassLoader(),
                                new Class[]{XmlRootElement.class},
                                (proxy, method, args) -> {
                                    if ("namespace".equals(method.getName())) {
                                        return Constant.namespace; // Modify the namespace here
                                    } else if ("name".equals(method.getName())) {
                                        return "Body"; // Modify the name here
                                    } else {
                                        return method.invoke(oldAnnotation, args);
                                    }
                                });

                        Map<Class<? extends Annotation>, Annotation> annotations = new HashMap<>();
                        annotations.put(XmlRootElement.class, newAnnotation);

                        ModifiedClassLoader modifiedClassLoader = new ModifiedClassLoader(
                                oldClass.getClassLoader(), Collections.singletonMap(className, classfileBuffer));

                        Class<?> modifiedClass = modifiedClassLoader.loadClass(className);
                        Field annotationsField = Class.class.getDeclaredField("annotations");
                        annotationsField.setAccessible(true);
                        annotationsField.set(modifiedClass, annotations);

//                        // Optionally, you can redefine the modified class in the JVM
//                        // This is useful if you want to ensure all references to Envelope use the modified version.
//                        Instrumentation instrumentation = java.lang.instrument.Instrumentation;
//                        if (instrumentation != null) {
//                            instrumentation.redefineClasses(new ClassDefinition(oldClass, classfileBuffer));
//                        }

                        return classfileBuffer;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }

    public static class ModifiedClassLoader extends ClassLoader {
        private final Map<String, byte[]> modifiedClasses;

        public ModifiedClassLoader(ClassLoader parent, Map<String, byte[]> modifiedClasses) {
            super(parent);
            this.modifiedClasses = modifiedClasses;
        }

        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            byte[] bytecode = modifiedClasses.get(name);
            if (bytecode != null) {
                return defineClass(name, bytecode, 0, bytecode.length);
            }
            return super.findClass(name);
        }
    }


}


