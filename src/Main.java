import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Algorithhm.AStar;
import Algorithhm.GBFS;
import Algorithhm.UCS;
import Util.Print;
import Util.readFile;


public class Main {
    public static final String RESET = "\033[0m";
    public static final String RED = "\033[1;31m";
    public static final String GREEN = "\033[1;32m";
    public static final String YELLOW = "\033[1;33m";
    public static final String BLUE = "\033[1;34m";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<String> Database_raw = readFile.readWordsFromFile();
        List<String> Result;
        System.out.println("\n=========================================");
        System.out.println("         Welcome to Word Ladder");
        System.out.println("          Made by: Keanu Gonza");
        System.out.println("=========================================");
        System.out.println("Masukan Kata akan " + YELLOW + "OTOMATIS LOWER CASE!!! " + RESET);
        System.out.print(BLUE + "\nMasukkan kata awal: " + RESET);
        String input = scanner.next();
        String start = input.toLowerCase();
        while(!readFile.isExist(start, Database_raw)){
            System.out.println(RED + "Kata tidak exist" + RESET);
            System.out.print(BLUE + "Masukkan kata awal: " + RESET);
            input = scanner.next();
            start = input.toLowerCase();
        }

        System.out.print(BLUE + "\nMasukkan kata tujuan: " + RESET);
        String input2 = scanner.next();
        String end = input2.toLowerCase();
        while(!readFile.isExist(end, Database_raw)){
            System.out.println(RED + "Kata tidak exist" + RESET);
            System.out.print(BLUE + "Masukkan kata tujuan: " + RESET);
            input2 = scanner.next();
            end = input2.toLowerCase();
        }

        if (start.length() != end.length()) {
            System.out.println(RED+ "Panjang tidak sama, tidak dapat dicari hasilnya" + RESET);
        }else{
            Print.printAlgo();
            int pilihan = scanner.nextInt();
            while (pilihan < 1 || pilihan > 3) {
                System.out.print(BLUE + "Pilih nomor algoritma dengan benar: " + RESET);
                pilihan = scanner.nextInt();
            }

            List<String> Database = new ArrayList<>();
            for(String data : Database_raw){
                if(data.length() == start.length()){
                    Database.add(data);
                }
            }
            double startTime;
            double endTime;
            if(pilihan == 1) {
                startTime = System.nanoTime();
                Result = UCS.UCS_Algorithm(start,end,Database);
                endTime = System.nanoTime();
                System.out.print(GREEN + "\nAlgoritma UCS" + RESET);
            } else if(pilihan == 2) {
                startTime = System.nanoTime();
                Result = GBFS.GBFS_Algorithm(start,end,Database);
                endTime = System.nanoTime();
                System.out.print(GREEN + "\nAlgoritma GBFS" + RESET);
            } else {
                startTime = System.nanoTime();
                Result = AStar.AStar_Algorithm(start,end,Database);
                endTime = System.nanoTime();
                System.out.print(GREEN + "\nAlgoritma A star" + RESET);
            }

            System.out.println();
            Print.printHasil(Result);
            System.out.println("Time: " + (endTime - startTime)/1_000_000_000 + " detik" + RESET);
        }
        scanner.close();
    }
}