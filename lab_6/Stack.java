import java.util.Arrays;

public class Stack<T> {
    private Object[] data;
    private int size;

    public Stack(int capacity) {
        this.data = new Object[capacity];
        this.size = 0;
    }

    public void push(T element) {
        if (size == data.length) {
            int newCapacity = data.length * 2;
            data = Arrays.copyOf(data, newCapacity);
        }
        data[size] = element;
        size++;
    }

    public String pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Невозможно удалить элемент так как стек пустой");
        }
        T element = getElementAtTop();
        size--;
        data[size] = null;
        return "Элемент \"" + element + "\" был удален";
    }

    public String peek() {
        if (isEmpty()) {
            throw new IllegalStateException("В стеке нет элементов");
        }
        return "Верхний элемент стека: " + getElementAtTop();
    }

    public void displayStack() {
        if (isEmpty()) {
            System.out.println("Стек пустой");
        } else {
            System.out.println("Содержимое стека:");
            for (int i = 0; i < data.length; i++) {
                if (data[i] != null) {
                    System.out.println(data[i]);
                }
            }
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }


    private T getElementAtTop() {
        return (T) data[size - 1];
    }

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>(10);
        stack.push("First");
        stack.push("Second");
        stack.push("Third");


        stack.displayStack();
        System.out.println();

        System.out.println(stack.pop());
        System.out.println();

        System.out.println(stack.peek());
        System.out.println();
        System.out.println("Количество элементов : " + stack.size);
    }
}