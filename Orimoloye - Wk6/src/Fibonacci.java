
import java.util.Scanner;

/**
 *@author Mark Orimoloye
 */
public class Fibonacci 
{
        
    public static void main(String[] args) 
    {
        int numbers = 20;
        
        System.out.println("Fibonacci Sequence - Iterative");
        for (int i = 1; i <= numbers; i++)
        {
            int fibonacci = Fibonacci_Iterative(i);
            String text = String.format("Fibonacci of %s is %s", i, fibonacci);
            System.out.println(text);
        }
        
        System.out.println();
        
        System.out.println("Fibonacci Sequence - Recursive");
        for (int i = 1; i <= numbers; i++)
        {
            int fibonacci = Fibonacci_Recursive(i);
            String text = String.format("Fibonacci of %s is %s", i, fibonacci);
            System.out.println(text);
        }
    }
    
    static int Fibonacci_Iterative(int n)
    {
        int fn_1 = 1;
        int fn_2 = 1;
        
        for (int i = 3; i <= n; i++)
        {
            int fn_2Aux = fn_1;
            fn_1 = fn_2 + fn_1;
            fn_2 = fn_2Aux; // old value of fn_1
        }
        return fn_1;
    }
    
    static int Fibonacci_Recursive(int n)
    {
        if (n == 1 || n == 2)
            return 1;
        else
            return Fibonacci_Recursive(n - 2) + Fibonacci_Recursive(n - 1);
    }
}