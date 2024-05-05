package Util;
import java.io.*;
import java.util.*;

public class readFile {
    public static List<String> readWordsFromFile() {
        String filename = "src\\words.txt";
        List<String> result = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))){
            String line;
            while ((line = br.readLine()) != null) {
                String[] lineWords = line.split("\\s+");
                result.addAll(Arrays.asList(lineWords));
            }
        } catch (IOException e){
            System.err.println("Error saat membaca file: " + e.getMessage());
        }
        return result;
    }

    public static boolean isExist(String word, List<String> Database){
        return Database.contains(word);
    }
}

