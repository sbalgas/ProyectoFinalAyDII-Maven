/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans;

import aplicacion.dao.IUsuarioDAO;
import aplicacion.dao.imp.IUsuarioDAOImp;
import aplicacion.modelo.dominio.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author sbalgass
 */
@ManagedBean
@RequestScoped
public class UsuarioBean {

    private IUsuarioDAO iUsuarioDAO;

    /**
     * Creates a new instance of UsuarioBean
     */
    public UsuarioBean() {
        iUsuarioDAO = new IUsuarioDAOImp();
    }

    public Usuario verifyCredentials(String email, String password) {
        return iUsuarioDAO.verificarCredenciales(email, password);
    }

    public void registerNewUser(Usuario user) {
        iUsuarioDAO.crear(user);
    }

    public IUsuarioDAO getiUserDAO() {
        return iUsuarioDAO;
    }

    public void setiUserDAO(IUsuarioDAO iUsuarioDAO) {
        this.iUsuarioDAO = iUsuarioDAO;
    }

    public void actualizar(Usuario user) {
        iUsuarioDAO.actualizar(user);
    }

}
