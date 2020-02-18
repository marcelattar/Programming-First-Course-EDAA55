	
public class projecteuler {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 0;
		for (int i = 1; i < 1000 ;i ++) {
			if ( (i%3 == 0) || (i%5 == 0) ) {
				n = n + i;
			}
			
		}
		System.out.println(n);

	}

}
