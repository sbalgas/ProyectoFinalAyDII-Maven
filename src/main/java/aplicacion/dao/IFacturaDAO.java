/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao;

import aplicacion.modelo.dominio.Factura;
import java.util.List;

/**
 *
 * @author LILI-PC
 */
public interface IFacturaDAO {
    void crear(Factura factura);
    void borrar(Factura factura);
    void actualizar(Factura factura);
    List<Factura> obtenerFacturas();
    List<Factura> obtenerFacturasSegunEmpresaYNumero(int empresa, int numero);
}
