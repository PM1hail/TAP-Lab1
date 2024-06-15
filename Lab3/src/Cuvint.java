import java.util.Scanner;

public class Cuvint {
    Scanner scan = new Scanner(System.in);

    protected String cuv;
    void Add(){
        cuv = scan.nextLine();
        StringBuffer str = new StringBuffer(cuv);

        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == ' '){
                for(int j = i; j < str.length(); ){
                    str.deleteCharAt(j);
                }
            }
        }
        cuv = new String(str);
    }
    void Add(int n){
        int cnt = 0;
        cuv = scan.nextLine();
        StringBuffer str = new StringBuffer(cuv);

        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == ' '){
                cnt++;
            }
            if(cnt == n){
                for(int j = i; j < str.length(); ){
                    str.deleteCharAt(j);
                }
            }
        }
        cuv = new String(str);
    }
}
