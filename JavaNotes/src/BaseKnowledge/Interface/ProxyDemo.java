package BaseKnowledge.Interface;

public class ProxyDemo {
    public static void main(String[] args) {
        // 代理设计模式
        Subject proxy = new ProxySubject(new RealSubject());
        proxy.make();
    }
}

interface Subject {
    // 主要工作
    public void make();
}

class RealSubject implements Subject {
    // 完成主要工作

    @Override
    public void make() {
        System.out.println("Make");
    }
}

class ProxySubject implements Subject {
    // 代理类完成与主要工作相关的操作

    private Subject subject;

    public ProxySubject(Subject subject) {
        this.subject = subject;
    }

    public void prepare() {
        System.out.println("Prepare");
    }

    @Override
    public void make() {
        this.prepare();
        this.subject.make();
        this.destroy();
    }

    public void destroy() {
        System.out.println("Destroy");
    }
}
