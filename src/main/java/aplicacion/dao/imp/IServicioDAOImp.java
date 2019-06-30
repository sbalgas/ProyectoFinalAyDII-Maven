/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao.imp;

import aplicacion.dao.IServicioDAO;
import aplicacion.modelo.dominio.Servicio;
import aplicacion.modelo.util.ListadoServicio;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sbalgass
 */
public class IServicioDAOImp implements IServicioDAO, Serializable {

    private ListadoServicio listadoServicio;

    public IServicioDAOImp() {
        this.listadoServicio = new ListadoServicio();
    }

    @Override
    public void crear(Servicio servicio) {
        listadoServicio.agregar(servicio);
    }

    @Override
    public void borrar(Servicio servicio) {
        listadoServicio.eliminar(servicio);
    }

    @Override
    public void actualizar(Servicio servicio) {
        listadoServicio.modificar(servicio);
    }

    @Override
    public List<Servicio> obtenerServicios() {
        return listadoServicio.getListaServicios();
    }

    @Override
    public List<String> obtenerRubros() {
        List<String> rubroList = new ArrayList<>();

        for (Servicio servicio : obtenerServicios()) {
            if (rubroList.contains(servicio.getRubro())) {
                continue;
            }

            rubroList.add(servicio.getRubro());
        }

        return rubroList;
    }

    @Override
    public List<Servicio> obtenerServiciosPorRubro(String rubro) {
        List<Servicio> servicioList = new ArrayList<>();

        for (Servicio unServicio : obtenerServicios()) {
            if (unServicio.getRubro().equals(rubro)) {
                servicioList.add(unServicio);
            }
        }

        return servicioList;
    }

    @Override
    public List<Servicio> obtenerServiciosPorIds(List<Integer> serviciosIds) {
        List<Servicio> servicioList = new ArrayList<>();

        for (Servicio unServicio : obtenerServicios()) {
            if (serviciosIds.contains(unServicio.getId())) {
                servicioList.add(unServicio);
            }
        }

        return servicioList;
    }

    @Override
    public Servicio obtenerUnServicioPorId(int servicioId) {
        Servicio servicio = null;

        for (Servicio unServicio : obtenerServicios()) {
            if (unServicio.getId() == servicioId ) {
                servicio = unServicio;
                break;
            }
        }

        return servicio;
    }

}
