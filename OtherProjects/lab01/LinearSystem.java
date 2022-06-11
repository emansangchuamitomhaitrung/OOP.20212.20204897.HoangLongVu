import java.util.Scanner;

public class LinearSystem {
	public static void main(String[] args) {
		System.out.println("Linear system solver for two variables");
		System.out.println("Given the system: {a11x1 + a12x2 = b1 \t a21x1 + a22x2 = b2");

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the coefficients a11, a12 and b1 for the first equation (separated by spaces): ");
		double[] eq1 = new double[3];

		for (int i=0; i < eq1.length; i++) {
			eq1[i] = scanner.nextDouble();
		}
		double a11 = eq1[0]; double a12 = eq1[1]; double b1 = eq1[2];

		System.out.println("Enter the coefficients a21, a22 and b2 for the second equation (separated by spaces: ");
		double[] eq2 = new double[3];

		for (int i=0; i < eq2.length; i++) {
			eq2[i] = scanner.nextDouble();
		}
		double a21 = eq2[0]; double a22 = eq2[1]; double b2 = eq2[2];

		if ((a11/a21) == (a12/a22)) {
			if (a11/a21 == b1/b2) {
				System.out.println("The system has infinitely many solutions.");
			}
			else {
				System.out.println("The system has no solution.");
			}
		}
		else {
		double det =  a11*a22 - a21*a12;

		double x1 = (a22*b1 - a12*b2) / det;
		double x2 = (a11*b2 - a21*b1) / det;

		System.out.println("The linear system has two solutions: x1 = " + x1 + ", x2 = " + x2);
		}
	}
}