
import java.util.Arrays;
import java.util.Scanner;

public class _4_SortArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in) ;
		int n = sc.nextInt();
		String[] strings = new String[n];
		for(int i = 0;i<n;i++){
			strings[i] = sc.next();
		}
		Arrays.sort(strings);
		sc.close();
		for(String line : strings){
			System.out.println(line);
		}
	}
}
