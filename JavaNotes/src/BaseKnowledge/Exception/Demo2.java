package BaseKnowledge.Exception;

public class Demo2 {
    public static void main(String[] args) {
        try {
            System.out.println(MyMath2.div(10, 0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyMath2 {
    public static int div(int x, int y) throws Exception {
        int result = 0;
        System.out.println("Start");
        try {
            result = x / y;
        } catch (Exception e) {
            throw  e;
        } finally {
            System.out.println("Stop");
        }
        return result;
    }
}
