/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package intento2Parking;

/**
 *
 * @author sandra
 */
public class DepositoDinero {
    private final double[] valores = {20, 10, 5, 2, 1, 0.5, 0.2, 0.1, 0.05}; // Los valores admitidos en el deposito de dinero.
    private int[] cantidades; // La cantidad disponible de cada tipo de moneda

    public DepositoDinero() {
        cantidades = new int[valores.length];
        for (int i = 0; i < valores.length; i++) {
            cantidades[i] = 100; // Iniciamos el deposito con 100 unidades de cada tipo de moneda
        }
    }

    // Metodo para agregar dinero al deposito
    public void agregarDinero(double valor, int cantidad) {
        for (int i = 0; i < valores.length; i++) {
            if (valores[i] == valor) { //Buscamos el valor
                cantidades[i] += cantidad; //Lo sumamos en su cantidad correspondiente
                return;
            }
        }
        System.out.println("El valor no es valido: " + valor);
    }

    //Metodo para comprobar si hay cambio disponible
    public boolean hayCambio(double cambio) {
        int[] copiaCantidades = cantidades.clone();
        return calcularCambioOptimo(cambio, copiaCantidades) != null;
    }

    // Calculo y entrega del cambio optimizado.
    public int[] calcularCambio(double cantidad) {
        int[] cambioEntregado = calcularCambioOptimo(cantidad, cantidades);
        if (cambioEntregado != null) {
            // Restamos del depósito el tipo de moneda dada como cambio
            for (int i = 0; i < valores.length; i++) {
                cantidades[i] -= cambioEntregado[i];
            }
        }
        return cambioEntregado;
    }

    // Calculamos el cambio optimo
    private int[] calcularCambioOptimo(double cantidad, int[] depositoTemporal) {
        int[] cambio = new int[valores.length];
        
        for (int i = 0; i < valores.length; i++) {
            int disponibles = depositoTemporal[i];
            int cantidadUsada = (int) (cantidad / valores[i]);

            if (cantidadUsada > 0) { 
                cantidadUsada = Math.min(disponibles, cantidadUsada);
                cambio[i] = cantidadUsada;
                cantidad -= cantidadUsada * valores[i];
            }
        }
        if (cantidad == 0) return cambio;
        return null;
    }

    
    // Metodo para mostrar el cambio entregado
    public void mostrarCambio(int[] cambio) {
        System.out.println("Cambio entregado:");
        for (int i = 0; i < valores.length; i++) {
            if (cambio[i] > 0) {
                System.out.println(cambio[i] + " moneda(s)/billete(s) de " + valores[i] + "€");
            }
        }
    }
    
    //Metodo para pruebas
    // Metodo para mostrar la cantidad de monedas que hay en el deposito
    public void mostrarDeposito() {
        System.out.println("Estado del depósito:");
        for (int i = 0; i < valores.length; i++) {
            System.out.println(valores[i] + "€: " + cantidades[i] + " unidades");
        }
    }
    
}