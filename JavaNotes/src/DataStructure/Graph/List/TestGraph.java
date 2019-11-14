package DataStructure.Graph.List;

public class TestGraph {
    public static void main(String[] args) {
        String[] values = new String[] {"0", "1", "2", "3", "4", "5"};
        Graph graph = new Graph(values.length);
        for (String v : values) {
            graph.addVertex(new Vertex(v));
        }
        Vertex[] vertices = graph.getVertices();
        graph.addEdge(vertices[0], vertices[1], 3);
        graph.addEdge(vertices[0], vertices[2], 5);
        graph.addEdge(vertices[1], vertices[3], 2);
        graph.addEdge(vertices[2], vertices[3], 1);
        graph.addEdge(vertices[3], vertices[4], 4);
        graph.addEdge(vertices[3], vertices[5], 8);
        graph.addEdge(vertices[4], vertices[5], 6);

        // 深度优先遍历
        graph.dfs();
        System.out.println();
        // 广度优先遍历
        graph.bfs();
    }
}
