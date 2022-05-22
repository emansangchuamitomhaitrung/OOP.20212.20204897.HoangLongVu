import java.util.Scanner;

public class ArrayCalculate {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter elements of the array, separated by spaces: ");
		String ele = scan.nextLine();
		String tempArr[] = ele.split(" ");
		
		int inpArr[] = new int[tempArr.length];
		for (int i=0; i < inpArr.length; i++) {
			inpArr[i] = Integer.parseInt(tempArr[i]);
		}
		
		
		System.out.println("Sum of elements in the array: " + sumOfArray(inpArr));
		System.out.println("The average value of the array: " + averageOfArray(inpArr));
		System.out.print("Sorted array in increasing value: ");
		sortArray(inpArr);
	}
	
	public static int sumOfArray(int[] a) {
		int sum = 0;
		for (int i=0; i < a.length; i++) {
			sum += a[i];
		}
		return sum;
	}
	
	public static double averageOfArray(int[] a) {
		int sum = sumOfArray(a);
		return (double) sum/(a.length);
	}
	
	public static void sortArray(int[] a) {
		for (int i=0; i < a.length; i++) {
			for (int j=i+1; j < a.length; j++) {
				int tmp = 0;
				if (a[i] > a[j]) {
					tmp = a[i];
					a[i] = a[j];
					a[j] = tmp;
				}
			}
		System.out.print(a[i] + " ");
		}
	}
	
}
