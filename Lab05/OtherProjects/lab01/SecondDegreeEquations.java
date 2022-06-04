import java.util.Scanner;

public class SecondDegreeEquations {
	public static void main(String[] args) {
		System.out.println("Second-degree equations solver for one variable");
		System.out.println("Given an equation of the form ax^2+bx+c=0, please enter the coefficients a, b, and c: ");

		Scanner scanner = new Scanner(System.in);

		System.out.print("a: ");
		double a = scanner.nextDouble();

		System.out.print("b: ");
		double b = scanner.nextDouble();

		System.out.print("c: ");
		double c = scanner.nextDouble();

		if (a == 0) {
			if (b == 0) {
				if (c == 0) {
					System.out.println("The equation has infinitely many solutions.");
				}
				else {
					System.out.println("The equation has no solution.");
				}
			}
			else {
				System.out.println("The system has one solution: " + (-c/b));
			}
		}
		else {
			double delta = b*b - 4*a*c;
			if (delta == 0) {
				System.out.println("The system has a double root: " + (-b/(2*a)));
			}
			else if (delta < 0) {
				System.out.println("The system has no real solution.");
			}
			else {
				double x1 = ((-b+Math.sqrt(delta))/(2*a));
				double x2 = ((-b-Math.sqrt(delta))/(2*a));
				System.out.println("The system has two solutions: x1 = " + x1 + ", x2 = " + x2);
			}
		}
	}
}