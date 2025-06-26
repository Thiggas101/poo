package br.edu.idp.cc.poo.dvdrental.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;

public class AuditLogger {
    private static final Path LOG_PATH = Path.of("audit.log");

    public static void log(String acao) {
        String logEntry = LocalDateTime.now() + " - " + acao + System.lineSeparator();
        try {
            Files.writeString(LOG_PATH, logEntry, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo de log: " + e.getMessage());
        }
    }
}
