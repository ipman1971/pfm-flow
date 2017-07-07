package com.ipman1971.pfm.preprocessor.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jcorredera on 6/07/17.
 */
public final class RawSourceParser {

    private final String rawSource;
    private static  ObjectMapper mapper;
    private final String payload;
    private final int lengthRawSource;

    private RawSourceParser(String rawSource, int lengthRawSource) throws IOException, IllegalArgumentException {
        this.rawSource=rawSource;
        this.lengthRawSource=lengthRawSource;
        mapper= new ObjectMapper();
        payload=getPayLoad(rawSource);
    }

    public static RawSourceParser of(String rawSource, int lengthRawSource) throws IOException {
        return new RawSourceParser(rawSource, lengthRawSource);
    }

    private String getPayLoad(String rawSource) throws IOException, IllegalArgumentException {
        JsonNode rootNode=mapper.readTree(rawSource);
        String payload = rootNode.path("message").asText();
        if(payload.length()!=lengthRawSource) {
            throw new IllegalArgumentException("ERROR: size of rawMessage recibed: "+ rawSource.length() + "expected: "+ lengthRawSource);
        }
        return payload;
    }

    public Map<String,String> parser(Fields sourceFields) {
        Map<String,String> sourceData=new HashMap<>();
        for(Map.Entry<String,FieldPosition> entry : sourceFields.get().entrySet()) {
            sourceData.put(entry.getKey(),extract(entry.getValue()));
        }
        return Collections.unmodifiableMap(sourceData);
    }

    public int length(Fields sourceFields) {
        int length=0;
        Map<String,String> source=parser(sourceFields);
        for(Map.Entry<String,String> entry : source.entrySet()) {
            length= length + entry.getValue().length();
        }
        return length;
    }

    private String extract(FieldPosition fd) {
        return payload.substring(fd.getStart(),fd.getEnd());
    }

}
