/* Write a program to implement Huffman Code using greedy methods and also calculate the 
best case and worst-case complexity. */

import java.util.*;
class HuffmanNode {
    int data;
    char c;
    HuffmanNode left, right;
    HuffmanNode(char c, int data) {
        this.c = c;
        this.data = data;
        left = right = null;
    }
}
class MyComparator implements Comparator<HuffmanNode> {
    public int compare(HuffmanNode x, HuffmanNode y) {
        return x.data - y.data;
    }
}
public class Slip10a {
    static void printCodes(HuffmanNode root, String s) {
        if (root.left == null && root.right == null && Character.isLetter(root.c)) {
            System.out.println(root.c + ":" + s);
            return;
        }
        printCodes(root.left, s + "0");
        printCodes(root.right, s + "1");
    }
    static void huffmanCodes(char[] charArray, int[] freq, int size) {
        PriorityQueue<HuffmanNode> queue = new PriorityQueue<>(size, new MyComparator());
        for (int i = 0; i < size; i++) {
            HuffmanNode node = new HuffmanNode(charArray[i], freq[i]);
            queue.add(node);
        }
        HuffmanNode root = null;
        while (queue.size() > 1) {
            HuffmanNode x = queue.poll();
            HuffmanNode y = queue.poll();
            HuffmanNode newNode = new HuffmanNode('$', x.data + y.data);
            newNode.left = x;
            newNode.right = y;
            root = newNode;
            queue.add(newNode);
        }
        printCodes(root, "");
    }
    public static void main(String[] args) {
        char[] charArray = {'a', 'b', 'c', 'd', 'e', 'f'};
        int[] freq = {5, 9, 12, 13, 16, 45};
        int size = charArray.length;
        huffmanCodes(charArray, freq, size);
    }
}
