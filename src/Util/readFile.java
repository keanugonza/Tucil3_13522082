package Util;
import java.io.*;
import java.util.*;

public class readFile {
    public static List<String> readWordsFromFile() {
        String filename = "src\\words.txt";
        List<String> words = new ArrayList<>();

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

    public static boolean isExist(String word, List<String> Database){
        return Database.contains(word);
    }
}

