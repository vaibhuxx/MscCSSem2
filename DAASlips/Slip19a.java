/*Write a program to determine if a given graph is a Hamiltonian cycle or not. */

import java.util.*;

public class Slip19a {
    private int V;
    private int path[];

    Slip19a(int V) {
        this.V = V;
        path = new int[V];
        Arrays.fill(path, -1);
    }

    boolean isSafe(int v, int graph[][], int pos) {
        if (graph[path[pos - 1]][v] == 0)
            return false;

        for (int i = 0; i < pos; i++)
            if (path[i] == v)
                return false;

        return true;
    }

    boolean hamCycleUtil(int graph[][], int pos) {
        if (pos == V) {
            if (graph[path[pos - 1]][path[0]] == 1)
                return true;
            else
                return false;
        }

        for (int v = 1; v < V; v++) {
            if (isSafe(v, graph, pos)) {
                path[pos] = v;
                if (hamCycleUtil(graph, pos + 1))
                    return true;
                path[pos] = -1;
            }
        }

        return false;
    }

    boolean hamCycle(int graph[][]) {
        path[0] = 0;
        if (!hamCycleUtil(graph, 1)) {
            System.out.println("No Hamiltonian Cycle exists");
            return false;
        }

        printSolution();
        return true;
    }

    void printSolution() {
        System.out.println("Hamiltonian Cycle exists");
        System.out.print("Path: ");
        for (int i = 0; i < V; i++)
            System.out.print(path[i] + " ");
        System.out.println(path[0]);
    }

    public static void main(String args[]) {
        int graph[][] = { 
            { 0, 1, 0, 1, 0 }, 
            { 1, 0, 1, 1, 1 }, 
            { 0, 1, 0, 0, 1 }, 
            { 1, 1, 0, 0, 1 }, 
            { 0, 1, 1, 1, 0 } 
        };

        Slip19a hamiltonian = new Slip19a(graph.length);
        hamiltonian.hamCycle(graph);
    }
}
