package Algorithhm;
import java.util.*;

import Util.Neighbors;
import Util.Node;

public class UCS{

    public static List<String> UCS_Algorithm(String start, String end, List<String> Database) {
        List<String> noPath = new ArrayList<>();

        //jika start == end maka keluarkan path 1
        if (start.equals(end)) {
            noPath.add(0,"1");
            noPath.add(1,start);
            return noPath;
        }

        //inisialisasi PriorityQueue
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0, null));

        //Inisialisasi visited
        List<String> visited = new ArrayList<>();
        visited.add(start);


        int count = 0;
        while (!queue.isEmpty()) { //loop sampai quue kosong
            Node currentNode = queue.poll(); //pop node pada queue
            String currentWord = currentNode.getWord();
            visited.add(currentWord);

            //jika sudah saampai tujuan, keluarkan hasil
            if (currentWord.equals(end)) {
                List<String> result = makePath(currentNode);
                result.add(0, String.valueOf(count));
                return result;
            }

            //cari tetangga dari currentWord
            List<String> neighbors = Neighbors.getNeighbors(currentWord, Database);
            count++;

            //masukan tetangga ke queue
            for (String neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    Node newNode = new Node(neighbor, currentNode.getCost() + 1, currentNode);
                    queue.add(newNode);
                    //kalau ada tetangga yang sampai tujuan, keluarkan hasil
                    if (neighbor.equals(end)) {
                        List<String> result = makePath(newNode);
                        result.add(0, String.valueOf(count));
                        return result;
                    }
                }
            }
        }

        noPath.add(0, String.valueOf(count));
        return noPath;
    }

    //membuat path
    private static List<String> makePath(Node node) {
        List<String> result = new ArrayList<>();
        while (node != null) {
            result.add(node.getWord());
            node = node.getPath();
        }
        Collections.reverse(result);
        return result;
    }
}
