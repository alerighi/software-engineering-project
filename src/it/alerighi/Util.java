package it.alerighi;

/**
 * Classe di utilià
 *
 * @author Alessandro Righi
 */
public final class Util {

    private Util() {}

    public static void log(String logLevel, String message) {
        System.out.println("[" + logLevel + "] " + message);
    }

    public static void info(String message) {
        log("INFO", message);
    }

    public static void err(String message) {
        log("ERR", message);
    }

    public static void die(String message) {
        err(message);
        System.exit(1);
    }
}
