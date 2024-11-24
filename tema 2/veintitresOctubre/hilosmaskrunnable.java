public class hilosmaskrunnable implements Runnable{

    private Thread hilo = null;

    public hilosmaskrunnable(String name) {
        this.hilo = new Thread(this, name);
        this.hilo.start();
    }

    public void run (){
        for (int i=0; i<=30; i++){
            System.out.println(this.hilo.getName() + " el contador " + i);
        }
    }

    public void ejecutarHilo(){
        this.hilo.start();
    }
}