package ge.playapp.brine.search;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class CountLuck {


    private static class StackObj {

        Integer i;
        Integer j;
        Integer mark;
        Integer rang;
        char value;


        public Integer getI() {
            return i;
        }

        public void setI(Integer i) {
            this.i = i;
        }

        public Integer getJ() {
            return j;
        }

        public void setJ(Integer j) {
            this.j = j;
        }

        public Integer getMark() {
            return mark;
        }

        public void setMark(Integer mark) {
            this.mark = mark;
        }

        public char getValue() {
            return value;
        }

        public void setValue(char value) {
            this.value = value;
        }

        public Integer getRang() {
            return rang;
        }

        public void setRang(Integer rang) {
            this.rang = rang;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new InputStreamReader(new FileInputStream("out/test.in")));
        int T = scanner.nextInt();

        int[] c =new int[100];
        Arrays.stream(c).boxed()
                .sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();

        for (int t  = 0; t < T; t++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();


            StackObj[][] forest = new StackObj[n][m];
            for (int i = 0; i < n; i++) {
                String x = scanner.next();
                for (int j = 0; j < m; j++) {
                    forest[i][j]=new StackObj();
                    forest[i][j].setValue(x.charAt(j));
                    forest[i][j].setJ(j);
                    forest[i][j].setI(i);
                    forest[i][j].setMark(0);
                    forest[i][j].setRang(0);

                }
            }

            int k = scanner.nextInt();

            StackObj startPoint = new StackObj();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (forest[i][j].getValue() == 'M') {
                        startPoint.setI(i);
                        startPoint.setJ(j);
                    }
                }

            }
            Stack<StackObj> stack = new Stack<>();
            stack.push(forest[startPoint.getI()][startPoint.getJ()]);
            forest[startPoint.getI()][startPoint.getJ()].setMark(1);
            StackObj popObj = forest[startPoint.getI()][startPoint.getJ()];
            int rung=0;
            while (!stack.isEmpty()) {

                int ind = 0;
                for (int x = -1; x < 2; x++) {

                    for (int y = -1; y < 2; y++) {
                        if ((x==0 ||y==0) && x!=y && popObj.getI() + x > -1 && popObj.getI() + x < n
                                && popObj.getJ() + y > -1 && popObj.getJ() + y < m &&
                                (forest[popObj.getI() + x][popObj.getJ() + y].getValue() == '.'
                                        ||forest[popObj.getI() + x][popObj.getJ() + y].getValue() == '*')
                                && forest[popObj.getI() + x][popObj.getJ() + y].getMark() == 0) {

                            ind ++;
                            if(ind<2) {
                                forest[popObj.getI() + x][popObj.getJ() + y].setMark(popObj.getMark()+1);
                                stack.push(forest[popObj.getI() + x][popObj.getJ() + y]);
                                if(forest[popObj.getI() + x][popObj.getJ() + y].getValue()=='*'){
//                                    System.out.println(rung);
                                    if(rung==k){
                                        System.out.println("Impressed");
                                    }else{
                                        System.out.println("Oops!");

                                    }

                                }
                            }
                        }
                    }
                }
                if(ind>1){
                    if(forest[popObj.getI()  ][popObj.getJ()  ].getRang()==0) {
                        rung++;
                        //ystem.out.println(popObj.getI() + " === " + popObj.getJ() + " ==r== " + rung);
                        forest[popObj.getI()][popObj.getJ()].setRang(1);
                    }
                }else if (ind == 0) {
                    StackObj remObj= stack.pop();

                    if(remObj!=null  && remObj.getRang()==1){
                        rung--;
                    }

                }
                if(stack.isEmpty()){
                    break;
                }
                popObj = stack.peek();

            }


        }


    }
}
