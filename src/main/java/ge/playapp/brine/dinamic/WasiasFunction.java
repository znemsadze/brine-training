package ge.playapp.brine.dinamic;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class WasiasFunction {

    private static Long wf(int s,int n ,Long[][] cache ){
        Long result=0L;
        if(n==1){
            return (s<=9)?1L:0L;
        }
        if (s==0)return 1L;
        if(cache[s][n]!=null){
            return cache[s][n];
        }
        for (int i=0;i<=9;i++){
            if((s-i)>=0  ) {
                result += wf(s - i, n - 1, cache);
            }
        }
        cache[s][n]=result;
        return result;
    }

    public static void main(String argv[]) throws IOException {
        Long[][]   cache= new Long[83][11] ;
        BufferedReader scanner = new BufferedReader(new InputStreamReader(new FileInputStream("out/test.in")));
        long result=0;
        int s=Integer.parseInt(scanner.readLine().trim());
        for(int  i=0;i<=9;i++){
            if(s-i>=0){
                result+=wf(s-i,8,cache);
            }
        }
        if(s==1){result++;}
        System.out.println(result);
    }

}
