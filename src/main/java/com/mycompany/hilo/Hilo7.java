package com.mycompany.hilo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class SumaCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int suma = 0;
        for (int i = 1; i <= 100; i++) {
            suma += i;
        }
        return suma;
    }
}

public class Hilo7 {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        SumaCallable sumaCallable = new SumaCallable();

        Future<Integer> future = executor.submit(sumaCallable);

        try {
            Integer resultado = future.get();
            System.out.println("La suma de los primeros 100 números es: " + resultado);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}
