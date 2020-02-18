
public class fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n1 = 1;
		int n2 = 2;
		int n3 = 0;
		int sum = 2;
		for (;n3 <= 4000000;) {
			n3 = n1 + n2;
			n1 = n2;
			n2 = n3;
			if ((n3 <= 4000000) && (n3 % 2 == 0)) {
				sum = sum + n3;
			}
			
		}
		System.out.println(sum);
		

	}

}
