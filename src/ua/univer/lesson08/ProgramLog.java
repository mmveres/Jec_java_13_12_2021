package ua.univer.lesson08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class ProgramLog {
    public static Logger logger = Logger.getLogger(ProgramLog.class.getName());

    static {
        try {
           FileHandler fh = new FileHandler(ProgramLog.class.getName()+".log", true);
           fh.setFormatter(new SimpleFormatter());
           logger.addHandler(fh);
           logger.setLevel(Level.SEVERE);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        int [] arr = new int[3];
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < arr.length; i++) {
            int intValue = getMarkValue(br);
            arr[i] = intValue;
        }

        System.out.println(Arrays.toString(arr));
    }

    private static int getMarkValue(BufferedReader br) throws IOException {
        while(true)
        try {
            int intValue = getIntValue(br);
            if (intValue < 2 || intValue > 12)
                throw new MarkErrorException(intValue+" not mark");
            return intValue;
        }catch (MarkErrorException e){
            logger.log(Level.SEVERE,"Error not mark" +  Arrays.toString(e.getStackTrace()));
        //    throw e;
        }
    }

    private static int getIntValue(BufferedReader br) throws IOException {
        while(true)
        try {
            String text = br.readLine();
            logger.log(Level.INFO, "user enter from console: "+text);
            return Integer.parseInt(text);
        }catch (NumberFormatException e){
           // System.err.print("Error not int value");
            logger.log(Level.SEVERE,"Error not int value" +  Arrays.toString(e.getStackTrace()));
        }

    }
}
