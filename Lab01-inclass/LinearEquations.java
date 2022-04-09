import javax.swing.JOptionPane;
public class LinearEquations {
	public static void main (String[] args) {
		String a, b;
		a = JOptionPane.showInputDialog(null,
			"Input the value for a: ", "Input a",
			JOptionPane.INFORMATION_MESSAGE);
		b = JOptionPane.showInputDialog(null,
			"Input the value for b: ", "Input b",
			JOptionPane.INFORMATION_MESSAGE);

		double a1 = Double.parseDouble(a);
		double b1 = Double.parseDouble(b);

		String solution;

		if (a1 == 0) {
			if (b1 == 0) {
				solution = "The linear equation has infinitely many solutions";

			}
			else {
				solution = "The linear equation has no solution";
			}


		}

		else {
			solution = "The solution of the linear equation is: " + (-b1/a1);
		}
		
		JOptionPane.showMessageDialog(null,
			solution);
		System.exit(0);

	}

}