package aplicacion.controlador.beans.forms;

import aplicacion.controlador.beans.FacturaBean;
import aplicacion.modelo.dominio.Factura;
import aplicacion.modelo.dominio.Usuario;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class FacturaFormBean implements Serializable {

    @ManagedProperty(value = "#{facturaBean}")
    private FacturaBean facturaBean;

    private List<Factura> facturaList;
    private List<Factura> facturaSelected;
    private double subTotal;
    private String titularFactura;
    private String domicilio;

    public FacturaFormBean() {
        Usuario user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
        if (user == null) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
            } catch (IOException ex) {
            }
        }

        Map<String, String> params = FacesContext.getCurrentInstance().
                getExternalContext().getRequestParameterMap();

        if (params.get("numero") != null) {
            FacesContext.getCurrentInstance().getExternalContext()
                    .getSessionMap().put(
                            "numero",
                            Integer.parseInt(params.get("numero")));
        }

        if (params.get("empresa") != null) {
            FacesContext.getCurrentInstance().getExternalContext()
                    .getSessionMap().put("empresa", Integer.parseInt(params.get("empresa")));
        }
    }

    @PostConstruct
    public void init() {
        int empresa = (int) FacesContext.getCurrentInstance().getExternalContext()
                .getSessionMap().get("empresa");

        int numero = (int) FacesContext.getCurrentInstance().getExternalContext()
                .getSessionMap().get("numero");

        facturaList = facturaBean.getFacturaListByEmpresaYNumero(empresa, numero);

        for (Factura unaFactura : facturaList) {
            titularFactura = unaFactura.getTitularFactura();
            domicilio = unaFactura.getDomicilio();
            break;
        }
    }

    public String procederAlCheckout() {
        String result = "checkout?faces-redirect=true";
        
        if (facturaSelected.isEmpty()) {
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Seleccione las facturas a pagar."));
            result = "";
        }
        
        FacesContext.getCurrentInstance().getExternalContext()
                    .getSessionMap().put("facturasAPagar", facturaSelected);
        
        return result;
    }

    public void toggleCheckbox() {
        double newSubTotal = 0;
        for (Factura factura : facturaSelected) {
            newSubTotal += factura.getImporte();
        }
        this.subTotal = newSubTotal;
    }

    public FacturaBean getFacturaBean() {
        return facturaBean;
    }

    public void setFacturaBean(FacturaBean facturaBean) {
        this.facturaBean = facturaBean;
    }

    public List<Factura> getFacturaList() {
        return facturaList;
    }

    public void setFacturaList(List<Factura> facturaList) {
        this.facturaList = facturaList;
    }

    public List<Factura> getFacturaSelected() {
        return facturaSelected;
    }

    public void setFacturaSelected(List<Factura> facturaSelected) {
        this.facturaSelected = facturaSelected;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public String getTitularFactura() {
        return titularFactura;
    }

    public void setTitularFactura(String titularFactura) {
        this.titularFactura = titularFactura;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

}
