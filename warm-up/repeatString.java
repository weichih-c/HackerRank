import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        long result = 0;
        long fullRepeat = (n / s.length()) ;
        long remainCnt = n - fullRepeat * s.length(); // not a full word

        // find how many 'a' occurred in one string word
        long occurInOnce = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'a'){
                occurInOnce++;
            }
        }
        result = occurInOnce * fullRepeat;

        for(int i = 0; i < remainCnt ; i++){
            if(s.charAt(i) == 'a'){
                result++;
            }
        }
        
        
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
