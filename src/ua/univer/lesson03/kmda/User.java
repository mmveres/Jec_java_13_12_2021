package ua.univer.lesson03.kmda;

import java.io.Serializable;

public class User implements Serializable, Comparable<User> {
    private int id;
    private String name;
    private String position;
    private double salary;

    private static final long serialVersionUID = 1L;
    public User(){

    }

    public User(String name, String position, double salary) {
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "\nUser{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public int compareTo(User o) {
        return name.compareTo(o.getName());
    }
}
