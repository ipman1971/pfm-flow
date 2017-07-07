package com.ipman1971.pfm.preprocessor.utils;

import com.ipman1971.pfm.preprocessor.model.Empleado;
import org.junit.Test;

import java.io.IOException;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by jcorredera on 7/07/17.
 */
public class MessageMappingTest {

    public static final String RAW_SOURCE ="{\n\t\"message\":\"0000000100151959-08-19      Guoxiang       NooteboomM1987-07-02\"\n}";
    public static final String RAW_SOURCE_WITH_NULLABLE ="{\n\t\"message\":\"0000000100151959-08-19                     NooteboomM1987-07-02\"\n}";
    public static final int LENGTH_RAW_SOURCE=63;

    @Test
    public void test_create() throws Exception {
        Empleado pojo=MessageMapping.create(new Empleado(),createSourceMapping(RAW_SOURCE,LENGTH_RAW_SOURCE));
        assertThat(pojo.getId(),is(equalTo("000000010015")));
        assertThat(pojo.getBirthDay(),is(equalTo("1959-08-19")));
        assertThat(pojo.getName(),is(equalTo("Guoxiang")));
        assertThat(pojo.getSurname(),is(equalTo("Nooteboom")));
        assertThat(pojo.getSex(),is(equalTo("M")));
        assertThat(pojo.getContractDay(),is(equalTo("1987-07-02")));
    }

    @Test
    public void test_create_with_field_null() throws Exception {
        Empleado pojo=MessageMapping.create(new Empleado(),createSourceMapping(RAW_SOURCE_WITH_NULLABLE,LENGTH_RAW_SOURCE));
        assertThat(pojo.getId(),is(equalTo("000000010015")));
        assertThat(pojo.getBirthDay(),is(equalTo("1959-08-19")));
        assertThat(pojo.getName(),is(equalTo("")));
        assertThat(pojo.getSurname(),is(equalTo("Nooteboom")));
        assertThat(pojo.getSex(),is(equalTo("M")));
        assertThat(pojo.getContractDay(),is(equalTo("1987-07-02")));
    }


    private Map<String,String> createSourceMapping(String rawSource, int lengthRawSource) throws IOException {
        RawSourceParser rawParser=RawSourceParser.of(rawSource,lengthRawSource);
        return rawParser.parser(createFields());
    }

    private Fields createFields() {
        return Fields.create()
                .addField("id",FieldPosition.of(0,12))
                .addField("birthDay",FieldPosition.of(12,22))
                .addField("name",FieldPosition.of(22,36))
                .addField("surname",FieldPosition.of(36,52))
                .addField("sex",FieldPosition.of(52,53))
                .addField("contractDay",FieldPosition.of(53,63));
    }

}