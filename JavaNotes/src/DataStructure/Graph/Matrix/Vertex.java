package DataStructure.Graph.Matrix;

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
