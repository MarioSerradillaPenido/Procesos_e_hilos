package diezOctubre;

import java.io.IOException;

public class ejercicio1 {
    public static void main(String[] args) {
        try {
            // Open Notepad
            System.out.println("Opening Notepad...");
            ProcessBuilder notepadProcessBuilder = new ProcessBuilder("notepad.exe");
            Process notepadProcess = notepadProcessBuilder.start();

            // Wait for Notepad to close
            notepadProcess.waitFor();  // This blocks until Notepad is closed
            System.out.println("Notepad closed.");

            // Open Calculator
            System.out.println("Opening Calculator...");
            ProcessBuilder calculatorProcessBuilder = new ProcessBuilder("calc.exe");
            calculatorProcessBuilder.start();
            
        } catch (IOException e) {
            System.err.println("An IOException occurred: " + e.getMessage());
        } catch (InterruptedException e) {
            System.err.println("The process was interrupted: " + e.getMessage());
        }
    }
}