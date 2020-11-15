import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {


    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {

        People[] peopleQueue = new People[q.length];

        // initial
        for(int i=0; i<q.length; i++){
            peopleQueue[i] = new People(q[i]);
        }
        int changeCnt = 0;

        for(int i=0; i<q.length; i++){
            // 要變成的值扣掉這個位子原本的index代表位移情況 （假設原始形態應該是每個位子index=值)
            if( (peopleQueue[i].tobePosition - i) > 3 ){
                // invalid － 偏差超過2 ->不可能
                changeCnt = -1;
                break;
            }
        }

        for(int i=0; (i<q.length) && (changeCnt!=-1); i++){
            

            // 要變成的位子和原始的index如果差距不為1,代表有移動
            if( (peopleQueue[i].tobePosition - i) != 1){
                for(int j=(q.length-1); j>i; j--){
                    if( peopleQueue[j-1].tobePosition > peopleQueue[j].tobePosition ){
                        if(!peopleQueue[j-1].doBribe()){
                            changeCnt = -1;
                            break;
                        }
                        int temp = peopleQueue[j].tobePosition;
                        peopleQueue[j].tobePosition = peopleQueue[j-1].tobePosition;
                        peopleQueue[j-1].tobePosition = temp;
                        changeCnt++;
                    }
                }
            }
        }

        if(changeCnt == -1){
            System.out.println("Too chaotic");
        }else{
            System.out.println(""+changeCnt);
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}

class People{
    int tobePosition;
    private int bribeChance = 2;
    public People(int tobePosition){
        this.tobePosition = tobePosition;
    }

    public boolean doBribe(){
        if(this.bribeChance == 0){
            return false;
        }else{
            this.bribeChance--;
            return true;
        }
    }
}
