import java.util.Scanner;

public class LinearEquations {
	public static void main(String[] args) {
		System.out.println("Linear Equation Solver");
		System.out.println("Given an equation ax+b=0, please enter the constants a and b: ");

		Scanner scanner = new Scanner(System.in);

		System.out.print("a: ");
		double a = scanner.nextDouble();

		System.out.print("b: ");
		double b = scanner.nextDouble();

		if (a == 0) {
			if (b == 0) {
				System.out.println("The linear equation has infinitely many solutions.");
			}
			else {
				System.out.println("The linear solution has no solution.");
			}
		}
		else {
			System.out.println("The solution of the linear equation is: " + (-b/a));
		}
	}
}