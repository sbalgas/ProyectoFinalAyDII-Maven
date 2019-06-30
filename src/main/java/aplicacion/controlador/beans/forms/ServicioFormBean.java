package aplicacion.controlador.beans.forms;

import aplicacion.controlador.beans.ServicioBean;
import aplicacion.modelo.dominio.Servicio;
import aplicacion.modelo.dominio.Usuario;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class ServicioFormBean implements Serializable {

    @ManagedProperty(value = "#{servicioBean}")
    private ServicioBean servicioBean;

    private List<Servicio> servicioList;
    private String servicio;
    private String numeroServicio;

    public ServicioFormBean() {
        servicioList = new ArrayList<>();
        Usuario user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
        if (user == null) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
            } catch (IOException ex) {
            }
        }
    }

    @PostConstruct
    public void init() {
        Usuario user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
        if (user != null) {
            servicioList = servicioBean.obtenerServiciosPorIds(user.getServiciosHabilitados());
        }
    }

    public String buscarFacturasPorServicioYEmpresa() {
        FacesContext.getCurrentInstance().getExternalContext()
                .getSessionMap().put("numero", null);

        FacesContext.getCurrentInstance().getExternalContext()
                .getSessionMap().put("empresa", null);

        return "facturas?faces-redirect=true&empresa=" + servicio
                + "&numero=" + numeroServicio;
    }

    public ServicioBean getServicioBean() {
        return servicioBean;
    }

    public void setServicioBean(ServicioBean servicioBean) {
        this.servicioBean = servicioBean;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getNumeroServicio() {
        return numeroServicio;
    }

    public void setNumeroServicio(String numeroServicio) {
        this.numeroServicio = numeroServicio;
    }

    public String goToCrearServicio() {
        return "crear-servicio?faces-redirect=true";
    }

    public List<Servicio> getServicioList() {
        return servicioList;
    }

    public void setServicioList(List<Servicio> servicioList) {
        this.servicioList = servicioList;
    }

}
