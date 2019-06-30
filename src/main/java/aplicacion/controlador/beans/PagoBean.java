/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans;

import aplicacion.dao.IPagoDAO;
import aplicacion.dao.imp.IPagoDAOImp;
import aplicacion.modelo.dominio.Pago;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author sbalgass
 */
@ManagedBean
@RequestScoped
public class PagoBean {

    private IPagoDAO iPagoDAO;

    /**
     * Creates a new instance of UsuarioBean
     */
    public PagoBean() {
        iPagoDAO = new IPagoDAOImp();
    }

    public List<Pago> getPagoList() {
        return iPagoDAO.obtenerPagos();

    }

    public void agregarPago(Pago pago) {
        iPagoDAO.crear(pago);
    }

    public int getLastPagoId() {
        int lastPagoId = 0;
        for (Pago unPago : getPagoList()) {
            if (unPago.getId() > lastPagoId) {
                lastPagoId = unPago.getId();
            }
        }
        return lastPagoId;
    }

}
