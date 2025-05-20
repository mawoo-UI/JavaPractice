package study4;

//기본 예외 클래스 (Checked Exception)
public class MyException extends Exception {
 // 기본 생성자
 public MyException() {
     super();
 }
 
 // 메시지를 받는 생성자
 public MyException(String message) {
     super(message);
 }
 
 // 원인 예외를 받는 생성자
 public MyException(Throwable cause) {
     super(cause);
 }
 
 // 메시지와 원인 예외를 모두 받는 생성자
 public MyException(String message, Throwable cause) {
     super(message, cause);
 }
}