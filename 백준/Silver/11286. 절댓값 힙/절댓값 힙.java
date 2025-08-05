import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pQ = new PriorityQueue<>((a, b) -> {
            int absA = Math.abs(a);
            int absB = Math.abs(b);

            if (absA != absB) {
                return absA - absB;
            } else {
                return a - b;
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());
            if (value != 0) {

                pQ.offer(value);
            } else {
                if (pQ.isEmpty()) {
                    sb.append("0\n");
                } else {
                    sb.append(pQ.poll() + "\n");
                }
            }
        }
        System.out.println(sb);
    }
}
