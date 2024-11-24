public class test {
    
    public test(){

    }

    public static void main (String [] args){

        hilosmaskrunnable minihilosmask1 = new hilosmaskrunnable("Tesla");
        hilosmaskrunnable minihilosmask2 = new hilosmaskrunnable("X");
        minihilosmask1.ejecutarHilo();
        minihilosmask2.ejecutarHilo();
    }

}
