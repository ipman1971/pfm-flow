package com.ipman1971.pfm.preprocessor.utils;

import org.junit.Test;

import java.util.Map;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

/**
 * Created by jcorredera on 6/07/17.
 */
public class FieldsTest {

    @Test
    public void test_create_fields_instance() {
        Fields fields= Fields.create();
        assertThat(fields,is(notNullValue()));
    }

    @Test
    public void test_create_fields_multiples_instances() {
        Fields fields1= Fields.create();
        assertThat(fields1,is(notNullValue()));
        Fields fields2= Fields.create();
        assertThat(fields2,is(notNullValue()));
        assertThat(fields1.equals(fields2),is(false));
    }

    @Test
    public void test_add_fieldposition() {
        Fields fields= Fields.create()
                .addField("nombre", FieldPosition.of(0,10))
                .addField("apellidos", FieldPosition.of(11,20));

        assertThat(fields,is(notNullValue()));
        assertThat(fields.get().size(),is(equalTo(2)));
        assertThat(fields.get().containsKey("nombre"),is(equalTo(true)));
        assertThat(fields.get().containsKey("apellidos"),is(equalTo(true)));
    }

    @Test
    public void test_get_fields() {
        Fields fields= Fields.create()
                .addField("nombre", FieldPosition.of(0,10))
                .addField("apellidos", FieldPosition.of(11,20));

        assertThat(fields,is(notNullValue()));
        assertThat(fields.get(),is(notNullValue()));
        assertThat(fields.get().size(),is(equalTo(2)));
    }

    @Test(expected=UnsupportedOperationException.class)
    public void test_check_immutability_in_get_fields() {
        Fields fields= Fields.create()
                .addField("nombre", FieldPosition.of(0,10))
                .addField("apellidos", FieldPosition.of(11,20));

        assertThat(fields,is(notNullValue()));

        Map<String,FieldPosition> immutableFields=fields.get();
        immutableFields.put("edad", FieldPosition.of(21,23));
    }

}
