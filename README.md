**1. Hilo que imprime números:**

o Crea un hilo que imprima los números del 1 al 10 con una pausa de 1 segundo
entre cada número.
o Usa Thread.sleep(1000); para simular el retardo.

**2. Dos hilos en paralelo:**

o Crea dos hilos que impriman letras y números respectivamente.
o El primer hilo imprime "A B C D E" y el segundo "1 2 3 4 5".
o Ambos deben ejecutarse en paralelo.

**3. Contador con Runnable:**

o Implementa un Runnable que incremente un contador global compartido por
dos hilos.
o Sincroniza el acceso al contador para evitar inconsistencias.

**4. Simulación de cajeros automáticos:**

o Simula un sistema bancario donde múltiples hilos representan cajeros
automáticos que intentan retirar dinero de una cuenta bancaria compartida.
o Usa synchronized para evitar retiros simultáneos que dejen saldo negativo.

**5. Productor-Consumidor con wait/notify:**

o Implementa un sistema donde un hilo (productor) genera números aleatorios y
otro hilo (consumidor) los consume e imprime.
o Usa wait() y notify() para coordinar la producción y el consumo.

**6. Ejecutores (ExecutorService)**

o Usa un ExecutorService con un FixedThreadPool(3) para ejecutar 5 tareas en
paralelo.
o Cada tarea debe imprimir su número de ejecución y luego dormir 2 segundos.

**7. Uso de Callable y Future:**

o Implementa un hilo que calcule la suma de los primeros 100 números y retorne
el resultado usando Callable<Integer> y Future<Integer>.
