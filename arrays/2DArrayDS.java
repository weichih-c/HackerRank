import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int[] sumArr = new int[16];
        int maxHourglass = 0;
        for(int idx=0; idx<16; idx++){
            int lv = idx/4;
            int a = idx%4;
            sumArr[idx] = arr[lv][0+a] + arr[lv][1+a] + arr[lv][2+a] + arr[lv+1][1+a] + arr[lv+2][0+a] + arr[lv+2][1+a] + arr[lv+2][2+a];
            
            if(idx==0 || sumArr[idx] > maxHourglass){
                maxHourglass = sumArr[idx];
            }
        }
        
        return maxHourglass;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
