import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new LinkedList<>();
        int[] array = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            array[i] = Integer.parseInt(st.nextToken());

            while (!deque.isEmpty() && array[deque.peekLast()] > array[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            if (deque.peekFirst() <= i - L) {
                deque.pollFirst();
            }
            bw.write(array[deque.peekFirst()] + " ");
        }
        bw.flush();
        bw.close();
    }
}
