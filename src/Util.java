import java.io.*;
import java.util.*;
public class Util {
    public static List<String> readWordsFromFile() {
        String filename = "src\\words_alpha.txt";
        List<String> words = new ArrayList<>();

        System.out.println("Current working directory: " + System.getProperty("user.dir")); // debug info

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] lineWords = line.split("\\s+");
                words.addAll(Arrays.asList(lineWords));
            }
        } catch (IOException e) {
            System.err.println("Error membaca file: " + e.getMessage());
        }

        return words;
    }

    public static List<String> getNeighboors(String FindWord, List<String> Database){
        List<String> neighboors = new ArrayList<>();
        for(String Word : Database){
            int beda = 0;
            for(int i = 0; i < Word.length(); i++){
                if (Word.charAt(i) != FindWord.charAt(i)){
                    beda++;
                }
            }
            if(beda == 1){
                neighboors.add(Word);
            }

        }
        return neighboors;
    }

    public static void printAlgo(){
        System.out.println("\nAlgoritma yang bisa digunakan: ");
        System.out.println("0. Semua algoritma (cheat)");
        System.out.println("1. UCS");
        System.out.println("2. GBFS");
        System.out.println("3. A*");
        System.out.print("Pilih nomor algoritma: ");
    }

    public static void printHasil(List<String> Result){
        if (Result != null){
            for(int i = 0; i < Result.size(); i++){
                if(i==0){
                    System.out.println("\n======================JAWABAN======================");
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
        }

    }

    public static boolean isExist(String word, List<String> Database){
        return Database.contains(word);
    }

    public static void printPriorityQueue(PriorityQueue<Node> queue) {
        PriorityQueue<Node> tempQueue = new PriorityQueue<>(queue);

        System.out.print("Queue: ");

        List<String> result = new ArrayList<>();
        while (!tempQueue.isEmpty()) {
            Node node = tempQueue.poll();
            result.add(node.word + " (Cost: " + node.cost + ")");
        }
        System.out.println(String.join(", ", result));
    }
}

