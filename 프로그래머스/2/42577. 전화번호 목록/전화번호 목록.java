import java.util.*;

class Solution {
    public boolean solution(String[] phoneBook) {
        Set<String> set = new HashSet<>(Arrays.asList(phoneBook));

        for (String number : set) {
            StringBuilder prefix = new StringBuilder();

            for (int i = 0; i < number.length() - 1; i++) {
                prefix.append(number.charAt(i)); 

                if (set.contains(prefix.toString())) {
                    return false;
                }
            }
        }
        return true;
    }
}