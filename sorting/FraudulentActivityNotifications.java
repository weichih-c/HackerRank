import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {
        int notifCnt = 0;
        
        boolean isEven = d%2==0;
        // check times
        for(int i=0; i<(expenditure.length-d); i++){
            
            int[] currExpArr = new int[d];
            // copy sub array
            for(int j=0, subIdx=i; j<d; j++, subIdx++){
                currExpArr[j] = expenditure[subIdx]; // 1 2 3 4
            }
            
            int doubleMedian = getMedian(currExpArr, isEven);
            if(expenditure[i+d] >= (doubleMedian)){
                notifCnt++;
            }
        }
        
        return notifCnt;
    }
    
     
    static int getMedian(int[] arr, boolean isEven){
        // [1 2 3 4], true
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            if(countMap.get(arr[i])== null){
                countMap.put(arr[i], 1);
            }else{
                countMap.put(arr[i], (1+countMap.get(arr[i])) );
            }
        }
        
        
        int half = arr.length/2;        
        
        // put into buffer array
        int[] buffer = new int[arr.length];
        int bufferIndex = 0;
        
        Integer[] tempArr = new Integer[countMap.keySet().size()];
        countMap.keySet().toArray(tempArr);
        Arrays.sort(tempArr);

        boolean terminateFlag = false;
        for(int i=0; i<tempArr.length; i++){
            Integer key = tempArr[i];
            Integer val = countMap.get(key);
            
            for(int j=0; j<val; j++, bufferIndex++){
                buffer[bufferIndex] = key;

                if( bufferIndex>half ){
                    terminateFlag = true;
                    break;   
                }
            }
            
            if( terminateFlag ){
                break;   
            }
        }

        if(isEven){
            int right = buffer[half];
            int left = buffer[half-1];
            
            return (right+left);
        }else{
            return buffer[half]*2;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications(expenditure, d);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
