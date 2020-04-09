package com.tool.monitor.util;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <p> Title: JsonUtil </p>
 * <p> Description: </p>
 * <p> Copyright: CMBC Copyright (c) 2012 </p>
 * <p> Company: CMBC </p>
 * 
 * @author sunchongrui
 * 
 * @since 1.0
 */
public class JsonUtil {
    private static final String DEFAULT_DATEFORMAT_PATTERN = "yyyy-MM-dd HH:mm:ss";
    private static final ObjectMapper objectMapper;

    static {

        objectMapper = new ObjectMapper();
        // 跳过未知(json字符串中无值)的对象属性
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        // 对于null的bean不报错
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_DATEFORMAT_PATTERN);
        objectMapper.setDateFormat(sdf);
        // null值转为空字符串
//        objectMapper.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {
//            @Override
//            public void serialize(Object value, JsonGenerator jgen,
//                    SerializerProvider provider) throws IOException,
//                    JsonProcessingException {
//                jgen.writeString("");
//            }
//        });
    }

    public static <T> T unmarshall(byte[] source, Class<T> entityType) throws IOException {

        JsonParser parser = objectMapper.getJsonFactory().createJsonParser(source);
        return readJsonValue(parser, entityType);
    }

    public static <T> T unmarshall(String source, Class<T> entityType) throws IOException {

        JsonParser parser = objectMapper.getJsonFactory().createJsonParser(source);
        return readJsonValue(parser, entityType);
    }

    public static <T> T unmarshall(Reader source, Class<T> entityType) throws IOException {

        JsonParser parser = objectMapper.getJsonFactory().createJsonParser(source);
        return readJsonValue(parser, entityType);
    }

    public static <T> T unmarshall(InputStream source, Class<T> entityType) throws IOException {

        JsonParser parser = objectMapper.getJsonFactory().createJsonParser(source);
        return readJsonValue(parser, entityType);
    }

    private static <T> T readJsonValue(JsonParser parser, Class<T> valueType) throws IOException {

        T object = null;
        try {
            object = parser.readValueAs(valueType);
        }
        finally {
            if (parser != null) {
                try {
                    parser.close();
                }
                catch (IOException e) {
                    // ignore
                }
            }
        }
        return object;
    }

    public static void marshall(Writer target, Object value) throws IOException {

        JsonGenerator generator = objectMapper.getJsonFactory().createJsonGenerator(target);
        write2Json(generator, value);
    }

    public static void marshall(OutputStream target, Object value) throws IOException {

        JsonGenerator generator = objectMapper.getJsonFactory().createJsonGenerator(target, JsonEncoding.UTF8);
        write2Json(generator, value);
    }

    public static void marshall(OutputStream target, Object value, String encoding) throws IOException {

        JsonGenerator generator = objectMapper.getJsonFactory().createJsonGenerator(target,
                JsonEncoding.valueOf(encoding));
        write2Json(generator, value);
    }

    public static String marshall(Object value) throws IOException {

        StringWriter sw = new StringWriter();
        marshall(sw, value);
        return sw.toString();
    }

    private static void write2Json(JsonGenerator generator, Object entity) throws IOException {

        try {
            generator.writeObject(entity);
        }
        finally {
            if (generator != null) {
                try {
                    generator.close();
                }
                catch (IOException e) {
                    // ignore
                }
            }
        }
    }

    public static String fromObject(Object... params) {
        Map<String, Object> map = new LinkedHashMap<>();
        for (int i = 0; i < params.length; i = i + 2) {
            map.put((String) getArray(params, i), getArray(params, i + 1));
        }
        return JSON.toJSONString(map);
    }

    public static Object getArray(Object[] params, int i) {
        if (params.length > 0 && i >= 0 && i < params.length) {
            return params[i];
        } else {
            return "";
        }
    }
}
