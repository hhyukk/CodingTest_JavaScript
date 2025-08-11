import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 줄 입력: N(배열 크기), K(K번째 작은 수)
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 두 번째 줄 입력: N개의 수
        st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 퀵셀렉트 실행: 0~N-1 범위에서 K-1 인덱스의 값을 찾음
        quickSort(A, 0, N - 1, K - 1);

        // K번째 작은 값 출력
        System.out.println(A[K - 1]);
    }

    // 퀵셀렉트 알고리즘 (퀵정렬과 비슷하지만 한쪽 부분만 재귀 호출)
    public static void quickSort(int[] A, int start, int end, int K) {
        if (start < end) {
            // 분할(partition) 후 피벗의 최종 위치 반환
            int pivot = partition(A, start, end);

            // 찾는 위치(K)와 피벗 위치 비교
            if (pivot == K) {
                // K번째 원소가 제자리에 왔으면 종료
                return;
            } else if (K < pivot) {
                // K가 피벗보다 왼쪽에 있으면 왼쪽 부분만 재귀
                quickSort(A, start, pivot - 1, K);
            } else {
                // K가 피벗보다 오른쪽에 있으면 오른쪽 부분만 재귀
                quickSort(A, pivot + 1, end, K);
            }
        }
    }

    // 배열을 피벗 기준으로 분할하고 피벗의 최종 위치를 반환
    public static int partition(int[] A, int start, int end) {
        // 구간 크기가 2인 경우: 단순 비교 후 정렬
        if (start + 1 == end) {
            if (A[start] > A[end]) {
                swap(A, start, end);
            }
            return end;
        }

        // 피벗 선택: 구간 중간값 인덱스를 start로 옮김
        int M = (start + end) / 2;
        swap(A, start, M);
        int pivot = A[start];

        int i = start + 1;
        int j = end;

        // 양쪽에서 포인터를 이동하며 피벗 기준으로 값 재배치
        while (i <= j) {
            // 오른쪽 포인터: 피벗보다 큰 값은 그냥 두고 왼쪽으로 이동
            while (j >= start + 1 && pivot < A[j]) {
                j--;
            }
            // 왼쪽 포인터: 피벗보다 작은 값은 그냥 두고 오른쪽으로 이동
            while (i <= end && pivot > A[i]) {
                i++;
            }
            // i와 j가 교차하지 않았으면 서로 교환
            if (i <= j) {
                swap(A, i++, j--);
            }
        }

        // 피벗을 j 위치로 옮겨서 최종 정렬 위치 확정
        A[start] = A[j];
        A[j] = pivot;

        // 피벗의 최종 위치 반환
        return j;
    }

    // 배열의 두 원소 교환
    public static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
