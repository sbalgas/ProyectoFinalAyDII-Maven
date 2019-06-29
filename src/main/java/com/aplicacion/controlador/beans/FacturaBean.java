/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans;

import aplicacion.dao.IFacturaDAO;
import aplicacion.dao.imp.IFacturaDAOImp;
import aplicacion.modelo.dominio.Factura;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author sbalgass
 */
@ManagedBean
@RequestScoped
public class FacturaBean {

    private IFacturaDAO iFacturaDAO;
    /**
     * Creates a new instance of UsuarioBean
     */
    public FacturaBean() {
        iFacturaDAO = new IFacturaDAOImp();
    }
    
    public List<Factura> getFacturaList(){
        return iFacturaDAO.obtenerFacturas();
    }
    
    public List<Factura> getFacturaListByEmpresaYNumero(int empresa, int numero){
        return iFacturaDAO.obtenerFacturasSegunEmpresaYNumero(empresa, numero);
    }
    
    
}
