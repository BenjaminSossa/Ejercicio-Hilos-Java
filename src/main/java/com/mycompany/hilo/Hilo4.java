// Benjamin Sossa - Simula un sistema bancario donde múltiples hilos representan cajeros automáticos que intentan retirar dinero de una cuenta bancaria compartida.

package com.mycompany.hilo;

import java.util.Scanner;

class CuentaBancaria {

    private int saldo;
    private final String contraseña;

    public CuentaBancaria(int saldoInicial, String contraseña) {
        this.saldo = saldoInicial;
        this.contraseña = contraseña;
    }

    public boolean validarContraseña(String intento) {
        return intento.equals(contraseña);
    }

    public synchronized boolean retirar(int monto, String cajero) {
        if (saldo >= monto) {
            System.out.println(cajero + " - Retiro exitoso de $" + monto);
            saldo -= monto;
            System.out.println("Saldo restante: $" + saldo);
            return true;
        } else {
            System.out.println(cajero + " - Fondos insuficientes. No se pudo retirar $" + monto);
            return false;
        }
    }

    public int getSaldo() {
        return saldo;
    }
}

class Cajero implements Runnable {

    private final CuentaBancaria cuenta;
    private final String nombreCajero;
    private final int monto;

    public Cajero(CuentaBancaria cuenta, String nombreCajero, int monto) {
        this.cuenta = cuenta;
        this.nombreCajero = nombreCajero;
        this.monto = monto;
    }

    @Override
    public void run() {
        cuenta.retirar(monto, nombreCajero);
    }
}

public class Hilo4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CuentaBancaria cuenta = new CuentaBancaria(5000, "1234"); // Saldo inicial $5000, contraseña "1234"

        for (int i = 1; i <= 2; i++) {
            System.out.println("Cajero-" + i + " - Ingrese su contraseña de 4 dígitos:");
            String intento = scanner.nextLine();

            if (!cuenta.validarContraseña(intento)) {
                System.out.println("Cajero-" + i + " - Contraseña incorrecta. Operación cancelada.");
                continue;
            }

            System.out.println("Cajero-" + i + " - Contraseña correcta. ¿Cuánto desea retirar?");
            int monto = scanner.nextInt();
            scanner.nextLine();

            Thread cajero = new Thread(new Cajero(cuenta, "Cajero-" + i, monto));
            cajero.start();

            try {
                cajero.join();
            } catch (InterruptedException e) {
                System.out.println("El hilo principal fue interrumpido.");
            }
        }

        System.out.println("Saldo final en la cuenta: $" + cuenta.getSaldo());
        scanner.close();
    }
}
