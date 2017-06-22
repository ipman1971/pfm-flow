package com.ipman1971.pfm.preprocessor.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by Ipman1971 on 16/06/2017.
 *
 * Representa el modelo de datos que se enviara a ElasticSearch
 */
@Data
@NoArgsConstructor
@ToString
public class ElasticModel {

    private Metadata metadata;
    private Movimiento movimiento;

}
