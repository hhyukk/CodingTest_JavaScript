import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        radixSortLSD(A);

        for (int i = 0; i < N; i++) {
            bw.write(A[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static void radixSortLSD(int[] a) {
        int n = a.length;
        if (n <= 1) return;

        int max = Arrays.stream(a).max().orElse(0);
        if (max == 0) return; // 모두 0이면 패스

        int[] output = new int[n];

        // exp = 1(1의 자리), 10(10의 자리), 100(100의 자리) ...
        for (int exp = 1; max / exp > 0; exp *= 10) {
            // 0~9 카운팅
            int[] count = new int[10];
            for (int value : a) {
                int digit = (value / exp) % 10;
                count[digit]++;
            }

            // 누적합 -> 각 digit의 최종 위치 인덱스 계산
            for (int d = 1; d < 10; d++) {
                count[d] += count[d - 1];
            }

            // 안정 정렬: 뒤에서 앞으로 채우기
            for (int i = n - 1; i >= 0; i--) {
                int digit = (a[i] / exp) % 10;
                output[--count[digit]] = a[i];
            }

            // 결과를 원본 배열로 복사
            System.arraycopy(output, 0, a, 0, n);
        }
    }
}
