import java.util.*;

class Solution {

    public boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>();

        // 모든 전화번호를 HashSet에 저장
        Arrays.stream(phone_book).forEach(set::add);

        // 각 번호의 접두어(1 ~ length - 1)를 검사하여
        // 다른 번호가 접두어로 존재하는 경우 false 반환
        for (String phone : phone_book) {
            for (int i = 1; i < phone.length(); i++) {
                if (set.contains(phone.substring(0, i))) return false;
            }
        }

        // 접두어가 존재하지 않으면 true 반환
        return true;
    }
}