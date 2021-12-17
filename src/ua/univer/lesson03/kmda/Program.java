package ua.univer.lesson03.kmda;

import java.io.*;
import java.nio.charset.Charset;

public class Program {
    public static void main(String[] args) throws IOException {
       try( BufferedReader br = new BufferedReader(new FileReader("resources"+ File.separator+"lipen-2019.csv", Charset.forName("WINDOWS-1251")))){
           while(br.ready()){
               System.out.println(br.readLine());
           }
       }

    }
}
