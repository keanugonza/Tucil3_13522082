package Algorithhm;
import java.util.*;

import Util.Print;
import Util.Neighboors;
import Util.Node;

public class UCS{

    public static List<String> UCS_Algorithm(String start, String end, List<String> Database) {
        if (!Database.contains(start) || !Database.contains(end)) {
            return null;
        }

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0, null));

        List<String> visited = new ArrayList<>();
        visited.add(start);
        Print.printPriorityQueue(queue);

        int count = 1;
        while (!queue.isEmpty()) {
//            Util.printPriorityQueue(queue);
            Node currentNode = queue.poll();
            String currentWord = currentNode.getWord();
            visited.add(currentWord);
//            System.out.println(count + ". " + currentWord);

            if (currentWord.equals(end)) {
                List<String> result = makePath(currentNode);
                result.add(0, String.valueOf(count));
                return result;
            }

            List<String> neighbors = Neighboors.getNeighboors(currentWord, Database);
            count++;

//            Collections.reverse(neighbors);
            for (String neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    Node newNode = new Node(neighbor, currentNode.getCost() + 1, currentNode);
                    queue.add(newNode);
                    if (neighbor.equals(end)) {
                        List<String> result = makePath(newNode);
                        result.add(0, String.valueOf(count));
                        return result;
                    }
                }
            }
//            Util.printPriorityQueue(queue);
        }

        return null;
    }

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
