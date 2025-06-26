// src/main/java/br/edu/idp/cc/poo/dvdrental/util/AuditLogger.java
package br.edu.idp.cc.poo.dvdrental.util;

import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AuditLogger {
    private static final Path LOG_PATH = Paths.get("audit.log");
    private static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void log(String action, String detail) {
        String line = String.format("%s | %-15s | %s%n",
            LocalDateTime.now().format(FMT),
            action,
            detail
        );
        try {
            Files.writeString(LOG_PATH, line, 
                StandardOpenOption.CREATE, 
                StandardOpenOption.APPEND
            );
        } catch (IOException e) {
            System.err.println("Falha ao escrever log: " + e.getMessage());
        }
    }
}
