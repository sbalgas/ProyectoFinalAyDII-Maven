/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao;

import aplicacion.modelo.dominio.Usuario;
import java.util.List;

/**
 *
 * @author LILI-PC
 */
public interface IUsuarioDAO {
    void crear(Usuario usuario);
    void borrar(Usuario usuario);
    void actualizar(Usuario usuario);
    List<Usuario> obtenerUsuarios();

    public Usuario verificarCredenciales(String email, String password);
    
}
