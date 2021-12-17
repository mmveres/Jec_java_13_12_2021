package ua.univer.lesson03.kmda;

import java.util.ArrayList;
import java.util.List;

public class UserServices {
    public static List<User> getMaxSalaryUser(List<User> users){
        List<User> maxSalaryUsers = new ArrayList<>();
        User maxSalaryUser = users.get(0);
        for (User user : users) {
            if(maxSalaryUser.getSalary()< user.getSalary())
                maxSalaryUser = user;
        }
        for (User user : users) {
            if(maxSalaryUser.getSalary()==user.getSalary())
                maxSalaryUsers.add(user);
        }
        return maxSalaryUsers;
    }
}
