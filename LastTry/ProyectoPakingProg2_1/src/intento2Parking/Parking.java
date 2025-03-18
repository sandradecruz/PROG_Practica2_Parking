/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package intento2Parking;

import java.util.ArrayList;

/**
 *
 * @author sandr
 */
public class Parking {
    private int contador = 0; //Este es el contador que marcará la plaza ocupada, con valores incrementales de uno en uno
    private int[][] parking; //La matriz del parking 
    protected ArrayList<Ticket> tickets; //Lista de los tickets generados

    //Crea el parking con sus plazas y inicia los tickets
    public Parking(){
        this.parking = new int[3][20];  
        this.tickets = new ArrayList<>(); 
    }
    
    public ArrayList<Ticket> getTickets() {
        return tickets;  // Devuelve la lista de tickets
    }
    
    //El metodo de estacionar un coche en la posicion de la matriz que le corresponda
    public Ticket estacionar(String matricula) {
        for (int piso = 0; piso < parking.length; piso++) {
            for (int plaza = 0; plaza < parking[piso].length; plaza++) {
                if (parking[piso][plaza] == 0) {  // Si la plaza está libre
                    Ticket ticket = new Ticket(matricula, piso, plaza);  // Crear ticket
                    tickets.add(ticket);  // Agregar ticket al ArrayList
                    parking[piso][plaza] = contador;  // Usamos el contador
                    this.contador++;
                    return ticket;
                }
            }
        }
        return null;  // Parking lleno
    }
    
    //El metodo de liberar plaza cuando se saque un coche
    public void vaciarPlaza(Ticket ticket){
        for (int piso = 0; piso < parking.length; piso++) {
            for (int plaza = 0; plaza < parking[piso].length; plaza++) {
                if (parking[piso][plaza] == ticket.getId()) { //Busca usando el id del ticket, la posicion de coche asociado al ticket
                    parking[piso][plaza] = 0; // La plaza seleccionada queda libre
                    tickets.remove(ticket); // Eliminanos el ticket de la lista
                    return;
                }
            }
        }
    }
    
}