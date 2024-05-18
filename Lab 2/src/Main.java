public class Main {

    public static void main(String[] args) {
        System.out.println("m1 constructor\n");
        Market m1 = new Market(9,"AAA");
        System.out.println("m2 constructor\n");
        Location m2 = new Location();
        System.out.println("m3 constructor\n");
        Location m3 = new Location(2, "BBB","X","q");
        System.out.println("m4 constructor\n");
        Market m4 = new Location(3, "CCC","D","e");

        m2.showDate();
        m3.showDate();
    }
}