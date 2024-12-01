// Clase Buffer
class Buffer {
    private int valor; // El valor almacenado en el buffer
    private boolean lleno = false; // Indica si el buffer tiene un valor o está vacío

    // Método para agregar un valor al buffer (llamado por el productor)
    public synchronized void agregar(int nuevoValor) {
        while (lleno) {
            try {
                wait(); // Esperar si el buffer ya está lleno
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("El hilo productor fue interrumpido: " + e.getMessage());
            }
        }
        valor = nuevoValor;
        lleno = true; // Indicar que el buffer ahora está lleno
        System.out.println("Productor agregó: " + valor);
        notifyAll(); // Notificar a los hilos en espera
    }

    // Método para consumir un valor del buffer (llamado por el consumidor)
    public synchronized int consumir() {
        while (!lleno) {
            try {
                wait(); // Esperar si el buffer está vacío
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("El hilo consumidor fue interrumpido: " + e.getMessage());
            }
        }
        lleno = false; // Indicar que el buffer ahora está vacío
        System.out.println("Consumidor leyó: " + valor);
        notifyAll(); // Notificar a los hilos en espera
        return valor;
    }
}

// Clase principal
public class ProductorConsumidor {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();

        // Hilo productor
        Thread productor = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                buffer.agregar(i);
                try {
                    Thread.sleep(100); // Simular tiempo de producción
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        // Hilo consumidor
        Thread consumidor = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                buffer.consumir();
                try {
                    Thread.sleep(150); // Simular tiempo de consumo
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        // Iniciar los hilos
        productor.start();
        consumidor.start();

        // Esperar a que terminen
        try {
            productor.join();
            consumidor.join();
        } catch (InterruptedException e) {
            System.err.println("Un hilo fue interrumpido: " + e.getMessage());
        }

        System.out.println("Proceso finalizado.");
    }
}
