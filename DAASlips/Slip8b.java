import java.util.*;
class TravelingSalesman {
    private int V;
    private int[][] graph;
    public TravelingSalesman(int[][] graph) {
        this.graph = graph;
        this.V = graph.length;
    }
    // Function to find the nearest unvisited city
    private int nearestNeighbor(int city, boolean[] visited) {
        int nearestCity = -1;
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < V; i++) {
            if (!visited[i] && graph[city][i] != 0 && graph[city][i] < minDistance) {
                minDistance = graph[city][i];
                nearestCity = i;
            }
        }
        return nearestCity;
    }
    // Function to find the minimum cost Hamiltonian cycle
    public List<Integer> findTour() {
        List<Integer> tour = new ArrayList<>();
        boolean[] visited = new boolean[V];
        
        // Start from the first city
        int currentCity = 0;
        tour.add(currentCity);
        visited[currentCity] = true;
        // Repeat until all cities are visited
        while (tour.size() < V) {
            int nextCity = nearestNeighbor(currentCity, visited);
            if (nextCity == -1) {
                // If no unvisited city found, return to the starting city
                tour.add(0);
                currentCity = 0;
            } else {
                tour.add(nextCity);
                visited[nextCity] = true;
                currentCity = nextCity;
            }
        }
        // Add the starting city to complete the cycle
        tour.add(0);
        return tour;
    }
    // Function to calculate the total cost of the tour
    public int calculateTourCost(List<Integer> tour) {
        int cost = 0;
        for (int i = 0; i < tour.size() - 1; i++) {
            cost += graph[tour.get(i)][tour.get(i + 1)];
        }
        return cost;
    }
}
public class Slip8b {
    public static void main(String[] args) {
        int[][] graph = {
            {0, 10, 15, 20},
            {10, 0, 35, 25},
            {15, 35, 0, 30},
            {20, 25, 30, 0}
        };
        TravelingSalesman tsp = new TravelingSalesman(graph);
        List<Integer> tour = tsp.findTour();
        int tourCost = tsp.calculateTourCost(tour);
        System.out.println("Optimal Tour: " + tour);
        System.out.println("Tour Cost: " + tourCost);
    }
}
