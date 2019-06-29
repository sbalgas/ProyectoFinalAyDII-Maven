/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao;

import aplicacion.modelo.dominio.Operacion;
import java.util.List;

/**
 *
 * @author sbalgass
 */
public interface IOperacionDAO {
    
    void crear(Operacion operacion);
    void borrar(Operacion operacion);
    void actualizar(Operacion operacion);
    List<Operacion> obtenerOperaciones();
    
}
