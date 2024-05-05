package Util;

import java.util.ArrayList;
import java.util.List;

public class Neighbors {
        public static List<String> getNeighbors(String FindWord, List<String> Database){
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
}
