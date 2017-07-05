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
public class FakeData implements Serializable {

    private static final long serialVersionUID =1;

    private String dni;
    private String nombre;
    private String apellidos;

}
