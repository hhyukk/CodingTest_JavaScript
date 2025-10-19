import java.util.*;

class Solution {
    static class Song {
        int idx, plays;
        Song(int idx, int plays) { this.idx = idx; this.plays = plays; }
    }

    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> total = new HashMap<>();          // 장르 -> 총 재생수
        Map<String, List<Song>> byGenre = new HashMap<>();     // 장르 -> 곡 목록

        // 1) 누적 & 장르별 모으기
        for (int i = 0; i < genres.length; i++) {
            String g = genres[i];
            int p = plays[i];
            total.put(g, total.getOrDefault(g, 0) + p);
            byGenre.computeIfAbsent(g, k -> new ArrayList<>()).add(new Song(i, p));
        }

        // 2) 장르를 총 재생수 내림차순으로 정렬
        List<String> order = new ArrayList<>(total.keySet());
        order.sort((a, b) -> total.get(b) - total.get(a));

        // 3) 결과 담기
        List<Integer> answer = new ArrayList<>();
        for (String g : order) {
            List<Song> list = byGenre.get(g);

            // 같은 장르 안에서: 재생수 내림차순, 같으면 인덱스 오름차순
            list.sort((s1, s2) -> {
                if (s2.plays != s1.plays) return s2.plays - s1.plays;
                return s1.idx - s2.idx;
            });

            // 최대 2곡
            answer.add(list.get(0).idx);
            if (list.size() >= 2) answer.add(list.get(1).idx);
        }

        // 4) 배열로 변환
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
