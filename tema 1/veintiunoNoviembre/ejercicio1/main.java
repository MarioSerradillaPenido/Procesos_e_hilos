class ejercicio1 extends Thread{
    public ejercicio1 (){
    }

    public void run() {
        for (int i = 0 ; i < 5; i++){
            System.out.println("Hola desde un hilo");
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e){}
        }
        System.err.println("Adios desde un hilo");
    }
}

public class main {
    public static void main (String[] args) {
        ejercicio1 hilo = new ejercicio1();
        hilo.start();
    }
}
