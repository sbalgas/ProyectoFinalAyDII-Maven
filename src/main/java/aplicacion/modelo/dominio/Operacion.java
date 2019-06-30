/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.modelo.dominio;

import java.util.Date;
import java.util.List;

/**
 *
 * @author LILI-PC
 */
public class Operacion {

    private int id;
    private Date fecha;
    private Pago pago;
    private Servicio servicio;
    private Usuario usuario;
    private List<Factura> factura;

    public Operacion() {
    }

    public Operacion(int id, Date fecha, Pago pago, Servicio servicio, Usuario usuario, List<Factura> factura) {
        this.id = id;
        this.fecha = fecha;
        this.pago = pago;
        this.servicio = servicio;
        this.usuario = usuario;
        this.factura = factura;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Factura> getFactura() {
        return factura;
    }

    public void setFactura(List<Factura> factura) {
        this.factura = factura;
    }

}
