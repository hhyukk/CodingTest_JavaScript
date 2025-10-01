import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[] A, temp;
    public static long result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        A = new int[N + 1];
        temp = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        mergeSort(1, N);
        System.out.println(result);
    }

    public static void mergeSort(int s, int e) {
        if (s >= e) return;
        int m = s + (e - s) / 2;
        mergeSort(s, m);
        mergeSort(m + 1, e);

        int k = s;
        int index1 = s;
        int index2 = m + 1;

        for (int i = s; i <= e; i++) {
            temp[i] = A[i];
        }
        while (index1 <= m && index2 <= e) {
            if (temp[index1] > temp[index2]) {
                A[k] = temp[index2];
                result = result + index2 - k;
                k++;
                index2++;
            } else {
                A[k] = temp[index1];
                k++;
                index1++;
            }
        }
        while (index1 <= m) {
            A[k] = temp[index1];
            k++;
            index1++;
        }
        while (index2 <= e) {
            A[k] = temp[index2];
            k++;
            index2++;
        }
    }
}
