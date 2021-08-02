package ge.playapp.brine.dinamic;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class RoadsInLibraries {

    /*
     * Complete the 'roadsAndLibraries' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER c_lib
     *  3. INTEGER c_road
     *  4. 2D_INTEGER_ARRAY cities
     */

    private static class Graph{

        private int V;
        private LinkedList<Integer> adj[];

        public Graph(int vc){
            adj=new LinkedList[vc];
            V=vc;
            for(int i=0;i<vc;i++){
                adj[i]=new LinkedList();
            }
        }

        void addEdge(int v,int w){
            adj[v].add(w);
        }

        int  DFSUtils(int v,boolean visited[]){
            if(visited[v]) return 0;
            visited[v]=true;
            int cnt=1;

            Iterator<Integer> i=adj[v].listIterator();
            while(i.hasNext()){
                int n=i.next();
                if(!visited[n]){
                    cnt+= DFSUtils(n,visited);
                }
            }
            return cnt;
        }

        int  dfs(int v,boolean[] visited){
            return DFSUtils(v,visited);
        }


        int bfs(int v ,boolean visited[]){

            if(visited[v])return 0;
            visited[v]=true;
            LinkedList<Integer> queue=new LinkedList<>();
            queue.add(v);
            int cnt=1;
            while(queue.size()>0){
                int top=queue.poll();
                Iterator<Integer> iter=adj[top].listIterator();
                while(iter.hasNext()){
                    int val=iter.next();
                    if(!visited[val]){
                        cnt++;
                        queue.add(val);
                        visited[val]=true;
                    }
                }
            }
            return cnt;
        }

    }



    public static long roadsAndLibraries(int n, int c_lib, int c_road, List<List<Integer>> cities) {
        // Write your code here
        boolean[] visited=new boolean[n+1];
        long result ;
        if(c_lib<c_road){
            result=(long)c_lib*(long)n*1L;
        }else{
            Graph graph=new Graph(n+1);
            for(List<Integer> row:cities){
                graph.addEdge(row.get(0),row.get(1));
                graph.addEdge(row.get(1),row.get(0));
            }
            long libCount=0L;long roadCount=0L;
            for(int i=1;i<=n;i++){
                if(!visited[i]){
                    int rc=graph.bfs(i,visited)-1;
                    if(rc<0) {
                        System.out.println(rc);
                    }
                    libCount++;roadCount+=rc;
                }
            }
            result=libCount*c_lib+(roadCount)*c_road;

        }
        System.out.println();
        System.out.println(result);
        return result;
    }

}


class Solution {

    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("out/test.in")));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("out/test.out"));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                int c_lib = Integer.parseInt(firstMultipleInput[2]);

                int c_road = Integer.parseInt(firstMultipleInput[3]);

                List<List<Integer>> cities = new ArrayList<>();

                IntStream.range(0, m).forEach(i -> {
                    try {
                        cities.add(
                                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                        .map(Integer::parseInt)
                                        .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                long result = RoadsInLibraries.roadsAndLibraries(n, c_lib, c_road, cities);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        bufferedReader.close();
        bufferedWriter.close();
    }
}
