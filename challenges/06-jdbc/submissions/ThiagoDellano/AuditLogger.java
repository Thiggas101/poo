package br.edu.idp.cc.poo.dvdrental.util;

import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDateTime;

public class AuditLogger {
    private static final Path path = Paths.get("audit.log");

    public static void log(String message) {
        String entry = "[" + LocalDateTime.now() + "] " + message + "\n";
        try {
            Files.writeString(path, entry, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.err.println("Erro ao escrever no log: " + e.getMessage());
        }
    }
}
