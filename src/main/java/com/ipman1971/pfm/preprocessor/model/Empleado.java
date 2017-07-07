package com.ipman1971.pfm.preprocessor.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by jcorredera on 1/07/17.
 */
@Data
@NoArgsConstructor
@ToString
public class Empleado implements Serializable {

    private String id;
    private String birthDay;
    private String name;
    private String surname;
    private String sex;
    private String contractDay;

}
