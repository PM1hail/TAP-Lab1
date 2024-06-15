import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Linie extends Cuvint{

    private StringBuffer line = new StringBuffer();
    private Pattern pattern;
    private Matcher matcher;
    private String str;
    private Scanner scan = new Scanner(System.in);

    @Override
    void Add(){
        super.Add();
        this.line.append(super.cuv + " ");
    }
    @Override
    void Add(int n){
        super.Add(n);
        this.line.append(super.cuv + " ");
    }
    void Edit(String new_, String old){
        str = new String(line);
        pattern = Pattern.compile(old);
        matcher = pattern.matcher(str);

        if(matcher.find()){
            str = str.replaceAll(old,new_);
        }else {
            System.out.println("word not found");
        }
        line = new StringBuffer(str);
    }
    void Edit(int n){
        str = new String(line);
        String old, new_;

        for (int i = 0; i < n; i++) {

            Show();

            System.out.println("Insert new word");
            new_ = scan.nextLine();
            System.out.println("Insert old word");
            old = scan.nextLine();

            pattern = Pattern.compile(old);
            matcher = pattern.matcher(str);

            if(matcher.find()){
                str = str.replaceAll(old,new_);
            }else {
                System.out.println("word not found");
            }
            line = new StringBuffer(str);
        }
    }
    void Delete(String str){

        this.str = new String(line);

        pattern = Pattern.compile(str);
        matcher = pattern.matcher(this.str);

        if(matcher.find()){
           this.str = this.str.replaceAll(str + " ","");
        }else {
            System.out.println("word not found");
        }

        line = new StringBuffer(this.str);
    }
    void Delete(int n) {

        String del;
        this.str = new String(line);
        for(int i = 0; i < n; i++) {
            Show();

            System.out.println("insert word for delete");
            del = scan.nextLine();

            pattern = Pattern.compile(del);
            matcher = pattern.matcher(str);

            if (matcher.find()) {
                str = str.replaceAll(del + " ", "");
            }else {
                System.out.println("word not found");
            }

            line = new StringBuffer(str);
        }
    }
    void Find(String str){
        pattern = Pattern.compile("\s?.*" + str + ".*?\s");
        matcher = pattern.matcher(this.line);
        while(matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    void Show(){
        System.out.println(this.line);
    }

}