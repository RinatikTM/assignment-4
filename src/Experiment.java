public class Experiment {
    public void runTraversals(Graph g, int start){
        long startTime = System.nanoTime();
        g.bfs(start);
        long endTime = System.nanoTime();
        System.out.println("BFS time: " + (endTime - startTime) + " ns");
        startTime = System.nanoTime();
        g.dfs(start);
        endTime = System.nanoTime();
        System.out.println("DFS timne: " + (endTime - startTime) + " ns");
    }
    public void runMultipleTests(){
        int[] sizes = {10, 30, 100};
        for (int size : sizes){
            System.out.println("\n=== Graph size: " + size + "===");
            Graph g = buildGraph(size);
            runTraversals(g, 0);
        }
    }
    private Graph buildGraph(int size){
        Graph g = new Graph();
        for (int i = 0; i < size; i++){
            g.addVertex(new Vertex(i));
        }
        for (int i = 0; i < size - 1; i++){
            g.addEdge(i, i + 1);
        }
        for (int i = 0; i < size - 2; i += 3){
            g.addEdge(i, i + 2);
        }
        return g;
    }
    public void printResults(){
        runMultipleTests();
    }
}
