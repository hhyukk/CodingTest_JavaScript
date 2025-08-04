import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String[] input = new String[N];

        for (int i = 0; i < N; i++) {
            input[i] = br.readLine();
        }

        int len = input[0].length();
        for (int i = 0; i < len; i++) {
            boolean b = true;
            char c = input[0].charAt(i);
            for (int j = 1; j < N; j++) {
                if (c != input[j].charAt(i)) {
                    b = false;
                }
            }
            if (b) {
                sb.append(c);
            } else {
                sb.append("?");
            }
        }
        System.out.println(sb);
    }
}
