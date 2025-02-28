/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoparkingprog;

import java.util.ArrayList;
import java.time.LocalTime;
import java.util.List;

/**
 *
 * @author David
 */
public class Ticket {

    public int[][] getParking() {
        return parking;
    }

    public void setParking(int[][] parking) {
        this.parking = parking;
    }

    public LocalTime getFechaHora() {
        return fechaHoraL;
    }

    public void setFechaHora(LocalTime fechaHora) {
        this.fechaHoraL = fechaHora;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public int getPlaza() {
        return plaza;
    }

    public void setPlaza(int plaza) {
        this.plaza = plaza;
    }

    public ArrayList<Ticket> getNuevoTicket() {
        return nuevoTicket;
    }

    public void setNuevoTicket(ArrayList<Ticket> nuevoTicket) {
        this.nuevoTicket = nuevoTicket;
    }

    int[][] parking = new int[3][20];
    int id;
    LocalTime fechaHoraL = LocalTime.now();
    int fechaInt = parseador(fechaHoraL);
    //String matriz = ;  Tenemos que obtener la matriz que el usuario ponga en el apartado visual
    int piso;
    int plaza;
    ArrayList<Ticket> nuevoTicket = new ArrayList<>();

    public ArrayList CrearnuevoTicket(int id, LocalTime fechaHora, int piso, int plaza) {
        ArrayList<Integer> nuevoTicket = new ArrayList<>();
        nuevoTicket.add(id + 1); // Incrementamos el ID
        nuevoTicket.add(fechaInt);
        nuevoTicket.add(piso);
        nuevoTicket.add(plaza);
        return nuevoTicket;
    }
    

    public static int parseador(LocalTime hora) {
        return hora.getHour() * 10000 + hora.getMinute() * 100 + hora.getSecond();
    }
    
}
