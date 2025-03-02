/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package intento2Parking;

/**
 *
 * @author sandr
 */
public class DepositoDinero {
    private final double[] valores = {20, 10, 5, 2, 1, 0.5, 0.2, 0.1, 0.05}; // Valores admitidos en el deposito de dinero.
    private int[] cantidades; // Cantidad disponible de cada tipo de moneda

    public DepositoDinero() {
        cantidades = new int[valores.length];
        for (int i = 0; i < valores.length; i++) {
            cantidades[i] = 100; // Inicialmente 100 unidades de cada tipo
        }
    }

    // Metodo para agregar dinero al deposito
    public void agregarDinero(double valor, int cantidad) {
        for (int i = 0; i < valores.length; i++) {
            if (valores[i] == valor) {
                cantidades[i] += cantidad;
                return;
            }
        }
        //Esto no va a saltar nunca gracias a la lista y el scroll para seleccionar los billetes y su cantidad
        System.out.println("Valor no válido: " + valor);
    }

    // ARREGLAR Verificación de que se necesite cambio
    public boolean hayCambio(double cambio) {
        int[] copiaCantidades = cantidades.clone();
        return calcularCambio(cambio, copiaCantidades) != null;
    }

    // Calculo y entrega del cambio optimizado.
    public int[] calcularCambio(double cantidad) {
        int[] cambioEntregado = calcularCambio(cantidad, cantidades);
        if (cambioEntregado != null) {
            // Restamos del depósito el tipo de moneda dada como cambio
            for (int i = 0; i < valores.length; i++) {
                cantidades[i] -= cambioEntregado[i];
            }
        }
        return cambioEntregado;
    }

    // Calculamos el cambio óptimo
    private int[] calcularCambio(double cantidad, int[] depositoTemporal) { //cambio int[] depositoTemporal por double costeParking para hacer pruebas
        int[] cambio = new int[valores.length];

        for (int i = 0; i < valores.length; i++) {
            if (cantidad <= 0.01) break; //Optimizar
            int disponibles = depositoTemporal[i];
            int cantidadUsada = (int) (cantidad / valores[i]);

            if (cantidadUsada > 0) {
                cantidadUsada = Math.min(disponibles, cantidadUsada);
                cambio[i] = cantidadUsada;
                cantidad -= cantidadUsada * valores[i];
                cantidad = Math.round(cantidad * 100.0) / 100.0; // Redondeamos a lo alto.
            }
        }
        if (cantidad > 0.05) return null;
        return cambio;
    }

    // Cantidad de monedas que hay en el deposito
    public void mostrarDeposito() {
        System.out.println("Estado del depósito:");
        for (int i = 0; i < valores.length; i++) {
            System.out.println(valores[i] + "€: " + cantidades[i] + " unidades");
        }
    }
}
