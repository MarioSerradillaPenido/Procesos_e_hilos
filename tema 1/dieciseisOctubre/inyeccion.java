package dieciseisOctubre;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class inyeccion {
    public static void main(String[] args) throws IOException {
        // Supongamos que este argumento proviene de una entrada del usuario
        String userInput = args[0];
        userInput = userInput.replace("&", "abc");

        // Vulnerable: el input del usuario se concatena directamente en el comando
        ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", "echo " + userInput);
        Process process = processBuilder.start();
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;

            while((line = reader.readLine())!=null){
                System.out.println(line);
            }
            int exitCode;
            try{
                exitCode = process.waitFor();
                System.out.println("\nEl proceso termino con el codigo" + exitCode);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
}