/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans;

import aplicacion.dao.IServicioDAO;
import aplicacion.dao.imp.IServicioDAOImp;
import aplicacion.modelo.dominio.Servicio;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author sbalgass
 */
@ManagedBean
@RequestScoped
public class ServicioBean {

    private IServicioDAO iServicioDAO;

    /**
     * Creates a new instance of UsuarioBean
     */
    public ServicioBean() {
        iServicioDAO = new IServicioDAOImp();
    }

    public List<Servicio> getServicioList() {
        return iServicioDAO.obtenerServicios();
    }

    public List<String> getRubroList() {
        return iServicioDAO.obtenerRubros();
    }

    public List<Servicio> getServicioListByRubro(String rubro) {
        return iServicioDAO.obtenerServiciosPorRubro(rubro);
    }

    public List<Servicio> obtenerServiciosPorIds(List<Integer> serviciosIds) {
        return iServicioDAO.obtenerServiciosPorIds(serviciosIds);
    }
    
    public Servicio obtenerUnServicioPorId(int servicioId){
        return iServicioDAO.obtenerUnServicioPorId(servicioId);
    }

}
