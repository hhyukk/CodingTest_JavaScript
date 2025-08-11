import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] p = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) p[i] = Integer.parseInt(st.nextToken());

        // 삽입 정렬: 오름차순
        for (int i = 1; i < N; i++) {
            int insertValue = p[i];
            int j = i - 1;

            // 왼쪽으로 가며 자신보다 큰 값들을 한 칸씩 뒤로 민다
            while (j >= 0 && p[j] > insertValue) {
                p[j + 1] = p[j];
                j--;
            }
            p[j + 1] = insertValue; // 알맞은 위치에 삽입
        }

        int prefix = 0, answer = 0;
        for (int x : p) {
            prefix += x;
            answer += prefix;
        }
        System.out.println(answer);
    }
}
