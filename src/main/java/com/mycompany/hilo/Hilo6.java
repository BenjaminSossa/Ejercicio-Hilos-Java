package com.mycompany.hilo;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Tarea implements Runnable {

    private final int numero;

    public Tarea(int numero) {
        this.numero = numero;
    }

    @Override
    public void run() {
        System.out.println("Tarea " + numero + " en ejecución por " + Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Tarea " + numero + " completada por " + Thread.currentThread().getName());
    }
}

public class Hilo6 {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 5; i++) {
            executor.execute(new Tarea(i));
        }

        executor.shutdown();
    }
}
