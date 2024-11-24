class ejercicio3 extends Thread{
    public int pasos;
    public String name;
    public ejercicio3 (int pasos, String name){
        this.pasos = pasos;
        this.name = name;
    }

    public void run(){
        while (this.pasos < 50){
            this.pasos += (Math.random());
            System.out.println(this.name +": " + pasos);
            try{
                Thread.sleep(1000);
            } catch (Exception e){}
        }
        System.out.println(this.name + " ha acabado la carrera");
    }
}
public class main{
public static void main(String[] args) {
    ejercicio3 hilo1 = new ejercicio3(0, "HiloUno");
    ejercicio3 hilo2 = new ejercicio3(0, "HiloDos");

    hilo1.start();
    hilo2.start();
}
}