package com.ipman1971.pfm.preprocessor.utils;

import org.apache.commons.beanutils.BeanMap;

import java.util.Map;

/**
 * Created by jcorredera on 7/07/17.
 */
public class MessageMapping {

    public static <T> T create(T pojo, Map<String,String> messageMapping) {
        BeanMap beanMap= new BeanMap(pojo);
        for(Map.Entry<String,String> entry: messageMapping.entrySet()) {
            beanMap.put(entry.getKey(),entry.getValue().trim());
        }
        return pojo;
    }

}
