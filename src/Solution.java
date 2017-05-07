import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int line = in.nextInt();
        int column = in.nextInt();
        int second = in.nextInt();
        int counter;
        String output = "";
        List<Integer> lines = new ArrayList<Integer>();
        List<Integer> columns = new ArrayList<Integer>();
        String[][] map1 = new String[line][column];
        String[][] map2 = new String[line][column];
        String[][] map3 = new String[line][column];
        //prepare second 1
        for (int i=0; i < line; i++){
            String lineString = in.next();
            counter = 0;
            for (int j=0; j < column; j++){
                if ((""+(lineString.charAt(counter))).equals("O")) {
                    lines.add(i);
                    columns.add(j);
                }
                map1[i][j] = "" + lineString.charAt(counter);
                counter++;
            }
        }
        //prepare second 2
        for (int i=0; i < line; i++){
            for (int j=0; j < column; j++){
                map2[i][j] = "O";
                map3[i][j] = "O";
            }
        }
        
        //prepare second 3
        for (int i =0; i < lines.size(); i++){
            map3[lines.get(i)][columns.get(i)] = ".";
            
            if ((lines.get(i)-1)>= 0){
                map3[lines.get(i)-1][columns.get(i)] = ".";
            }
            if ((lines.get(i)+1)< line){
                map3[lines.get(i)+1][columns.get(i)] = ".";
            }
            if ((columns.get(i)-1)>= 0){
                map3[lines.get(i)][columns.get(i)-1] = ".";
            }
            if ((columns.get(i)+1)< column){
                map3[lines.get(i)][columns.get(i)+1] = ".";
            }
        }
        
        if (second == 1) {
            output += output(map1, output, line, column);
        } else if (second == 2) {
            output += output(map2, output, line, column);
        } else {
            output += output(map3, output, line, column);
        }

        System.out.println(output);
    }
    
    public static String output(String[][] map, String output, int line, int column){
        for (int i=0; i < line; i++){
            for (int j=0; j < column; j++){
                output += map[i][j];
            }
            output += "\n";
        }
        return output;
    }
}