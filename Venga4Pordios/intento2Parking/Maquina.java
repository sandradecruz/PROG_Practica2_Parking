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
    
    //Metodo para pagar el parking, recogiendo la cantidad introducida por el usuario ademas de su respectivo ticket.
    //Tras pagar, se vacia la plaza
    //HE HECHO EL METODO EN BOOLEAN PORQUE LO VEIA MAS EFICIENTE, PERO LO PUEDES HACER A TU GUSTO
    public boolean pagarYSalir(Ticket ticket, double cantidadIntroducida) {
        double totalAPagar = calcularTarifa(ticket);
        if (cantidadIntroducida >= totalAPagar) { //Verifica si el usuario a introducido el dinero suficiente
            double cambio = cantidadIntroducida - totalAPagar;
            if (deposito.hayCambio(cambio)) { //Verificamos sin necesita cambio o nos ha dado justo
                int[] cambioEntregado = deposito.calcularCambio(cambio);
                if (cambioEntregado != null) { //Verificamos si la maquina puede dar el cambio
                    parking.vaciarPlaza(ticket);
                    System.out.println("Pago realizado con éxito.");
                    deposito.mostrarCambio(cambioEntregado);
                    return true;
                }
            }
        }
        System.out.println("Error. Pago insuficiente o sin cambio disponible.");
        return false; // Pago incompleto
    }
}