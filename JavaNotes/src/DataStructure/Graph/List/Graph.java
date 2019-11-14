package DataStructure.Graph.List;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 图
 * 有向带权图
 * 基于邻接表实现
 */
public class Graph {
    // 所有顶点
    private Vertex[] vertices;
    private int currentSize = 0;
    // 节点被访问过的标识
    private boolean flag = true;

    public Graph(int size) {
        this.vertices = new Vertex[size];
    }

    /**
     * 添加顶点
     * @param vertex
     */
    public void addVertex(Vertex vertex) {
        if (currentSize >= vertices.length) {
            throw new NullPointerException();
        }
        vertices[currentSize++] = vertex;
    }

    /**
     * 添加边
     * @param from 边的起始顶点
     * @param to 边的结束顶点
     * @param weight 边的权重
     */
    public void addEdge(Vertex from, Vertex to, int weight) {
        if (from.getNeighbor() == null) {
            from.setNeighbor(new NeighborVertex(weight, to));
            return;
        }
        NeighborVertex neighbor = from.getNeighbor();
        while (neighbor.getNext() != null) {
            if (neighbor.getVertex() == to) {
                // 两顶点间已经存在边了，更新权重
                neighbor.setWeight(weight);
                return;
            }
            neighbor = neighbor.getNext();
        }
        // 找到结尾邻接点
        if (neighbor.getVertex() == to) {
            neighbor.setWeight(weight);
        } else {
            // 添加新的邻接点
            neighbor.setNext(new NeighborVertex(weight, to));
        }
    }

    /**
     * 深度优先搜索，遍历图
     */
    public void dfs() {
        if (vertices[0] != null) {
            vertices[0].dfs(flag);
            // 遍历一次后，节点中的访问标识被修改为flag，
            // 所以每次遍历完都对flag取反，以便下一次遍历
            flag = !flag;
        }
    }

    /**
     * 广度优先搜索，遍历图
     */
    public void bfs() {
        if (vertices[0] == null) {
            return;
        }
        Queue<Vertex> queue = new LinkedBlockingQueue<>();
        vertices[0].setVisited(flag);
        System.out.println(vertices[0].getValue());
        queue.add(vertices[0]);
        while (!queue.isEmpty()) {
            Vertex vertex = queue.poll();
            NeighborVertex next = vertex.getNeighbor();
            while (next != null) {
                if (next.getVertex().getVisited() != flag) {
                    next.getVertex().setVisited(flag);
                    System.out.println(next.getVertex().getValue());
                    queue.add(next.getVertex());
                }
                next = next.getNext();
            }
        }
        flag = !flag;
    }

    public Vertex[] getVertices() {
        return vertices;
    }
}
