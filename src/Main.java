import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Algorithhm.AStar;
import Algorithhm.GBFS;
import Algorithhm.UCS;
import Util.Print;
import Util.readFile;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> Database_raw = readFile.readWordsFromFile();
        List<String> Result;
        System.out.println("\n=========================================");
        System.out.println("         Welcome to Word Ladder");
        System.out.println("          Made by: Keanu Gonza");
        System.out.println("=========================================");
        System.out.println("Masukan Kata akan " + "\033[0;32m" + "OTOMATIS LOWER CASE!!! ");
        System.out.print("\033[0m" + "\nMasukkan kata awal: ");
        String input = scanner.next();
        String start = input.toLowerCase();
        while(!readFile.isExist(start, Database_raw)){
            System.out.println("Kata tidak exist");
            System.out.print("Masukkan kata awal: ");
            start = scanner.next();
        }

        System.out.print("\nMasukkan kata tujuan: ");
        String input2 = scanner.next();
        String end = input2.toLowerCase();
        while(!readFile.isExist(end, Database_raw)){
            System.out.println("Kata tidak exist");
            System.out.print("Masukkan kata tujuan: ");
            end = scanner.next();
        }

        if (start.length() != end.length()) {
            System.out.println("Panjang tidak sama, tidak dapat dicari hasilnya");
        }else{
            Print.printAlgo();
            int pilihan = scanner.nextInt();
            while (pilihan < 1 || pilihan > 3) {
                System.out.print("Pilih nomor algoritma dengan benar: ");
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
            } else if(pilihan == 2) {
                startTime = System.nanoTime();
                Result = GBFS.GBFS_Algorithm(start,end,Database);
                endTime = System.nanoTime();
            } else {
                startTime = System.nanoTime();
                Result = AStar.AStar_Algorithm(start,end,Database);
                endTime = System.nanoTime();
            }

            System.out.println();
            Print.printHasil(Result);
            System.out.println((endTime - startTime)/1_000_000_000 + " detik");
        }
    }
}