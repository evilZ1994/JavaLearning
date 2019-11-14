package DataStructure.Graph.Matrix;

import java.util.Arrays;

public class TestGraph {
    public static void main(String[] args) {
        // 基于邻接矩阵实现的无向图
        String[] values = new String[] {"A", "B", "C", "D", "E"};
        Graph graph = new Graph(values.length);
        for (String v : values) {
            graph.addVertex(new Vertex(v));
        }
        // 增加边
        graph.addEdge("A", "C");
        graph.addEdge("B", "C");
        graph.addEdge("B", "D");
        graph.addEdge("C", "E");

        for (int[] a : graph.getAdjacentMatrix()) {
            System.out.println(Arrays.toString(a));
        }

        // 深度优先搜索遍历
        graph.dfs();
        // 广度优先搜索遍历
        System.out.println();
        graph.bfs();
    }
}
