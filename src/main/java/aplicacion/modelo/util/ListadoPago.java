/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.modelo.util;

import aplicacion.modelo.dominio.Pago;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sbalgass
 */
public class ListadoPago {
    private List<Pago> listaPagos;

    public ListadoPago() {
        listaPagos = new ArrayList<>();
    }    
    
    public void agregar(Pago pago){
        listaPagos.add(pago);
    }
    
    public void eliminar(Pago pago){
        for(int i = 0; i< listaPagos.size();i++){
            if(listaPagos.get(i).getId() == pago.getId()){
                listaPagos.remove(i);
            }
        }
    }
    
    public void modificar(Pago pagoModificado){
        for(Pago pago : listaPagos){
            if(pago.getId() == pagoModificado.getId()){
                pago = pagoModificado;
            }
        }
    }

    public List<Pago> getListaPagos() {
        return listaPagos;
    }

    public void setListaPagos(List<Pago> listaPagos) {
        this.listaPagos = listaPagos;
    }
    
}
