import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        int resCnt = 0;

        Map<String, Integer> anagramMap = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            for(int j=i+1; j<s.length()+1; j++){
                String word = s.substring(i, j);
                System.out.println("before sort:" + word);

                char []arr = word.toCharArray(); 
                Arrays.sort(arr); 
                word = String.valueOf(arr);
                System.out.println("after sort:" + word);

                if(anagramMap.get(word)==null){
                    anagramMap.put(word, 1);
                }else{
                    resCnt += anagramMap.get(word);
                    anagramMap.put(word, anagramMap.get(word)+1 );
                }
            }
        }


        return resCnt;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
