package br.edu.idp.cc.poo.dvdrental.util;

import java.nio.file.*;
import java.io.IOException;
import java.time.LocalDateTime;

public class AuditLogger {

    private static final Path LOG_PATH = Paths.get("audit.log");

    public static void log(String action) {
        String timestamp = LocalDateTime.now() + " - " + action + System.lineSeparator();
        try {
            Files.write(LOG_PATH, timestamp.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.err.println("Erro ao gravar no log: " + e.getMessage());
        }
    }
}
