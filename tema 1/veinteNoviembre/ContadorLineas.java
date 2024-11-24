package veinteNoviembre;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ContadorLineas {

    public ContadorLineas(){

    }
    
    public void lanzarProceso(){
        ProcessBuilder pb = new ProcessBuilder("cmd", "find \\c \\v", "archivo.java");
        try{
            Process proceso = pb.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
            String linea = "";
            while ((linea = reader.readLine()) != null){
                System.out.println(linea);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main (String [] args){
        ContadorLineas c = new ContadorLineas();
        c.lanzarProceso();
    }
}
