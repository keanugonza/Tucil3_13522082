package Util;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Print {
    public static void printAlgo(){
        System.out.println("\nAlgoritma yang bisa digunakan: ");
        System.out.println("0. Semua algoritma (cheat)");
        System.out.println("1. UCS");
        System.out.println("2. GBFS");
        System.out.println("3. A*");
        System.out.print("Pilih nomor algoritma: ");
    }

    public static void printHasil(List<String> Result){
        if (Result.size()!=1){
            for(int i = 0; i < Result.size(); i++){
                if(i==0){
                    System.out.println("======================JAWABAN======================");
                    System.out.println("Jumlah Node dikunjungi: " + Result.get(i));
                    System.out.print("Path: ");
                } else if (i != Result.size()-1) {
                    System.out.print(Result.get(i) + " -> ");
                } else{
                    System.out.print(Result.get(i));
                }
            }
            System.out.println();
        }else{
            System.out.println("jalur tidak ditemukan");
            System.out.println("Jumlah Node dikunjungi: " + Result.get(0));
        }

    }

    public static void printPriorityQueue(PriorityQueue<Node> queue) {
        PriorityQueue<Node> tempQueue = new PriorityQueue<>(queue);

        System.out.print("Queue: ");

        List<String> result = new ArrayList<>();
        while (!tempQueue.isEmpty()) {
            Node node = tempQueue.poll();
            result.add(node.getWord() + " (Cost: " + node.getCost() + ")");
        }
        System.out.println(String.join(", ", result));
    }
}
