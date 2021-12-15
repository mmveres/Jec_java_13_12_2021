package ua.univer.lesson02;

import java.util.*;

class Ship {
    private String name;
    private int x;
    private int y;

    public Ship(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ship ship = (Ship) o;
        return Objects.equals(name, ship.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Ship{" +
                "name='" + name + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", hash=" + hashCode() +
                '}';
    }
}

class ShipList implements Iterable<Ship>{
    Node head;

    public void addFirst(Ship ship) {
        Node node = new Node(ship);
        if (head == null) head = node;
        else {
            node.next = head;
            head = node;
        }

    }

    @Override
    public Iterator<Ship> iterator() {
        return new Iterator<Ship>() {
            Node curr = head;
            @Override
            public boolean hasNext() {
                return curr!=null;
            }

            @Override
            public Ship next() {
                Ship ship = curr.data;
                curr = curr.next;
                return ship;
            }
        };
    }

    class Node {
        Ship data;
        Node next;

        public Node(Ship data) {
            this.data = data;
            this.next = null;
        }
    }

}

public class Program {
    public static void main(String[] args) {
        //   testMap();

        Map<Ship, Integer> shipMap = new HashMap<>();
        shipMap.put(new Ship("A", 1, 2), 100);
        shipMap.put(new Ship("B", 2, 3), 200);
        shipMap.put(new Ship("C", 4, 5), 300);

        System.out.println(shipMap);

        System.out.println(shipMap.get(new Ship("A", 10, 20)));


        ShipList ships = new ShipList();
        ships.addFirst(new Ship("A1", 1, 2));
        ships.addFirst(new Ship("A2", 1, 2));
        ships.addFirst(new Ship("A3", 1, 2));
        ships.addFirst(new Ship("A4", 1, 2));

        for (Ship ship: ships ) {
            System.out.println(ship);
        }
        Iterator<Ship> iter = ships.iterator();
        while(iter.hasNext())
            System.out.println(iter.next());
    }

    private static void testMap() {
        Object[] arr = {"Hi", 1, 1.1, new Object(), new Program()};
        System.out.println(Arrays.toString(arr));
        System.out.print(arr.length);
        for (var obj : arr) {
            System.out.println(obj.getClass());
        }
        List<Integer> list = new ArrayList<>();

        Map<Integer, String> map = new HashMap<>();
        map.put(11, "A");
        map.put(5, "B");
        map.put(17, "C");
        map.put(20, "D");

        System.out.println(map);
        System.out.println(map.get(17));
    }
}
