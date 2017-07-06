package com.ipman1971.pfm.preprocessor.utils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jcorredera on 6/07/17.
 */
public class Fields {

    private static Map<String,FieldPosition> fields;

    private Fields() {
        fields = new HashMap<>();
    }

    public static Fields create() {
        return new Fields();
    }

    public Fields addField(String fieldName, FieldPosition fd) {
        fields.put(fieldName,fd);
        return this;
    }

    public Map<String,FieldPosition> get() {
        return Collections.unmodifiableMap(fields);
    }

}
