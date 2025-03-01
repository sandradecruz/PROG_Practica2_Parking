/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica2parking;

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

    private static final double TARIFA_POR_MINUTO = 0.50;
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
     public static void Aparcamiento(int[][] matriz) {
        for (int i = 0; i < parking.length; i++) {
            for (int j = 0; j < parking[i].length; j++) {
                if (matriz[i][j] == 0) {
                    piso = i;
                    plaza = j;
                    matriz[i][j] = 1;
                    return;
                } /*Vale esto funciona pero estaba pensando que estaria bien que
                una vez asegurado que no hay espacio en el parking, que no te dejase.
                No se me ocurre como, probablemente por las horas, pero si se te ocurre algo ponlo aqui,
                de todas maneras, me comprometo a buscar algo para solucionarlo
                */
            }
        }
    }
    
    // Método para calcular el costo del estacionamiento
    public double calcularCosto() {
        LocalTime salida = LocalTime.now();
        int minutosEstacionados = salida.toSecondOfDay() / 60 - fechaHoraL.toSecondOfDay() / 60;
        if (minutosEstacionados <= 0) minutosEstacionados = 1; //Añadimos como mínimo un minuto de estacionamiento
        return minutosEstacionados * TARIFA_POR_MINUTO;
    }

    public static int parseador(LocalTime hora) {
        return hora.getHour() * 10000 + hora.getMinute() * 100 + hora.getSecond();
    }
    
}
