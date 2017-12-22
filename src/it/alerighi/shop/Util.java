package it.alerighi.shop;

/**
 * Classe di utilià statica
 *
 * @author Alessandro Righi
 */
public final class Util {

    private Util() {}

    /**
     * Scrive un messaggio di info su standard output
     *
     * @param message messaggio da stampare
     */
    public static void info(String message) {
        System.out.println("[INFO] " + message);
    }

    /**
     * Scrive un messaggio di errore su standard error
     *
     * @param message messaggio da stampare
     */
    public static void err(String message) {
        System.err.println("[ERR] " + message);
    }

    /**
     * Scrive un messaggio di errore su standard error, e termina il programma
     *
     * @param message messaggio da stampare
     */
    public static void die(String message) {
        err(message);
        System.exit(1);
    }
}
