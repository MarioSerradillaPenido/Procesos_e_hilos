package diecisieteOctubre;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ContadorLineas {
    public static void main(String[] args) {
        // Verifica que se haya proporcionado un nombre de archivo como argumento
        // Servicios y procesos no lo lee por los espacios
        String archivo = "C:\\Users\\thepi\\Desktop\\Servicios_y_Procesos\\diecisieteOctubre\\ContadorLineas.java";

        try {
            // Prepara el comando para contar líneas en Windows
            ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "find /c /v \"\" " + archivo);
            
            // Inicia el proceso
            Process proceso = builder.start();

            // Lee la salida del comando
            BufferedReader lector = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
            String linea;

            // Imprime la salida del comando
            while ((linea = lector.readLine()) != null) {
                System.out.println(linea);
            }

            lector.close();
            
            // Espera a que el proceso termine
            proceso.waitFor();

        } catch (Exception e) {
            System.out.println("Error al ejecutar el comando.");
            e.printStackTrace();
        }
    }
}
