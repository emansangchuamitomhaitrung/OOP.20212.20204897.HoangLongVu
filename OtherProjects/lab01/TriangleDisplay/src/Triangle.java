import java.util.Scanner;

public class Triangle {
	public static void main(String args[]) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Enter n:");
		int n = keyboard.nextInt();
		System.out.println("n = " + n);

		int i, j, k;
		for (i=1; i <= n; i++) {
			for (j=(n-1);j >= i; j--) {
				System.out.print(" ");
			}
			for (k=1; k<=(2*i-1); k++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}

}
