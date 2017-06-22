package com.ipman1971.pfm.preprocessor.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by Ipman1971 on 15/06/2017.
 *
 * Representa el modelo de datos de un movimiento o tarjeta
 *
 */
@Data
@NoArgsConstructor
@ToString
public class Movimiento {


    private String codigoEmpresaApertura;
    private String codigoCentroApertura;
    private String digitoControlCuenta;
    private String restoIdentificadorCuenta;
    private String codigoSaldo;
    private String FechaImputacionSaldo;
    private long numeroSecuencialClave;
    private String codigoEstadoMovimiento;
    private String codigoNaturalezaContable;
    private long importeMovimiento;
    private String codigoMonedaMovimiento;
    private String codigoTipoMonedaMovimiento;
    private String numeroDecimalesImporteMovimiento;
    private String claveConceptoGenericoMovimiento;
    private long saldoAnteriorMovimiento;
    private String fechaOperacionCliente;
    private String horaOperacionCliente;
    private String fechaValorMovimiento;
    private String sesionMovimiento;
    private String codigoEmpresaResponsableOperacion;
    private String codigoCentroResponsableOperacion;
    private String codigoSubseccionResponsableOperacion;
    private String identificacionPuestoTrabajoResponsableOperacion;
    private String codigoCanalDistribucion;
    private long cambioAplicado;
    private String numeroDecimalesCantidad;
    private String indicadorUtilizacionSeguroCambioAsociado;
    private String codigoTipoCambioDivisaAplicado;
    private String fechaEntradaAplicacionAhorro;
    private String horaEntradaAplicacionAhorro;
    private String microSegundoInicioTransaccion;
    private long completaIdentificadorUnicoInternoOperacion1;
    private long completaIdentificadorUnicoInternoOperacion2;
    private long numeroServicioOperacionEjecutado;
    private long numeroIdentificadorServicioOperacionLlamador;
    private long importeOperacion;
    private String codigoMonedaOperacion;
    private String codigoTipoMonedaOperacion;
    private String numeroDecimalesImporteOperacion;
    private String identificadorReferencia0;
    private String contenidoIdentificadorReferencia0;
    private String identificadorReferencia1;
    private String contenidoIdentificadorReferencia1;
    private String identificadorReferencia2;
    private String contenidoIdentificadorReferencia2;
    private String identificadorReferencia3;
    private String contenidoIdentificadorReferencia3;
    private String identificadorReferencia4;
    private String contenidoIdentificadorReferencia4;
    private String identificadorReferencia5;
    private String contenidoIdentificadorReferencia5;

}
