import javax.xml.crypto.Data;
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
                System.out.println("Pilih nomor algoritma dengan benar: ");
                pilihan = scanner.nextInt();
            }

            List<String> Database = new ArrayList<>();
            for(String data : Database_raw){
                if(data.length() == start.length()){
                    Database.add(data);
                }
            }

            if(pilihan == 1) {
                Result = Algoritma.find_result(start,end,Database, 1);
            } else if(pilihan == 2) {
                Result = Algoritma.find_result(start,end,Database, 2);
            } else if(pilihan == 3) {
                Result = Algoritma.find_result(start,end,Database, 3);
            } else if(pilihan == 0) {
                Result = UCS.UCS_Algorithm(start, end, Database);
                Util.printHasil(Result);
                Result = GBFS.GBFS_Algorithm(start, end, Database);
                Util.printHasil(Result);
                Result = AStar.AStar_Algorithm(start, end, Database);
                Util.printHasil(Result);
            }


            Util.printHasil(Result);
        }
    }
}