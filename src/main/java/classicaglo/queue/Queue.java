package classicaglo.queue;

// Java program to implement a queue using an array
class Queue {
    static private int head, tail, length;
    static private int queue[];

    Queue(int c) {
        head = tail = 0;
        length = c;
        queue = new int[length];
    }

    // function to insert an element
    // at the tail of the queue
    static void queueEnqueue(int data) {
        // check queue is full or not
        if (length == tail) {
            System.out.printf("\nQueue is full\n");
            return;
        }

        // insert element at the tail
        else {
            queue[tail] = data;
            tail++;
        }
        return;
    }

    // function to delete an element
    // from the head of the queue
    static void queueDequeue() {
        // if queue is empty
        if (head == tail) {
            System.out.printf("\nQueue is empty\n");
            return;
        }

        // shift all the elements from index 2 till tail
        // to the right by one
        else {
            for (int i = 0; i < tail - 1; i++) {
                queue[i] = queue[i + 1];
            }

            // store 0 at tail indicating there's no element
            if (tail < length)
                queue[tail] = 0;

            // decrement tail
            tail--;
        }
        return;
    }

    // print queue elements
    static void queueDisplay() {
        int i;
        if (head == tail) {
            System.out.printf("\nQueue is Empty\n");
            return;
        }

        // traverse head to tail and print elements
        for (i = head; i < tail; i++) {
            System.out.printf(" %d <-- ", queue[i]);
        }
        return;
    }

    // print head of queue
    static void queuehead() {
        if (head == tail) {
            System.out.printf("\nQueue is Empty\n");
            return;
        }
        System.out.printf("\nhead Element is: %d",
                queue[head]);
        return;
    }


    // Driver code
    public static void main(String[] args) {
        // Create a queue of length 4
        Queue q = new Queue(4);

        // print Queue elements
        q.queueDisplay();

        // inserting elements in the queue
        q.queueEnqueue(20);
        q.queueEnqueue(30);
        q.queueEnqueue(40);
        q.queueEnqueue(50);

        // print Queue elements
        q.queueDisplay();

        // insert element in the queue
        q.queueEnqueue(60);

        // print Queue elements
        q.queueDisplay();

        q.queueDequeue();
        q.queueDequeue();

        // print Queue elements
        q.queueDisplay();

        // print head of the queue
        q.queuehead();
    }
}
