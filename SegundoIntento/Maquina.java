/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package intento2Parking;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 *
 * @author sandr
 */
public class Maquina {
    private double tarifaPorMinuto;
    private DepositoDinero deposito;
    private Parking parking;
    
    public Maquina(double tarifaPorMinuto) {
        this.tarifaPorMinuto = tarifaPorMinuto;
        this.deposito = new DepositoDinero(); // Inicializa con el dinero disponible
        this.parking = new Parking(); 
    }
    
    public Ticket generarTicket(String matricula) {
        return parking.estacionar(matricula);
    }
    
    public double calcularTarifa(Ticket ticket) {
    long segundos = Duration.between(ticket.getFechaHoraEntrada(), LocalDateTime.now()).getSeconds();
    double minutos = Math.ceil(segundos / 60.0); //Redondeamos hacia arriba
    return minutos * tarifaPorMinuto; //Devolvemos el coste de la estancia
}
}
