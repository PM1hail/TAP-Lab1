public class Location extends Market {
    private String location;
    private String street;

    public Location() {
        this.location = "No location insert";
        this.street = "No location insert";
        System.out.println("no parameter derivate constructor \n");
    }

    public Location(int nr, String name, String location, String street) {
        super(nr, name);
        this.location = location;
        this.street = street;
        System.out.println("all parameter derivate constructor \n");
    }
    String setLocation() {
        return this.location;
    }
    String setStreet() {
        return this.street;
    }
    void showDate() {
        System.out.println("Market Nr - " + setNr() + " Market Name - " + setName() +
                "\tMarket Street - " + setStreet() + "\tMarket Location - " + setLocation());
    }
}