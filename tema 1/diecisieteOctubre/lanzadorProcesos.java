package diecisieteOctubre;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class lanzadorProcesos {
    public static void main(String args[]){
        ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "echo Hola que tal");
        try{
            Process process = pb.start();
            BufferedReader buffer = new BufferedReader
                (new InputStreamReader(process.getInputStream()));
            
            String linea;
            while ((linea = buffer.readLine()) != null){
                System.out.println(linea);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
