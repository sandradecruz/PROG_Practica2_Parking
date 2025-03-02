/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package intento2Parking;

/**
 *
 * @author sandr
 */
public class Principal {
    public static void main(String[] args) {
        Maquina maquina = new Maquina (0.50); //Creamos la maquina pasando la tarifa por minuto
        Terminal terminal = new Terminal();
        terminal.setVisible(true);
    }
}
