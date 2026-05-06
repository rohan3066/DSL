import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Registry reg = LocateRegistry.getRegistry("localhost", 1099);
            Cal_interface obj = (Cal_interface) reg.lookup("CalculatorService");

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter your first number: ");
            int a = sc.nextInt();

            System.out.print("Enter your second number: ");
            int b = sc.nextInt();

            System.out.println("Addition is: " + obj.add(a, b));
            System.out.println("Subtraction is: " + obj.sub(a, b));

            if (b != 0) {
                System.out.println("Division is: " + obj.divide(a, b));
            } else {
                System.out.println("Division not possible (divide by zero)");
            }

            System.out.println("Multiplication is: " + obj.multiply(a, b));

            System.out.println("Power is: " + obj.power((double) a, (double) b));

            System.out.print("Enter your Celsius value: ");
            double c = sc.nextDouble();

            System.out.println("Temperature in Fahrenheit: " + obj.celsius_to_fer(c));
            System.out.print("Enter Distance in Mile :");
            double m=sc.nextDouble();
            System.out.println("Distance in KM :"+obj.miles_to_klm(m));
            System.out.println("Enter no to find factorial :");
            long f=sc.nextLong();
            System.out.println("Factorial :"+obj.factorial(f));




        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}