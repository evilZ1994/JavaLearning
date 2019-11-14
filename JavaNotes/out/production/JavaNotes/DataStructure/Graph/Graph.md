# 图-概述

![](http://upyun.ishavanti.top/img/Graph1.png)

- 邻接：两个顶点通过一条边相连
- 路径：依次遍历顶点序列之间的边所形成的轨迹
- 环：路径包含相同的顶点两次或两次以上
- 联通性：连通性是图中的一个重要概念。对于无向图而言，如果它的每个顶点都能通过某条路径到达其他顶点，那么我们称它为连通的。如果该条件在有向图中同样成立，则称该图是强连通的。

# 图结构的实现

图结构没办法像树那样直接用链表实现，因为每个顶点的边的数量不确定。

通常我们使用一个数组保存图中的顶点数据，然后再用其他的方法保存顶点间的关系，即边的信息。保存顶点关系的常用的方法有：邻接表和邻接矩阵。

## 邻接表

![](http://upyun.ishavanti.top/img/AdjacencyList.jpg)

将图中每个顶点作为头节点，分别建立一个链表，头节点指向其邻接节点，邻接节点指向头节点的另一个邻接节点（顶点和其所有的邻接点连成一个链表）

## 邻接矩阵

![](http://upyun.ishavanti.top/img/AdjacentMatrix.jpeg)

# 遍历

## 深度优先搜索（DFS）

深度优先搜索属于图算法的一种，是一个针对图和树的遍历算法，英文缩写为DFS即Depth First Search。深度优先搜索是图论中的经典算法，利用深度优先搜索算法可以产生目标图的相应拓扑排序表，利用拓扑排序表可以方便的解决很多相关的图论问题，如最大路径问题等等。一般用堆数据结构来辅助实现DFS算法。其过程简要来说是对每一个可能的分支路径深入到不能再深入为止，而且每个节点只能访问一次。

基本步骤：

1. 对于下面的树而言，DFS方法首先从根节点1开始，其搜索节点顺序是1,2,3,4,5,6,7,8（假定左分枝和右分枝中优先选择左分枝）。

![](http://upyun.ishavanti.top/img/DFS1.png)

2. 从stack中访问栈顶的点

   ![](http://upyun.ishavanti.top/img/DFS2.png)

3. 找出与此点邻接的且尚未遍历的点，进行标记，然后放入stack中，依次进行

   ![](http://upyun.ishavanti.top/img/DFS3.png)

4. 如果此点没有尚未遍历的邻接点，则将此点从stack中弹出，再按照（3）依次进行

   ![](http://upyun.ishavanti.top/img/DFS4.png)

   ![](http://upyun.ishavanti.top/img/DFS5.png)

5. 直到遍历完整个树，stack里的元素都将弹出，最后栈为空，DFS遍历完成

   ![](http://upyun.ishavanti.top/img/DFS6.png)

   ![](http://upyun.ishavanti.top/img/DFS7.png)

## 广度优先搜索（BFS）

广度优先搜索（也称宽度优先搜索，缩写BFS，以下采用广度来描述）是连通图的一种遍历算法这一算法也是很多重要的图的算法的原型。Dijkstra单源最短路径算法和Prim最小生成树算法都采用了和宽度优先搜索类似的思想。其别名又叫BFS，属于一种盲目搜寻法，目的是系统地展开并检查图中的所有节点，以找寻结果。换句话说，它并不考虑结果的可能位置，彻底地搜索整张图，直到找到结果为止。基本过程，BFS是从根节点开始，沿着树(图)的宽度遍历树(图)的节点。如果所有节点均被访问，则算法中止。一般用队列数据结构来辅助实现BFS算法。

基本步骤：

1. 给出一连通图，如图，初始化全是白色（未访问）

   ![](http://upyun.ishavanti.top/img/BFS1.png)

2. 搜索起点V1（灰色）

   ![](http://upyun.ishavanti.top/img/BFS2.png)

3. 已搜索V1（黑色），即将搜索V2，V3，V4（标灰）

   ![](http://upyun.ishavanti.top/img/BFS3.png)

4. 对V2，V3，V4重复以上操作

   ![](http://upyun.ishavanti.top/img/BFS4.png)

5. 直到终点V7被染灰，终止

   ![](http://upyun.ishavanti.top/img/BFS5.png)

6. 最短路径为V1，V4，V7

# 代码实现

## 基于邻接表

**Vertex.java**

```java
package DataStructure.Graph.List;

public class Vertex {
    private String value;
    // 邻接节点
    private NeighborVertex neighbor;
    // 遍历时记录是否被访问过
    private boolean visited = false;

    public Vertex(String value) {
        this.value = value;
    }

    /**
     * 深度优先搜索(遍历)
     * @param flag 标识节点已被访问过
     */
    public void dfs(boolean flag) {
        // 设置当前顶点为已访问
        visited = flag;
        // 打印当前顶点的值
        System.out.println(value);
        // 遍历邻接节点
        NeighborVertex next = neighbor;
        while (next != null) {
            if (next.getVertex().visited != flag) {
                // 如果这个邻接节点未被访问过，则从这个顶点继续深度优先遍历
                next.getVertex().dfs(flag);
            }
            next = next.getNext();
        }
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public NeighborVertex getNeighbor() {
        return neighbor;
    }

    public void setNeighbor(NeighborVertex neighbor) {
        this.neighbor = neighbor;
    }

    public boolean getVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}
```

**NeighborVertex.java**

```java
package DataStructure.Graph.List;

public class NeighborVertex {
    // 权重
    private int weight;
    // 这个邻接节点所代表的顶点
    private Vertex vertex;
    // 下一个邻接节点
    private NeighborVertex next;

    public NeighborVertex(int weight, Vertex vertex) {
        this.weight = weight;
        this.vertex = vertex;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Vertex getVertex() {
        return vertex;
    }

    public void setVertex(Vertex vertex) {
        this.vertex = vertex;
    }

    public NeighborVertex getNext() {
        return next;
    }

    public void setNext(NeighborVertex next) {
        this.next = next;
    }
}
```

**Graph.java**

```java
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
```

**TestGraph.java**

```java
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
```

## 基于邻接矩阵

实现了一个无向图，且连接边权重仅为{0, 1}，1表示两顶点邻接，0表示不邻接

**Vertex.java**

```java
package DataStructure.Graph;

public class Vertex {
    private String value;
    // 遍历时标记是否被访问过
    private boolean visited = false;

    public Vertex(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean getVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}
```

**Graph.java**

```java
package DataStructure.Graph;

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
```

**TestGraph.java**

```java
package DataStructure.Graph;

import java.util.Arrays;

public class TestGraph {
    public static void main(String[] args) {
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
```

