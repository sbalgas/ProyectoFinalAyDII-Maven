/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao;

import aplicacion.modelo.dominio.Servicio;
import java.util.List;

/**
 *
 * @author sbalgass
 */
public interface IServicioDAO {
    
    void crear(Servicio servicio);
    void borrar(Servicio servicio);
    void actualizar(Servicio servicio);
    List<Servicio> obtenerServicios();
    List<Servicio> obtenerServiciosPorRubro(String rubro);
    List<String> obtenerRubros();
    List<Servicio> obtenerServiciosPorIds(List<Integer> serviciosIds);

    public Servicio obtenerUnServicioPorId(int servicioId);
}
