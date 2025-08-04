import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N + 1];
        int count = 1;

        for (int i = 1; i < N + 1; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 1; i < N + 1; i++) {
            if (array[i] >= count) {
                while (count <= array[i]) {
                    stack.push(count++);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            } else {
                if (stack.peek() > array[i]) {
                    System.out.println("NO");
                    return;
                }
                stack.pop();
                sb.append("-\n");
            }
        }
        System.out.println(sb);
    }
}
