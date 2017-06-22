package com.ipman1971.pfm.preprocessor.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by Ipman1971 on 16/06/2017.
 *
 * Metadatos generados por la ingesta de los movimientos
 *
 */
@Data
@NoArgsConstructor
@ToString
public class Metadata {

    public enum Tipo {
        CUENTA, TARJETA
    }

    public enum Origen {
        FICHERO, ORACLE, HDFS
    }

    // informacion de metadata
    private Tipo tipo;
    private Origen origen;
    private long timeStamp;

}
