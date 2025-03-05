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
    private int contador = 0; //Este es el contador que marcará la plaza ocupada, con valores incrementales
    private int[][] parking; //matriz del parking
    private ArrayList<Ticket> tickets; //Lista de los tickets generados

    public Parking(){
        this.parking = new int[3][20];  // Inicializa todas las plazas
        this.tickets = new ArrayList<>(); //Inicializa los tickets
    }
    
    
    
    //El metodo de estacionar
    public Ticket estacionar(String matricula) {
    for (int piso = 0; piso < parking.length; piso++) {
        for (int plaza = 0; plaza < parking[piso].length; plaza++) {
            if (parking[piso][plaza] == 0) {  // En el caso de que la plaza esté libre
                Ticket ticket = new Ticket(matricula, piso, plaza);  // Creamos el ticket
                tickets.add(ticket);  // Guardamos el ticket en el array de tickets
                parking[piso][plaza] = contador;  // Marcar la plaza como ocupada
                contador++; //Sumamos valor al contador
                return ticket;
            }
        }
    }
    return null;  // Parking lleno
    }
    
    //El metodo de liberar plaza
    public void vaciarPlaza(Ticket ticket){
        for (int piso = 0; piso < parking.length; piso++) {
            for (int plaza = 0; plaza < parking[piso].length; plaza++) {
                if (parking[piso][plaza] == ticket.getId()) {
                    parking[piso][plaza] = 0; // La plaza seleccionada queda libre
                    tickets.remove(ticket); // Eliminanos el ticket de la lista
                    return;
                }
            }
        }
    }
    
}