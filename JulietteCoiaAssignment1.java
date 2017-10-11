import java.util.Scanner;

public class JulietteCoiaAssignment1 {

    public static void main(String[] args) {
        int sum = 0;
        int n = 0;

        System.out.println("\nPlease enter a positive integer.");
        System.out.println("Or, at any time you may enter -3 to print, -2 to reset sum to zero, or -1 to quit.");

        Scanner input = new Scanner(System.in);

        do {
            System.out.println("Please enter a positive integer.");
            n = input.nextInt();

            if (n == -3) {
                System.out.println("Sum: " + sum);
            }

            else if (n == -2) {
                sum = 0;
            }

            else if (n > 0) {
                sum = sum + n;

            }
        }
        while (n != -1);

        if (n == -1)
        {
            System.out.println("Sum: " + sum);
        }
    }
}
