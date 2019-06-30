/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao.imp;

import aplicacion.dao.IOperacionDAO;
import aplicacion.modelo.dominio.Operacion;
import aplicacion.modelo.util.ListadoOperaciones;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author sbalgass
 */
public class IOperacionDAOImp implements IOperacionDAO, Serializable {
    private ListadoOperaciones listadoOperacion;

    public IOperacionDAOImp() {
        this.listadoOperacion = new ListadoOperaciones();
    }
        
    @Override
    public void crear(Operacion operacion) {
        listadoOperacion.agregar(operacion);
    }

    @Override
    public void borrar(Operacion operacion) {
        listadoOperacion.eliminar(operacion);
    }

    @Override
    public void actualizar(Operacion operacion) {
        listadoOperacion.modificar(operacion);
    }

    @Override
    public List<Operacion> obtenerOperaciones() {
        return listadoOperacion.getListaOperaciones();
    }
    
}
