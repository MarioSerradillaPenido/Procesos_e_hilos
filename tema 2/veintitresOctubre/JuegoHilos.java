import java.util.Random;

public class JuegoHilos extends Thread{
    public static final int META = 100;
    private String name = "";
    private int posicion;

    public JuegoHilos(String name){
        this.name = name;
    }

    public void run(){
        Random random = new Random();
        while (posicion < META){
            int avance = random.nextInt(10);
            posicion += avance;
            mostrarPosicion();
            try {
                Thread.sleep(random.nextInt(500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void mostrarPosicion(){
        StringBuilder hipodromo = new StringBuilder();
        for (int i=0; i< META; i++){
            if (i==posicion){
                hipodromo.append(this.name);
            }else{
                hipodromo.append("-");
            }
        }
        System.out.println(hipodromo.toString());
    }

    public static void main(String[] args){

        JuegoHilos caballo1 = new JuegoHilos("C1");
        JuegoHilos caballo2 = new JuegoHilos("C2");
        caballo1.start();
        caballo2.start();
    }
}
