package Util;

import java.util.List;

public class Print {
    public static final String RESET = "\033[0m";
    public static final String GREEN = "\033[1;32m";
    public static final String BLUE = "\033[1;34m";

    public static void printAlgo() {
        System.out.println("\nAlgoritma yang bisa digunakan: ");
        System.out.println("1. UCS");
        System.out.println("2. GBFS");
        System.out.println("3. A*");
        System.out.print(BLUE + "Pilih nomor algoritma: " + RESET);
    }

    public static void printHasil(List<String> Result) {
        if (Result.size() != 1) {
            for (int i = 0; i < Result.size(); i++) {
                if (i == 0) {
                    System.out.println(GREEN + "======================JAWABAN======================" + RESET);
                    System.out.println("Jumlah Node dikunjungi: " + Result.get(i));
                    System.out.print( "Path: " + RESET);
                } else if (i != Result.size() - 1) {
                    System.out.print(Result.get(i) + " -> ");
                } else {
                    System.out.print(Result.get(i));
                }
            }
            System.out.println();
        } else {
            System.out.println(GREEN + "======================JAWABAN======================" + RESET);
            System.out.println("Jalur tidak ditemukan");
            System.out.println("Jumlah Node dikunjungi: " + Result.get(0));
        }

    }
}
