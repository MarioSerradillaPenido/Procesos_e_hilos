package treceNoviembre;

public class Banco extends Thread{

    //recurso compartido
    int saldo = 600;

    public Banco(){

    }

    class cliente extends Thread{}

    @Override
    public void run(){

    }

    private synchronized compra (int compra){
        if (saldo > 0){

        }
    }
    
}
