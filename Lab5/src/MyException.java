public class MyException extends RuntimeException{
    MyException(){}
    MyException(String str){
        System.out.println(str);
    }
}
