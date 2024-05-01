/* Write a program to implement Knapsack problems using Greedy method*/

import java.util.Arrays;
import java.util.Comparator;
class Item {
    int weight, value;
    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}
class Slip4b {
    static double getMaxValue(int capacity, Item[] items) {
        // Sorting items by value per weight ratio in descending order
        Arrays.sort(items, Comparator.comparingDouble((Item i) -> (double) i.value /
i.weight).reversed());
        double totalValue = 0;
        int remainingCapacity = capacity;
        for (Item item : items) {
            if (item.weight <= remainingCapacity) {
                totalValue += item.value;
                remainingCapacity -= item.weight;
            } else {
                double fraction = (double) remainingCapacity / item.weight;
                totalValue += item.value * fraction;
                break;
            }
        }
        return totalValue;
    }
    public static void main(String[] args) {
        Item[] items = {
                new Item(10, 60),
                new Item(20, 100),
                new Item(30, 120)
        };
        int capacity = 50;
        double maxValue = getMaxValue(capacity, items);
        System.out.println("Maximum profit that can be obtained: " + maxValue);
    }
}