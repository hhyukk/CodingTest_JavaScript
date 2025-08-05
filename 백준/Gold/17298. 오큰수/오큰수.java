import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] answer = new int[N];
        int[] array = new int[N];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        int range = 0;
        for (int i = 0; i < N; i++) {
            while (!stack.empty() && array[i] > array[stack.peek()]) {
                answer[stack.pop()] = array[i];
            }
            stack.push(i);
        }
        while (!stack.empty()) {
            answer[stack.pop()] = -1;
        }
        StringBuilder sb = new StringBuilder();
        for (int value : answer) {
            sb.append(value + " ");
        }
        System.out.println(sb);
    }
}
