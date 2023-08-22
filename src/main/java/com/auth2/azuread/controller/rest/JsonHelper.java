package com.auth2.azuread.controller.rest;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class JsonHelper {
    private static Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
            .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
            .create();

    private JsonHelper() {
        throw new IllegalStateException("Utility class");
    }

    public static <T> T jsonStringToObject(String jsonStringValue, Class<T> clazz) {
        return gson.fromJson(jsonStringValue, clazz);
    }

    public static String objectToJsonString(Object object) {
        return gson.toJson(object);
    }


    public static <T> T jsonStringToObjectTypeRef(String jsonStringValue, TypeToken<T> typeToken) {
        return gson.fromJson(jsonStringValue, typeToken.getType());
    }

    public static <T> T objectToObject(Object object, Class<T> clazz) {
        String value = object instanceof String ? object.toString() : gson.toJson(object);
        return gson.fromJson(value, clazz);
    }

    public static <T> T objectToObjectTypeRef(Object object, TypeToken<T> typeToken) {
        String value = object instanceof String ? object.toString() : gson.toJson(object);
        return gson.fromJson(value, typeToken.getType());
    }

    private static class LocalDateAdapter implements JsonSerializer<LocalDate>, JsonDeserializer<LocalDate> {
        private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        @Override
        public JsonElement serialize(LocalDate src, Type typeOfSrc, JsonSerializationContext context) {
            return new JsonPrimitive(formatter.format(src));
        }

        @Override
        public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
                throws JsonParseException {
            return formatter.parse(json.getAsString(), LocalDate::from);
        }

    }

    private static class LocalDateTimeAdapter implements JsonSerializer<LocalDateTime>, JsonDeserializer<LocalDateTime> {
        private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

        @Override
        public JsonElement serialize(LocalDateTime src, Type typeOfSrc, JsonSerializationContext context) {
            return new JsonPrimitive(formatter.format(src));
        }

        @Override
        public LocalDateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
                throws JsonParseException {
            return LocalDateTime.parse(json.getAsString(), formatter);
        }
    }


}