package DesignPattern.Proxy.JDKDynamic;

public class Singer implements ISinger {
    @Override
    public void sing() {
        System.out.println("I'm Singing !");
    }
}
