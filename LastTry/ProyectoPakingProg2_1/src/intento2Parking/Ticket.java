/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package intento2Parking;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author sandra
 */
public class Ticket {
    
    private static int contadorID = 0; // Para generar IDs unicos
    private int id;
    private String matricula;
    private LocalDateTime fechaHoraEntrada;
    private int piso;
    private int plaza;
    
    public Ticket (String matricula, int piso, int plaza){
        this.id = contadorID++; //Sumamos el contador de los id, ya que son unicos y no se pueden repetir
        this.matricula = matricula;
        this.fechaHoraEntrada = LocalDateTime.now(); //Obtenemos la fecha actual de llegada
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

    //Override para mostrar el ticket
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss");
           return "\n===============================" +
               "\n   TICKET DE ESTACIONAMIENTO   " +
               "\n===============================" +
               "\n ID: " + id +
               "\n Fecha y Hora: " + fechaHoraEntrada.format(formatter) +
               "\n Matrícula: " + matricula +
               "\n Ubicación: Piso " + piso + " - Plaza " + plaza +
               "\n===============================\n";
    }
}