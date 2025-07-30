import java.util.Scanner;

public class CircularQueue {
    static final int N = 10;
    static int front = -1;
    static int rear = -1;
    static int[] queue = new int[N];

    public static void display() {
        if (front == -1) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.println("Queue elements are:");
        int i = front;
        while (true) {
            System.out.print(queue[i] + " ");
            if (i == rear)
                break;
            i = (i + 1) % N;
        }
        System.out.println();
    }

    public static void enqueue(Scanner sc) {
        if ((rear + 1) % N == front) {
            System.out.println("Queue is already full");
            return;
        }
        System.out.print("Enter a value for the Queue: ");
        int val = sc.nextInt();
        if (front == -1 && rear == -1) {
            front = rear = 0;
        } else {
            rear = (rear + 1) % N;
        }
        queue[rear] = val;
        display();
    }

    public static void dequeue() {
        if (front == -1 && rear == -1) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.println("Dequeued element: " + queue[front]);
        if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % N;
        }
        display();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c;
        do {
            System.out.print("Enter\n 1. For Enqueue\n 2. For Dequeue\n 3. To End Program: ");
            c = sc.nextInt();
            switch (c) {
                case 1: enqueue(sc); break;
                case 2: dequeue(); break;
                case 3: c = 0; break;
                default: System.out.println("Enter a valid number"); break;
            }
        } while (c != 0);
        sc.close();
    }
}
