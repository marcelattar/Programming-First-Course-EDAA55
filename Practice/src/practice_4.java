import java.util.Random;


public class practice_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random randomNbr = new Random();
		int a = randomNbr.nextInt(100) + 1;
		int b = randomNbr.nextInt(100) + 1;
		if (a >= b) {
			System.out.println(b + " " + a);
		}
		else {
			System.out.println(a);
			System.out.println(b);
		}

	}

}
