package com.ipman1971.pfm.preprocessor.utils;

import com.ipman1971.pfm.preprocessor.utils.FieldPosition;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by jcorredera on 6/07/17.
 */
public class FieldPositionTest {

    @Test
    public void test_create_fieldPosition_object() {
        FieldPosition fp= FieldPosition.of(3,23);
        assertThat(fp.getStart(),is(equalTo(3)));
        assertThat(fp.getEnd(),is(equalTo(23)));
    }

}
