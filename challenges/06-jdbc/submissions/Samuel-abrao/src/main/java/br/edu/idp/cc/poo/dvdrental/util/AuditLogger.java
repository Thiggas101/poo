package br.edu.idp.cc.poo.dvdrental.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.Instant;

public class AuditLogger {
    private static final Path LOG_PATH = Path.of("audit.log");
    public static void log(String message) {
        String line = Instant.now().toString() + " - " + message + System.lineSeparator();
        try {
            Files.write(LOG_PATH, line.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
