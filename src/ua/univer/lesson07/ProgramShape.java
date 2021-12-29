package ua.univer.lesson07;
class Flower implements ColorAble{
    @Override
    public int getColor() {
        return 777777;
    }
}
public class ProgramShape {
    public static void main(String[] args) throws CloneNotSupportedException {
       Point p1 = new Point(1,1);
       Point p2 = p1.clone();
       Point p3 = new Point(p1);
        p2.setX(2);
        p3.setX(33);
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

        Line l1 = new Line(p1, p2);
        Line l2 = new Line(new Point(2,2), new Point(3,3));
        Line l3 = l2.clone();
     //   l3.setBegin(new Point(4,4));
        l3.getBegin().setX(4);
        System.out.println(l2);
        System.out.println(l3);

        Shape [] shapes = {p1,l2};
        ColorAble[] colorAbles = {
                new ColorLine(p1,p2,111111),
                new ColorPoint(1,1,222222),
                () -> 333333,
                new Flower()
        };
    }
}
