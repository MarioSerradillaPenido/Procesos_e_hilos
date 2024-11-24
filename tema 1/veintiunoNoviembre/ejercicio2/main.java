class ejercicio2 extends Thread{
    public String name;
    public int sueño;
    public ejercicio2(String name, int sueño){
        this.name = name;
        this.sueño = sueño;
    }

    public void run() {
        for (int i = 0; i<10; i++){
            System.out.println(this.name +": " + i);
            try{
                Thread.sleep(sueño);
            } catch (Exception e){}
        }
        System.out.println(this.name + " ha acabado");
    }
}

public class main{
public static void main(String[] args) {
    ejercicio2 hilo1 = new ejercicio2("hilo1", 500);
    ejercicio2 hilo2 = new ejercicio2("hilo2", 1000);
    ejercicio2 hilo3 = new ejercicio2("hilo3", 2000);

    hilo1.start();
    hilo2.start();
    hilo3.start();
}
}