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
