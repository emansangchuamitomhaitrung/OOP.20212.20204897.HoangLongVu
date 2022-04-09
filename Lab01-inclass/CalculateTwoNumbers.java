import javax.swing.JOptionPane;
public class CalculateTwoNumbers {
	public static void main(String[] args) {
		String strNum1, strNum2;
		strNum1 = JOptionPane.showInputDialog(null,
			"Please input the first number: ", "Input the first number",
			JOptionPane.INFORMATION_MESSAGE);

		strNum2 = JOptionPane.showInputDialog(null,
			"Please input the second number: ", "Input the second number",
			JOptionPane.INFORMATION_MESSAGE);

		double num1 = Double.parseDouble(strNum1);
		double num2 = Double.parseDouble(strNum2);

		double sum = num1 + num2;
		double diff = Math.abs(num2 - num1);
		double product = num1 * num2;
		double quotient = num1 / num2;

		JOptionPane.showMessageDialog(null,
			"The sum of two numbers: " + sum +
			"\nThe difference between two numbers: " + diff +
			"\nThe product of two numbers: " + product +
			"\nThe quotient of two numbers: " + quotient);
		System.exit(0);

	}
}