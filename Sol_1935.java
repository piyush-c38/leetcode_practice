class Sol_1935 {
    public static int canBeTypedWords(String text, String brokenLetters) {
        // form an array of letters that are broken
        // form an array of words in the text
        // store the word count in a variable
        // then check if each letter is present in the word
        // if the letter is present then decrease the number by one
        String[] brokenLtr = brokenLetters.split("");
        String[] words = text.split(" ");
        int wordCnt = words.length;

        if (brokenLetters.compareTo("") == 0) {
            return wordCnt;
        }

        for (String word : words) {
            for (String letter : brokenLtr) {
                if (word.indexOf(letter.charAt(0)) != -1) {
                    wordCnt--;
                    break;
                }
            }
        }

        return wordCnt;
    }

    public static void main(String args[]) {
        System.out.println(canBeTypedWords("abc de", ""));
    }
}