/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao.imp;

import aplicacion.dao.IPagoDAO;
import aplicacion.modelo.dominio.Pago;
import aplicacion.modelo.util.ListadoPago;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author sbalgass
 */
public class IPagoDAOImp implements IPagoDAO, Serializable{

    private ListadoPago listadoPago; 

    public IPagoDAOImp() {
        this.listadoPago = new ListadoPago();
    }
    
    @Override
    public void crear(Pago pago) {
        listadoPago.agregar(pago);
    }

    @Override
    public void borrar(Pago pago) {
        listadoPago.eliminar(pago);
    }

    @Override
    public void actualizar(Pago pago) {
        listadoPago.modificar(pago);
    }

    @Override
    public List<Pago> obtenerPagos() {
        return listadoPago.getListaPagos();
    }
    
}
