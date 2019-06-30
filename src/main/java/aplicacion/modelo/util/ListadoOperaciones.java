/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.modelo.util;

import aplicacion.modelo.dominio.Operacion;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sbalgass
 */
public class ListadoOperaciones {
    private List<Operacion> listaOperaciones;

    public ListadoOperaciones() {
        listaOperaciones = new ArrayList<>();
    }
    
    public void agregar(Operacion operacion){
        listaOperaciones.add(operacion);
    }
    
    public void eliminar(Operacion operacion){
        for(int i = 0; i< listaOperaciones.size();i++){
            if(listaOperaciones.get(i).getId() == operacion.getId()){
                listaOperaciones.remove(i);
            }
        }
        
    }
    
    public void modificar(Operacion operacionModificado){
        for(Operacion operacion : listaOperaciones){
            if(operacion.getId() == operacionModificado.getId()){
                operacion = operacionModificado;
            }
        }
    }

    public List<Operacion> getListaOperaciones() {
        return listaOperaciones;
    }

    public void setListaOperaciones(List<Operacion> listaOperaciones) {
        this.listaOperaciones = listaOperaciones;
    }
    
}
