package ua.univer.lesson03.kmda;

import java.io.*;
import java.util.List;

public class Program {
    public static void main(String[] args) throws IOException {
       // List<User> users = UserHelper.getUsersFromCSV("resources" + File.separator + "lipen-2019.csv");
        List<User> users = UserHelper.getUsersFromURL("https://data.gov.ua/dataset/770cc750-4333-424f-b6e9-6e6c5c76aec9/resource/59cb6066-1fac-41ed-a571-811db551c75b/download/zp-lupen-2019.csv");
        System.out.println(users);
        UserHelper.writeUsersToCSV(users,"resources" + File.separator + "users.csv");
        System.out.println(UserServices.getMaxSalaryUser(users));
    }
}
