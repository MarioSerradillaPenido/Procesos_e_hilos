package hola;

public class lanzador {
    public void ejecutar (String Ruta){
        ProcessBuilder pb;
        try{
            pb = new ProcessBuilder(Ruta);
            Process process = pb.start();
            System.out.println(process);
            System.out.println(process.info());
            process.destroy();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
    public static void main(String[] args){ 
        String Ruta = "C:\\windows\\system32\\notepad.exe";
        lanzador l = new lanzador();
        lanzador l2 = new lanzador();
        l.ejecutar(Ruta);
        l2.ejecutar(Ruta);
    }
}
