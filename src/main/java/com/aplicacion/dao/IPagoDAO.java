/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao;

import aplicacion.modelo.dominio.Pago;
import java.util.List;

/**
 *
 * @author sbalgass
 */
public interface IPagoDAO {
    void crear(Pago pago);
    void borrar(Pago pago);
    void actualizar(Pago pago);
    List<Pago> obtenerPagos();
}
