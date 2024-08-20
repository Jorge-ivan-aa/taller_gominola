package co.edu.uniquindio.gominola.model;

import co.edu.uniquindio.gominola.model.services.Disponibilidad;

public class Acompanante {
    private String nombre;
    private String edad;
    private String talla;
    private String correo;
    private String telefono;
    private String saludo;
    private int valorHora;
    private Disponibilidad disponibilidad;

    public Acompanante(String nombre, String edad, String talla, String correo, String telefono, String saludo, int valorHora) {
        this.nombre = nombre;
        this.edad = edad;
        this.talla = talla;
        this.correo = correo;
        this.telefono = telefono;
        this.saludo = saludo;
        this.valorHora = valorHora;
        this.disponibilidad = Disponibilidad.DIPONIBLE;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getSaludo() {
        return saludo;
    }

    public void setSaludo(String saludo) {
        this.saludo = saludo;
    }

    public int getValorHora() {
        return valorHora;
    }

    public void setValorHora(int valorHora) {
        this.valorHora = valorHora;
    }

    public void setNoDisponibilidad() {
        this.disponibilidad = Disponibilidad.OCUPADX;
    }
}
