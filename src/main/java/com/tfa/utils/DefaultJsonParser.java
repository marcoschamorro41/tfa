package com.tfa.utils;

import java.io.IOException;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * Default json parser impl. Can be changed, injected etc.
 */
public class DefaultJsonParser {

    private ObjectMapper mapper;

    public DefaultJsonParser() {
        this.mapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .enable(SerializationFeature.INDENT_OUTPUT)
                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
                .findAndRegisterModules();
    }

    public DefaultJsonParser(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    /**
     * Parses and Object (POJO) in a JSON format
     * to a plain String object
     *
     * @param Object
     * @return String
     *
     * @author Agustin Mascheroni
     */
    public <T> String getPlainJson(T object) {
        try {
            return mapper.writer().withDefaultPrettyPrinter().writeValueAsString(object);
        } catch (IOException e) {
            System.err.print("An issue appeared during object serialization\n" + e);
            return null;
        }
    }

    /**
     * Parses a JSON String
     * to an Object (POJO) with JSON format
     *
     * @param Class type, String
     * @return Object
     *
     * @author Agustin Mascheroni
     */
    public static <T> T getObjectFromJson(Class<T> type, String json) {
    	ObjectMapper localMapper  = new ObjectMapper()
                    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                    .enable(SerializationFeature.INDENT_OUTPUT)
                    .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
                    .findAndRegisterModules();
        try {
            return localMapper.readValue(json, type);
        } catch (Exception e) {
            System.err.print("An issue appeared during object serialization\n" + e);
            return null;
        }
    }

    /**
     * Mapper object.
     *
     * @return ObjectMapper
     *
     * @author Agustin Mascheroni
     */
    public ObjectMapper getMapper() {
        return mapper;
    }
}
