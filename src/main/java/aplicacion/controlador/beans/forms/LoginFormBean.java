
package aplicacion.controlador.beans.forms;

import aplicacion.controlador.beans.UsuarioBean;
import aplicacion.modelo.dominio.Usuario;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class LoginFormBean implements Serializable {

    @ManagedProperty(value = "#{usuarioBean}")
    private UsuarioBean userBean;

    private String email;
    private String password;

    /**
     * Creates a new instance of LoginFormBean
     */
    public LoginFormBean() {
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public UsuarioBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UsuarioBean userBean) {
        this.userBean = userBean;
    }

    /**
     * Se verifica el logueo.
     * @return
     */
    public String verifyCredentials() {
        String resultado = "";

        Usuario user = userBean.verifyCredentials(email, password);
        if (user != null) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", user);
            resultado = "pagar-servicio?faces-redirect=true";
        } else {
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Accesso Denegado", "Credenciales Incorrectas"));
        }
        return resultado;
    }

    public String gotToSignUp() {
        return "sign-up?faces-redirect=true";
    }

    public String goToLogin() {
        return "login?faces-redirect=true";
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "login?faces-redirect=true";
    }
    
    /**
     * Si hay un usuario en sesión retornará verdadero.
     *
     * @return
     */
    public boolean isLogged() {
        Usuario user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
        return user != null;
    }
    
    public String getUserName(){
        Usuario user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
        return (user != null) ? "Bienvenido/a " + user.getNombre() : "";
    }
    
    public boolean checkLoggedStatus(){
        if (this.isLogged()){
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("faces/pagar-servicio.xhtml");
            } catch (IOException ex) {
            }
        }
        
        return true;
    }

}