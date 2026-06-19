import java.util.ArrayList;

public class MyStack<T> {
    // List to store the stack elements
    private ArrayList<T> stack;

    // Constructor to initialize the stack
    public MyStack() {
        stack = new ArrayList<>();
    }

    // Push an element onto the stack
    public void push(T item) {
        stack.add(item);
    }

    // Pop an element from the stack
    public T pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop.");
            return null; // or throw an exception
        }
        // Remove the last element (top of the stack)
        return stack.remove(stack.size() - 1);
    }

    // Peek the top element without removing it
    public T peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Nothing to peek.");
            return null; // or throw an exception
        }
        // Return the last element (top of the stack)
        return stack.get(stack.size() - 1);
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    // Main method for testing
    public static void main(String[] args) {
        // Create a stack for Integer type
        MyStack<Integer> intStack = new MyStack<>();
        intStack.push(10);
        intStack.push(20);
        intStack.push(30);

        System.out.println("Top of intStack: " + intStack.peek()); // Should print 30
        System.out.println("Popped from intStack: " + intStack.pop()); // Should print 30
        System.out.println("Top of intStack after pop: " + intStack.peek()); // Should print 20

        // Create a stack for String type
        MyStack<String> stringStack = new MyStack<>();
        stringStack.push("Apple");
        stringStack.push("Banana");
        stringStack.push("Cherry");

        System.out.println("Top of stringStack: " + stringStack.peek()); // Should print "Cherry"
        System.out.println("Popped from stringStack: " + stringStack.pop()); // Should print "Cherry"
        System.out.println("Top of stringStack after pop: " + stringStack.peek()); // Should print "Banana"

        // Check if a stack is empty
        System.out.println("Is stringStack empty? " + stringStack.isEmpty()); // Should print false
        stringStack.pop(); // Remove "Banana"
        stringStack.pop(); // Remove "Apple"
        System.out.println("Is stringStack empty after removing all elements? " + stringStack.isEmpty()); // Should print true
    }
}