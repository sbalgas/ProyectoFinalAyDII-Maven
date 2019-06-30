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
public class Factura {

    private int id;
    private int empresaId;
    private int numeroDeServicio;
    private int numeroDeFactura;
    private String domicilio;
    private double importe;
    private String titularFactura;
    private Date fechaVencimiento;

    public Factura() {
    }

    public Factura(int id, int empresaId, int numeroDeServicio, int numeroDeFactura, String domicilio, double importe, String titularFactura, Date fechaVencimiento) {
        this.id = id;
        this.empresaId = empresaId;
        this.numeroDeServicio = numeroDeServicio;
        this.numeroDeFactura = numeroDeFactura;
        this.domicilio = domicilio;
        this.importe = importe;
        this.titularFactura = titularFactura;
        this.fechaVencimiento = fechaVencimiento;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumeroDeServicio() {
        return numeroDeServicio;
    }

    public void setNumeroDeServicio(int numeroDeServicio) {
        this.numeroDeServicio = numeroDeServicio;
    }

    public int getNumeroDeFactura() {
        return numeroDeFactura;
    }

    public void setNumeroDeFactura(int numeroDeFactura) {
        this.numeroDeFactura = numeroDeFactura;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public String getTitularFactura() {
        return titularFactura;
    }

    public void setTitularFactura(String titularFactura) {
        this.titularFactura = titularFactura;
    }

    public int getEmpresaId() {
        return empresaId;
    }

    public void setEmpresa(int empresaId) {
        this.empresaId = empresaId;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
    
    
   
}
