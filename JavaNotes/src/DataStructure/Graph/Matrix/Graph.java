package DataStructure.Graph.Matrix;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 图
 * 无向图，连接边仅用0-1表示连接关系
 * 邻接矩阵实现
 */
public class Graph {
    // 顶点数组
    private Vertex[] vertices;
    // 当前顶点数量
    private int currentSize;
    // 邻接矩阵
    private int[][] adjacentMatrix;
    // 遍历时，与节点比较判断节点是否被访问过。
    // 每遍历一次，这个值就取反（因为节点的访问标识一旦被访问就被设置为这个值）
    private boolean flag = true;
    // 栈，用于深度优先搜索
    Stack<Integer> stack = new Stack<>();
    // 队列，用于广度优先搜索
    Queue<Integer> queue = new LinkedBlockingQueue<>();

    public Graph(int size) {
        this.vertices = new Vertex[size];
        this.adjacentMatrix = new int[size][size];
    }

    /**
     * 向图中加入一个顶点
     */
    public void addVertex(Vertex vertex) {
        this.vertices[this.currentSize++] = vertex;
    }

    /**
     * 添加边
     * @param v1 顶点1的值
     * @param v2 顶点2的值
     */
    public void addEdge(String v1, String v2) {
        int index1 = getIndex(v1);
        int index2 = getIndex(v2);
        if (index1 != -1 && index2 != -1) {
            adjacentMatrix[index1][index2] = 1;
            adjacentMatrix[index2][index1] = 1;
        }
    }

    private int getIndex(String v) {
        for (int i=0; i<vertices.length; i++) {
            if (vertices[i].getValue().equals(v)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 深度优先搜索DFS 遍历图
     */
    public void dfs() {
        // 从第0个顶点开始遍历
        int currentIndex = 0;
        // 将第0个顶点设置为已访问
        vertices[currentIndex].setVisited(flag);
        // 将第0个顶点入栈
        stack.push(currentIndex);
        System.out.println(vertices[currentIndex].getValue());
        int start = 0;
        while (!stack.isEmpty()) {
            for (int i=start + 1; i<vertices.length; i++) {
                if (adjacentMatrix[currentIndex][i] == 1 && vertices[i].getVisited() != flag) {
                    // 访问下一个元素，标记为已访问，并入栈
                    vertices[i].setVisited(flag);
                    stack.push(i);
                    System.out.println(vertices[i].getValue());
                    currentIndex = i;
                    i=0;
                }
            }
            // 弹出栈顶元素（前一个元素再次遍历时，只需要接着这个元素的位置开始）
            start = stack.pop();
            // 修改当前位置为栈顶元素位置
            if (!stack.isEmpty()) {
                currentIndex = stack.peek();
            }
        }
        // 遍历完成，flag取反，以便下一次遍历
        flag = !flag;
    }

    /**
     * 广度优先搜索BFS 遍历图
     */
    public void bfs() {
        // 从第0个节点开始
        int currentIndex = 0;
        // 将第0个节点设置为已访问
        vertices[currentIndex].setVisited(flag);
        // 将第0个节点入队列
        queue.add(currentIndex);
        System.out.println(vertices[currentIndex].getValue());
        while (!queue.isEmpty()) {
            currentIndex = queue.poll();
            for (int i=0; i<vertices.length; i++) {
                if (adjacentMatrix[currentIndex][i] == 1 && vertices[i].getVisited() != flag) {
                    // 将下一个元素设置为已访问，并入队列
                    vertices[i].setVisited(flag);
                    queue.add(i);
                    System.out.println(vertices[i].getValue());
                }
            }
        }
        flag = !flag;
    }

    public int[][] getAdjacentMatrix() {
        return adjacentMatrix;
    }
}
