import java.util.*;

class Sol_966 {
    // Helper to check vowel
    private boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }

    // Helper to transform a word by replacing vowels with '*'
    private String devowel(String word) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (isVowel(c)) {
                sb.append('*');
            } else {
                sb.append(Character.toLowerCase(c)); // normalize to lowercase
            }
        }
        return sb.toString();
    }

    public String[] spellchecker(String[] wordlist, String[] queries) {
        String[] answer = new String[queries.length];

        // Exact words set (for quick lookup)
        Set<String> exactWords = new HashSet<>(Arrays.asList(wordlist));

        // Case-insensitive map (first occurrence wins)
        Map<String, String> caseInsensitive = new HashMap<>();

        // Vowel-insensitive map (first occurrence wins)
        Map<String, String> vowelInsensitive = new HashMap<>();

        for (String word : wordlist) {
            String lower = word.toLowerCase();
            caseInsensitive.putIfAbsent(lower, word);

            String devowelKey = devowel(word);
            vowelInsensitive.putIfAbsent(devowelKey, word);
        }

        // Process each query
        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];

            // Exact match
            if (exactWords.contains(query)) {
                answer[i] = query;
                continue;
            }

            // Case-insensitive match
            String lower = query.toLowerCase();
            if (caseInsensitive.containsKey(lower)) {
                answer[i] = caseInsensitive.get(lower);
                continue;
            }

            // Vowel error match
            String devowelKey = devowel(query);
            if (vowelInsensitive.containsKey(devowelKey)) {
                answer[i] = vowelInsensitive.get(devowelKey);
                continue;
            }

            // No match
            answer[i] = "";
        }

        return answer;
    }
}
