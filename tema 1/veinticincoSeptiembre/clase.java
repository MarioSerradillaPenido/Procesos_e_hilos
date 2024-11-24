package veinticincoSeptiembre;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class clase {
    public static void main(String[] args){
        String[] comando = {"cmd", "/c", "dir", "/o"};
        ProcessBuilder pb = new ProcessBuilder(comando);
        ProcessHandle processHandle = ProcessHandle.current();
        ProcessHandle.Info processInfo = processHandle.info();

        System.out.println("PID: " + processHandle.pid());
        System.out.println("Arguments: " + processInfo.arguments());
        System.out.println("Command: " + processInfo.command());
        System.out.println("Instant: " + processInfo.startInstant());
        System.out.println("Total CPU duration: " + processInfo.totalCpuDuration());
        System.out.println("User: " + processInfo.user());
        
        try{Process p = pb.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
