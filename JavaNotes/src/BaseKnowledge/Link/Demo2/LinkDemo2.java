package BaseKnowledge.Link.Demo2;

public class LinkDemo2 {
    public static void main(String[] args) {
        // 使用内部类，防止外部直接操作Node
        Link link = new Link();
        link.add("Hello");
        link.add("World");
        link.add("Hi");
        link.add("Java");
        System.out.println(link.size());
        System.out.println(link.isEmpty());
        System.out.println(link.get(2));
        link.set(2, "How are you");
        System.out.println(link.get(2));
        link.remove("World");
        System.out.println(link.get(1));

        for (String s : link.toArray()) {
            System.out.print(s + " ");
        }
        System.out.println("\n");
    }
}

class Link {
    private class Node {
        private String data;
        private Node next;
        public Node(String data) {
            this.data = data;
        }

        public void addNode(Node newNode) {
            if (this.next == null) {
                this.next = newNode;
            } else {
                this.next.addNode(newNode);
            }
        }

        public boolean containsNode(String data) {
            if (this.data.equals(data)) {
                return true;
            } else if (this.next != null){
                return this.next.containsNode(data);
            } else {
                return false;
            }
        }

        public String getNode(int index) {
            if (Link.this.foot++ == index) {
                return this.data;
            }
            return this.next.getNode(index);
        }

        public void setNode(int index, String data) {
            if (Link.this.foot++ == index) {
                this.data = data;
            } else {
                this.next.setNode(index, data);
            }
        }

        public void removeNode(Node previous, String data) {
            if (data.equals(this.data)) {
                previous.next = this.next;
            } else {
                this.next.removeNode(this, data);
            }
        }

        public void toArrayNode() {
            Link.this.retArray[Link.this.foot++] = this.data;
            if (this.next != null) {
                this.next.toArrayNode();
            }
        }
    }

    private Node root; // 根节点
    private int count = 0; // 统计链表长度
    private int foot = 0; // 用于索引查找节点
    private String[] retArray; // 返回的数组

    public void add(String data) {
        // 假设不允许为空
        if (data == null) {
            return;
        }
        Node newNode = new Node(data);
        if (this.root == null) {
            this.root = newNode;
        } else {
            this.root.addNode(newNode);
        }
        this.count++;
    }

    public int size() {
        return this.count;
    }

    public boolean isEmpty() {
        return this.count == 0;
        // return root == null; // 两种都行
    }

    // 数据查询
    public boolean contains(String data) {
        if (data == null || this.root == null) {
            return false;
        }
        return this.root.containsNode(data);
    }

    // 根据索引获取数据
    public String get(int index) {
        if (index > this.count) {
            return null;
        }
        this.foot = 0;
        return this.root.getNode(index);
    }

    // 修改指定索引内容
    public void set(int index, String data) {
        if (index > this.count) {
            return;
        }
        this.foot = 0;
        this.root.setNode(index, data);
    }

    // 删除指定数据
    public void remove(String data) {
        if (this.contains(data)) {
            if (data.equals(this.root.data)) {
                this.root = this.root.next;
            } else {
                this.root.next.removeNode(this.root, data);
            }
            this.count--;
        }
    }

    // 将链表变为对象数组
    public String[] toArray() {
        if (this.root == null) {
            return null;
        }
        this.retArray = new String[this.count];
        this.foot = 0;
        this.root.toArrayNode();
        return this.retArray;
    }
}
