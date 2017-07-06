package com.ipman1971.pfm.preprocessor.utils;

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;


/**
 * Created by jcorredera on 6/07/17.
 */
public class RawSourceParserTest {

    public static final String RAW_SOURCE_TEST="{\n\t\"message\":\"0000000100151959-08-19      Guoxiang       NooteboomM1987-07-02\"\n}";

    @Test
    public void test_of() throws Exception {
        RawSourceParser rawParser=RawSourceParser.of(RAW_SOURCE_TEST);
        assertThat(rawParser,is(notNullValue()));
    }

    @Test
    public void test_parser() throws Exception {
        RawSourceParser rawParser=RawSourceParser.of(RAW_SOURCE_TEST);
        assertThat(rawParser,is(notNullValue()));

        Map<String,String> rawMapping=rawParser.parser(createFields());

        assertThat(rawMapping.size(),is(equalTo(6)));
        assertThat(rawMapping.containsKey("dni"),is(equalTo(true)));
        assertThat(rawMapping.get("dni"),is(equalTo("000000010015")));
        assertThat(rawMapping.containsKey("birthDay"),is(equalTo(true)));
        assertThat(rawMapping.get("birthDay"),is(equalTo("1959-08-19")));
        assertThat(rawMapping.containsKey("name"),is(equalTo(true)));
        assertThat(rawMapping.get("name"),is(equalTo("      Guoxiang")));
        assertThat(rawMapping.containsKey("surname"),is(equalTo(true)));
        assertThat(rawMapping.get("surname"),is(equalTo("       Nooteboom")));
        assertThat(rawMapping.containsKey("sex"),is(equalTo(true)));
        assertThat(rawMapping.get("sex"),is(equalTo("M")));
        assertThat(rawMapping.containsKey("contractDay"),is(equalTo(true)));
        assertThat(rawMapping.get("contractDay"),is(equalTo("1987-07-02")));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void test_modify_result_of_parser() throws Exception {
        RawSourceParser rawParser=RawSourceParser.of(RAW_SOURCE_TEST);
        assertThat(rawParser,is(notNullValue()));

        Map<String,String> rawMapping=rawParser.parser(createFields());

        assertThat(rawMapping.size(),is(equalTo(6)));
        assertThat(rawMapping.containsKey("dni"),is(equalTo(true)));
        assertThat(rawMapping.get("dni"),is(equalTo("000000010015")));

        rawMapping.remove("dni");
    }

    @Test
    public void test_lenght() throws Exception {
        RawSourceParser rawParser=RawSourceParser.of(RAW_SOURCE_TEST);
        assertThat(rawParser,is(notNullValue()));

        assertThat(rawParser.length(createFields()),is(equalTo(63)));
    }

    private Fields createFields() {
        return Fields.create()
                .addField("dni",FieldPosition.of(0,12))
                .addField("birthDay",FieldPosition.of(12,22))
                .addField("name",FieldPosition.of(22,36))
                .addField("surname",FieldPosition.of(36,52))
                .addField("sex",FieldPosition.of(52,53))
                .addField("contractDay",FieldPosition.of(53,63));
    }

}