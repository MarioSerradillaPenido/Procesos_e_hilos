public class hilosmask extends Thread{

    public hilosmask (String name) {
        super (name);
    }

    public void run (){
        for (int i=0; i<=30; i++){
            System.out.println(this.getName() + " el contador " + i);
            try {
                sleep((long) Math.random() * 1000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static void main (String [] args){
        hilosmask minihilomask1 = new hilosmask("tesla");
        hilosmask minihilomask2 = new hilosmask("X");
        minihilomask1.setPriority(Thread.MIN_PRIORITY);
        minihilomask2.setPriority(Thread.MAX_PRIORITY);
        minihilomask1.start();
        minihilomask2.start();
    }
}