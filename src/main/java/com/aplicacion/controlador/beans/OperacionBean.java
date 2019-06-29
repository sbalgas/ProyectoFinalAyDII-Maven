/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans;

import aplicacion.dao.IOperacionDAO;
import aplicacion.dao.imp.IOperacionDAOImp;
import aplicacion.modelo.dominio.Operacion;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author sbalgass
 */
@ManagedBean
@RequestScoped
public class OperacionBean {

    private IOperacionDAO iOperacionDAO;

    /**
     * Creates a new instance of UsuarioBean
     */
    public OperacionBean() {
        iOperacionDAO = new IOperacionDAOImp();
    }

    public List<Operacion> getPagoList() {
        return iOperacionDAO.obtenerOperaciones();

    }

    public void crear(Operacion operacion) {
        iOperacionDAO.crear(operacion);
    }
    
    public int getLastOperacionId() {
        int lastOperacionId = 0;
        for (Operacion unaOperacion : getPagoList()) {
            if (unaOperacion.getId() > lastOperacionId) {
                lastOperacionId = unaOperacion.getId();
            }
        }
        return lastOperacionId;
    }


}
