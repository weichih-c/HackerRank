import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the whatFlavors function below.
    static void whatFlavors(int[] cost, int money) {
        int index1 = 0;
        int index2 = 0;
        Map<Integer, Integer> costMap = new HashMap<>();
        Set<Integer> remainderSet = new HashSet<>();
        
        for(int i=0; i<cost.length; i++){
            int currCost = cost[i];
            int remainder = money - currCost;
            
            if( remainderSet.contains(currCost) ){
                System.out.println(costMap.get(remainder) + " " + (i+1));
                break;
            }
            
            if( remainder > 0 ){
                costMap.put( currCost, i+1 );
                remainderSet.add(remainder); // remainder , index
            } 
            
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int money = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] cost = new int[n];

            String[] costItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int costItem = Integer.parseInt(costItems[i]);
                cost[i] = costItem;
            }

            whatFlavors(cost, money);
        }

        scanner.close();
    }
}
