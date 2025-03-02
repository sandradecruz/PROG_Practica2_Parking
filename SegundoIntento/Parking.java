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
    
    private int numMatricula = 1234;
    private String letrasMatricula = "ABC";
    
    public String generarMatricula(){
        String matricula = numMatricula +"-"+letrasMatricula; //Generamos la matricula
        if(numMatricula < 9999){
            numMatricula++; //Sumamos los numeros hasta que llegue al maximo (9999)
        }else{
            numMatricula = 0000; //Reseteamos el numero
            letrasMatricula = sumarLetra(letrasMatricula);
        }
        return matricula;
    }
    
    //AQUI VA EL MÉTODO PARA INCREMENTAR LAS LETRAS, AHORA MISMO NO TENGO NI IDEA
    //AUNQUE PREFIERO DEJAR ESTO PARA EL FINAL, YA QUE EN LA VIDA VAMOS A LLEGAR
    //A SUMAR UNA LETRA EN TODO LO QUE PRACTIQUEMOS, ASÍ QUE SOLO HE HECHOO QUE 
    //SUME NUMEROS
    private String sumarLetra (String letrasMatricula){
        return letrasMatricula;
    }
    
    
    //El metodo de estacionar
    public Ticket estacionar() {
    for (int piso = 0; piso < 3; piso++) {
        for (int plaza = 0; plaza < 20; plaza++) {
            if (parking[piso][plaza] == 0) {  // En el caso de que la plaza esté libre
                String matricula = generarMatricula(); //Solicitamos la matricula unica generada
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
    
}
