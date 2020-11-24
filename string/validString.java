import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the isValid function below.
    static String isValid(String s) {
        Map<String, Integer> countMap = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            String str = s.substring(i, i+1);
            if(countMap.get(str)==null){
                countMap.put(str, 1);
            }else{
                countMap.put(str, countMap.get(str)+1);
            }
        }

        List<Integer> countList = new ArrayList<>();

        for(Map.Entry<String, Integer> entry: countMap.entrySet()){
            String str = entry.getKey();
            Integer cnt = entry.getValue();
            countList.add(cnt);
        }
        Collections.sort(countList);
        
        boolean isValid = true;

        int minCnt = countList.get(0);


        int currGapCount = 0;
        boolean isUpAt1 = false;
        for(int i=1; i<countList.size(); i++){

            if(isUpAt1){
                if(countList.get(i) > countList.get(i-1)){
                    isValid = false;
                    break;
                }
            }

            if(countList.get(i) > countList.get(i-1)){
                if(i==1){
                    isUpAt1 = true;
                }else{
                    if(i<countList.size()-1){
                        isValid = false;
                        break;
                    }else{
                        if( (countList.get(i) - countList.get(i-1)) > 1 ){
                            isValid = false;
                        }
                    }
                }

            }
        }

        return isValid ? "YES" : "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
