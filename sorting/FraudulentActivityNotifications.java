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
        for(int i=0; i<expenditure.length-d; i++){
            
            int[] currExpArr = new int[d];
            // copy sub array
            for(int j=0, subIdx=i; j<d; j++, subIdx++){
                currExpArr[j] = expenditure[subIdx];
            }
            
            // do sorting asc
            sort(currExpArr);
            
            if(isEven){
                int doubleMedian = getMedian(d, currExpArr, isEven);
                if(expenditure[i+d] >= (doubleMedian)){
                    notifCnt++;
                }
            }else{
                int median = getMedian(d, currExpArr, isEven);
                if(expenditure[i+d] >= (median*2)){
                    notifCnt++;
                }
            }
        }
        
        return notifCnt;
    }
    
    static void sort(int[] arr){
        doQuickSort(arr, 0, arr.length-1);
    }
    
    private static void doQuickSort(int[] number, int left, int right) {
        if(left < right) { 
            int q = partition(number, left, right); 
            doQuickSort(number, left, q-1); 
            doQuickSort(number, q+1, right); 
        } 

    }

    private static int partition(int number[], int left, int right) {  
        int i = left - 1; 
        for(int j = left; j < right; j++) { 
            if(number[j] <= number[right]) { 
                i++; 
                swap(number, i, j); 
            } 
        } 
        swap(number, i+1, right); 
        return i+1; 
    } 

    private static void swap(int[] number, int i, int j) {
        int t = number[i]; 
        number[i] = number[j]; 
        number[j] = t;
    }
    
    static int getMedian(int arrayLen, int[] arr, boolean isEven){
        if(isEven){
            int midIdxRight = arrayLen/2;
            int midIdxLeft = midIdxRight - 1;
            
            return ( (arr[midIdxRight] + arr[midIdxLeft])  );
        }else{
            int medianIdx = arrayLen/2;
            return arr[medianIdx];
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
