import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] p = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N; i++) {
            int insertValue = p[i];
            int insertIndex = i;
            for (int j = i - 1; j >= 0; j--) {
                if (p[i] > p[j]) {
                    insertIndex = j + 1;
                    break;
                }
                if (j == 0) {
                    insertIndex = 0;
                }
            }
            for (int j = i; j > insertIndex; j--) {
                p[j] = p[j - 1];
            }
            p[insertIndex] = insertValue;
        }
        int[] sum = new int[N];
        sum[0] = p[0];
        int sumValue = sum[0];
        for (int i = 1; i < N; i++) {
            sum[i] = sum[i - 1] + p[i];
            sumValue += sum[i];
        }
        System.out.println(sumValue);
    }
}
