import java.util.ArrayList;
import java.util.Collections;

public class Sol_2785 {

    public String sortVowels(String s) {
        ArrayList<Character> vowelList = new ArrayList<>();
        ArrayList<Integer> idxList = new ArrayList<>();

        //reading vowel
        for(int i=0; i<s.length(); i++){
            if("aeiouAEIOU".indexOf(s.charAt(i)) != -1){
                vowelList.add(s.charAt(i));
                idxList.add(i);
            }
        }

        //sorting vowel list
        Collections.sort(vowelList);

        //using StringBuffer to replace sorted vowels
        StringBuilder newString = new StringBuilder(s);

        for(int j=0; j<idxList.size(); j++){
            newString.setCharAt(idxList.get(j), vowelList.get(j));
        }

        return newString.toString();
    }

    public static void main(String args[]){
        Sol_2785 obj = new Sol_2785();

        String result = obj.sortVowels("lEetcOde");

        if(result.compareTo("lEOtcede") == 0){
            System.out.println("Test case passed");
        }else{
            System.out.println("Test case failed!");
        }
    }
}   
