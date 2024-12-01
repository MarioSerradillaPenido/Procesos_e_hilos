// Clase Contador
class Contador {
    private int contador = 0;

    // Método sincronizado para incrementar el contador
    public synchronized void incrementar() {
        contador++;
    }

    // Método para obtener el valor actual del contador
    public int getContador() {
        return contador;
    }
}

// Clase principal
public class ContadorSincronizado {
    public static void main(String[] args) {
        // Instancia de la clase Contador
        Contador contador = new Contador();

        // Definir el número de iteraciones por hilo
        int iteraciones = 100;

        // Crear los hilos
        Thread hilo1 = new Thread(() -> {
            for (int i = 0; i < iteraciones; i++) {
                contador.incrementar();
            }
        });

        Thread hilo2 = new Thread(() -> {
            for (int i = 0; i < iteraciones; i++) {
                contador.incrementar();
            }
        });

        Thread hilo3 = new Thread(() -> {
            for (int i = 0; i < iteraciones; i++) {
                contador.incrementar();
            }
        });

        // Iniciar los hilos
        hilo1.start();
        hilo2.start();
        hilo3.start();

        // Esperar a que los hilos terminen
        try {
            hilo1.join();
            hilo2.join();
            hilo3.join();
        } catch (InterruptedException e) {
            System.err.println("Un hilo fue interrumpido: " + e.getMessage());
        }

        // Mostrar el resultado final
        System.out.println("Valor final del contador: " + contador.getContador());
    }
}
