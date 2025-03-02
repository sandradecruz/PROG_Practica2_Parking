/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package intento2Parking;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author sandr
 */
public class Ticket {
    
    private static int contador = 1; // Para generar IDs únicos
    private int id;
    private String matricula;
    private LocalDateTime fechaHoraEntrada;
    private int piso;
    private int plaza;
    
    public Ticket (String matricula, int piso, int plaza){
        this.id = contador++;
        this.matricula = matricula;
        this.fechaHoraEntrada = LocalDateTime.now();
        this.piso = piso;
        this.plaza = plaza;
    }
    
    //getters
    public int getId() {
        return id;
    }

    public String getMatricula() {
        return matricula;
    }

    public LocalDateTime getFechaHoraEntrada() {
        return fechaHoraEntrada;
    }

    public int getPiso() {
        return piso;
    }

    public int getPlaza() {
        return plaza;
    }

    //Override para mostrar el tiket, habrá que ponerlo mas coquette
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss");
        return "Ticket{id=" + id + ", fechaHora=" + fechaHoraEntrada.format(formatter) + ", matricula=" + matricula + ", sitio=piso=" + piso + ", plaza=" + plaza + "}";
    }
}
