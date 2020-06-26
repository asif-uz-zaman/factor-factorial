package javaapplication18;
import java.util.Scanner;
public class JavaApplication18 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter an integer to find factorial");
        int a = input.nextInt();
        System.out.println("Enter an integer to find factor");
        int b = input.nextInt();
        Factorial fact = new Factorial(a);
        Factor fac = new Factor(b);
        try {
            fac.t.join();
            fact.t.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println("Exiting main thread");
    }
}
class Factorial implements Runnable {
    Thread t;
    int n;
    Factorial(int x) {
        n = x;
        t = new Thread(this, "Factorial Thread");
        t.start();
    }
    public void run() {
        try {
            long f = 1;
            for (int i = 2; i <= n; i++) {
                f = f * i;
            }
            System.out.print("Factorial of " + n + " is : " + f);
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("\nExiting " + t);
    }
}
class Factor implements Runnable {
    Thread t;
    int n;
    Factor(int x) {
        n = x;
        t = new Thread(this, "Factor Thread");
        t.start();
    }
    public void run() {
        try {
            System.out.print("Factors of " + n + " are : ");
            for (int i = 1; i <= n; i++) {
                if (n % i == 0) System.out.print(i + " ");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("\nExiting " + t);
    }
}