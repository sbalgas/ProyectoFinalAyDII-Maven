/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.modelo.util;

import aplicacion.modelo.dominio.Servicio;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sbalgass
 */
public class ListadoServicio {

    private List<Servicio> listaServicios;

    public ListadoServicio() {
        listaServicios = new ArrayList<>();

        listaServicios.add(new Servicio(1, "Ejesa", "Luz y Agua"));
        listaServicios.add(new Servicio(2, "Agua de los Andes", "Luz y Agua"));
        listaServicios.add(new Servicio(3, "Telecom", "Telefonia"));
        listaServicios.add(new Servicio(4, "Movistar", "Telefonia"));
        listaServicios.add(new Servicio(5, "Personal", "Telefonia"));
        listaServicios.add(new Servicio(6, "Claro", "Telefonia"));
        listaServicios.add(new Servicio(7, "Wirenet", "Proveedores de Internet"));
        listaServicios.add(new Servicio(8, "Telecentro", "Proveedores de Internet"));
        listaServicios.add(new Servicio(9, "Canal 2", "Operadoras de TV"));
        listaServicios.add(new Servicio(10, "Canal 4", "Operadoras de TV"));

    }

    public void agregar(Servicio servicio) {
        listaServicios.add(servicio);
    }

    public void eliminar(Servicio servicio) {
        for (int i = 0; i < listaServicios.size(); i++) {
            if (listaServicios.get(i).getId() == servicio.getId()) {
                listaServicios.remove(i);
            }
        }
    }

    public void modificar(Servicio servicioModificado) {
        for (Servicio servicio : listaServicios) {
            if (servicio.getId() == servicioModificado.getId()) {
                servicio = servicioModificado;
            }
        }
    }

    public List<Servicio> getListaServicios() {
        return listaServicios;
    }

    public void setListaServicios(List<Servicio> listaServicios) {
        this.listaServicios = listaServicios;
    }

}
