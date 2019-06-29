package aplicacion.controlador.beans.forms;

import aplicacion.controlador.beans.FacturaBean;
import aplicacion.controlador.beans.OperacionBean;
import aplicacion.controlador.beans.PagoBean;
import aplicacion.controlador.beans.ServicioBean;
import aplicacion.modelo.dominio.Factura;
import aplicacion.modelo.dominio.Operacion;
import aplicacion.modelo.dominio.Pago;
import aplicacion.modelo.dominio.Usuario;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class CheckoutFormBean implements Serializable {

    @ManagedProperty(value = "#{facturaBean}")
    private FacturaBean facturaBean;

    @ManagedProperty(value = "#{pagoBean}")
    private PagoBean pagoBean;

    @ManagedProperty(value = "#{servicioBean}")
    private ServicioBean servicioBean;

    @ManagedProperty(value = "#{operacionBean}")
    private OperacionBean operacionBean;

    private List<Factura> facturas;
    private double subTotal;
    private Usuario usuario;

    private String marcaTarjeta;
    private String numeroTarjeta;
    private String titularTarjeta;
    private String vencimientoTarjeta;
    private int codigoTarjeta;

    public CheckoutFormBean() {
        usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
        if (usuario == null) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
            } catch (IOException ex) {
            }
        }
    }

    @PostConstruct
    public void init() {
        facturas = (List<Factura>) FacesContext.getCurrentInstance().getExternalContext()
                .getSessionMap().get("facturasAPagar");

        facturas.stream().forEach((unaFactura) -> {
            subTotal += unaFactura.getImporte();
        });

    }

    public String pagarFacturas() {

        Pago nuevoPago = new Pago();
        nuevoPago.setId(pagoBean.getLastPagoId() + 1);
        nuevoPago.setMarca(this.marcaTarjeta);
        nuevoPago.setNumeroDeTarjeta(this.numeroTarjeta);
        nuevoPago.setTitularTarjeta(this.titularTarjeta);
        nuevoPago.setCodigoDeSeguridad(this.codigoTarjeta);
        nuevoPago.setFecha(Calendar.getInstance().getTime());
        nuevoPago.setEstado(0);

        try {
            nuevoPago.setFechaVecimiento(
                    new SimpleDateFormat("MM/yyyy")
                    .parse(this.vencimientoTarjeta));
        } catch (ParseException ex) {
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "",
                    "Error al verificar la fecha de vencimiento."));
        }

        // Se crea el Pago
        pagoBean.agregarPago(nuevoPago);

        Operacion nuevaOperacion = new Operacion();
        nuevaOperacion.setId(operacionBean.getLastOperacionId() + 1);
        nuevaOperacion.setFecha(Calendar.getInstance().getTime());
        nuevaOperacion.setPago(nuevoPago);
        nuevaOperacion.setUsuario(usuario);

        facturas.stream().forEach((unaFactura) -> {
            nuevaOperacion.setServicio(servicioBean.
                    obtenerUnServicioPorId(unaFactura.getEmpresaId()));
        });
        
        nuevaOperacion.setFactura(facturas);
        
        // Se crea la operacion
        operacionBean.crear(nuevaOperacion);

        FacesContext.getCurrentInstance().getExternalContext()
                .getSessionMap().put("ultimaOperacion", nuevaOperacion);
        
        return "exito?faces-redirect=true";
    }

    public FacturaBean getFacturaBean() {
        return facturaBean;
    }

    public void setFacturaBean(FacturaBean facturaBean) {
        this.facturaBean = facturaBean;
    }

    public PagoBean getPagoBean() {
        return pagoBean;
    }

    public void setPagoBean(PagoBean pagoBean) {
        this.pagoBean = pagoBean;
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public String getMarcaTarjeta() {
        return marcaTarjeta;
    }

    public void setMarcaTarjeta(String marcaTarjeta) {
        this.marcaTarjeta = marcaTarjeta;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getTitularTarjeta() {
        return titularTarjeta;
    }

    public void setTitularTarjeta(String titularTarjeta) {
        this.titularTarjeta = titularTarjeta;
    }

    public String getVencimientoTarjeta() {
        return vencimientoTarjeta;
    }

    public void setVencimientoTarjeta(String vencimientoTarjeta) {
        this.vencimientoTarjeta = vencimientoTarjeta;
    }

    public int getCodigoTarjeta() {
        return codigoTarjeta;
    }

    public void setCodigoTarjeta(int codigoTarjeta) {
        this.codigoTarjeta = codigoTarjeta;
    }

    public ServicioBean getServicioBean() {
        return servicioBean;
    }

    public void setServicioBean(ServicioBean servicioBean) {
        this.servicioBean = servicioBean;
    }

    public OperacionBean getOperacionBean() {
        return operacionBean;
    }

    public void setOperacionBean(OperacionBean operacionBean) {
        this.operacionBean = operacionBean;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
}
