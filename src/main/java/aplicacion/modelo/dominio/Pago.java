/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.modelo.dominio;

import java.util.Date;

/**
 *
 * @author LILI-PC
 */
public class Pago {

    private int id;
    private String numeroDeTarjeta;
    private int codigoDeSeguridad;
    private String marca;
    private Date fechaVecimiento;
    private Date fecha;
    private int estado;
    private String titularTarjeta;

    public Pago() {
    }

    public Pago(int id, String numeroDeTarjeta, int codigoDeSeguridad, String marca, Date fechaVecimiento, Date fecha, int estado) {
        this.id = id;
        this.numeroDeTarjeta = numeroDeTarjeta;
        this.codigoDeSeguridad = codigoDeSeguridad;
        this.marca = marca;
        this.fechaVecimiento = fechaVecimiento;
        this.fecha = fecha;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeroDeTarjeta() {
        return numeroDeTarjeta;
    }

    public void setNumeroDeTarjeta(String numeroDeTarjeta) {
        this.numeroDeTarjeta = numeroDeTarjeta;
    }

    public int getCodigoDeSeguridad() {
        return codigoDeSeguridad;
    }

    public void setCodigoDeSeguridad(int codigoDeSeguridad) {
        this.codigoDeSeguridad = codigoDeSeguridad;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Date getFechaVecimiento() {
        return fechaVecimiento;
    }

    public void setFechaVecimiento(Date fechaVecimiento) {
        this.fechaVecimiento = fechaVecimiento;
    }

    public String getTitularTarjeta() {
        return titularTarjeta;
    }

    public void setTitularTarjeta(String titularTarjeta) {
        this.titularTarjeta = titularTarjeta;
    }
}
