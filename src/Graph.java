import java.util.*;
public class Graph {
    private Map<Integer, List<Integer>> adjecancyList;
    private Map<Integer, Vertex> vertices;
    public Graph(){
        adjecancyList = new HashMap<>();
        vertices = new HashMap<>();
    }
    public void addVertex(Vertex v){
        vertices.put(v.getId(), v);
        adjecancyList.putIfAbsent(v.getId(), new ArrayList<>());
    }
    public void addEdge(int from, int to){
        adjecancyList.get(from).add(to);
        adjecancyList.get(to).add(from);
    }
    public void printGraph(){
        for (int id : adjecancyList.keySet()){
            System.out.println("Vertex " + id + " -> " + adjecancyList);
        }
    }
    public void bfs(int start){
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        visited.add(start);
        queue.add(start);
        System.out.print("BFS: ");
        while (!queue.isEmpty()){
            int current = queue.poll();
            System.out.print(current + " ");
            for (int neighbor : adjecancyList.get(current)){
                if(!visited.contains(neighbor)){
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }
    public void dfs(int start){
        Set<Integer> visited = new HashSet<>();
        System.out.print("DFS: ");
        dfsHelper(start, visited);
        System.out.println();
    }
    public void dfsHelper(int current, Set<Integer> visited){
        visited.add(current);
        System.out.print(current + "");
        for (int neighbor : adjecancyList.get(current)){
            if (!visited.contains(neighbor)){
                dfsHelper(neighbor, visited);
            }
        }
    }
}
