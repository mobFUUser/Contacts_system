
import java.util.Scanner;

public class scanner {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter Your name: ");
        String name = scan.nextLine();

        System.out.print("hello " + name);

        scan.close();
    }
}
