/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.modelo.dominio;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LILI-PC
 */
public class Usuario {

    private int id;
    private String nombre;
    private String apellido;
    private String correo;
    private String contraseña;
    private List<Integer> serviciosHabilitados;

    public Usuario() {
        this.serviciosHabilitados = new ArrayList<>();
    }

    public Usuario(int id, String nombre, String apellido, String correo, String contraseña) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contraseña = contraseña;
        this.serviciosHabilitados = new ArrayList<>();
    }

    public Usuario(int id, String nombre, String apellido, String correo, String contraseña, List<Integer> serviciosHabilitados) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contraseña = contraseña;
        this.serviciosHabilitados = serviciosHabilitados;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public List<Integer> getServiciosHabilitados() {
        return serviciosHabilitados;
    }

    public void setServiciosHabilitados(List<Integer> serviciosHabilitados) {
        this.serviciosHabilitados = serviciosHabilitados;
    }

    public void addServiciosHabilitados(Integer servicioHabilitado) {
        this.serviciosHabilitados.add(servicioHabilitado);
    }
}
