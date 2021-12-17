package ua.univer.lesson03;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws IOException {
//       new Scanner( System.in);
//       new BufferedReader(new InputStreamReader(System.in));

        int [] arr = {48,49,50,51,52,53};
      //  writeToCsv(arr);
        List<String[]> listStrings = getListStrings();
        System.out.println(listStrings);
    }

    private static List<String[]> getListStrings() throws IOException {
        List<String[]> listStrings = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("resources"+File.separator+"arr.csv"));
        while(br.ready()){
            String str = br.readLine();
            String [] words = str.split(";");
            listStrings.add(words);
            System.out.println(Arrays.toString(words));
        }
        return listStrings;
    }

    private static void writeToCsv(int[] arr) throws IOException {
        FileWriter fw = new FileWriter("arr.csv");
        for (int i = 0; i < arr.length; i++) {
            fw.write(String.valueOf(arr[i])+";");
        }
        fw.close();
    }
}
