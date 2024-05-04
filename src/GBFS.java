import java.util.*;

public class GBFS{

    public static List<String> GBFS_Algorithm(String start, String end, List<String> Database) {
        if (!Database.contains(start) || !Database.contains(end)) {
            return null;
        }

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0, null));

        List<String> visited = new ArrayList<>();
        visited.add(start);

        int count = 1;
        while (!queue.isEmpty()){
//            printPriorityQueue(queue);
            Node currentNode = queue.poll();
            String currentWord = currentNode.word;
            visited.add(currentWord);

            if (currentWord.equals(end)) {
                List<String> result = new ArrayList<>();
                result = makePath(currentNode);
                result.add(0, String.valueOf(count));
                return result;
            }

            List<String> neighbors = Util.getNeighboors(currentWord, Database);
            count++;

            for (String neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    Node newNode = new Node(neighbor, heuristicCost(neighbor,end), currentNode);
                    queue.add(newNode);
                }
            }
        }

        return null;
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
            result.add(node.word);
            node = node.path;
        }
        Collections.reverse(result);
        return result;
    }

//    public static void printPriorityQueue(PriorityQueue<Node> queue) {
//        System.out.print("Priority Queue: ");
//
//        Iterator<Node> iterator = queue.iterator();
//
//        // Iterasi melalui PriorityQueue dan cetak nama beserta cost
//        while (iterator.hasNext()) {
//            Node node = iterator.next();
//            System.out.print(node.word + " (Cost: " + node.cost + ")");
//
//            if (iterator.hasNext()) {
//                System.out.print(", "); // Tambahkan koma jika masih ada elemen
//            }
//        }
//
//        System.out.println(); // Pindah baris setelah mencetak queue
//    }
}
