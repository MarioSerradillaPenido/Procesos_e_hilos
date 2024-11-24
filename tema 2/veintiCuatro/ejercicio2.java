import java.util.Random;

public class ejercicio2 {
    
    public HiloPersonalizado(String nombre) {
        super(nombre);
    }
   
    @Override
    public void run() {
        Random random = new Random();
       
        for (int i = 0; i < 5; i++) {
            try {
                System.out.println("Este es el hilo " + getName());
               
                Thread.sleep(random.nextInt(1000) + 500);
            } catch (InterruptedException e) {
                System.out.println("El hilo " + getName() + " fue interrumpido.");
            }
        }
    }
 
    public static void main(String[] args) {
        HiloPersonalizado hilo1 = new HiloPersonalizado("Bercelona");
        HiloPersonalizado hilo2 = new HiloPersonalizado("Madrid");
 
        hilo1.start();
        hilo2.start();
    }
}
 

}
