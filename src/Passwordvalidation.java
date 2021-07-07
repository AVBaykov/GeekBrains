import java.util.Scanner;

public class Passwordvalidation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите пароль");
        String passwd = sc.nextLine();
        String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
        System.out.println(passwd.matches(pattern));
    }
}
