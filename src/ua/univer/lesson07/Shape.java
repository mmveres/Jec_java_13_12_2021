package ua.univer.lesson07;

public abstract class Shape {
    static int glId;
    private int curId;
    static{
        glId =100;
    }

    public Shape() {
        this.curId = glId++;
    }
}
