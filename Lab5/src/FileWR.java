import java.io.*;
import java.util.Scanner;
class MyException2{}
public class FileWR {

    Scanner scan = new Scanner(System.in);
    boolean fr;
    String readv;
    BufferedReader read;
    BufferedWriter write;

    void aa() {

            throw new RuntimeException();

    }

    void Write() {
        try {
            String str;
            read = new BufferedReader(new FileReader("File.txt"));
            if ((readv = read.readLine()) != null) {fr=false;
                System.out.println("false");}
            else fr = true;
            read.close();
            if(fr) {
                System.out.println("Insert the text for write to file");
                str = scan.nextLine();
                if(str == null){
                    throw new MyException("Variable str is null");
                } else {
                    write = new BufferedWriter(new FileWriter("File.txt"));
                        write.write(str);
                    write.close();
                }
            }else{
                StringBuilder str1 = new StringBuilder();
                read = new BufferedReader (new FileReader("File.txt"));
                    while((str = read.readLine()) != null){
                        System.out.println(str);
                        str1.append(str);
                    }
                read.close();
                System.out.println("Insert the text for write to file");
                str = scan.nextLine();
                if(str == null){
                    throw new MyException("Variable str is null");
                } else {
                    write = new BufferedWriter(new FileWriter("File.txt"));
                    str1.append(str);
                    write.write(" " + str1);
                    write.close();
                }
            }
        } catch(FileNotFoundException e){
            try {
                write = new BufferedWriter(new FileWriter("File.txt"));
                System.out.println("File created");
                write.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        } catch(MyException e){
            System.out.println("NullVariableException!");
        } catch(IOException e){
            System.out.println("RuntimeException!");
        }
    }
    void Read(){
        String str;
        try {
            read = new BufferedReader(new FileReader("File.txt"));
                while((str = read.readLine()) != null){
                    System.out.println(str);
                }
            read.close();
        } catch(FileNotFoundException e){
            try {
                write = new BufferedWriter(new FileWriter("File.txt"));
                System.out.println("File created");
                write.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        } catch (IOException e) {
            System.out.println("RuntimeException!");
            throw new RuntimeException(e);
        }
    }
}
