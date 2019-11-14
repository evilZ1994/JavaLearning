package BaseKnowledge.Interface;

public class FactoryDemo {
    public static void main(String[] args) {
        // 工厂设计模式
        Fruit fruit = Factory.getInstance("apple");
        if (fruit != null) {
            fruit.eat();
        }
    }
}

interface Fruit {
    public void eat();
}

class Apple implements Fruit {
    @Override
    public void eat() {
        System.out.println("Eat apple");
    }
}

class Orange implements Fruit {
    @Override
    public void eat() {
        System.out.println("Eat orange");
    }
}

class Factory {
    public static Fruit getInstance(String className) {
        if ("apple".equals(className)) {
            return new Apple();
        } else if ("orange".equals(className)) {
            return new Orange();
        } else {
            return null;
        }
    }
}
