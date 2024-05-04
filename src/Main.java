import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> Database_raw = Util.readWordsFromFile();
        List<String> Result = new ArrayList<>();

        System.out.print("\nMasukkan kata awal: ");
        String start = scanner.next();
        while(!Util.isExist(start, Database_raw)){
            System.out.println("Kata tidak exist");
            System.out.print("Masukkan kata awal: ");
            start = scanner.next();
        }

        System.out.print("\nMasukkan kata tujuan: ");
        String end = scanner.next();
        while(!Util.isExist(end, Database_raw)){
            System.out.println("Kata tidak exist");
            System.out.print("Masukkan kata tujuan: ");
            end = scanner.next();
        }

        if (start.length() != end.length()) {
            System.out.println("Panjang tidak sama, tidak dapat dicari hasilnya");
        }else{
            Util.printAlgo();
            int pilihan = scanner.nextInt();
            while (pilihan < 0 || pilihan > 3) {
                System.out.print("Pilih nomor algoritma dengan benar: ");
                pilihan = scanner.nextInt();
            }

            List<String> Database = new ArrayList<>();
            for(String data : Database_raw){
                if(data.length() == start.length()){
                    Database.add(data);
                }
            }
            double startTime =0;
            double endTime =0;
            if(pilihan == 1) {
                startTime = System.nanoTime();
                Result = UCS.UCS_Algorithm(start,end,Database);
                endTime = System.nanoTime();
            } else if(pilihan == 2) {
                startTime = System.nanoTime();
                Result = GBFS.GBFS_Algorithm(start,end,Database);
                endTime = System.nanoTime();
            } else if(pilihan == 3) {
                startTime = System.nanoTime();
                Result = AStar.AStar_Algorithm(start,end,Database);
                endTime = System.nanoTime();
            }

            if(pilihan == 0){
                startTime = System.nanoTime();
                Result = UCS.UCS_Algorithm(start, end, Database);
                endTime = System.nanoTime();
                System.out.println("\nUCS Algorithm");
                Util.printHasil(Result);
                System.out.println((endTime - startTime)/1_000_000_000 + " detik");
                startTime = System.nanoTime();
                Result = GBFS.GBFS_Algorithm(start, end, Database);
                endTime = System.nanoTime();
                System.out.println("\nGBFS Algorithm");
                Util.printHasil(Result);
                System.out.println((endTime - startTime)/1_000_000_000 + " detik");
                startTime = System.nanoTime();
                Result = AStar.AStar_Algorithm(start, end, Database);
                endTime = System.nanoTime();
                System.out.println("\nA* Algorithm");
                Util.printHasil(Result);
                System.out.println((endTime - startTime)/1_000_000_000 + " detik");

            } else{
                System.out.println();
                Util.printHasil(Result);
                System.out.println((endTime - startTime)/1_000_000_000 + " detik");
            }
        }
    }
}