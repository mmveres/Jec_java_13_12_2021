package ua.univer.lesson01;

public class Program {
    public static void main(String[] args) {

        System.out.println(Droid.getEngine());

        Droid r2d2 = new Droid("R2D2", 80,90);
        System.out.println(r2d2);

        Droid [] droids = {new Droid("BattleDroid", 100, 100),
                new Droid("BattleDroid", 100, 100),
                new Droid("BattleDroid", 100, 100),
                new Droid("BattleDroid", 100, 100),
                new Droid("BattleDroid", 100, 100)
        };
        Droid.setEngine(new Droid.Engine("B", 200));
        int i= 0;
        for (var droid: droids) {
            droid.setShield(droid.new Shield("A"+(i++),100  ));
            System.out.println(droid);
        }
    }
}
