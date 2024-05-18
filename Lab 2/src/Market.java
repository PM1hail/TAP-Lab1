public class Market {
    private int nr;
    private String name;

    public Market(int nr, String name) {
        this.nr = nr;
        this.name = name;
        System.out.println("2 parameter parent constructor \n");
    }

    public Market(String name) {
        this.name = name;
        this.nr = 0;
        System.out.println("1 parameter parent constructor \n");
    }

    public Market() {
        this.name = "no name insert";
        this.nr = 0;
        System.out.println("no parameter parent constructor \n");

    }
    int setNr() {
        return this.nr;
    }
    String setName() {
        return this.name;
    }
}