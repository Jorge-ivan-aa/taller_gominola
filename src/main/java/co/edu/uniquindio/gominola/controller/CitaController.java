package co.edu.uniquindio.gominola.controller;

import co.edu.uniquindio.gominola.factory.ModelFactory;
import co.edu.uniquindio.gominola.model.Acompanante;
import co.edu.uniquindio.gominola.model.Cita;
import co.edu.uniquindio.gominola.model.Cliente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class CitaController {
    private ModelFactory factory;
    private ObservableList<Cita> listaCitaObservable;

    public CitaController() {
        this.factory = ModelFactory.getIntance();
        this.listaCitaObservable =  FXCollections.observableArrayList();
        this.sincronizarData();
    }

    public ObservableList<Cita> getListaCitaObservable() {
        return listaCitaObservable;
    }

    public void sincronizarData() {
        this.listaCitaObservable.addAll(this.factory.getGominola().getListaCita());
    }

    public String eliminarCita(String nombre) {

        if (this.consultarCita(nombre) == null) {
            return "La cita ingresada no existe";
        } else {
            int index = -1;
            ArrayList<Cita> Citas = factory.getGominola().getListaCita();
            for (int i = 0; i < Citas.size(); i++) {
                if (Objects.equals(Citas.get(i).getAcompanante().getNombre(), nombre)) {
                    index = i;
                }
            }

            if (index != -1) {
                this.listaCitaObservable.remove(Citas.get(index));
                Citas.remove(Citas.get(index));
            }

            return "La cita fue eliminado correctamente";
        }
    }

    public Cita consultarCita(String nombre){
        ArrayList<Cita> cita = this.factory.getGominola().getListaCita();
        for (Cita value : cita) {
            if (value.getAcompanante().getNombre().equals(nombre)){
                return value;
            }
        }
        return null;
    }

    public String crearCita(Acompanante acompanante, Cliente cliente, Date fecha, String hora, String lugar, int horas) {
        ArrayList<Cita> citas = factory.getGominola().getListaCita();

        if (this.consultarCita(acompanante.getNombre()) != null) {
            return "La cita ingresada ya existe";
        } else {
            Cita nuevoCita = new Cita(acompanante, cliente, fecha, hora, lugar, horas);
            this.factory.getGominola().addCita(nuevoCita);
            this.listaCitaObservable.add(nuevoCita);
            return "Cita registrado exitosamente";
        }

    }

    public String actualizarCita(Acompanante acompanante, Cliente cliente, Date fecha, String hora, String lugar, int horas){
        ArrayList<Cita> citas = factory.getGominola().getListaCita();

        if (this.consultarCita(acompanante.getNombre()) == null) {
            return "La cita ingresada no existe";

        } else {
            for (int i = 0; i < citas.size(); i++) {
                if (Objects.equals(citas.get(i).getAcompanante().getNombre(), acompanante.getNombre())) {
                    Cita nuevoCita = new Cita(acompanante, cliente, fecha, hora, lugar, horas);
                    citas.remove(citas.get(i));
                    citas.add(nuevoCita);
                    this.listaCitaObservable.remove(citas.get(i));
                    this.listaCitaObservable.add(nuevoCita);

                }

            }
            return "La cita ingresada fue actualizada";
        }
    }

}