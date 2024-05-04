public class Node implements Comparable<Node> {
    Node path;
    String word;
    int cost;
    long timestamp;
    private static long Counter = 0;

    public Node(String word, int cost, Node path) {
        this.path = path;
        this.word = word;
        this.cost = cost;
        this.timestamp = Counter++; // Incremental unique sequence
    }

    public Node() {
        this.path = null;
        this.word = null;
        this.cost = 0;
        this.timestamp = Counter++; // Incremental unique sequence
    }

    @Override
    public int compareTo(Node other) {
        int costComparison = Integer.compare(this.cost, other.cost);
       if (costComparison == 0) {
           return Long.compare(other.timestamp, this.timestamp);
       }
        return costComparison;
    }
}
