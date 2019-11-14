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
