import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the jumpingOnClouds function below.
    // 用一個loop去一直跳，只需要檢查可不可以一次跳兩格
    static int jumpingOnClouds(int[] c) {
        int jumpCnt = 0;
        int cLen = c.length;
        for(int i=0; i<cLen; i++){
            jumpCnt++;
            // 可以一次跳兩格且不會撞終點
            if(i<(cLen-2) && c[i+2]==0){
                i++;
            }
            // 是倒數第二格就直接跳出去了
            if(i==(cLen-2)){
                break;
            }
            
        }
        return jumpCnt;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
