package com.dragonfly.timemachine.util;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.util.CollectionUtils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.datatype.joda.JodaModule;

/**
 * Json Utils class - utility to serialize/deserialize objects
 *
 */
public class JsonUtils {

    public static String serialize(Object object) {
        return serialize(object, false);
    }

    public static String serializeIfNotNull(Object object) {
        return object == null ? null : serialize(object);
    }

    public static String serializeIfNotEmpty(List<?> list) {
        return CollectionUtils.isEmpty(list) ? null : serialize(list);
    }

    public static String serializeWithIndention(Object object) {
        return serialize(object, true);
    }

    private static String serialize(Object object, boolean indent) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JodaModule());
        mapper.configure(SerializationFeature.INDENT_OUTPUT, indent);
        try {
            return mapper.writeValueAsString(object);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> String serializeIfNotEmpty(List<T> list, Class<T> clazz) {
        return CollectionUtils.isEmpty(list) ? null : serializeList(list, clazz);
    }

    public static <T> String serializeList(List<T> list, Class<T> clazz) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JodaModule());
        JavaType type = TypeFactory.defaultInstance().constructCollectionType(List.class, clazz);
        try {
            return mapper.writerWithType(type).writeValueAsString(list);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> List<T> deserializeList(String json, Class<T> clazz, boolean ignoreUnknown) {
        JavaType type = TypeFactory.defaultInstance().constructCollectionType(List.class, clazz);
        return deserialize(json, type, ignoreUnknown);
    }

    public static <V> Map<String, V> deserializeStringKeyedMap(String json, Class<V> valueClass, boolean ignoreUnknown) {
        return deserializeMap(json, String.class, valueClass, ignoreUnknown);
    }

    public static <K, V> Map<K, V> deserializeMap(String json, Class<K> keyClass, Class<V> valueClass, boolean ignoreUnknown) {
        JavaType type = TypeFactory.defaultInstance().constructMapType(Map.class, String.class, valueClass);
        return deserialize(json, type, ignoreUnknown);
    }

    public static <T> T deserialize(String json, JavaType type, boolean ignoreUnknown) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JodaModule());
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, !ignoreUnknown);
        try {
            return mapper.readValue(json, type);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T deserialize(String json, Class<T> clazz, boolean ignoreUnknown) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JodaModule());
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, !ignoreUnknown);
        try {
            return mapper.readValue(json, clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}