// Benjamin Sossa - Productor-Consumidor con wait/notify

package com.mycompany.hilo;

import java.util.LinkedList;
import java.util.Random;

class Almacen {

    private final LinkedList<Integer> lista = new LinkedList<>();
    private final int LIMITE = 5; 

    public synchronized void producir(int numero) {
        while (lista.size() == LIMITE) {
            try {
                System.out.println("Almacén lleno. Productor espera...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        lista.add(numero);
        System.out.println("Productor generó: " + numero);
        notify();
    }

    public synchronized int consumir() {
        while (lista.isEmpty()) {
            try {
                System.out.println("Almacén vacío. Consumidor espera...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int numero = lista.removeFirst();
        System.out.println("Consumidor consumió: " + numero);
        notify();
        return numero;
    }
}

class Productor implements Runnable {

    private final Almacen almacen;
    private final Random random = new Random();

    public Productor(Almacen almacen) {
        this.almacen = almacen;
    }

    @Override
    public void run() {
        while (true) {
            int numero = random.nextInt(100);
            almacen.producir(numero);
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumidor implements Runnable {

    private final Almacen almacen;

    public Consumidor(Almacen almacen) {
        this.almacen = almacen;
    }

    @Override
    public void run() {
        while (true) {
            almacen.consumir();
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Hilo5 {

    public static void main(String[] args) {
        Almacen almacen = new Almacen();

        Thread productor = new Thread(new Productor(almacen));
        Thread consumidor = new Thread(new Consumidor(almacen));

        productor.start();
        consumidor.start();
    }
}
