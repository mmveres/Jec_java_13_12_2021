package ua.univer.lesson07;

public class Line extends Shape implements Cloneable{
    private Point begin;
    private Point end;

    public Line(Point begin, Point end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    protected Line clone() throws CloneNotSupportedException {
        Line line = (Line) super.clone();
        line.setBegin(begin.clone());
        line.setEnd(new Point(end));
        return line;
    }

    public Point getBegin() {
        return begin;
    }

    public void setBegin(Point begin) {
        this.begin = begin;
    }

    public Point getEnd() {
        return end;
    }

    public void setEnd(Point end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Line{" +
                "begin=" + begin +
                ", end=" + end +
                '}';
    }
}
