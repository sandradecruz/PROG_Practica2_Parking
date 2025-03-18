/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package intento2Parking;

/**
 *
 * @author sandra
 */

//CLASE PRINCIPAL EN LA QUE SE INICIA TODO EL PROGRAMA
public class Principal {
    public static void main(String[] args) {
        Maquina maquina = new Maquina (0.5); //Iniciamos la maquina, enviandola el valor de la tarifa/minuto
        Terminal terminal = new Terminal(); //Creamos e iniciamos la terminal para comenzar con el programa
        terminal.setVisible(true); //Y mostramos la ventana para comenzar
    }
}