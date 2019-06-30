/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao.imp;

import aplicacion.dao.IFacturaDAO;
import aplicacion.modelo.dominio.Factura;
import aplicacion.modelo.util.ListadoFacturas;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LILI-PC
 */
public class IFacturaDAOImp implements Serializable, IFacturaDAO {

    ListadoFacturas listadoFacturas;

    public IFacturaDAOImp() {
        listadoFacturas = new ListadoFacturas();
    }

    @Override
    public void crear(Factura factura) {
        listadoFacturas.agregar(factura);
    }

    @Override
    public void borrar(Factura factura) {
        listadoFacturas.eliminar(factura);
    }

    @Override
    public void actualizar(Factura factura) {
        listadoFacturas.modificar(factura);
    }

    @Override
    public List<Factura> obtenerFacturas() {
        return listadoFacturas.getListaFactura();
    }

    @Override
    public List<Factura> obtenerFacturasSegunEmpresaYNumero(int empresa, int numero) {
        List<Factura> listadoFacturas = new ArrayList<>();

        for (Factura unaFactura : obtenerFacturas()) {
            if (unaFactura.getNumeroDeServicio() == numero &&
                unaFactura.getEmpresaId() == empresa) {
                listadoFacturas.add(unaFactura);
            }
        }
        return listadoFacturas;
    }

}
