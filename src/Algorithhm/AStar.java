package Algorithhm;
import java.util.*;

import Util.Neighboors;
import Util.Node;

public class AStar{

    public static List<String> AStar_Algorithm(String start, String end, List<String> Database) {
        List<String> noPath = new ArrayList<>();
        if (!Database.contains(start) || !Database.contains(end)) {
            noPath.add(0,"0");
            return noPath;
        }

        if (start.equals(end)) {
            noPath.add(0,"1");
            noPath.add(1,start);
            return noPath;
        }

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0, null));

        List<String> visited = new ArrayList<>();
        visited.add(start);
//        Print.printPriorityQueue(queue);

        int count = 0;
        while (!queue.isEmpty()){
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
                    Node newNode = new Node(neighbor, count + heuristicCost(neighbor,end), currentNode);
                    queue.add(newNode);
                    if (neighbor.equals(end)) {
                        List<String> result = makePath(newNode);
                        result.add(0, String.valueOf(count));
                        return result;
                    }
                }
            }
//            Print.printPriorityQueue(queue);
        }

        noPath.add(0, String.valueOf(count));
        return noPath;
    }

    private static int heuristicCost(String current, String target) {
        int count = 0;
        for (int i = 0; i < current.length(); i++) {
            if (current.charAt(i) != target.charAt(i)) {
                count++;
            }
        }
        return count;
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
