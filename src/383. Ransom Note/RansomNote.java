import java.util.HashMap;
import java.util.Map;

class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {

        Map<Character, Integer> hs = new HashMap<Character, Integer>();
        char flag;
        int num;

        for (int i = 0; i < magazine.length(); i++) {
            flag = magazine.charAt(i);
            hs.put(flag, hs.getOrDefault(flag, 0) + 1);
        }

        for (int j = 0; j < ransomNote.length(); j++) {
            flag = ransomNote.charAt(j);
            num = hs.getOrDefault(flag, 0);

            if (!hs.containsKey(flag) || num <= 0)
                return false;
            hs.put(flag, num - 1);
        }

        return true;
    }
}
