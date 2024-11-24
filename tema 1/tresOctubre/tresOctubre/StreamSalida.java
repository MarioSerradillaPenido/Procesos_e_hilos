package tresOctubre;

import java.io.*;

public class StreamSalida {
    public static void main (String[] args) {

        File f = new File ("C:\\Users\\thepi\\Desktop\\Servicios y Procesos\\tresOctubre\\tresOctubre\\fichero.txt");
        try {
            FileInputStream fis = new FileInputStream(f);
            
            // Reads the first byte
            int i = fis.read();

        while(i != -1) {
            System.out.print((char)i);
            // Reads next byte from the file
            i = fis.read();
         }
         fis.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
    }

}