// Benjamin Sossa - Contador con Runnableque que incrementa un contador global compartido por dos hilos.

package com.mycompany.hilo;

class Contador {

    private int contador = 0;

    public synchronized void incrementar() {
        contador++;
        System.out.println(Thread.currentThread().getName() + "  " + contador);
    }

    public int getValor() {
        return contador;
    }
}

class TareaContador implements Runnable {

    private final Contador contadorCompartido;

    public TareaContador(Contador contador) {
        this.contadorCompartido = contador;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            contadorCompartido.incrementar();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " fue interrumpido.");
            }
        }
    }
}

public class Hilo3 {

    public static void main(String[] args) {
        Contador contador = new Contador(); 

        Thread hilo1 = new Thread(new TareaContador(contador), "Hilo-1");
        Thread hilo2 = new Thread(new TareaContador(contador), "Hilo-2");

        hilo1.start();
        hilo2.start();

        try {
            hilo1.join();
            hilo2.join();
        } catch (InterruptedException e) {
            System.out.println("El hilo principal fue interrumpido.");
        }

        System.out.println("Valor final del contador: " + contador.getValor());
    }
}
