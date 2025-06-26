package br.edu.idp.cc.poo.dvdrental.util;

import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AuditLogger {
    private static final String LOG_FILE = "audit.log";
    private static final Path LOG_PATH = Paths.get(LOG_FILE);
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void log(String message) {
        String timestamp = LocalDateTime.now().format(FORMATTER);
        String logMessage = String.format("[%s] %s%n", timestamp, message);

        try {
            if (!Files.exists(LOG_PATH)) {
                Files.createFile(LOG_PATH);
            }
            Files.write(LOG_PATH, logMessage.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.err.println("Erro ao registrar log: " + e.getMessage());
        }
    }
}
