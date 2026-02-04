import java.util.*;

public class MinHeap {
    static final int MAX = 100;
    static int[] heap = new int[MAX];
    static int heapSize = 0;

    static void heapifyDown(int i) {
        int smallest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < heapSize && heap[left] < heap[smallest])
            smallest = left;
        if (right < heapSize && heap[right] < heap[smallest])
            smallest = right;

        if (i != smallest) {
            int temp = heap[i];
            heap[i] = heap[smallest];
            heap[smallest] = temp;
            heapifyDown(smallest);
        }
    }

    static void heapifyUp(int i) {
        while (i > 0 && heap[(i - 1) / 2] > heap[i]) {
            int temp = heap[i];
            heap[i] = heap[(i - 1) / 2];
            heap[(i - 1) / 2] = temp;
            i = (i - 1) / 2;
        }
    }

    static void insert(int val) {
        if (heapSize == MAX) {
            System.out.println("Heap full");
            return;
        }
        heap[heapSize] = val;
        heapSize++;
        heapifyUp(heapSize - 1);
        System.out.println("Inserted " + val);
    }

    static int search(int val) {
        for (int i = 0; i < heapSize; i++) {
            if (heap[i] == val) {
                System.out.println("Found " + val + " at index " + i);
                return i;
            }
        }
        System.out.println(val + " not found");
        return -1;
    }

    static void delete(int val) {
        int index = search(val);
        if (index == -1) return;
        
        heap[index] = heap[heapSize - 1];
        heapSize--;
        heapifyDown(index);
        System.out.println("Deleted " + val);
    }

    static void display() {
        System.out.print("Heap: ");
        for (int i = 0; i < heapSize; i++)
            System.out.print(heap[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n1. Insert\n2. Search\n3. Delete\n4. Display\n5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            
            if (choice == 1) {
                System.out.print("Enter value: ");
                insert(sc.nextInt());
            } else if (choice == 2) {
                System.out.print("Enter value: ");
                search(sc.nextInt());
            } else if (choice == 3) {
                System.out.print("Enter value: ");
                delete(sc.nextInt());
            } else if (choice == 4) {
                display();
            } else {
                break;
            }
        }
    }
}