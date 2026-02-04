import java.util.PriorityQueue;
import java.util.Scanner;

class CutOffScore {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int n = sc.nextInt();

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int score = sc.nextInt();
            heap.add(score);

            if (heap.size() > K) {
                heap.poll();
            }

            if (heap.size() == K) {
                System.out.println(
                    "After reading " + (i + 1) + " scores, cutoff score is: " + heap.peek()
                );
            } else {
                System.out.println(
                    "After reading " + (i + 1) + " scores, cutoff score = -1 "
                );
            }
        }
    }
}