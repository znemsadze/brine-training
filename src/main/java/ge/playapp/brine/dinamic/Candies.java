package ge.playapp.brine.dinamic;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'candies' function below.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */

    public static Integer getHeight(Integer n ,Integer max, List<Integer> heights, List<Integer> rating){
        System.out.println(n);
        if(max.equals(n)){
            heights.set(n,1);
            return 1;
        }
        if(heights.get(n)!=null){
            return heights.get(n);
        }
        if(rating.get(n)<=rating.get(n+1)){
            heights.set(n,1);
        }else{
            heights.set(n,getHeight(n+1,max,heights,rating)+1);
        }
        return heights.get(n);
    }


    public static long candies(int n, List<Integer> arr) {
        List<Integer> height=new ArrayList<>(Collections.nCopies (n+1, null));
        Integer gift=getHeight(0,n-1,height,arr);
        Long sum=0L;
        sum+=gift;
        for(int i=1;i<n;i++){
            if(arr.get(i)>arr.get(i-1)){
                gift++;
                if(gift<getHeight(i, n - 1, height, arr)){
                    gift=getHeight(i, n - 1, height, arr);
                }
                sum+=gift;
            }else {
                gift= getHeight(i, n - 1, height, arr);
                sum +=gift;
            }
        }
//        height.forEach(System.out::println);
        return sum;
    }

}

public class Candies {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("out/test.in")));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("out/test.out"));
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        List<Integer> arr = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }).map(String::trim)
          .map(Integer::parseInt)
          .collect(toList());


        long result = Result.candies(n, arr);

        System.out.println(result);
        bufferedReader.close();
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//        bufferedWriter.close();
    }
}
