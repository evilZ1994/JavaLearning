package BaseKnowledge.Exception;

public class Demo4 {
    public static void main(String[] args) {
        // 自定义异常
        // 开发自定义的异常类可以继承Exception或RuntimeException
        int num = 20;
        try {
            if (num > 10) {
                throw new AddException("数值传递过大");
            }
        } catch (AddException e) {
            e.printStackTrace();
        }
        // 此例只是介绍自定义异常的形式，不能说明自定义异常的实际使用
    }
}

class AddException extends Exception {
    public AddException(String msg) {
        super(msg);
    }
}
