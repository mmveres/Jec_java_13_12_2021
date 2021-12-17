package ua.univer.lesson03.kmda;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class UserHelper {


    public static List<User> getUsersFromURL(String url) throws IOException {
        URL website = new URL(url);
        URLConnection connection = website.openConnection();
        BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        connection.getInputStream(), Charset.forName("WINDOWS-1251")));
        List<User> users = new ArrayList<>();
        br.readLine();
        while (br.ready()) {
            String[] words = br.readLine().split(";");
            users.add(new User(
                    words[0],
                    words[1],
                    Double.parseDouble(words[2].replace(",", "."))
            ));
        }
        br.close();
        return users;
    }
    public static List<User> getUsersFromCSV(String filename) throws IOException {
        List<User> users = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename, Charset.forName("WINDOWS-1251")))) {
            System.out.println(br.readLine());
            while (br.ready()) {
                String[] words = br.readLine().split(";");
                users.add(new User(
                        words[0],
                        words[1],
                        Double.parseDouble(words[2].replace(",", "."))
                ));
            }
        }
        return users;
    }
    public static void writeUsersToCSV(List<User> users, String filename) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename, Charset.forName("WINDOWS-1251")))) {
            for (User user: users) {
                bw.write(user.getName()+";");
                bw.write(user.getPosition()+";");
                bw.write(user.getSalary()+";");
                bw.newLine();
              //  bw.flush();
            }
        }
    }
}
