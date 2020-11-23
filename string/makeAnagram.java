import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {
        boolean isALarger = (a.length()>=b.length());

        Map<String, Integer> countMap = new HashMap<>();
        int resCnt = 0;
        if(isALarger){
            for(int i=0; i<b.length(); i++){
                String str = b.substring(i, i+1); 
                if(countMap.get(str) == null){
                    countMap.put(str, 1);
                }else{
                    countMap.put(str, countMap.get(str)+1);
                }
                
            }

            for(int i=0; i<a.length(); i++){
                String str = a.substring(i, i+1); 
                Integer cnt = countMap.get(str);
                if(cnt == null || cnt==0){
                    resCnt++;
                }else{
                    countMap.put(str, cnt-1);
                }
            }

            for(Map.Entry<String, Integer> entry: countMap.entrySet()){
                String str = entry.getKey(); 
                Integer cnt = entry.getValue(); 
                if(cnt != null && cnt>0){
                    resCnt+=cnt;
                }
            }
        }else{
            for(int i=0; i<a.length(); i++){
                String str = a.substring(i, i+1); 
                if(countMap.get(str) == null){
                    countMap.put(str, 1);
                }else{
                    countMap.put(str, countMap.get(str)+1);
                }
                
            }

            for(int i=0; i<b.length(); i++){
                String str = b.substring(i, i+1); 
                Integer cnt = countMap.get(str);
                if(cnt == null || cnt==0){
                    resCnt++;
                }else{
                    countMap.put(str, cnt-1);
                }
            }

            for(Map.Entry<String, Integer> entry: countMap.entrySet()){
                String str = entry.getKey(); 
                Integer cnt = entry.getValue(); 
                if(cnt != null && cnt>0){
                    resCnt+=cnt;
                }
            }
        }

        return resCnt;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
