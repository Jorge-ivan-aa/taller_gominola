package co.edu.uniquindio.gominola.model;

import java.util.Date;

public class Cita {
    private Acompanante acompanante;
    private Cliente cliente;
    private Date fecha;
    private String hora;
    private String lugar;
    private int horas;

    public Cita(Date fecha, String hora, String lugar, int horas) {
        this.fecha = fecha;
        this.hora = hora;
        this.lugar = lugar;
        this.horas = horas;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }
}
