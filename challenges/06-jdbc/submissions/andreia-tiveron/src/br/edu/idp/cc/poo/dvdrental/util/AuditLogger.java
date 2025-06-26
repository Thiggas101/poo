package br.edu.idp.cc.poo.dvdrental.util;


import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDateTime;


public class AuditLogger {

    private static final String LOG_FILE = "audit.log";

    public static void log(String message) {
        String log = LocalDateTime.now() + " - " + message + System.lineSeparator();
        try {
            Files.write(Paths.get(LOG_FILE), log.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.err.println("Erro ao registrar log: " + e.getMessage());
        }
    }
}
