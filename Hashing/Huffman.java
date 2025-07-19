import java.util.*;

public class HuffmanCoder {
    private HashMap<Character, String> encoder;
    private HashMap<String, Character> decoder;

    private class Node implements Comparable<Node> {
        Character data;
        int cost;
        Node left;
        Node right;

        public Node(Character data, int cost) {
            this.data = data;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public HuffmanCoder(String feeder) {
        HashMap<Character, Integer> fMap = new HashMap<>();

        // construct frequency map
        for (char ch : feeder.toCharArray()) {
            if (fMap.containsKey(ch)) {
                int currentCount = fMap.get(ch);
                currentCount++;
                fMap.put(ch, currentCount);
            } else {
                fMap.put(ch, 1);
            }
        }

        // create minHeap
        PriorityQueue<Node> minHeap = new PriorityQueue<>();

        Set<Map.Entry<Character, Integer>> entrySet = fMap.entrySet();

        for (Map.Entry<Character, Integer> entry : entrySet) {
            Node node = new Node(entry.getKey(), entry.getValue());
            minHeap.offer(node);
        }

        while (minHeap.size() != 1) {
            Node first = minHeap.poll();
            Node second = minHeap.poll();

            Node newNode = new Node('\0', first.cost + second.cost);
            newNode.left = first;
            newNode.right = second;

            minHeap.offer(newNode);
        }

        // create tree. Note: minHeap has already connected nodes
        Node root = minHeap.poll();

        this.encoder = new HashMap<>();
        this.decoder = new HashMap<>();

        this.initEncoderDecoderTree(root, "");


    }

    private void initEncoderDecoderTree(Node node, String output) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            this.encoder.put(node.data, output);
            this.decoder.put(output, node.data);
        }

        // left
        initEncoderDecoderTree(node.left, output + 0);
        // right
        initEncoderDecoderTree(node.right, output + 1);
    }

    public String encode(String source) {
        StringBuilder ans = new StringBuilder();

        for (char ch : source.toCharArray()) {
            ans.append(encoder.get(ch));
        }

        return ans.toString();
    }

    public String decode(String codedString) {
        String key = "";
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < codedString.length(); i++) {
            key += codedString.charAt(i);

            if (decoder.containsKey(key)) {
                ans.append(decoder.get(key));
                key = "";
            }
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        String str = "hello";

        HuffmanCoder huffmanCoder = new HuffmanCoder(str);

        String cs = huffmanCoder.encode(str);
        System.out.println("Encoded string: " + cs);

        String ds = huffmanCoder.decode(cs);
        System.out.println("Decoded string: " + ds);
    }
}
