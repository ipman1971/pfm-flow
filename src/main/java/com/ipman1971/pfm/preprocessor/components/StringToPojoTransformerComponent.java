package com.ipman1971.pfm.preprocessor.components;

import com.ipman1971.pfm.preprocessor.configuration.PfmConstant;
import com.ipman1971.pfm.preprocessor.model.FakeData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.transformer.StreamTransformer;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

/**
 * Created by jcorredera on 1/07/17.
 */
@Component("stringPojoTransformerComponent")
@Slf4j
public class StringToPojoTransformerComponent {
    private static final int SIZE_RAW_MESSAGE=48;

    @Transformer(inputChannel = "pfmRequestChannel", outputChannel = "pfmTransformChannel")
    public FakeData rawMessageToPojo(final byte[] input) throws Exception {
        String rawMessage=null;
        try {
            rawMessage=new String(input, "UTF-8");
            log.info(PfmConstant.ID_LOG + "mensaje recibido de REDIS => {}",rawMessage);
            if(!isMessageOk(rawMessage)) {
                throw new Exception(PfmConstant.ID_LOG + "ERROR: size of rawMessage RECIBED: "+ rawMessage.length() + "EXPECTED: "+ SIZE_RAW_MESSAGE);
            }
        } catch (UnsupportedEncodingException e) {
            log.error(PfmConstant.ID_LOG+ "ERROR : encoding not supported");
        }
        return getPojo(rawMessage);
    }

    private FakeData getPojo(String rawMessage) {
        FakeData pojo = new FakeData();
        pojo.setDni(rawMessage.substring(0,7));
        pojo.setNombre(rawMessage.substring(8,17));
        pojo.setApellidos(rawMessage.substring(18,37));
        return pojo;
    }

    private boolean isMessageOk(String rawMessage) {
        return rawMessage.length()==SIZE_RAW_MESSAGE ? true: false;
    }
}
