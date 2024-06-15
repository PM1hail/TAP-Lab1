import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        FileWR file = new FileWR();
        int com = 1;
        Scanner scan = new Scanner(System.in);

        while(com != 0){

            try {
                System.out.println("Insert command:\n1 - write file\n2 - read file\n3 - close");
                com = scan.nextInt();

                switch (com) {
                    case 1:
                        file.Write();
                        break;
                    case 2:
                        file.Read();
                        break;
                    case 3:
                        com = 0;
                        break;
                }
            }
            catch(NumberFormatException e) {
                System.out.println("Number format exception");
            }
            catch(InputMismatchException e){
                System.out.println("InputMismatchException!");
            }

        }

    }
}