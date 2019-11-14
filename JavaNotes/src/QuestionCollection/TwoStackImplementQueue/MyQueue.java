package QuestionCollection.TwoStackImplementQueue;

import java.util.Stack;

public class MyQueue<T> {
    private Stack<T> pushStack;
    private Stack<T> popStack;

    public MyQueue() {
        pushStack = new Stack<>();
        popStack = new Stack<>();
    }

    public T push(T element) {
        pushStack.push(element);
        return element;
    }

    public T pop() {
        T element = null;
        if (!popStack.isEmpty()) {
            element = popStack.pop();
        } else {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
            if (!popStack.isEmpty()) {
                element = popStack.pop();
            }
        }

        return element;
    }

    public boolean isEmpty() {
        return pushStack.isEmpty() && popStack.isEmpty();
    }
}
