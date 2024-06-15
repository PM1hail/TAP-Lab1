import java.util.Scanner;
public class ComplexFraction extends Fraction{
    Scanner scan = new Scanner(System.in);

    protected String cf;
    protected String nr, nr2;

    StringBuffer fraction() {
        int nr;
        System.out.println("insert the number of numbers");
        nr = scan.nextInt();

        StringBuffer cf = new StringBuffer();
        if(nr % 2 == 0){
            for(int i = 0; i < nr / 2; i++){

                if(nr == 2 || i + 1 == nr / 2) {
                    cf.append(super.fraction());
                }
                else{
                    cf.append(super.fraction() + "\n-\n");
                }
            }
        }else{
            for(int i = 0; i < (nr + 1) / 2; i++) {
                if (i+1 == (nr + 1) / 2) {
                    cf.append(super.fraction1());
                } else {
                    cf.append(super.fraction() + "\n-\n");
                }
            }
        }
        return cf;
    }
    void Show(){
        System.out.println(cf);
    }
    void Execute(){
        cf = new String (fraction());
        Show();
    }
}
