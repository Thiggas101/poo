package br.edu.idp.cc.poo.dvdrental.util;

import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDateTime;

public class AuditLogger {
    private static final String LOG_FILE = "audit.log";

    public static void log(String message) {
        String timestamp = LocalDateTime.now() + " - " + message + "\n";
        try {
            Files.write(Paths.get(LOG_FILE), timestamp.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
