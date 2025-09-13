public class Sol_3541 {
    public int maxFreqSum(String s) {
        int freqArr[] = new int[26];

        //if string is empty
        if(s.length() == 0){
            return 0;
        }

        //counting frequency of letters
        for(int i=0; i<s.length(); i++){
            freqArr[s.charAt(i)-'a']++;
        }

        int maxVowel=0, maxCons=0;
        //finding maximum among the each of vowels and consonants
        
        for(int i=0; i<freqArr.length; i++){
            if( i==('a'-'a')
            || i==('e'-'a')
            || i==('i'-'a')
            || i==('o'-'a')
            || i==('u'-'a')){
                if(freqArr[i]>maxVowel){
                    maxVowel = freqArr[i];
                }
            }else{
                if(freqArr[i]>maxCons){
                    maxCons = freqArr[i];
                }
            }
        }

        return maxVowel+maxCons;
    }

    public static void main(String args[]){
        Sol_3541 obj = new Sol_3541();

        String test = "successes";

        int result = obj.maxFreqSum(test);

        //we know result is 6
        if(result == 6){
            System.out.println("Test Case Passed");
        }else{
            System.out.println("Test Case Failed! \nExpected: 6 \nResult: "+result);
        }
    }
}


/*
Question:
You are given a string s consisting of lowercase English letters ('a' to 'z').

Your task is to:

Find the vowel (one of 'a', 'e', 'i', 'o', or 'u') with the maximum frequency.
Find the consonant (all other letters excluding vowels) with the maximum frequency.
Return the sum of the two frequencies.

Note: If multiple vowels or consonants have the same maximum frequency, you may choose any one of them. If there are no vowels or no consonants in the string, consider their frequency as 0.

The frequency of a letter x is the number of times it occurs in the string.
 */