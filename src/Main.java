import java.util.Scanner;

public class Main {
    static String getSentence(){
            String sentence;
            Scanner scanner = new Scanner(System.in);
            sentence = scanner.nextLine();
            return sentence;
    }

    static int getPosition(){
        int position;
        Scanner scanner = new Scanner(System.in);
        position = scanner.nextInt();
        return position;
    }

    static char getSymbol(){
        char symbol;
        Scanner scanner = new Scanner(System.in);
        symbol = scanner.next().charAt(0);
        return symbol;
    }
    static String NewSentence(String edit, int switchPosition, char symbol){
        int letterNumber = 0;
        StringBuffer swap = new StringBuffer();
        swap.append(edit);
        for (int i = 0; i < edit.length(); i++){

            if (edit.charAt(i) == ' '){
                letterNumber = 0;

            }
            if (letterNumber == switchPosition){
                swap.deleteCharAt(i);
                swap.insert(i, symbol);
            }
            letterNumber++;
        }
        edit = new String(swap);
        return edit;
    }

    public static void main(String[] args) {

        System.out.println("Inset text:");
        String sentence = getSentence();

        System.out.print("Insert position:");
        int position = getPosition();

        System.out.print("Insert character:");
        char symbol = getSymbol();

        System.out.println("New text");
        String newSentence = NewSentence(sentence, position, symbol);

        System.out.println(newSentence);
    }
}