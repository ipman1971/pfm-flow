package com.ipman1971.pfm.preprocessor.components;

import com.ipman1971.pfm.preprocessor.utils.PfmConstant;
import com.ipman1971.pfm.preprocessor.model.Empleado;
import com.ipman1971.pfm.preprocessor.utils.FieldPosition;
import com.ipman1971.pfm.preprocessor.utils.Fields;
import com.ipman1971.pfm.preprocessor.utils.MessageMapping;
import com.ipman1971.pfm.preprocessor.utils.RawSourceParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.annotation.Transformer;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by jcorredera on 1/07/17.
 */
@Component("stringPojoTransformerComponent")
@Slf4j
public class StringToPojoTransformerComponent {
    private static final int SIZE_RAW_MESSAGE=63;

    @Transformer(inputChannel = "pfmRequestChannel", outputChannel = "pfmTransformChannel")
    public Empleado rawMessageToPojo(final byte[] input) throws Exception {
        String rawMessage=null;
        try {
            rawMessage=new String(input, "UTF-8");
            log.info(PfmConstant.ID_LOG + "mensaje recibido de REDIS => {}",rawMessage);
        } catch (UnsupportedEncodingException e) {
            log.error(PfmConstant.ID_LOG+ "ERROR : encoding not supported");
        }
        return createPojo(rawMessage);
    }

    private Empleado createPojo(String rawMessage) {
        Empleado pojo = new Empleado();
        try {
            RawSourceParser rawParser=RawSourceParser.of(rawMessage,63);
            pojo = MessageMapping.create(pojo,rawParser.parser(createFields()));
        } catch (IOException e) {
            log.error(PfmConstant.ID_LOG + "ERROR: problem in parser of rawMessage => " + rawMessage + " Exception: " + e.getMessage());
        }
        return pojo;
    }

    private Fields createFields() {
        return Fields.create()
                .addField("id", FieldPosition.of(0,12))
                .addField("birthDay",FieldPosition.of(12,22))
                .addField("name",FieldPosition.of(22,36))
                .addField("surname",FieldPosition.of(36,52))
                .addField("sex",FieldPosition.of(52,53))
                .addField("contractDay",FieldPosition.of(53,63));
    }

}
