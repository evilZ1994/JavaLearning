package QuestionCollection.StepWalk;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(compute(n));
    }

    static int compute(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n <= 2) {
            return n;
        }

        return compute(n - 1) + compute(n - 2);
    }
}
