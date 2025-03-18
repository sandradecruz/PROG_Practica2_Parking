/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package intento2Parking;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author sandra
 */
public class Maquina {
    private double tarifaPorMinuto;
    private DepositoDinero deposito;
    private Parking parking;
    private int ntickets =0;
    
    
    public Maquina(double tarifaPorMinuto) {
        this.tarifaPorMinuto = tarifaPorMinuto;
        this.deposito = new DepositoDinero(); //Iniciamos la maquina con el deposito inicial
        this.parking = new Parking(); //A su vez la iniciamos tambien con el parking vacio
        
    }

   
    
    //Metodo para generar el ticket
    public Ticket generarTicket(String matricula) {
        this.ntickets++;  // Incrementar el contador de tickets
        Ticket ticket = parking.estacionar(matricula); // Intentar estacionar el coche

        if (ticket != null) {
            return ticket;  // Si hay espacio, devolver el ticket generado
        } else {
            return null;  // Si el parking está lleno, devolver null
        }
        
    }

    //Nuevo
    public ArrayList<Ticket> getTickets() {
        Parking tkt = new Parking();
        return tkt.tickets;  // Devuelve la lista de tickets
    }
    
    //Metodo para calcular la tarifa por el tiempo estacionado
    public double calcularTarifa(Ticket ticket) {
        long segundos = Duration.between(ticket.getFechaHoraEntrada(), LocalDateTime.now()).getSeconds(); //Obtenemos el tiempo estacionado en segundos
        double minutos = Math.ceil(segundos / 60.0); //Redondeamos hacia arriba y pasamos a minutos
        return minutos * tarifaPorMinuto; //Devolvemos el coste de la estancia
    }
    
    //Metodo para pagar el parking, recogiendo la cantidad introducida por el usuario ademas de su respectivo ticket, ya buscado en comprobarMatriculaPago
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
        return false; // Pago insuficiente
    }
}