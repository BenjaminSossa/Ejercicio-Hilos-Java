// Benjamin Sossa - Hilo que imprime números

package com.mycompany.hilo;

class HiloNumeros extends Thread {

    @Override
    public void run() {
        try {
            // Bucle que imprime los números del 1 al 10
            for (int i = 1; i <= 10; i++) {
                System.out.println("Número: " + i);
                // Pausa de 1 segundo (1000 milisegundos)
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("El hilo fue interrumpido.");
        }
    }
}

public class Hilo1 {

    public static void main(String[] args) {
        // Crear una instancia del hilo
        HiloNumeros hilo = new HiloNumeros();

        // Iniciar la ejecución del hilo
        hilo.start();

        System.out.println("Hilo iniciado, imprimiendo números...");
    }
}
