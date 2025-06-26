package br.edu.idp.cc.poo.dvdrental.util;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;

public class AuditLogger {
    private static final String LOG_FILE = "audit.log";

    public static void log(String action, String details) {
        String entry = String.format("[%s] %s: %s%n", 
            LocalDateTime.now(), action, details);
        
        try {
            Files.write(Paths.get(LOG_FILE), 
                entry.getBytes(), 
                StandardOpenOption.CREATE, 
                StandardOpenOption.APPEND);
        } catch (Exception e) {
            System.err.println("Falha no log: " + e.getMessage());
        }
    }
}