import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        String str1, str2;
        Scanner scan = new Scanner(System.in);
        Linie line = new Linie();

        line.Add();
        line.Show();

        line.Add(4);
        line.Show();

        System.out.println("insert old word");
        str1 = scan.nextLine();
        System.out.println("insert new word");
        str2 = scan.nextLine();

        line.Edit(str2,str1);
        line.Show();

        line.Edit(2);
        line.Show();

        System.out.println("insert word for delete");
        str1 = scan.nextLine();
        line.Delete(str1);
        line.Show();

        line.Delete(2);
        line.Show();

        System.out.println("insert word to find");
        str2 = scan.nextLine();
        line.Find(str2);
    }
}