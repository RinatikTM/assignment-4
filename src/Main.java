public class Main{
    public static void main(String[] args){
        System.out.println("=== Small Graph (10 vertices) ===");
        Graph small = new Graph();
        for (int i = 0; i < 10; i++) small.addVertex(new Vertex(i));
        for (int i = 0; i < 9; i++) small.addEdge(i, i + 1);
        small.addEdge(0, 5);
        small.addEdge(2, 7);
        small.printGraph();
        small.bfs(0);
        small.dfs(0);
        System.out.println("\n=== Performance Experiments ===");
        Experiment exp = new Experiment();
        exp.printResults();
    }
}