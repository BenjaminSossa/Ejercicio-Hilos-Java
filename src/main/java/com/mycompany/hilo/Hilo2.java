// Benjamin Sossa - Dos hilos que impriman letras y números en paralelo.

package com.mycompany.hilo;

class Paralelo extends Thread {

    @Override
    public void run() {
        try {       
            for (int i = 1; i <= 10; i++) {
                System.out.println("Número: " + i);
                Thread.sleep(1000);
            }

        } catch (InterruptedException e) {
            System.out.println("El hilo fue interrumpido.");
        }

    }
}

class letras extends Thread {

    @Override
    public void run() {
        String[] array = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};

        try {
            for (String letra : array) {
                System.out.println("Letra: " + letra);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("El hilo de letras fue interrumpido.");
        }
    }
}

public class Hilo2 {

    public static void main(String[] args) {
        Paralelo hilo = new Paralelo();
        hilo.start();

        letras hil = new letras();
        hil.start();

    }
}
