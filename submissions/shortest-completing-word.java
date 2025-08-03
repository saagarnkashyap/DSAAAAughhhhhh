import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        Map<Character, Integer> licensePlateMap = new HashMap<>();
        for (char c : licensePlate.toLowerCase().toCharArray()) {
            if (Character.isLetter(c)) {
                licensePlateMap.put(c, licensePlateMap.getOrDefault(c, 0) + 1);
            }
        }

        String shortestWord = null;
        for (String word : words) {
            Map<Character, Integer> wordMap = new HashMap<>();
            for (char c : word.toCharArray()) {
                wordMap.put(c, wordMap.getOrDefault(c, 0) + 1);
            }

            boolean isCompletingWord = true;
            for (Map.Entry<Character, Integer> entry : licensePlateMap.entrySet()) {
                if (wordMap.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                    isCompletingWord = false;
                    break;
                }
            }

            if (isCompletingWord && (shortestWord == null || word.length() < shortestWord.length())) {
                shortestWord = word;
            }
        }

        return shortestWord;
    }
}