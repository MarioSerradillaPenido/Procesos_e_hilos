package veintiCuatro;

import java.util.Random;

    // Crea una clase extoemda de Thread
// Hilo imprimir un mensaje(x5 veces)
// --> Sleep (aleatorio)
// mensaje: Este es el hilo <<nombre del hilo>>

public class ejercicio1 {

    public HiloPersonalizado(String nombre) {
        super(nombre);
    }
   
    @Override
    public void run() {
        Random random = new Random();
       
        for (int i = 0; i < 5; i++) {
            try {
                // Imprime el mensaje con el nombre del hilo
                System.out.println("Este es el hilo " + getName());
               
                // Duerme el hilo por un tiempo aleatorio entre 500 y 1500 ms
                Thread.sleep(random.nextInt(1000) + 500);
            } catch (InterruptedException e) {
                System.out.println("El hilo " + getName() + " fue interrumpido.");
            }
        }
    }
 
    public static void main(String[] args) {
        // Crea y empieza dos hilos
        HiloPersonalizado hilo1 = new HiloPersonalizado("Bercelona");
        HiloPersonalizado hilo2 = new HiloPersonalizado("Madrid");
 
        hilo1.start();
        hilo2.start();
    }
}
 
