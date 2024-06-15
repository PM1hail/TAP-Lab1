import java.util.Scanner;
public class Fraction{
    Scanner scan = new Scanner(System.in);
    protected String str, nr, nr2;
    StringBuffer fraction(){
        System.out.println("insert 2 numbers");
        this.nr = scan.nextLine();
        this.nr2 = scan.nextLine();
        str = nr+"\n-\n"+nr2;
        StringBuffer f = new StringBuffer(str);
        return f;
    }
    String fraction1(){
        System.out.println("insert last number");
        this.nr = scan.nextLine();
        return nr;
    }
}
